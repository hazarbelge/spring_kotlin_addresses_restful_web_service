package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseController
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(
    private val countryRepository: CountryRepository,
    private val cityRepository: CityRepository
) : BaseController() {
    @GetMapping("/")
    fun addresses(model: Model): String {
        model["title"] = "Addresses"
        model["countries"] = countryRepository.findAllByOrderByNameAsc().map { it }
        return "addresses"
    }

    @GetMapping("/country/{code}")
    fun country(@PathVariable code: String, model: Model): String {
        val country = countryRepository.findByCode(code) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This country does not exist"
        )
        model["title"] = country.code
        model["country"] = country
        model["cities"] =
            cityRepository.findByCountryId(countryRepository.findByCode(code)?.id).map { it }
        return "country"
    }

    @GetMapping("/country/{code}/city/{id}")
    fun city(@PathVariable code: String, @PathVariable id: Long, model: Model): String {
        val city = cityRepository.findByIdOrNull(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This city does not exist"
        )
        model["title"] = city.name
        model["city"] = city
        model["country"] = countryRepository.findByIdOrNull(city.countryId!!)!!
        return "city"
    }
}