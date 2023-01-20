package com.movierental.spring.application.repositories;

import com.movierental.spring.application.entities.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
