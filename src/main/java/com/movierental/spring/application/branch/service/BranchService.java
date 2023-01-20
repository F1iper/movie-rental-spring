package com.movierental.spring.application.branch.service;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;

import java.util.List;

public interface BranchService {

    List<BranchDto> findAllBranches();

    BranchDto findBranchById(Long id);

    BranchDto createBranch(BranchDto dto);

    BranchDto updateName(Long id, BranchUpdateDto branchUpdateDto);

    void deleteBranchById(Long id);

    boolean deleteAllBranches();
}
