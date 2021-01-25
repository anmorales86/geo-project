package com.aquintero.appgate.geoproject.repository;

import com.aquintero.appgate.geoproject.entities.Geolocation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeolocationRepository extends CrudRepository<Geolocation, Long>
{

    @Query("select t from Geolocation t where :ip between t.ipFrom and t.ipTo")
    List<Geolocation> findByBetweenIpfromAndIpto(@Param("ip") Long ip);

}
