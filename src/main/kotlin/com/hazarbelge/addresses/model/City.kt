package com.hazarbelge.addresses.model

import javax.persistence.*

@Entity
class City(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var name: String,
    @ManyToOne var country: Country,
)
