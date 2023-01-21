package com.movierental.spring.application.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "positions")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "position_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "position")
    private List<Staff> staffMembers;
}
