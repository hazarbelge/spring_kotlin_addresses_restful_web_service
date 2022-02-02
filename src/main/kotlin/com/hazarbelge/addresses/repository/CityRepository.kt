package com.hazarbelge.addresses.repository

import com.hazarbelge.addresses.model.City
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CityRepository  : CrudRepository<City, Long> {
    fun findByName(name: String): City
    fun findAllByOrderByNameAsc(): Iterable<City>
}
