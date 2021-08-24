package com.andreybotanic.asm.nasm.formatting;

import com.andreybotanic.asm.nasm.NasmLanguage;
import com.andreybotanic.asm.nasm.psi.NasmTypes;
import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CommonCodeStyleSettings;
import org.jetbrains.annotations.NotNull;

public class NasmFormattingModelBuilder implements FormattingModelBuilder {
    private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
        CommonCodeStyleSettings commonSettings = settings.getCommonSettings(NasmLanguage.INSTANCE.getID());
        return new SpacingBuilder(settings, NasmLanguage.INSTANCE)
                .after(NasmTypes.SEPARATOR)
                    .spaceIf(commonSettings.SPACE_AFTER_COMMA)
                .after(NasmTypes.OPERATION)
                    .spacing(1, 4, 0, false, 0);

    }

    @Override
    public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
        final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
        return FormattingModelProvider
                .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                    new NasmBlock(formattingContext.getNode(),
                            Wrap.createWrap(WrapType.NONE, false),
                            Alignment.createAlignment(),
                            createSpaceBuilder(codeStyleSettings)),
                    codeStyleSettings);
    }
}
