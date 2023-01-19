package com.movierental.spring.application.actor.repository;

import com.movierental.spring.application.actor.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
