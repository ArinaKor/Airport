package com.example.demo.repository;

import com.example.demo.entity.Plane;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {


    @Query("from Plane pl WHERE pl.town = :town")
    List<Plane> findByTown(String town);

    @Query("from Plane pl WHERE pl.airport1 = :airport1")
    List<Plane> findByAirport1(String airport1);

    @Query("from Plane pl WHERE pl.airport1 = :airport2")
    List<Plane> findByAirport2(String airport2);

   /*Page<Plane> findAll(Pageable pageable);*/

/*
    List<Plane> findPlaneByAirport1(long departmentId, Pageable pageable);*/
}
