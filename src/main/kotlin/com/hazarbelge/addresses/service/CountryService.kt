package com.hazarbelge.addresses.service

import com.hazarbelge.addresses.base.BaseService
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.stereotype.Service

@Service
class CountryService(val countryRepository: CountryRepository) : BaseService() {

    fun getCountries(): List<Country> = countryRepository.findCountries()
    fun getCountryByCode(code: String): Country? = countryRepository.findByCode(code)

    fun post(country: Country){
        countryRepository.save(country)
    }
}