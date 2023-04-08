package com.hanin.parfums.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.hanin.parfums.entities.Parfum;
public interface ParfumRepository extends JpaRepository<Parfum, Long> {
}