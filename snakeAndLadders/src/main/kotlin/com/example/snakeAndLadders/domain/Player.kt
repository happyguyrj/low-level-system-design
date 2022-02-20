package com.example.snakeAndLadders.domain

import java.util.UUID

class Player(_name: String) {

    val name: String = _name
    val id: String = UUID.randomUUID().toString()
}