package com.example.otocu.demo.Repository;

import com.example.otocu.demo.Model.BrandCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCarRepository extends JpaRepository<BrandCar,Integer> {
}
