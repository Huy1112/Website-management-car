package com.example.otocu.demo.Repository;

import com.example.otocu.demo.Model.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface NewRepository extends JpaRepository<New,Integer> {
    @Query("SELECT n FROM New n WHERE n.id = ?1")
    New findByIdNew(int id);

    @Query("SELECT n FROM New n WHERE n.carNew.form = ?1")
    List<New> findByFormCar(String form);


    @Query("SELECT SUM(n) FROM New n WHERE n.carNew.form = ?1")
    Integer findSumCar(String form);

    @Query("SELECT n FROM New n WHERE (:old is null or n.carNew.state = :old) "+
            "and (:neww is null or n.carNew.state = :neww) "+
            "and (n.carNew.city.code = :codeCity) "+
            "and (n.carNew.brand.id = :brand) "+
            "and (n.carNew.price BETWEEN :pricefrom AND :priceto) " +
            "and (n.carNew.create_car BETWEEN :yearfrom AND :yearto) " +
            "or (:gear1 is null or n.carNew.gear = :gear1) " +
            "or (:gear2 is null or n.carNew.gear = :gear2) "+
            "or (:fuel1 is null or n.carNew.fuel = :fuel1) " +
            "or (:fuel2 is null or n.carNew.fuel = :fuel2) " +
            "or (:fuel3 is null or n.carNew.fuel = :fuel3) "+
            "or (:nation1 is null or n.carNew.nation = :nation1) " +
            "or (:nation2 is null or n.carNew.nation = :nation2) "
            )
    List<New> search(
            @Param("old")String old
            ,@Param("neww")String neww
            ,@Param("codeCity")String codeCity
            ,@Param("brand")int brand
            ,@Param("pricefrom")int pricefrom
            ,@Param("priceto")int priceto
            ,@Param("yearfrom")int yearfrom
            ,@Param("yearto")int yearto
            ,@Param("gear1")String gear1
            ,@Param("gear2")String gear2
            ,@Param("fuel1")String fuel1
            ,@Param("fuel2")String fuel2
            ,@Param("fuel3")String fuel3
            ,@Param("nation1")String nation1
            ,@Param("nation2")String nation2
    );


    @Query("Select n FROM New n WHERE n.carNew.city.code = ?1")
    List<New> findAllByCodeCity(String code);

    @Query("Select n FROM New n WHERE n.carNew.brand.id = ?1")
    List<New> findAllByBrand(int code);

    @Query("SELECT n FROM New n WHERE  n.carNew.city.code = :city " +
            "AND n.carNew.brand.name = :brand " +
            "AND n.carNew.name LIKE :nameCar")
    List<New> findAllByCodeCityBrandNameCar(@Param("brand") String brand,@Param("nameCar") String nameCar,@Param("city") String city);

    @Query("Select n FROM New n WHERE n.user.email = :email")
    List<New> findByUser(@Param("email")String email);
}
