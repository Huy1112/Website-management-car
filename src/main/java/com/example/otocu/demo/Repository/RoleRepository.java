package com.example.otocu.demo.Repository;

import com.example.otocu.demo.Model.Province;
import com.example.otocu.demo.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("SELECT r FROM Role r where r.name =:name")
    Role getRoleByName(@Param("name") String name);
}
