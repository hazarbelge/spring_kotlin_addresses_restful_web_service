package com.hazarbelge.addresses

import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
    val entityManager: TestEntityManager,
    val countryRepository: CountryRepository,
    val cityRepository: CityRepository,
) {
    @Test
    fun `When findByIdOrNull then return Article`() {
        val turkey = Country(name = "Turkey", code = "TR", continent = "Europe")
        entityManager.persist(turkey)
        val adana = City(name ="Adana", country = turkey)
        entityManager.persist(adana)
        entityManager.flush()
        val found = cityRepository.findByIdOrNull(adana.id!!)
        assertThat(found).isEqualTo(adana)
    }

    @Test
    fun `When findByCode then return Country`() {
        val turkey = Country(name = "Turkey", code = "TR", continent = "Europe")
        entityManager.persist(turkey)
        entityManager.flush()
        val country = countryRepository.findByCode(turkey.code)
        assertThat(country).isEqualTo(turkey)
    }
}