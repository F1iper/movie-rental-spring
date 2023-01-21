package com.movierental.spring.application.services;

import com.movierental.spring.application.dtos.StaffDto;

import java.util.List;

public interface StaffService {
    List<StaffDto> findAllStaff();

    StaffDto findStaffById(Long id);

    StaffDto createStaff(StaffDto dto);

    void deleteStaffById(Long id);

    boolean deleteAllStaffMembers();
}
