package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.CriminalElements;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CriminalElementRepo extends JpaRepository<CriminalElements, String> {

}
