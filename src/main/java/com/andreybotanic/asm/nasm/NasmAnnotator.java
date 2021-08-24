package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.*;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class NasmAnnotator implements Annotator {
    /**
     * Annotates the specified PSI element.
     * It is guaranteed to be executed in non-reentrant fashion.
     * I.e there will be no call of this method for this instance before previous call get completed.
     * Multiple instances of the annotator might exist simultaneously, though.
     *
     * @param element to annotate.
     * @param holder  the container which receives annotations created by the plugin.
     */
    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof NasmIdentifier) {
            annotateUnresolvedReference((NasmIdentifier) element, holder);
        } else if (element instanceof NasmStr) {
            annotateUnclosedString((NasmStr) element, holder);
        } else if (element instanceof NasmChar) {
            annotateUnclosedCharacter((NasmChar) element, holder);
        }
    }

    private void annotateUnresolvedReference(@NotNull NasmIdentifier identifier, @NotNull AnnotationHolder holder) {
        PsiElement parent = identifier.getParent();

        // Skip definitions (also skip define args)
        if (parent instanceof NasmAssign || parent instanceof NasmDefine || parent instanceof NasmDefineParams) return;

        // Skip identifiers in define or macro
        if (PsiTreeUtil.getParentOfType(identifier, NasmDefine.class) != null /* && !findInParents(element, NasmTypes.MACRO) */ ) return;

        // Skip data elements
        PsiElement top = PsiTreeUtil.getParentOfType(identifier, NasmPrimary.class);
        if (top != null && top.getParent() instanceof NasmFile) return;

        String idName = identifier.getName();

        if (idName == null) return;

        // Search for identifiers
        List<NasmIdentifier> identifiers = NasmUtil.findIdentifierDefinitionsInProject(identifier.getProject(), idName);

        // Search for labels
        List<NasmLabel> labels = NasmUtil.findLabelsInProject(identifier.getProject(), idName);

        if (identifiers.isEmpty() && labels.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved identifier '" + idName + "'")
                    .range(TextRange.from(identifier.getTextRange().getStartOffset(), identifier.getTextRange().getLength()))
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    .create();
        }
    }

    private void annotateUnclosedString(@NotNull NasmStr string, @NotNull AnnotationHolder holder) {
        if (!string.isValid()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unclosed string literal")
                    .range(TextRange.from(string.getTextRange().getStartOffset(), string.getTextRange().getLength()))
                    .highlightType(ProblemHighlightType.GENERIC_ERROR_OR_WARNING)
                    .create();
        }
    }

    private void annotateUnclosedCharacter(@NotNull NasmChar character, @NotNull AnnotationHolder holder) {
        if (!character.isValid()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unclosed character literal")
                    .highlightType(ProblemHighlightType.GENERIC_ERROR_OR_WARNING)
                    .range(TextRange.from(character.getTextRange().getStartOffset(), character.getTextRange().getLength()))
                    .create();
        }
    }
}
