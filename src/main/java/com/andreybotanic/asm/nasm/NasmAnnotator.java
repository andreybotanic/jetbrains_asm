package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.*;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
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
        }
    }

    private void annotateUnresolvedReference(@NotNull NasmIdentifier identifier, @NotNull AnnotationHolder holder) {
        PsiElement parent = identifier.getParent();

        // Skip definitions (also skip define args)
        if (parent instanceof NasmAssign || parent instanceof NasmDefine || parent instanceof NasmDefineParams) return;

        // Skip identifiers in define or macro
        if (findInParents(identifier, NasmDefine.class) /* && !findInParents(element, NasmTypes.MACRO) */ ) return;

        String idName = identifier.getName();

        if (idName == null) return;

        List<NasmIdentifier> identifiers = NasmUtil.findIdentifierReferencesInProject(identifier.getProject(), idName);
        identifiers = identifiers.stream()
                .filter(id->id.getParent() instanceof NasmAssign || id.getParent() instanceof NasmDefine)
                .collect(Collectors.toList());

        if (identifiers.isEmpty()) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved identifier '" + idName + "'")
                    .range(TextRange.from(identifier.getTextRange().getStartOffset(), identifier.getTextRange().getLength()))
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                    .create();
        }
    }

    private boolean findInParents(@NotNull PsiElement element, Class<? extends PsiElement> elementClass) {
        PsiElement parent = element.getParent();
        if (parent == null) return false;
        if (elementClass.isInstance(parent)) return true;
        return findInParents(parent, elementClass);
    }
}
