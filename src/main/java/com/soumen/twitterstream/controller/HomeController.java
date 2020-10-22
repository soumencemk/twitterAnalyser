package com.soumen.twitterstream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Soumen Karmakar
 * 15/05/2020
 */
@Controller
public class HomeController {

    @SuppressWarnings("SameReturnValue")
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }
}
