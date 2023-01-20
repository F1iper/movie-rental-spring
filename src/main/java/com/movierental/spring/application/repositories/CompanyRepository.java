package com.movierental.spring.application.repositories;

import com.movierental.spring.application.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
