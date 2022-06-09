package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.LoaiTin;
import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.Repository.LoaiTinRepository;
import com.example.otocu.demo.Repository.NewRepository;
import com.example.otocu.demo.Singleton.UserInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/doc")
public class LoaiTinController {

    @Autowired
    private LoaiTinRepository loaiTinRepository;
    @Autowired
    private NewRepository newRepository;



    @GetMapping("/table-data-product")
    public String index(Model model){
        User user_logging = UserInstance.getInstance().getUser();
        model.addAttribute("loaitins",loaiTinRepository.findAll());
        model.addAttribute("user",user_logging);

        return "doc/table-data-product";
    }

    @GetMapping("/form-add-san-pham")
    public String getFormAdd(Model model){
        User user_logging = UserInstance.getInstance().getUser();
        model.addAttribute("loaitin",new LoaiTin());
        model.addAttribute("user",user_logging);
        return "doc/form-add-san-pham";
    }
    @PostMapping("/form-add-san-pham")
    public String saveLoaitin(@ModelAttribute("loaitin")@Valid LoaiTin loaiTin, BindingResult rs, Model model){
        User user_logging = UserInstance.getInstance().getUser();
        if(rs.hasErrors()){
            model.addAttribute("loaitin",loaiTin);
            model.addAttribute("user",user_logging);
            return "doc/form-add-san-pham";
        }
        loaiTinRepository.save(loaiTin);
        model.addAttribute("loaitins",loaiTinRepository.findAll());
        model.addAttribute("user",user_logging);
        return "doc/table-data-product";
    }

    @GetMapping("/delete-san-pham/{id}")
    public String deleteLoaitin(@PathVariable("id") int id, Model model){
        User user_logging = UserInstance.getInstance().getUser();
        loaiTinRepository.deleteById(id);
        model.addAttribute("loaitins",loaiTinRepository.findAll());
        model.addAttribute("user",user_logging);
        return "doc/table-data-product";
    }
    @GetMapping("/form-edit-san-pham/{id}")
    public String getLoaitin(@PathVariable("id")int id,Model model){
        User user_logging = UserInstance.getInstance().getUser();
         LoaiTin loaiTin = loaiTinRepository.getOne(id);
         model.addAttribute("loaitin",loaiTin);
         model.addAttribute("user",user_logging);
         return "doc/form-add-san-pham";
    }
}
