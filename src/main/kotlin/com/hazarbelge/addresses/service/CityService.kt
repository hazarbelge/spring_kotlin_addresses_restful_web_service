package com.hazarbelge.addresses.service

import com.hazarbelge.addresses.base.BaseService
import com.hazarbelge.addresses.model.City
import com.hazarbelge.addresses.repository.CityRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CityService(val cityRepository: CityRepository) : BaseService() {

    fun getCities(): List<City> = cityRepository.findCities()
    fun getCityById(id: Long): City? = cityRepository.findByIdOrNull(id)

    fun post(city: City){
        cityRepository.save(city)
    }
}