package org.group.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by lincolnz9511 on 16-11-20.
 */
@Controller
public class CuisineDetailController {

    @RequestMapping(value="/cuisine_detail")
    public String CuisineDetailTemplate(@RequestParam(value = "cuisine", required = true) String cuisine, Model model) {
//        model.addAttribute("name", name);
//        model.addAttribute("FoodPic", FoodPic);
        model.addAttribute("commodity", cuisine);
        return "cuisine_detail";
    }

}
