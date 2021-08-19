package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.NasmIdentifier;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

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
            NasmIdentifier identifier = (NasmIdentifier) element;
            // Search for definition if this ID not in define or macro and it's not an identifier definition
            if (!(element.getParent() instanceof NasmFile) && !findInParents(element, NasmTypes.DEFINE) /* && !findInParents(element, NasmTypes.MACRO) */ ) {
                String idName = identifier.getName();
                if (idName == null) return;
                List<NasmIdentifier> identifiers = NasmUtil.findIdentifierReferencesInProject(element.getProject(), idName);
                if (identifiers.isEmpty()) {
                    holder.newAnnotation(HighlightSeverity.ERROR, "Unresolved identifier")
                            .range(TextRange.from(element.getTextRange().getStartOffset(), element.getTextRange().getLength()))
                            .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                            .create();
                }
            }
        }
    }

    private boolean findInParents(PsiElement element, IElementType elementType) {
        PsiElement parent = element.getParent();
        if (parent == null) return false;
        if (parent.equals(elementType)) return true;
        return findInParents(parent, elementType);
    }
}
