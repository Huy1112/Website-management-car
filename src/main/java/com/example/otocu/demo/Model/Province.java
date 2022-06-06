package com.example.otocu.demo.Model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "provinces")
@Entity
public class Province implements Serializable {

    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
