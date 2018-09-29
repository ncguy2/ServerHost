package net.ncguy.gamehost.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootController {

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("test");
        model.addObject("name", "Butts");
        return model;
    }

}
