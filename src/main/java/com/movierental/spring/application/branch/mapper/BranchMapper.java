package com.movierental.spring.application.branch.mapper;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.entity.Branch;
import com.movierental.spring.base.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class BranchMapper extends BaseMapper<BranchDto, Branch> {

    @Override
    public BranchDto toDto(Branch entity) {
        BranchDto dto = new BranchDto();
        dto.setId(entity.getBranchId());
        dto.setName(entity.getName());
        return dto;
    }

    @Override
    public Branch toEntity(BranchDto dto) {
        Branch branch = new Branch();
        branch.setBranchId(dto.getId());
        branch.setName(dto.getName());
        return branch;
    }
}
