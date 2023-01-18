package com.movierental.spring.application.branch.repository;

import com.movierental.spring.application.branch.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<Branch, Long> {
}
