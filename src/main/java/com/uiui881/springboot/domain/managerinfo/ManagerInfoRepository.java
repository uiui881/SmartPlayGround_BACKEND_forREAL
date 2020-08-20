package com.uiui881.springboot.domain.managerinfo;

import com.uiui881.springboot.domain.rides.Rides;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ManagerInfoRepository extends JpaRepository<ManagerInfo, Long> {

    @Query("SELECT mi from ManagerInfo mi ORDER BY mi.managerId DESC")
    List<ManagerInfo> findAllDesc();
}
