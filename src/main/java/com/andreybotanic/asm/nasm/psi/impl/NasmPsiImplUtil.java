package com.andreybotanic.asm.nasm.psi.impl;

import com.andreybotanic.asm.nasm.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import org.jetbrains.annotations.NotNull;

public class NasmPsiImplUtil {
    public static String getName(NasmLabel element) {
        PsiElement lblDef = element.getLblDef();
        if (lblDef != null) {
            String lblDefText = lblDef.getText();
            return lblDefText.substring(0, lblDefText.indexOf(':')).trim();
        }
        return null;
    }

    public static PsiElement setName(NasmLabel element, String newName) {
        ASTNode lblDefNode = element.getNode().findChildByType(NasmTypes.LBL_DEF);
        if (lblDefNode != null) {
            NasmLabel newLabel = NasmElementFactory.createLabel(element.getProject(), newName);
            ASTNode newLblDefNode = newLabel.getNode().findChildByType(NasmTypes.LBL_DEF);
            assert newLblDefNode != null;
            element.getNode().replaceChild(lblDefNode, newLblDefNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(NasmLabel element) {
        ASTNode keyNode = element.getNode().findChildByType(NasmTypes.LBL_DEF);
        if (keyNode != null) {
            return keyNode.getPsi();
        }
        return null;
    }

    public static String getName(NasmIdentifier identifier) {
        return getNameIdentifier(identifier).getText();
    }

    public static PsiElement setName(NasmIdentifier identifier, String newName) {
        ASTNode idNode = getNameIdentifier(identifier).getNode();
        if (idNode != null) {
            PsiElement newId = NasmElementFactory.createIdentifier(identifier.getProject(), newName);
            identifier.getNode().replaceChild(idNode, newId.getNode());
        }
        return identifier;
    }

    @NotNull
    public static PsiElement getNameIdentifier(NasmIdentifier identifier) {
        PsiElement element = identifier.getId();
       /* if (element == null) {
            element = identifier.getMacroParamRef();
            if (element == null) {
                element = identifier.getMacroVarRef();
            }
        }*/
        assert element != null;
        return element;
    }

    @NotNull
    public static PsiReference[] getReferences(@NotNull NasmIdentifier element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }

    public static String getName(NasmLabelIdentifier element) {
        PsiElement id = element.getId();
        if (id != null) {
            return id.getText();
        }
        PsiElement lbl = element.getLbl();
        if (lbl != null) {
            return lbl.getText();
        }
        return null;
    }

    public static PsiElement setName(NasmLabelIdentifier element, String newName) {
        ASTNode idNode = element.getNode().findChildByType(NasmTypes.ID);
        if (idNode != null) {
            NasmLabelIdentifier newLabelIdentifier = NasmElementFactory.createLabelIdentifierId(element.getProject(), newName);
            ASTNode newIdNode = newLabelIdentifier.getNode().findChildByType(NasmTypes.ID);
            assert newIdNode != null;
            element.getNode().replaceChild(idNode, newIdNode);
        }
        ASTNode lblNode = element.getNode().findChildByType(NasmTypes.LBL);
        if (lblNode != null) {
            NasmLabelIdentifier newLabelIdentifier = NasmElementFactory.createLabelIdentifierLbl(element.getProject(), newName);
            ASTNode newLblNode = newLabelIdentifier.getNode().findChildByType(NasmTypes.LBL);
            assert newLblNode != null;
            element.getNode().replaceChild(lblNode, newLblNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(NasmLabelIdentifier element) {
        ASTNode idNode = element.getNode().findChildByType(NasmTypes.ID);
        if (idNode != null) {
            return idNode.getPsi();
        }
        ASTNode lblNode = element.getNode().findChildByType(NasmTypes.LBL);
        if (lblNode != null) {
            return lblNode.getPsi();
        }
        return null;
    }

    @NotNull
    public static PsiReference[] getReferences(@NotNull NasmLabelIdentifier element) {
        return ReferenceProvidersRegistry.getReferencesFromProviders(element);
    }
}
