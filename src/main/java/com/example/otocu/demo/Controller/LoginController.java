package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.New;
import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.ModelData.Search;
import com.example.otocu.demo.Repository.BrandCarRepository;
import com.example.otocu.demo.Repository.NewRepository;
import com.example.otocu.demo.Repository.ProvinceRepository;
import com.example.otocu.demo.Repository.UserRepository;
import com.example.otocu.demo.Security.MyUserDetailsService;
import com.example.otocu.demo.Singleton.UserInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BrandCarRepository brandCarRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @GetMapping(value = {"","/","/index"})
    public String index(Model model){
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("news",newRepository.findAll());
        return "index";
    }

    @GetMapping(value = {"/login"})
    public String indexx(Model model){
        return "login";
    }
//    @PostMapping(value = {"/login"})
//    public String userSubmit(Principal principal,
//                             Model model){
////        UserInstance.getInstance().setUser(user);
//        System.out.print(principal.toString());
//        return "doc/index";
////        UserDetails userDetails = ;
////
////        if(user.getCatUser().getName().equals("Admin")){
////            model.addAttribute("user", user);
////            return "doc/index";
////        }else {
////            model.addAttribute("user",user);
////            List<New> newList =  newRepository.findAll();
////            model.addAttribute("search",new Search());
////            model.addAttribute("brands",brandCarRepository.findAll());
////            model.addAttribute("provinces",provinceRepository.findAll());
////            model.addAttribute("news",newList);
////            return "Web/index";
////        }
//    }
    @GetMapping("/forgot")
    public String getForgot(){
        return "forgot";
    }

    @GetMapping("/logout")
    public String getLogout(Model model){

        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("news",newRepository.findAll());
        return "index";
    }

}
