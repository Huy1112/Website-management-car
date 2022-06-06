package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.Singleton.UserInstance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/doc")
public class DashbroadController {
    @GetMapping(value = {"/","","/index"})
    public String index(Model model){
        User user_logging = UserInstance.getInstance().getUser();
        model.addAttribute("user",user_logging);
        return "doc/index";
    }
}
