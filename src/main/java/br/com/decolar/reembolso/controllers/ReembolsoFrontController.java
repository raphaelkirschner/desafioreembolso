package br.com.decolar.reembolso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ReembolsoFrontController {
    @GetMapping("/")
    public ModelAndView Index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Home/Index");
        return mv;
    }
}
