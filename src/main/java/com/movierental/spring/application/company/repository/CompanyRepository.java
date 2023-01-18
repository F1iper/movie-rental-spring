package com.movierental.spring.application.company.repository;

import com.movierental.spring.application.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
