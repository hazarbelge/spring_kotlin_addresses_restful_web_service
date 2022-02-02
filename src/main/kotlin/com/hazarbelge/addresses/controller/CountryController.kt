package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.service.CountryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/country")
class CountryController(private val countryService: CountryService) : BaseRestController() {

    @GetMapping("")
    fun getAll() = countryService.getCountries()

    @GetMapping("/{code}")
    fun getCountryByCode(@PathVariable code: String) =
        countryService.getCountryByCode(code) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This country does not exist",
        )

}