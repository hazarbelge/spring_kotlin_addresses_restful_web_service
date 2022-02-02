package com.hazarbelge.addresses.base

import org.springframework.data.repository.CrudRepository

interface BaseRepository<T> : CrudRepository<T, String>