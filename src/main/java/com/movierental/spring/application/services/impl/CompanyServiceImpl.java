package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.dtos.CompanyDto;
import com.movierental.spring.application.dtos.CompanyUpdateDto;
import com.movierental.spring.application.entities.Company;
import com.movierental.spring.application.mappers.CompanyMapper;
import com.movierental.spring.application.repositories.CompanyRepository;
import com.movierental.spring.application.services.CompanyService;
import com.movierental.spring.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyDto> findAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> new CompanyDto(company.getCompanyId(), company.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto findCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Company with id: " + id + " does not exist."));
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto createCompany(CompanyDto dto) {
        Company company = companyMapper.toEntity(dto);
        Company saved = companyRepository.save(company);
        company.setCompanyId(saved.getCompanyId());
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto updateCompanyName(Long id, CompanyUpdateDto companyUpdateDto) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent() && companyUpdateDto != null) {
            Company company = companyOptional.get();

            companyMapper.toDto(company);
            company.setName(companyUpdateDto.getName());
            company = companyRepository.save(company);
            return companyMapper.toDto(company);
        }
        throw new ResourceNotFoundException("Company with id: " + id + " not found.");
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Company with id: " + id + " not found."));
        companyRepository.delete(company);
    }

    @Override
    public boolean deleteAllCompanies() {
        long countBefore = companyRepository.count();
        companyRepository.deleteAll();
        long countAfter = companyRepository.count();
        return countAfter < countBefore;
    }
}
