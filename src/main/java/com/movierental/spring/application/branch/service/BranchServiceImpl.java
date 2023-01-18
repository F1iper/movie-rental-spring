package com.movierental.spring.application.branch.service;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;
import com.movierental.spring.application.branch.entity.Branch;
import com.movierental.spring.application.branch.mapper.BranchMapper;
import com.movierental.spring.application.branch.repository.BranchRepository;
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
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final BranchMapper branchMapper;

    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 40;

    @Override
    public List<BranchDto> findBranches() {
        List<Branch> branches = branchRepository.findAll();
        return branches.stream()
                .map(branch -> new BranchDto(branch.getBranchId(), branch.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public BranchDto findById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch with id: " + id + " does not exist."));
        return branchMapper.toDto(branch);
    }

    @Override
    public BranchDto add(BranchDto dto) {
        if (dto.getName().length() < 2) {
            throw new InvalidDataLengthException("Branch name must have a minimum length of 2 characters");
        }
        if (dto.getName().length() > 40) {
            throw new InvalidDataLengthException("Branch name must have a maximum length of 40 characters");
        }
        Branch branch = branchMapper.toEntity(dto);
        branchRepository.save(branch);
        return branchMapper.toDto(branch);
    }

    @Override
    public BranchDto update(Long id, BranchUpdateDto branchUpdateDto) {
        Optional<Branch> branchOptional = branchRepository.findById(id);
        if (branchOptional.isPresent() && branchUpdateDto != null) {
            Branch branch = branchOptional.get();
            if (branchUpdateDto.getName() == null) {
                throw new EmptyValueException("Name cannot be empty.");
            }
            if (branchUpdateDto.getName().length() > MAX_NAME_LENGTH) {
                throw new InvalidDataLengthException("Name length exceeds maximum of " + MAX_NAME_LENGTH + " characters.");
            }
            if (branchUpdateDto.getName().length() < MIN_NAME_LENGTH) {
                throw new InvalidDataLengthException("Name length is less than minimum of " + MIN_NAME_LENGTH + " characters.");
            }
            branchMapper.toDto(branch);
            branch.setName(branchUpdateDto.getName());
            branch = branchRepository.save(branch);
            return branchMapper.toDto(branch);
        }
        throw new ResourceNotFoundException("Branch with id: " + id + " not found.");
    }

    @Override
    public boolean deleteById(Long id) {
        Branch branch = branchRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Branch with id: " + id + " not found."));
        branchRepository.delete(branch);
        return true;
    }

    @Override
    public boolean deleteAll() {
        long countBefore = branchRepository.count();
        branchRepository.deleteAll();
        long countAfter = branchRepository.count();
        return countAfter < countBefore;
    }
}
