package com.hazarbelge.addresses

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class AddressesApplication

fun main(args: Array<String>) {
	runApplication<AddressesApplication>(*args) {
		//setBannerMode(Banner.Mode.OFF)
	}
}
