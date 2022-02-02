package com.hazarbelge.addresses.configuration

import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AddressConfiguration {
    @Bean
    fun databaseInitializer(cityRepository: CityRepository, countryRepository: CountryRepository) = ApplicationRunner {
        countryRepository.save(Country(name = "Turkey", code = "TR", continent = "Europe"))
        cityRepository.save(City(name = "İstanbul", country = countryRepository.findByCode("TR")!!))
        cityRepository.save(City(name = "Ankara", country = countryRepository.findByCode("TR")!!))
        cityRepository.save(City(name = "İzmir", country = countryRepository.findByCode("TR")!!))
        countryRepository.save(Country(name = "ABD", code = "US", continent = "America"))
        cityRepository.save(City(name = "Washington", country = countryRepository.findByCode("US")!!))
    }
}