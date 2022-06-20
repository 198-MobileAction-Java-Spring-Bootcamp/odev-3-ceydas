package com.ceydog.hw3ceydas.usr.entity;


import com.ceydog.hw3ceydas.gen.entity.BaseEntity;
import com.ceydog.hw3ceydas.vhc.entity.VhcVehicle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USR_USER")
@Getter
@Setter
public class UsrUser extends BaseEntity {
    @Id
    @SequenceGenerator(name = "UsrUser", sequenceName = "USR_USER_ID_SEQ")
    @GeneratedValue(generator = "UsrUser")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @Column(name = "USERNAME", length = 30, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "PASSWORD", length = 80, nullable = false)
    private String password;

    @Column(name = "OLD_PASSWORD", length = 80, nullable = true)
    private String oldPassword;

}


