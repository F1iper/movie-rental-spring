package com.movierental.spring.application.company.mapper;

import com.movierental.spring.application.company.dto.CompanyDto;
import com.movierental.spring.application.company.entity.Company;
import com.movierental.spring.base.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper extends BaseMapper<CompanyDto, Company> {

    @Override
    public CompanyDto toDto(Company entity) {
        CompanyDto dto = new CompanyDto();
        dto.setId(entity.getCompanyId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public Company toEntity(CompanyDto dto) {
        Company company = new Company();
        company.setCompanyId(dto.getId());
        company.setName(dto.getName());
        return company;
    }
}
