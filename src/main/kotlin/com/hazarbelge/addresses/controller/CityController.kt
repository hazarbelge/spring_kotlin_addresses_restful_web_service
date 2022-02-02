package com.hazarbelge.addresses.controller

import com.hazarbelge.addresses.base.BaseRestController
import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.model.Country
import com.hazarbelge.addresses.model.ResponseModel
import com.hazarbelge.addresses.service.CityService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/city")
class CityController(private val cityService: CityService) : BaseRestController() {

    @GetMapping("")
    fun getAll(): ResponseModel<List<City>> {
        return ResponseModel(
            true,
            http_code = HttpStatus.OK.value(),
            data = cityService.getCities()
        )
    }

    @GetMapping("/{id}")
    fun getCityById(@PathVariable id: Long): ResponseModel<City> {
        val city: City? = cityService.getCityById(id)
        if (city != null) {
            return ResponseModel(
                true,
                http_code = HttpStatus.OK.value(),
                data = cityService.getCityById(id)!!,
            )
        } else {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "This City does not exist",
            )
        }
    }

    @PostMapping("")
    fun createCity(@RequestBody city: City) {
        cityService.post(city)
    }

    @PutMapping("")
    fun updateCity(@RequestBody city: City) {
        cityService.post(city)
    }
}