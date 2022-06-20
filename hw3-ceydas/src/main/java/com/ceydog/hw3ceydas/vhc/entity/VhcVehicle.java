package com.ceydog.hw3ceydas.vhc.entity;

import com.ceydog.hw3ceydas.gen.entity.BaseEntity;
import com.ceydog.hw3ceydas.usr.entity.UsrUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VHC_VEHICLE")
@Getter
@Setter
public class VhcVehicle extends BaseEntity {
    @Id
    @SequenceGenerator(name = "VhcVehicle", sequenceName = "VHC_VEHICLE_ID_SEQ")
    @GeneratedValue(generator = "VhcVehicle")
    private Long id;

    @Column(name = "PLATE_CODE", nullable = false)
    private String plateCode;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Column(name = "MODEL", nullable = false)
    private String model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USR_USER")
    private UsrUser usrUser;
}
