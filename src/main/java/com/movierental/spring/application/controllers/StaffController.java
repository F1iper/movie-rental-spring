package com.movierental.spring.application.controllers;

import com.movierental.spring.application.controllers.controller.BaseController;
import com.movierental.spring.application.dtos.StaffDto;
import com.movierental.spring.application.services.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/staff")
@RequiredArgsConstructor
public class StaffController implements BaseController<StaffDto> {

    private final StaffService staffService;

    @GetMapping
    @Override
    public ResponseEntity<List<StaffDto>> findAll() {
        return new ResponseEntity<>(staffService.findAllStaff(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<StaffDto> findById(Long id) {
        return new ResponseEntity<>(staffService.findStaffById(id), HttpStatus.OK);
    }

    @PostMapping
    @Override
    public ResponseEntity<StaffDto> create(@RequestBody @Valid StaffDto dto) {
        return new ResponseEntity<>(staffService.createStaff(dto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Void> deleteAll() {
        if (staffService.deleteAllStaffMembers()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
