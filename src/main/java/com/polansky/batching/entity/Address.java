package com.polansky.batching.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "batch_address")
@Data
@NoArgsConstructor
public class Address {


    @Id
    @SequenceGenerator(name = "seq_address", sequenceName = "seq_address", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_address")
    private Long id;

    @Column(name = "street")
    private String street;

}
