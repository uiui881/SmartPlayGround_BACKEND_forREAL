package com.uiui881.springboot.domain.safety;

import com.uiui881.springboot.domain.rides.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SafetyRepository extends JpaRepository<Safety, Long> {
    @Query("SELECT s from Safety s ORDER BY s.id_s DESC")
    List<Safety> findAllDesc();
}
