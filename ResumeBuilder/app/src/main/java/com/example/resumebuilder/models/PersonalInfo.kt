package com.example.resumebuilder.models

class PersonalInfo {
    var editName: String? = null
    var editPhone: String? = null
    var editEmailAddress: String? = null
    var editAddress: String? = null

    constructor() : super() {}

    constructor(name: String, phone: String, eaddress: String, address: String) : super() {
        this.editName = name
        this.editPhone = phone
        this.editEmailAddress = eaddress
        this.editAddress = address
    }
}