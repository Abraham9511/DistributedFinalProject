package org.apache.shiro.samples;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;


@Controller
public class ImageController {
    @ResponseBody
    @RequestMapping(value = "/image/{id}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] ImageReturn(@PathVariable("id") String id) throws IOException {
        String path = "/images/" + id +".jpg";
        System.out.println(path);
        Resource image = new ClassPathResource(path);
        InputStream in = image.getInputStream();
        return IOUtils.toByteArray(in);
    }
}
