package com.lena.vaadin.view.product.component;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by alexey.dranchuk on 10/1/15.
 */
public class PhotoReciever implements Upload.Receiver, Upload.SucceededListener {

    private File file;

    private Image image;

    private ProductWindowModel productWindowModel;

    public PhotoReciever(Image image, ProductWindowModel productWindowModel) {
        this.image = image;
        this.productWindowModel = productWindowModel;
    }

    @Override
    public OutputStream receiveUpload(String filename, String mimeType) {
        FileOutputStream fos;
        try {
            file = new File("/tmp/" + filename+System.currentTimeMillis());
            fos = new FileOutputStream(file);
            return fos;
        } catch (final java.io.FileNotFoundException e) {
            new Notification("Could not open file<br/>",
                    e.getMessage(),
                    Notification.Type.ERROR_MESSAGE)
                    .show(Page.getCurrent());
            return null;
        }
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent event) {
        image.setSource(new FileResource(file));
        productWindowModel.setUploadedFile(file);
    }
}
