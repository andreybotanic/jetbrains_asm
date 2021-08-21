package com.andreybotanic.asm.nasm;

import com.andreybotanic.asm.nasm.psi.*;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.util.ArrayUtil;
import com.intellij.util.SmartList;
import com.intellij.util.indexing.FileBasedIndex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NasmUtil {
    static List<NasmNamedElement> findNamedElementReferencesByIdInProject(Project project, String targetLabelId) {
        List<NasmNamedElement> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(NasmFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NasmFile nasmFile = (NasmFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (nasmFile != null) {

                NasmNamedElement[] labels = findAllChildrenOfType(nasmFile, NasmNamedElement.class); /*PsiTreeUtil.getChildrenOfType*/
                if (labels != null) {
                    for (NasmNamedElement label : labels) {
                        if (targetLabelId.equals(label.getName())) {
                            result.add(label);
                        }
                    }
                }
            }
        }

        return result;
    }

    public static <T extends PsiElement> T[] findAllChildrenOfType(@Nullable PsiElement element, @NotNull Class<T> aClass) {
        if (element == null)
            return null;
        List<T> result = findAllChildrenOfTypeAsList(element, aClass, 0);
        return result.isEmpty() ? null : ArrayUtil.toObjectArray(result, aClass);
    }

    @NotNull
    public static <T extends PsiElement> List<T> findAllChildrenOfTypeAsList(@Nullable PsiElement element, @NotNull Class<T> aClass, int depth) {
        // Don't search over a depth of 3, for performance reasons.
        if (element == null || depth > 3)
            return Collections.emptyList();

        SmartList<T> result = new SmartList<>();
        for(PsiElement child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (aClass.isInstance(child)) {
                result.add(aClass.cast(child));
            } else {
                // Recurse search into child element
                List<T> subResult = findAllChildrenOfTypeAsList(child, aClass, depth + 1);
                if (!subResult.isEmpty()) {
                    result.addAll(subResult);
                }
            }
        }

        return result;
    }

    static List<NasmIdentifier> findIdentifierReferencesInProject(Project project) {
        List<NasmIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NasmFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NasmFile nasmFile = (NasmFile)PsiManager.getInstance(project).findFile(virtualFile);
            if (nasmFile != null) {
                Collection<NasmIdentifier> nasmIdentifiers = PsiTreeUtil.collectElementsOfType(nasmFile, NasmIdentifier.class);
                result.addAll(nasmIdentifiers);
            }
        }
        return result;
    }

    static List<NasmIdentifier> findIdentifierReferencesInProject(Project project, @NotNull String identifierName) {
        List<NasmIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NasmFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NasmFile nasmFile = (NasmFile)PsiManager.getInstance(project).findFile(virtualFile);
            if (nasmFile != null) {
                Collection<NasmIdentifier> nasmIdentifiers = PsiTreeUtil.collectElementsOfType(nasmFile, NasmIdentifier.class);
                result.addAll(nasmIdentifiers
                        .stream()
                        .filter(nasmIdentifier -> nasmIdentifier.getName() != null)
                        .filter(nasmIdentifier -> nasmIdentifier.getName().equals(identifierName))
                        .collect(Collectors.toList()));
            }
        }
        return result;
    }

    static List<NasmIdentifier> findIdentifierDefinitionsInProject(Project project, @NotNull String identifierName) {
        List<NasmIdentifier> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NasmFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NasmFile nasmFile = (NasmFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (nasmFile != null) {
                // Search in preprocessor directives
                Collection<NasmIdentifier> nasmIdentifiers =
                        PsiTreeUtil.findChildrenOfType(nasmFile, NasmPreprocessor.class).stream()
                                .filter(nasmPreprocessor -> {
                                    PsiElement firstChild = nasmPreprocessor.getFirstChild();
                                    return firstChild instanceof NasmAssign || firstChild instanceof NasmDefine;
                                })
                                .map(directive -> (NasmIdentifier) ((NasmNamedElement) directive.getFirstChild()).getNameIdentifier())
                                .filter(Objects::nonNull)
                                .filter(nasmIdentifier -> nasmIdentifier.getName() != null)
                                .filter(nasmIdentifier -> nasmIdentifier.getName().equals(identifierName))
                                .collect(Collectors.toList());
                result.addAll(nasmIdentifiers);

                // Search in data definitions
                nasmIdentifiers =
                        Stream.of(nasmFile.getChildren())
                                .filter(psiElement -> psiElement instanceof NasmPrimary)
                                .filter(element -> PsiTreeUtil.skipWhitespacesForward(element) instanceof NasmDataElement)
                                .map(element -> PsiTreeUtil.findChildOfType(element, NasmIdentifier.class))
                                .filter(Objects::nonNull)
                                .filter(nasmIdentifier -> nasmIdentifier.getName() != null)
                                .filter(nasmIdentifier -> nasmIdentifier.getName().equals(identifierName))
                                .collect(Collectors.toList());
                result.addAll(nasmIdentifiers);
            }
        }
        return result;
    }

    static List<NasmLabel> findLabelsInProject(Project project, @NotNull String labelName) {
        List<NasmLabel> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NasmFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NasmFile nasmFile = (NasmFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (nasmFile != null) {
                Collection<NasmLabel> labels =
                        PsiTreeUtil.getChildrenOfTypeAsList(nasmFile, NasmLabel.class).stream()
                                .filter(Objects::nonNull)
                                .filter(nasmLabel -> nasmLabel.getName() != null)
                                .filter(nasmLabel -> nasmLabel.getName().equals(labelName))
                                .collect(Collectors.toList());
                result.addAll(labels);
            }
        }
        return result;
    }
}
