package com.movierental.spring.application.company.controller;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public List<CompanyDto> getCompanies() {
        return companyService.getAll();
    }

    @PostMapping
    public CompanyDto addCompany(@RequestBody @Valid CompanyDto dto) {
        return companyService.add(dto);
    }

    @PatchMapping("/{id}")
    // TODO: 1/18/23 Validate the String or pass the body with part ?
    public CompanyDto updateCompanyName(@PathVariable Long id, @Valid String name) {
        return companyService.update(id, name);
    }
}
