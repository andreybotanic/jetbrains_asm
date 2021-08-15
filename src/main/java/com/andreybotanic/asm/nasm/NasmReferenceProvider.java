package com.andreybotanic.asm.nasm;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class NasmReferenceProvider extends PsiReferenceProvider {
    @Override
    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        if (element instanceof PsiNamedElement) {
            PsiNamedElement namedElement = (PsiNamedElement) element;
            String value = namedElement.getName();
            if (value != null) {
                int valueIndex = namedElement.getText().indexOf(value);
                if (valueIndex >= 0) {
                    return new PsiReference[]{new NasmReference(element, new TextRange(valueIndex, valueIndex + value.length()))};
                }
            }
        }

        return PsiReference.EMPTY_ARRAY;
    }
}
