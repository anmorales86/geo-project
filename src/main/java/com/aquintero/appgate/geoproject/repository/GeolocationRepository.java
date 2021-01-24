package com.aquintero.appgate.geoproject.repository;

import com.aquintero.appgate.geoproject.entities.Geolocation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends CrudRepository<Geolocation, Long> {
}
