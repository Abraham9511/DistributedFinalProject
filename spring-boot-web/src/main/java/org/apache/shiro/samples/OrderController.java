package org.apache.shiro.samples;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lincolnz9511 on 16-11-20.
 */
@Controller
public class OrderController {

    @RequestMapping(value="/Order/{id}")
    public String OrderDetailTemplate(@PathVariable("id") String id, Model model) {
        model.addAttribute("id", id);
//        model.addAttribute("FoodPic", FoodPic);
        return "Order";
    }

}