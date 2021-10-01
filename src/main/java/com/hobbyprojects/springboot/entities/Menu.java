package com.hobbyprojects.springboot.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Restaurant restaurant;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuItem> menuItems;
}
