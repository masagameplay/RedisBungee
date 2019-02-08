package com.imaginarycode.minecraft.redisbungee.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IOUtil {
    public static String readInputStreamAsString(InputStream is) {
        try {
            try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
                int readLen;
                final int bufLen = 4 * 0x400;
                byte[] buf = new byte[bufLen];
                while ((readLen = is.read(buf, 0, bufLen)) != -1)
                    out.write(buf, 0, readLen);
                return new String(out.toByteArray(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
