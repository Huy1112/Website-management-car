package com.example.otocu.demo.Controller;


import com.example.otocu.demo.Model.*;
import com.example.otocu.demo.ModelData.Brand;
import com.example.otocu.demo.ModelData.Oder;
import com.example.otocu.demo.ModelData.Search;
import com.example.otocu.demo.Repository.*;
import com.example.otocu.demo.Singleton.UserInstance;
import com.example.otocu.demo.Singleton.newInstance;
import com.example.otocu.demo.utils.FileUploadUtil;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;


@Setter
@Getter
@Data
@Controller
@RequestMapping("/doc")
public class oderController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private PicCarRepository picCarRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewRepository newRepository;
    @Autowired
    private BrandCarRepository brandCarRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private RoleRepository roleRepository;



    @GetMapping("/table-data-oder")
    public String index(Model model) {
        model.addAttribute("news", newRepository.findAll());
        model.addAttribute("brandCar", new Brand());
        return "doc/table-data-oder";
    }

    @GetMapping("/form-add-don-hang")
    public String indexOder(Model model, Oder oder, Principal principal) {
        oder.setNameUser(principal.getName());
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("brands" , brandCarRepository.findAll());
        model.addAttribute("oder", oder);
        return "doc/form-add-don-hang";
    }

    @PostMapping("/form-add-don-hang")
    public String saveOder(@ModelAttribute("oder")@Valid Oder oder, BindingResult rs,
                           Model model, New newCreate, @AuthenticationPrincipal MyUserDetails myUserDetails) throws IOException {
        if(rs.hasErrors()){
            model.addAttribute("oder",oder);
            model.addAttribute("provinces",provinceRepository.findAll());
            model.addAttribute("brands" , brandCarRepository.findAll());
            return "doc/form-add-don-hang";
        }
//      CREATE CONTRUCTOR CAR
        Car car = new Car(oder.getNameCar(),oder.getCreate_car(),oder.getNation(),oder.getForm(),oder.getState(),oder.getGear(),oder.getFuel(),oder.getGone(),oder.getQuality(),oder.getPrice());
        car.setCity(provinceRepository.getOne(oder.getCity()));
        car.setBrand(brandCarRepository.getOne(oder.getBrand()));
        carRepository.save(car);


        PicCar picCar = new PicCar();
        PicCar picCar1 = new PicCar();
        PicCar picCar2 = new PicCar();

//      TRANSFORM IMAGE UPLOAD TO BASE64
        File pic1 = FileUploadUtil.convertToFile(oder.getFile1());
        File pic2 = FileUploadUtil.convertToFile(oder.getFile2());
        File pic3 = FileUploadUtil.convertToFile(oder.getFile3());
        String pic1Base64 = FileUploadUtil.encodeFileToBase64Binary(pic1);
        String pic2Base64 = FileUploadUtil.encodeFileToBase64Binary(pic2);
        String pic3Base64 = FileUploadUtil.encodeFileToBase64Binary(pic3);

        picCar.setCar1(car);
        picCar.setName(pic1Base64);
        picCarRepository.save(picCar);
        picCar1.setCar1(car);
        picCar1.setName(pic2Base64);
        picCarRepository.save(picCar1);
        picCar2.setCar1(car);
        picCar2.setName(pic3Base64);
        picCarRepository.save(picCar2);


        newCreate.setTitle(oder.getTitle());
        newCreate.setDescription(oder.getDes());
        newCreate.setSupport("chua");
        newCreate.setCarNew(car);

//      SET USER RECENT TO NEW CREATE
        User user = userRepository.findByUsername(myUserDetails.getUsername());
        newCreate.setUser(user);

        newRepository.save(newCreate);


        if(user.getRoles().contains(roleRepository.getRoleByName("ROLE_ADMIN"))){

            model.addAttribute("news", newRepository.findAll());
            return "doc/table-data-oder";
        }else if (user.getRoles().contains(roleRepository.getRoleByName("ROLE_USER"))){
            model.addAttribute("search",new Search());
            model.addAttribute("brands",brandCarRepository.findAll());
            model.addAttribute("provinces",provinceRepository.findAll());
            model.addAttribute("news",newRepository.findAll());
            return "Web/index";
        }
        return "doc/table-data-oder";
    }

    @GetMapping("/deleteNew/{id}")
    public String delete(@PathVariable("id") int id,Model model){
        New new2 = newRepository.getOne(id);
        Car car = new2.getCarNew();
        List<PicCar> picCars = car.getPicCars();
        picCarRepository.deleteAll(picCars);
        carRepository.delete(car);
        newRepository.delete(new2);
        model.addAttribute("news", newRepository.findAll());
        return "doc/table-data-oder";
    }
    @GetMapping("/form-edit-don-hang/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        New new1 = newRepository.findByIdNew(id);
        newInstance.getInstance().setRs(new1);
        User user = new1.getUser();
        Car car = new1.getCarNew();
        List<PicCar> picCars = car.getPicCars();
        model.addAttribute("piccar" ,picCars.get(0));
        model.addAttribute("piccar1" ,picCars.get(1));
        model.addAttribute("piccar2" ,picCars.get(2));
        Oder oder = new Oder(car.getName(), car.getCreate_car(), car.getNation(), car.getForm(), car.getState(), car.getGear(), car.getFuel(), car.getGone(), car.getQuality(), car.getPrice(), car.getCity().getCode(), car.getBrand().getId(), new1.getTitle(), new1.getDescription(), new1.getSupport() , user.getName());
        model.addAttribute("oderEdited", oder);
        model.addAttribute("provinces",provinceRepository.findAll());
        model.addAttribute("brands" , brandCarRepository.findAll());
        return "doc/form-edit-don-hang";
    }

