package com.hazarbelge.addresses

import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import com.hazarbelge.addresses.service.CityService
import com.hazarbelge.addresses.service.CountryService
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ServicesTests {
    private final val countryRepository : CountryRepository = mockk()
    private final val cityRepository : CityRepository = mockk()

    val countryService = CountryService(countryRepository)
    val cityService = CityService(cityRepository)

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `When getCityById then return City`() {
        val turkey = Country(id = 1, name = "Turkey", code = "TR", continent = "Europe")
        countryService.post(turkey)
        val adana = City(id = 1, name = "Adana", countryId = turkey.id)
        cityService.post(adana)
        val found = cityService.getCityById(adana.id!!)
        assertThat(found).isEqualTo(adana)
    }

    @Test
    fun `When getCountryByCode then return Country`() {
        val turkey = Country(id = 1, name = "Turkey", code = "TR", continent = "Europe")
        countryService.post(turkey)
        val country = countryService.getCountryByCode(turkey.code)
        assertThat(country).isEqualTo(turkey)
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}