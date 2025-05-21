package com.frota.umu.model;
import jakarta.persistence.*;
import com.frota.umu.model.enums.DriverStatus;

import java.time.LocalDate;

@Entity
@Table(name = "tb_drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;

    @Column(name = "license_category", nullable = false)
    private String licenseCategory;

    @Column(name = "license_expiration", nullable = false)
    private LocalDate licenseExpiration;

    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private DriverStatus status;

    public Driver(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public LocalDate getLicenseExpiration() {
        return licenseExpiration;
    }

    public void setLicenseExpiration(LocalDate licenseExpiration) {
        this.licenseExpiration = licenseExpiration;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", licenseCategory='" + licenseCategory + '\'' +
                ", licenseExpiration=" + licenseExpiration +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
