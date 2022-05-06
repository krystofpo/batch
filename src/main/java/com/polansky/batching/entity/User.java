package com.polansky.batching.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "batch_user")
@Data
@NoArgsConstructor
public class User {


    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", allocationSize = 100)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    private Long id;


    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<Address> addresses;
}
