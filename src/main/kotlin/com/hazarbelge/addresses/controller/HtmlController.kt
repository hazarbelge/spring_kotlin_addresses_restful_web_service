package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseController
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException

@Controller
class HtmlController(private val countryRepository: CountryRepository) : BaseController() {
    @GetMapping("/")
    fun addresses(model: Model): String {
        model["title"] = "Addresses"
        model["countries"] = countryRepository.findAllByOrderByNameAsc().map { it.render() }
        return "address"
    }

    @GetMapping("/country/{code}")
    fun country(@PathVariable code: String, model: Model): String {
        val country = countryRepository.findByCode(code)?.render() ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This country does not exist"
        )
        model["title"] = country.code
        model["country"] = country
        return "country"
    }

    fun Country.render() = RenderedCountry(
        id,
        name,
        code,
        continent,
    )

    data class RenderedCountry(
        val id: Long?,
        val name: String,
        val code: String,
        val continent: String,
    )
}