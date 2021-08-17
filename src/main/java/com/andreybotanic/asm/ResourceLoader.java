package com.andreybotanic.asm;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {
    @Nullable
    public static String loadResource(@NotNull String path, @NotNull Class <?> aClass) {
        try (InputStream is = aClass.getResourceAsStream(path)) {
            if (is != null) {
                byte[] buffer = new byte[is.available()];
                //noinspection ResultOfMethodCallIgnored
                is.read(buffer);
                return new String(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @NotNull
    public static String loadResource(@NotNull String path, @NotNull Class <?> aClass, String defaultStr) {
        String content = loadResource(path, aClass);
        return content == null ? defaultStr : content;
    }
}
