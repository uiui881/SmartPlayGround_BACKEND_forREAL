package com.uiui881.springboot.domain.playgrounds;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaygroundsRepository extends JpaRepository<Playgrounds, Long> {

    @Query("SELECT p from Playgrounds p ORDER BY p.playgroundId DESC")
    List<Playgrounds> findAllDesc();
}
