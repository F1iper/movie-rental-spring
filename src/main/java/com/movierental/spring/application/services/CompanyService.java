package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.CompanyDto;
import com.movierental.spring.application.dtos.CompanyUpdateDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> findAllCompanies();

    CompanyDto findCompanyById(Long id);

    CompanyDto createCompany(CompanyDto dto);

    CompanyDto updateCompanyName(Long id, CompanyUpdateDto companyUpdateDto);

    void deleteCompanyById(Long id);

    boolean deleteAllCompanies();

}
