package com.movierental.spring.application.controllers;

import com.movierental.spring.application.dtos.CompanyDto;
import com.movierental.spring.application.dtos.CompanyUpdateDto;
import com.movierental.spring.application.services.CompanyService;
import com.movierental.spring.application.controllers.controller.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/companies")
@RequiredArgsConstructor
public class CompanyController implements BaseController<CompanyDto> {

    private final CompanyService companyService;

    @GetMapping
    @Override
    public ResponseEntity<List<CompanyDto>> findAll() {
        return new ResponseEntity<>(companyService.findAllCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CompanyDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<CompanyDto> create(@RequestBody @Valid CompanyDto dto) {
        return new ResponseEntity<>(companyService.createCompany(dto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CompanyDto> update(@PathVariable Long id, @RequestBody CompanyUpdateDto updateDto) {
        return new ResponseEntity<>(companyService.updateCompanyName(id, updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Override
    public ResponseEntity deleteAll() {
        if (companyService.deleteAllCompanies()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
