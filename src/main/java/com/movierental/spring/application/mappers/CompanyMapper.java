package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.CompanyDto;
import com.movierental.spring.application.entities.Company;
import com.movierental.spring.application.mappers.base.BaseMapper;
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
