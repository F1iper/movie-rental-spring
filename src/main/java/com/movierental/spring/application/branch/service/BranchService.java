package com.movierental.spring.application.branch.service;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;

import java.util.List;

public interface BranchService {

    List<BranchDto> findBranches();

    BranchDto add(BranchDto dto);

    BranchDto update(Long id, BranchUpdateDto branchUpdateDto);

    boolean deleteById(Long id);

    boolean deleteAll();

    BranchDto findById(Long id);

}
