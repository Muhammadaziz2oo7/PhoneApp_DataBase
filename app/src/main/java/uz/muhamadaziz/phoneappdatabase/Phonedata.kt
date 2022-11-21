package uz.muhamadaziz.phoneappdatabase

import java.io.Serializable

class Phonedata: Serializable {

    var id: Int? = null
    var position: Int? = null
    var name: String? = null
    var feature: String? = null

    constructor(id: Int?, position: Int?, name: String?, feature: String?) {
        this.id = id
        this.position = position
        this.name = name
        this.feature = feature
    }

    constructor(position: Int?, name: String?, feature: String?) {
        this.position = position
        this.name = name
        this.feature = feature
    }

    constructor()
}