package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.repository.CityRepository
import com.hazarbelge.addresses.repository.CountryRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/city")
class CityController(private val cityRepository: CityRepository) : BaseRestController() {

    @GetMapping("/")
    fun findAll() = cityRepository.findAll()

    @GetMapping("/{id}")
    fun findByCode(@PathVariable id: Long) =
        cityRepository.findByIdOrNull(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This city does not exist",
        )

}