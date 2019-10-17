package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriminalCaseRepo extends JpaRepository<CriminalCase, String> {

    List<CriminalCase> findAllByOrderByTimeDesc();

    List<CriminalCase> findAllByName(String name);

}
