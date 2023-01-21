package com.movierental.spring.application.mappers;

import com.movierental.spring.application.dtos.ActorDto;
import com.movierental.spring.application.entities.Actor;
import com.movierental.spring.application.mappers.base.BaseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ActorMapper extends BaseMapper<ActorDto, Actor> {

    @Override
    public ActorDto toDto(Actor entity) {
        ActorDto dto = new ActorDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public Actor toEntity(ActorDto dto) {
        Actor actor = new Actor();
        BeanUtils.copyProperties(dto, actor);
        return actor;
    }
}
