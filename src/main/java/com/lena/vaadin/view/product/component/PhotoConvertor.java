package com.lena.vaadin.view.product.component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by alexey.dranchuk on 12/1/15.
 */
public class PhotoConvertor {

    public static byte[] convertImage(File file)  {
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Couldn't convert file " + file + " to byte[]");
        }
    }
}
