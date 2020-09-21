package com.smart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.entity.LogsData;

@Repository
public interface LogDataRepository extends JpaRepository<LogsData, Integer> {

}

