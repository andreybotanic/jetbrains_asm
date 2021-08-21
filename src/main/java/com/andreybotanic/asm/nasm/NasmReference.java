package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.icons.AsmIcons;
import com.andreybotanic.asm.nasm.psi.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NasmReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private final String refId;

    public NasmReference(@NotNull PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
        refId = element.getText().substring(rangeInElement.getStartOffset(), rangeInElement.getEndOffset());
    }

    @NotNull
    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        List<NasmNamedElement> elements =
                NasmUtil.findNamedElementReferencesByIdInProject(myElement.getProject(), refId).stream()
                        .filter(element -> !(element instanceof NasmLabelIdentifier))
                        .collect(Collectors.toList());
        List<ResolveResult> results = new ArrayList<>();
        for (NasmNamedElement element : elements) {
            if (element instanceof NasmAssign || element instanceof NasmDefine) {
                NasmNamedElement realId = (NasmNamedElement) PsiTreeUtil.skipWhitespacesForward(element.getFirstChild());
                if (realId != null) {
                    results.add(new PsiElementResolveResult(realId));
                }
            } else {
                results.add(new PsiElementResolveResult(element));
            }
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
                variants.add(LookupElementBuilder.create(identifier.getId())
                        .withIcon(AsmIcons.NasmFileType)
                        .withTypeText(identifier.getContainingFile().getName())
                );
            }
        }
        return variants.toArray();
    }
}
