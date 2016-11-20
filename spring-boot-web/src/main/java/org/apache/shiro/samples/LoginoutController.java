package org.apache.shiro.samples;

/**
 * Created by lincolnz9511 on 16-11-20.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginoutController {

    @RequestMapping(value="/loginout")
    public String loginoutTemplate() {

        return "loginout";
    }

}

