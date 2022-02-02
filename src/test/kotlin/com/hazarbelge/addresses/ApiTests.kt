package com.hazarbelge.addresses

import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*


@WebMvcTest
class ApiTests(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var countryRepository: CountryRepository

    @MockkBean
    private lateinit var cityRepository: CityRepository

    @Test
    fun `List cities`() {
        val turkey = Country(name = "Turkey", code = "TR", continent = "Europe")
        val izmir = City(name = "İzmir", country = turkey)
        val istanbul = City(name = "İstanbul", country = turkey)
        every { cityRepository.findAll() } returns listOf(izmir, istanbul)
        mockMvc.perform(get("/api/city/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].country.code").value(turkey.code))
            .andExpect(jsonPath("\$.[0].name").value(izmir.name))
            .andExpect(jsonPath("\$.[1].country.code").value(turkey.code))
            .andExpect(jsonPath("\$.[1].name").value(istanbul.name))
    }

    @Test
    fun `List countries`() {
        val turkey = Country(name = "Turkey", code = "TR", continent = "Europe")
        val usa = Country(name = "USA", code = "US", continent = "America")
        every { countryRepository.findAll() } returns listOf(turkey, usa)
        mockMvc.perform(get("/api/country/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].code").value(turkey.code))
            .andExpect(jsonPath("\$.[1].code").value(usa.code))
    }
}