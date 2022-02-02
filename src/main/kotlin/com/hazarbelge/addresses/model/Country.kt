package com.hazarbelge.addresses.model

import javax.persistence.*

@Entity
class Country(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    var code: String,
    var continent: String,
)
