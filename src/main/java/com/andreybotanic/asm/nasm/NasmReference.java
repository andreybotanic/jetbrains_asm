package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.icons.AsmIcons;
import com.andreybotanic.asm.nasm.psi.NasmIdentifier;
import com.andreybotanic.asm.nasm.psi.NasmLabel;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NasmReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String refId;

    public NasmReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        refId = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<NasmLabel> labels = NasmUtil.findLabelReferencesByIdInProject(myElement.getProject(), refId);
        List<ResolveResult> results = new ArrayList<>();
        for (NasmLabel label : labels) {
            results.add(new PsiElementResolveResult(label));
        }
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object @NotNull [] getVariants() {
        List<NasmIdentifier> identifiers = NasmUtil.findIdentifierReferencesInProject(myElement.getProject());
        List<LookupElement> variants = new ArrayList<>();
        for (final NasmIdentifier identifier : identifiers) {
            String identifierText = identifier.getId().getText();
            if (identifierText != null && identifierText.length() > 0) {
                variants.add(LookupElementBuilder.create(identifier.getId()).
                        withIcon(AsmIcons.NasmFileType).
                        withTypeText(identifier.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
