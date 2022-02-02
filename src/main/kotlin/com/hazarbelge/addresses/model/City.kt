package com.hazarbelge.addresses.model

import javax.persistence.*

@Entity
@Table(name = "CITY")
data class City(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "countryId")
    val countryId: Long?,
)
