package com.hazarbelge.addresses.repository

import com.hazarbelge.addresses.model.Country
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository  : CrudRepository<Country, Long> {
    fun findByCode(code: String): Country?
    override fun findAll(): Iterable<Country>
    fun findAllByOrderByNameAsc(): Iterable<Country>
}
