package com.uiui881.springboot.domain.rides;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface RidesRepository extends JpaRepository<Rides, Long> {


    @Query("SELECT r from Rides r join Playgrounds p on r.id_p = p.playgroundId ORDER BY r.id_r DESC")
    List<Rides> findAllDesc();
}
