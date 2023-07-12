package de.aittr.springdemo.controller;

import de.aittr.springdemo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {
    User user = new User("Jack","Berlin");

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(Model model){
        model.addAttribute("user",user);
        return "user_view";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String getMap(){

        return "hello_view";
    }

    @RequestMapping(value = "/test123",method = RequestMethod.GET)
    public String getMap2(){

        return "hello_view123";
    }
}
