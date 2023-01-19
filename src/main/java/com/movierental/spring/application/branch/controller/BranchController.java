package com.movierental.spring.application.branch.controller;

import com.movierental.spring.application.branch.dto.BranchDto;
import com.movierental.spring.application.branch.dto.BranchUpdateDto;
import com.movierental.spring.application.branch.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/branches")
@RequiredArgsConstructor
public class BranchController {

    private final BranchService branchService;

    @GetMapping
    public ResponseEntity<List<BranchDto>> findAllBranches() {
        return new ResponseEntity<>(branchService.findBranches(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDto> findBranchById(@PathVariable Long id) {
        return new ResponseEntity<>(branchService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BranchDto> addBranch(@RequestBody @Valid BranchDto dto) {
        return new ResponseEntity<>(branchService.add(dto), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<BranchDto> updateCompanyName(@PathVariable Long id, @RequestBody BranchUpdateDto updateDto) {
        return new ResponseEntity<>(branchService.update(id, updateDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBranchById(@PathVariable Long id) {
        branchService.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity deleteAllBranches() {
        if (branchService.deleteAll()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
