package com.movierental.spring.application.branch.service;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;
import com.movierental.spring.application.branch.entity.Branch;
import com.movierental.spring.application.branch.mapper.BranchMapper;
import com.movierental.spring.application.branch.repository.BranchRepository;
import com.movierental.spring.exception.ResourceNotFoundException;
import com.movierental.spring.base.validator.CustomValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;
    private final CustomValidator customValidator;

    @Override
    public List<BranchDto> findAllBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(branch -> new BranchDto(branch.getBranchId(), branch.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto findBranchById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch with id: " + id + " does not exist."));
        return branchMapper.toDto(branch);
    }

    @Override
    public BranchDto createBranch(BranchDto dto) {
        customValidator.validateValueLength(dto.getName(), "Branch name");
        Branch branch = branchMapper.toEntity(dto);
        branchRepository.save(branch);
        return branchMapper.toDto(branch);
    }

    public BranchDto updateName(Long id, BranchUpdateDto branchUpdateDto) {
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if (branchOptional.isPresent() && branchUpdateDto != null) {
            Branch branch = branchOptional.get();

            customValidator.validateValueLength(branchUpdateDto.getName(), "Branch name");
            branchMapper.toDto(branch);
            branch.setName(branchUpdateDto.getName());
            branch = branchRepository.save(branch);
            return branchMapper.toDto(branch);
        }
        throw new ResourceNotFoundException("Branch with id: " + id + " not found.");
    }

    @Override
    public void deleteBranchById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch with id: " + id + " not found."));
        branchRepository.delete(branch);
    }

    @Override
    public boolean deleteAllBranches() {
        long countBefore = branchRepository.count();
        branchRepository.deleteAll();
        long countAfter = branchRepository.count();
        return countAfter < countBefore;
    }
}
