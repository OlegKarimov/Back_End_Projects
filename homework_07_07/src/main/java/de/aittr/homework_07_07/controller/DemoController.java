package de.aittr.homework_07_07.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DemoController {


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String getMap(){
        return "Hello";
    }

    @RequestMapping(value = "/goodbye",method = RequestMethod.GET)
    public String getMap2(){
        return "Goodbye";
    }
}

