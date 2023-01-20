package com.movierental.spring.application.actor.mapper;

import com.movierental.spring.application.actor.dto.ActorDto;
import com.movierental.spring.application.actor.entity.Actor;
import com.movierental.spring.base.mapper.BaseMapper;
import org.springframework.stereotype.Service;

@Service
public class ActorMapper extends BaseMapper<ActorDto, Actor> {

    @Override
    public ActorDto toDto(Actor entity) {
        ActorDto dto = new ActorDto();
        dto.setId(entity.getId());
        dto.setFirstname(entity.getFirstname());
        dto.setLastname(entity.getLastname());
        return dto;
    }

    @Override
    public Actor toEntity(ActorDto dto) {
        Actor actor = new Actor();
        actor.setId(dto.getId());
        actor.setFirstname(dto.getFirstname());
        actor.setLastname(dto.getLastname());
        return actor;
    }
}
