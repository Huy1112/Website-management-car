package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.MyUserDetails;
import com.example.otocu.demo.Model.New;
import com.example.otocu.demo.Model.User;
import com.example.otocu.demo.ModelData.Search;
import com.example.otocu.demo.Repository.BrandCarRepository;
import com.example.otocu.demo.Repository.NewRepository;
import com.example.otocu.demo.Repository.ProvinceRepository;
import com.example.otocu.demo.Singleton.UserInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Web")
public class CustomerController {

    @Autowired
    private NewRepository newRepository;
    @Autowired
    private BrandCarRepository brandCarRepository;
    @Autowired
    private ProvinceRepository provinceRepository;


    @GetMapping(value={"/dang-tin"})
    public String Dangtin(Model model) throws InstantiationException, IllegalAccessException {
        return "Web/dang-tin/index";
    }
    @GetMapping(value = {"/hang-xe"})
    public String hangXe(Model model){

        model.addAttribute("news",newRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        return "Web/hang-xe";
    }
    @GetMapping(value = {"/danh-sach-bai-dang"})
    public String getDanhsach(Model model,@AuthenticationPrincipal MyUserDetails myUserDetails){
        model.addAttribute("news",newRepository.findByUser(myUserDetails.getUsername()));
        return "Web/danh-sach-bai-dang";
    }
    @GetMapping(value = {"/hang-xe/{id}"})
    public String hangXeByID(@PathVariable("id") int id ,Model model){

        model.addAttribute("news",newRepository.findAllByBrand(id));
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        return "Web/hang-xe";
    }
    @GetMapping(value = {"/tinh-thanh"})
    public String tinhThanh(Model model){
        model.addAttribute("news",newRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        return "Web/tinh-thanh";
    }
    @GetMapping(value = {"/tinh-thanh/{id}"})
    public String tinhThanhById(@PathVariable("id") String code,Model model){
        model.addAttribute("news",newRepository.findAllByCodeCity(code));
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        return "Web/tinh-thanh";
    }
    @GetMapping(value = {"/tinh-thanh/{id}/{brand}/{nameCar}"})
    public String tinhThanhById1(@PathVariable("brand") String brand
            ,@PathVariable("nameCar") String nameCar
            ,@PathVariable("id") String code
            ,Model model){
        model.addAttribute("news",newRepository.findAllByCodeCityBrandNameCar(brand,nameCar,code));
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        return "Web/tinh-thanh";
    }
    @GetMapping(value = {"","/","/index"})
    public String index(Model model){
        List<New> newList =  newRepository.findAll();
        model.addAttribute("news",newList);
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        return "Web/index";
    }

    @GetMapping("/chi-tiet-bai-dang/{id}")
    public String getNews(@PathVariable("id") int id, Model model){
        New item = newRepository.getOne(id);

        model.addAttribute("item" , item);
        model.addAttribute("news",newRepository.findAllByCodeCityBrandNameCar(
                item.getCarNew().getBrand().getName()
                ,item.getCarNew().getName()
                , item.getCarNew().getCity().getCode()));
        model.addAttribute("provinces",provinceRepository.findAll());
        return "Web/chi-tiet-bai-dang";
    }
    @GetMapping("/tim-kiem")
    public String searchObject( Model model){
        model.addAttribute("search", new Search());
        model.addAttribute("brands" , brandCarRepository.findAll());
        model.addAttribute("provinces",provinceRepository.findAll());
        return "Web/tim-kiem";
    }


}
