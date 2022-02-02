package com.hazarbelge.addresses.repository

import com.hazarbelge.addresses.model.Country
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository  : CrudRepository<Country, Long> {

    @Query("select * from Country as C", nativeQuery=true)
    fun findCountries(): List<Country>

    fun findByCode(code: String): Country?

    fun findAllByOrderByNameAsc(): List<Country>
}
