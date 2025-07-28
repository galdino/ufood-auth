package com.galdino.ufood.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class UGroup {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "ugroup_upermission", joinColumns = @JoinColumn(name = "ugroup_id"),
               inverseJoinColumns = @JoinColumn(name = "upermission_id"))
    private Set<UPermission> uPermissions = new HashSet<>();


}
