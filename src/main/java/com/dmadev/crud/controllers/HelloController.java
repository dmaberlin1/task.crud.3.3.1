package com.dmadev.crud.controllers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //значение будет внедрено в это поле из файла application.properties
    @Value("${hello}")
    private String hello;

    @GetMapping("/hello")
    public String hello(){
        System.out.println(this.hello);
        return "hello";
    }

}
