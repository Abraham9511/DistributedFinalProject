package org.group.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lincolnz9511 on 16-11-20.
 */

@Controller
public class MenuController {

    @RequestMapping(value="/menu")
    public String MenuTemplate(Model model) {

        return "menu";
    }

}
