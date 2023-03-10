package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.BranchDto;
import com.movierental.spring.application.entities.Branch;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BranchMapper extends BaseMapper<BranchDto, Branch> {

    @Override
    public BranchDto toDto(Branch entity) {
        BranchDto dto = new BranchDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Branch toEntity(BranchDto dto) {
        Branch branch = new Branch();
        BeanUtils.copyProperties(dto, branch);
        return branch;
    }
}