//  CAN XEM LAI DIEU CHINH VIEC SU DUNG CHUNG PHUONG THUC SAVE BAI VIET






//    @PostMapping("/form-edit-don-hang")
//    public String updateUser(@ModelAttribute("oderEdited") Oder oder
//                            , Model model, @AuthenticationPrincipal MyUserDetails myUserDetails) throws IOException {
//        New newEdit = newInstance.getInstance().getRs();
//        Car car = newEdit.getCarNew();
//        car.setName(oder.getNameCar());
//        car.setCreate_car(oder.getCreate_car());
//        car.setNation(oder.getNation());
//        car.setForm(oder.getForm());
//        car.setState(oder.getState());
//        car.setGear(oder.getGear());
//        car.setFuel(oder.getFuel());
//        car.setGone(oder.getGone());
//        car.setQuality(oder.getQuality());
//        car.setPrice(oder.getPrice());
//        car.setCity(provinceRepository.getOne(oder.getCity()));
//        car.setBrand(brandCarRepository.getOne(oder.getBrand()));
//        carRepository.save(car);
//        List<PicCar> picCars = car.getPicCars();
//        MultipartFile multipartFile = oder.getFile1();
//        MultipartFile multipartFile1 = oder.getFile2();
//        MultipartFile multipartFile2 = oder.getFile3();
//        if(multipartFile.isEmpty() && multipartFile1.isEmpty() && multipartFile2.isEmpty()){
//            model.addAttribute("oderEdited",oder);
//            model.addAttribute("piccar" ,picCars.get(0).getName());
//            model.addAttribute("piccar1" ,picCars.get(1).getName());
//            model.addAttribute("piccar2" ,picCars.get(2).getName());
//            model.addAttribute("provinces",provinceRepository.findAll());
//            model.addAttribute("brands" , brandCarRepository.findAll());
//            model.addAttribute("user",user_logging);
//            model.addAttribute("error", "Upload image entire 3 image of car to edit New");
//            return "doc/form-edit-don-hang";
//        }
//
//        newEdit.setTitle(oder.getTitle());
//        newEdit.setDescription(oder.getDes());
//        newEdit.setSupport(oder.getSupport());
//        newEdit.setCarNew(car);
//        newEdit.setUser(user_logging);
//        newRepository.save(newEdit);
//        model.addAttribute("news",newRepository.findAll());
//        model.addAttribute("user",user_logging);
//        return "doc/table-data-oder";
//    }

    @GetMapping("/form-edit-car/{id}")
    public String getCar(@PathVariable("id") int id, Model model){
        Car car = carRepository.getOne(id);
        List<PicCar> picCars =  car.getPicCars();
        model.addAttribute("carEdit",car);
        model.addAttribute("piccar" ,picCars.get(0).getName());
        model.addAttribute("piccar1" ,picCars.get(1).getName());
        model.addAttribute("piccar2" ,picCars.get(2).getName());
        return "doc/form-edit-car";
    }

    @PostMapping("/add-brand-car")
    public String addBrandCar(@ModelAttribute("brandCar")@Valid Brand brandCar, BindingResult rs,Model model){
        BrandCar brandCar1 = new BrandCar();
        File pictureSaved = FileUploadUtil.convertToFile(brandCar.getPicture());
        String pic1Base64 = FileUploadUtil.encodeFileToBase64Binary(pictureSaved);
        brandCar1.setName(brandCar.getName());
        brandCar1.setPicture(pic1Base64);
        brandCarRepository.save(brandCar1);
        model.addAttribute("news", newRepository.findAll());
        model.addAttribute("brandCar",new Brand());
        return "doc/table-data-oder";
    }




}
