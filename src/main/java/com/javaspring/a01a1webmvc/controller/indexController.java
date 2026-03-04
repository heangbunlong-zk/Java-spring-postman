package com.javaspring.a01a1webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

@Controller
public class indexController {

//    @RequestMapping(path = "/index, method = RequestMethod.GET")
    @GetMapping("/index/{page}/category/{number}")
    public String viewIndex(@PathVariable String page,
                            @PathVariable Integer number,
                            @RequestParam String query) {
        System.out.println("Page" + page);
        System.out.println("Number:" + number);
        System.out.println("Query :" + query);
        return "index";
    }
}
