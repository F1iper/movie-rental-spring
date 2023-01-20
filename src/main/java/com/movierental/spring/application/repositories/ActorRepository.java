package com.movierental.spring.application.repositories;

import com.movierental.spring.application.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
