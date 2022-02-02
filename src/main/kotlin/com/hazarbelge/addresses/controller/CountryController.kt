package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.model.ResponseModel
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
    fun getAll(): ResponseModel<List<Country>> {
        return ResponseModel(
            true,
            http_code = HttpStatus.OK.value(),
            data = countryService.getCountries(),
        )
    }

    @GetMapping("/{code}")
    fun getCountryByCode(@PathVariable code: String): ResponseModel<Country> {
        val country: Country? = countryService.getCountryByCode(code)
        if (country != null) {
            return ResponseModel(
                true,
                http_code = HttpStatus.OK.value(),
                data = countryService.getCountryByCode(code)!!,
            )
        } else {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "This country does not exist",
            )
        }
    }
}