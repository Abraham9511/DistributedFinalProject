package org.group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

@Controller
public class IndexController {

    @ModelAttribute(value = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value={"/", "/index.html", "/index", "/index/*" })
    public String home(@RequestParam(value = "city", required = false) String city, Model model) throws UnsupportedEncodingException {
        String name = "World";
        String city1 = "Beijing";
        String city2 = "Shanghai";
        String city3 = "Guangzhou";

        String curCity = city3;

        if (city != null) {
            curCity = city;
        }

        System.out.println("CITY:"+city);

        String commodity[] = {"Rice rolls", "Porridge", "Chicken wings", "Hamburg", "French fries", "Coffee"};
        String price[] = {"$2", "$1", "$3", "$4", "$3", "$2"};


        Subject subject = SecurityUtils.getSubject();

        PrincipalCollection principalCollection = subject.getPrincipals();

        if (principalCollection != null && !principalCollection.isEmpty()) {
            Collection<Map> principalMaps = subject.getPrincipals().byType(Map.class);
            if (CollectionUtils.isEmpty(principalMaps)) {
                name = subject.getPrincipal().toString();
            }
            else {
                name = (String) principalMaps.iterator().next().get("username");
            }
        }

        model.addAttribute("curCity", curCity);

        model.addAttribute("city1", city1);
        model.addAttribute("city2", city2);
        model.addAttribute("city3", city3);

        model.addAttribute("commodity1", commodity[0]);
        model.addAttribute("commodity2", commodity[1]);
        model.addAttribute("commodity3", commodity[2]);
        model.addAttribute("commodity4", commodity[3]);
        model.addAttribute("commodity5", commodity[4]);
        model.addAttribute("commodity6", commodity[5]);

        model.addAttribute("price1", price[0]);
        model.addAttribute("price2", price[1]);
        model.addAttribute("price3", price[2]);
        model.addAttribute("price4", price[3]);
        model.addAttribute("price5", price[4]);
        model.addAttribute("price6", price[5]);


//        System.out.println("IndexController");
        return "index";
    }

}
