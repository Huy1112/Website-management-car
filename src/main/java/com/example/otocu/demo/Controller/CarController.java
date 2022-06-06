package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.New;
import com.example.otocu.demo.ModelData.Search;
import com.example.otocu.demo.Repository.BrandCarRepository;
import com.example.otocu.demo.Repository.NewRepository;
import com.example.otocu.demo.Repository.ProvinceRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/Web")
public class CarController {
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private BrandCarRepository brandCarRepository;

    @GetMapping(value = {"/xe"})
    public String getAll(Model model){
        List<New> list = newRepository.findAll();
        model.addAttribute( "news",list);
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("sumCar",list.size());
        return "Web/xe";
    }
    @GetMapping("/xe/form")
    public String getCarByID1(@RequestParam String rs, Model model) {
        Integer sumCar = newRepository.findSumCar(rs);

        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        model.addAttribute("news",newRepository.findByFormCar(rs));
        model.addAttribute("sumCar", newRepository.findSumCar(rs));
        return "Web/xe";
    }
    @PostMapping(value = "/xe/search")
    public String getCars(@ModelAttribute("search") Search search, Model model){

        List<New> rs = newRepository.search(search.getOld(),
                search.getNeww(),
                search.getCity(),
                search.getBrandd(),
                search.getPricefrom(),
                search.getPriceto(),
                search.getYearfrom(),
                search.getYearto(),
                search.getManual(),
                search.getAuto(),
                search.getGasoline(),
                search.getOil(),
                search.getHybrid(),
                search.getImportt(),
                search.getCountry()
                );

        model.addAttribute("sumCar", rs.size());
        model.addAttribute("news", rs);

        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("search",new Search());
        model.addAttribute("brands",brandCarRepository.findAll());
        return "Web/xe";
    }

}
