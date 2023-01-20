package com.movierental.spring.application.branch.controller;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;
import com.movierental.spring.application.branch.service.BranchService;
import com.movierental.spring.base.controller.BaseController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController implements BaseController<BranchDto> {

    private final BranchService branchService;

    @GetMapping
    @Override
    public ResponseEntity<List<BranchDto>> findAll() {
        return new ResponseEntity<>(branchService.findAllBranches(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<BranchDto> findById(@PathVariable Long id) {
        return new ResponseEntity<>(branchService.findBranchById(id), HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<BranchDto> create(@RequestBody @Valid BranchDto dto) {
        return new ResponseEntity<>(branchService.createBranch(dto), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BranchDto> updateCompanyName(@PathVariable Long id, @RequestBody BranchUpdateDto updateDto) {
        return new ResponseEntity<>(branchService.updateName(id, updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity deleteById(@PathVariable Long id) {
        branchService.deleteBranchById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Override
    public ResponseEntity deleteAll() {
        if (branchService.deleteAllBranches()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
