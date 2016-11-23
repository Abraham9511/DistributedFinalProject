package org.apache.shiro.samples;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lincolnz9511 on 16-11-20.
 */

@Controller
public class MenuController {

    @RequestMapping(value="/menu")
    public String MenuTemplate() {

        return "menu";
    }

}
