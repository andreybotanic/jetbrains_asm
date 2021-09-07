package com.andreybotanic.asm.nasm.completion;

import com.intellij.codeInsight.completion.CompletionParameters;
import com.intellij.codeInsight.completion.CompletionProvider;
import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class RegisterProvider extends CompletionProvider<CompletionParameters> {
    private final String[] registers;

    RegisterProvider() {
        registers = new String[]{
                "ax", "bx", "cx", "dx",
                "eax", "ebx", "ecx", "edx",
                "rax", "rbx", "rcx", "rdx",
                "sp", "bp", "esp", "ebp"
        };
    }

    @Override
    protected void addCompletions(@NotNull CompletionParameters parameters,
                                  @NotNull ProcessingContext context,
                                  @NotNull CompletionResultSet resultSet) {
        for (String mnemonic : registers) {
            resultSet.addElement(LookupElementBuilder
                    .create(mnemonic)
                    .withCaseSensitivity(false));
        }
    }
}
