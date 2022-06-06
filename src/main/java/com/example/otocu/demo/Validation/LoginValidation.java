//package com.example.otocu.demo.Validation;
//
//import com.example.otocu.demo.Model.User;
//import com.example.otocu.demo.Singleton.UserInstance;
//import org.springframework.ui.Model;
//
//public class LoginValidation {
//
//    public static boolean loginValidation(Model model){
//        User user_logging = UserInstance.getInstance().getUser();
//        if(user_logging == null){
//            model.addAttribute("user",new User());
//            model.addAttribute("notification", "Cần đăng nhập trước khi truy cập vào giao diện");
//            return "index";
//        }
//        return true;
//    }
//}
