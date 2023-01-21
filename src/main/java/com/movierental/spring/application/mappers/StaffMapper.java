package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.StaffDto;
import com.movierental.spring.application.entities.Staff;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class StaffMapper extends BaseMapper<StaffDto, Staff> {


    @Override
    public StaffDto toDto(Staff entity) {
        StaffDto dto = new StaffDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Staff toEntity(StaffDto dto) {
        Staff staff = new Staff();
        BeanUtils.copyProperties(dto, staff);
        return staff;
    }
}
