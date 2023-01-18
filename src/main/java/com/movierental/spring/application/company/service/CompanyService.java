package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;

import java.util.List;

public interface CompanyService {

    List<CompanyDto> getAll();

    CompanyDto add(CompanyDto company);

    CompanyDto update(Long id, String name);
}
