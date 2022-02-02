package com.hazarbelge.addresses.model

import javax.persistence.*

@Entity
@Table(name = "COUNTRY")
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "name")
    val name: String,

    @Column(name = "code")
    val code: String,

    @Column(name = "continent")
    val continent: String,
)
