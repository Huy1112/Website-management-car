//package com.example.otocu.demo.Controller;
//
//import com.example.otocu.demo.Model.CatUser;
//import com.example.otocu.demo.Model.User;
//import com.example.otocu.demo.Repository.CatUserRepository;
//import com.example.otocu.demo.Repository.UserRepository;
//import com.example.otocu.demo.Singleton.UserInstance;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//
//
//        import com.example.otocu.demo.Model.CatUser;
//        import com.example.otocu.demo.Model.User;
//        import com.example.otocu.demo.Repository.CatUserRepository;
//        import com.example.otocu.demo.Repository.UserRepository;
//        import com.example.otocu.demo.Singleton.UserInstance;
//        import org.springframework.beans.factory.annotation.Autowired;
//        import org.springframework.stereotype.Controller;
//        import org.springframework.ui.Model;
//        import org.springframework.validation.BindingResult;
//        import org.springframework.web.bind.annotation.*;
//
//        import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/doc")
//public class CustomerAdminController {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private CatUserRepository catUserRepository;
//    public static int numberUser = 0;
//
//    @GetMapping("/table-data-customer")
//    public String getAll(Model model){
//        User user_logging = UserInstance.getInstance().getUser();
//        model.addAttribute("users", userRepository.findAllWithCatUser());
//        model.addAttribute("user",user_logging);
//        return "doc/table-data-customer";
//    }
//}
