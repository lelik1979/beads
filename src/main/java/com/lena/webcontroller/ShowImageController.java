package com.lena.webcontroller;

import com.lena.dao.ProductPhotoDao;
import com.lena.domain.ProductPhoto;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 01.11.14.
 */
@Controller
public class ShowImageController {

    @Autowired
    private ProductPhotoDao productPhotoDao;

    @RequestMapping(value = "/getPhoto")
    public void getPhotoById(@RequestParam("id")int productId, HttpServletResponse response) {
        ProductPhoto pp = productPhotoDao.getProductPhotoById(productId);
        if (pp == null) {
            return;
        }
        InputStream in1 = new ByteArrayInputStream(pp.getBigPhoto());
        try {
            IOUtils.copy(in1, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
