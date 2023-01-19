package com.movierental.spring.application.company.controller;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.dto.CompanyUpdateDto;
import com.movierental.spring.application.company.service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public ResponseEntity<List<CompanyDto>> findAllCompanies() {
        return new ResponseEntity<>(companyService.findCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findCompanyById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CompanyDto> addCompany(@RequestBody @Valid CompanyDto dto) {
        return new ResponseEntity<>(companyService.add(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompanyDto> updateCompanyName(@PathVariable Long id, @RequestBody CompanyUpdateDto updateDto) {
        return new ResponseEntity<>(companyService.update(id, updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompanyById(@PathVariable Long id) {
        companyService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllCompanies() {
        if (companyService.deleteAll()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
