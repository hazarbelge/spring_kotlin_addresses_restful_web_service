package com.hazarbelge.addresses.repository

import com.hazarbelge.addresses.model.City
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository  : CrudRepository<City, Long> {

    @Query("select * from City as Cit", nativeQuery=true)
    fun findCities(): List<City>

    fun findByCountryId(countryId: Long?): Iterable<City>
}
