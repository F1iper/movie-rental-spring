package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.dto.CompanyUpdateDto;
import com.movierental.spring.application.company.entity.Company;
import com.movierental.spring.application.company.mapper.CompanyMapper;
import com.movierental.spring.application.company.repository.CompanyRepository;
import com.movierental.spring.exception.ResourceNotFoundException;
import com.movierental.spring.base.validator.CustomValidator;
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
    private final CustomValidator validator;

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
        validator.validateValueLength(dto.getName(), "Company name");
        Company company = companyMapper.toEntity(dto);
        companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto updateCompanyName(Long id, CompanyUpdateDto companyUpdateDto) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent() && companyUpdateDto != null) {
            Company company = companyOptional.get();

            validator.validateValueLength(companyUpdateDto.getName(), "Company name");

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
