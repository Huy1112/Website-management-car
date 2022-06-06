package com.example.otocu.demo.ModelData;


import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@Data
public class Brand {

    @NotEmpty(message = "The name of brand can't be null")
    private String name;
    @NotFound
    private MultipartFile picture;
}
