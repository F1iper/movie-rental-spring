package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.entity.CompanyUpdateDto;
import com.movierental.spring.exception.ResourceNotFoundException;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAll();

    CompanyDto add(CompanyDto dto);

    CompanyDto update(Long id, CompanyUpdateDto companyUpdateDto);
}
