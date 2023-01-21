package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.CompanyDto;
import com.movierental.spring.application.entities.Company;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CompanyMapper extends BaseMapper<CompanyDto, Company> {

    @Override
    public CompanyDto toDto(Company entity) {
        CompanyDto dto = new CompanyDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Company toEntity(CompanyDto dto) {
        Company company = new Company();
        BeanUtils.copyProperties(dto, company);
        return company;
    }
}
