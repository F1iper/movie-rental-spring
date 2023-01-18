package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.entity.Company;
import com.movierental.spring.application.company.dto.CompanyUpdateDto;
import com.movierental.spring.application.company.mapper.CompanyMapper;
import com.movierental.spring.application.company.repository.CompanyRepository;
import com.movierental.spring.exception.EmptyValueException;
import com.movierental.spring.exception.InvalidDataLengthException;
import com.movierental.spring.exception.ResourceNotFoundException;
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
    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 40;

    @Override
    public List<CompanyDto> findCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> new CompanyDto(company.getCompanyId(), company.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto findById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Company with id: " + id + " does not exist."));
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto add(CompanyDto dto) {
        if (dto.getName().length() < 2) {
            throw new InvalidDataLengthException("Company name must have a minimum length of 2 characters");
        }
        if (dto.getName().length() > 40) {
            throw new InvalidDataLengthException("Company name must have a maximum length of 40 characters");
        }
        Company company = companyMapper.toEntity(dto);
        companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto update(Long id, CompanyUpdateDto companyUpdateDto) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent() && companyUpdateDto != null) {
            Company company = companyOptional.get();
            if (companyUpdateDto.getName() == null) {
                throw new EmptyValueException("Name cannot be empty.");
            }
            if (companyUpdateDto.getName().length() > MAX_NAME_LENGTH) {
                throw new InvalidDataLengthException("Name length exceeds maximum of " + MAX_NAME_LENGTH + " characters.");
            }
            if (companyUpdateDto.getName().length() < MIN_NAME_LENGTH) {
                throw new InvalidDataLengthException("Name length is less than minimum of " + MIN_NAME_LENGTH + " characters.");
            }
            companyMapper.toDto(company);
            company.setName(companyUpdateDto.getName());
            company = companyRepository.save(company);
            return companyMapper.toDto(company);
        }
        throw new ResourceNotFoundException("Company with id: " + id + " not found.");
    }

    @Override
    public boolean deleteById(Long id) {
        Company company = companyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Company with id: " + id + " not found."));
        companyRepository.delete(company);
        return true;
    }

    @Override
    public boolean deleteAll() {
        long countBefore = companyRepository.count();
        companyRepository.deleteAll();
        long countAfter = companyRepository.count();
        return countAfter < countBefore;
    }
}
