package com.backend.bart.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="arrays")

public class Glass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name="id")
    private Long id;

    @Getter @Setter @Column(name="input_array")
    private String array;
}
