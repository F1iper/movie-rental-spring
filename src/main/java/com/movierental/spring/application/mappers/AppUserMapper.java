package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.AppUserDto;
import com.movierental.spring.application.entities.AppUser;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class AppUserMapper extends BaseMapper<AppUserDto, AppUser> {

    @Override
    public AppUserDto toDto(AppUser entity) {
        AppUserDto dto = new AppUserDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public AppUser toEntity(AppUserDto dto) {
        AppUser entity = new AppUser();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
