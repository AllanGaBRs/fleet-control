package com.frota.umu.config;

import com.frota.umu.model.Driver;
import com.frota.umu.model.Trip;
import com.frota.umu.model.Vehicle;
import com.frota.umu.model.enums.DriverStatus;
import com.frota.umu.model.enums.TripStatus;
import com.frota.umu.model.enums.VehicleStatus;
import com.frota.umu.repository.DriverRepository;
import com.frota.umu.repository.TripRepository;
import com.frota.umu.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DriverRepository driverRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private TripRepository tripRepository;

    @Override
    public void run(String... args) throws Exception {

        Vehicle v1 = new Vehicle();
        v1.setBrand("honda");
        v1.setModel("turbo");
        v1.setPlate("KJFK-4532");
        v1.setYear(2005);
        v1.setType("carro");
        v1.setStatus(VehicleStatus.IN_USE);
        vehicleRepository.save(v1);

        Driver driver = new Driver();
        driver.setName("João Silva");
        driver.setLicenseNumber("ABC123456");
        driver.setLicenseCategory("B");
        driver.setLicenseExpiration(LocalDate.of(2027, 12, 31));
        driver.setPhone("(11) 98765-4321");
        driver.setStatus(DriverStatus.ACTIVE);
        driverRepository.save(driver);

        Trip trip = new Trip();
        trip.setVehicle(v1);
        trip.setDriver(driver);
        trip.setOrigin("São Paulo");
        trip.setDestination("Rio de Janeiro");
        trip.setDepartureDate(LocalDateTime.of(2025, 6, 10, 8, 0));
        trip.setArrivalDate(LocalDateTime.of(2025, 6, 10, 14, 30));
        trip.setStatus(TripStatus.IN_PROGRESS);
        trip.setNotes("Viagem de transporte de equipamentos.");
        tripRepository.save(trip);
    }
}
