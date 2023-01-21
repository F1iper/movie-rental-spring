package com.movierental.spring.application.services.impl;

import com.movierental.spring.application.dtos.StaffDto;
import com.movierental.spring.application.dtos.StaffUpdateSalaryDto;
import com.movierental.spring.application.entities.Staff;
import com.movierental.spring.application.mappers.StaffMapper;
import com.movierental.spring.application.repositories.StaffRepository;
import com.movierental.spring.application.services.StaffService;
import com.movierental.spring.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;
    private final StaffMapper staffMapper;

    @Override
    public List<StaffDto> findAllStaff() {
        List<Staff> staffList = staffRepository.findAll();
        return staffList.stream()
                .map(staffMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StaffDto findStaffById(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Staff member with id: " + id + " does not exist."));
        return staffMapper.toDto(staff);
    }

    @Override
    public StaffDto createStaff(StaffDto dto) {
        Staff staff = staffMapper.toEntity(dto);
        Staff saved = staffRepository.save(staff);
        staff.setStaffId(saved.getStaffId());
        return staffMapper.toDto(saved);
    }

    @Override
    public StaffDto updateStaffSalary(Long id, StaffUpdateSalaryDto dto) {
        Optional<Staff> staffOptional = staffRepository.findById(id);
        if (staffOptional.isPresent()) {
            Staff staff = staffOptional.get();
            if (dto != null) {
                staff.setSalary(dto.getSalary());
            }

            staff = staffRepository.save(staff);
            return staffMapper.toDto(staff);
        }
        throw new ResourceNotFoundException("Staff member with id: " + id + " not found.");
    }

    @Override
    public void deleteStaffById(Long id) {
        Staff staff = staffRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Staff member with id: " + id + " not found."));
        staffRepository.delete(staff);
    }

    @Override
    public boolean deleteAllStaffMembers() {
        long countBefore = staffRepository.count();
        staffRepository.deleteAll();
        long countAfter = staffRepository.count();
        return countAfter < countBefore;
    }
}
