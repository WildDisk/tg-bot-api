package core

import model.BodyResponse

class Endpoint private constructor(private val result: String) {
    constructor(response: BodyResponse) : this(result = response.toString())
    override fun toString(): String = this.result
}