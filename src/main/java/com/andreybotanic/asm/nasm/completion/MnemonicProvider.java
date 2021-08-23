package com.andreybotanic.asm.nasm.completion;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;


class MnemonicProvider extends CompletionProvider<CompletionParameters> {
    private final String[] mnemonics;

    MnemonicProvider() {
        mnemonics = new String[]{"add", "sub", "inc", "dec", "mov", "jmp", "cmp", "call"};
    }

    private static final InsertHandler<LookupElement> MNEMONIC_HANDLER = (context, item) ->
            EditorModificationUtil.insertStringAtCaret(context.getEditor(), " ");

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet resultSet) {
        for (String mnemonic : mnemonics) {
            resultSet.addElement(LookupElementBuilder
                    .create(mnemonic)
                    .withCaseSensitivity(false)
                    .withInsertHandler(MNEMONIC_HANDLER));
        }
    }


}
