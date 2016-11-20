package org.apache.shiro.samples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lincolnz9511 on 16-11-20.
 */
@Controller
public class CuisineDetailController {

    @RequestMapping(value="/cuisine_detail/{name}")
    public String CuisineDetailTemplate(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
//        model.addAttribute("FoodPic", FoodPic);
        return "cuisine_detail";
    }

}