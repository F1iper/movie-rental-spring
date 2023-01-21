package com.movierental.spring.application.repositories;

import com.movierental.spring.application.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
