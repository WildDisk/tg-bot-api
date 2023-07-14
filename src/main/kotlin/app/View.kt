package app

import core.Endpoint

class View(private val value: String) {
    constructor(endpoint: Endpoint) : this(value = endpoint.toString())
    init {
        println(this.value)
    }
}