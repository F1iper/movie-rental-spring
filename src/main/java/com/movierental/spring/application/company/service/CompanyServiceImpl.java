package com.movierental.spring.application.company.service;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.entity.Company;
import com.movierental.spring.application.company.mapper.CompanyMapper;
import com.movierental.spring.application.company.repository.CompanyRepository;
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
    public List<CompanyDto> getAll() {
        List<Company> companies = companyRepository.findAll();
        return companies.stream()
                .map(company -> new CompanyDto(company.getCompanyId(), company.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDto add(CompanyDto dto) {
        Company company = companyMapper.toEntity(dto);
        companyRepository.save(company);
        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDto update(Long id, String name) {
        Optional<Company> byId = companyRepository.findById(id);
        if (byId.isPresent()) {
            Company company = byId.get();
            company.setName(name);
            companyRepository.save(company);
            return companyMapper.toDto(company);
        }
        return null;
    }
}
