package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/country")
class CountryController(private val countryRepository: CountryRepository) : BaseRestController() {

    @GetMapping("/")
    fun findAll() = countryRepository.findAll()

    @GetMapping("/{code}")
    fun findByCode(@PathVariable code: String) =
        countryRepository.findByCode(code) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This country does not exist",
        )

}