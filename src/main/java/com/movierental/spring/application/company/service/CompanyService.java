package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.dto.CompanyUpdateDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> findCompanies();

    CompanyDto findById(Long id);

    CompanyDto add(CompanyDto dto);

    CompanyDto update(Long id, CompanyUpdateDto companyUpdateDto);

    boolean deleteById(Long id);

    boolean deleteAll();

}
