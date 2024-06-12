package com.example.repository;

import com.example.model.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LugarRepository extends CrudRepository<LugarEntity, String> {


    @Modifying
    @Transactional
    @Query("UPDATE LugarEntity l SET l.capacidad = :capacidad WHERE l.id = :id")
    void updateCapacidad(@Param("id") String id, @Param("capacidad") int capacidad);


    @Modifying
    @Transactional
    @Query("UPDATE LugarEntity l SET l.nombre = :nombre, l.capacidad = :capacidad WHERE l.id = :id")
    void updateLugar(@Param("id") String id, @Param("nombre") String nombre, @Param("capacidad") int capacidad);

}
