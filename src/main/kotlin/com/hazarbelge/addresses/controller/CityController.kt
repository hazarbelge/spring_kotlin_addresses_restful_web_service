package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.service.CityService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/city")
class CityController(private val cityService: CityService) : BaseRestController() {

    @GetMapping("")
    fun getAll() = cityService.getCities()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long) =
        cityService.getCityById(id) ?: throw ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "This city does not exist",
        )

}