package com.movierental.spring.application.company.controller;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.entity.CompanyUpdateDto;
import com.movierental.spring.application.company.service.CompanyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
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
    public CompanyDto updateCompanyName(@PathVariable Long id, @RequestBody CompanyUpdateDto updateDto) {
        return companyService.update(id, updateDto);
    }

//    @DeleteMapping("/{id}")
//    public

}
