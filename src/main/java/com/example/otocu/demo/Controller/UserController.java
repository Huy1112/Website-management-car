package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.Role;
import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.Repository.RoleRepository;
import com.example.otocu.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/doc")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository rolesRepository;


    @GetMapping("/table-data-table")
    public String getAll(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "doc/table-data-table";
    }
    @GetMapping("/form-add-nhan-vien")
    public String getAddUser(User user, Model model, Role role){
        model.addAttribute("cat" , role);
        model.addAttribute("userCreate", user);
        model.addAttribute("allRoles",rolesRepository.findAll());
        return "doc/form-add-nhan-vien";
    }
    @PostMapping("/form-add-nhan-vien")
    public String addUser(@ModelAttribute("userCreate")@Valid User user, BindingResult rs, Model model,Role role){
        if (rs.hasErrors()){
            model.addAttribute("cat" , role);
            model.addAttribute("allRoles",rolesRepository.findAll());
            model.addAttribute("userCreate", user);
            return "doc/form-add-nhan-vien";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "doc/table-data-table";
    }
    @PostMapping("/add-cat-user")
    public String addCat(@ModelAttribute("cat") Role role, Model model, User user){
        rolesRepository.save(role);
        model.addAttribute("userCreate" , user);
        return "doc/form-add-nhan-vien";
    }
    @GetMapping("/form-edit-nhan-vien/{id}")
    public String editUser(@PathVariable("id") int id,Model model,Role role){
        User user = userRepository.getOne(id);
        model.addAttribute("cat",role);
        model.addAttribute("allRoles",rolesRepository.findAll());
        model.addAttribute("userCreate",user);
        return "doc/form-add-nhan-vien";
    }
    @GetMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model){
        User user = userRepository.getOne(id);
        model.addAttribute("users", userRepository.findAll());
        userRepository.deleteById(id);
        return "doc/table-data-table";
    }
}
