package com.example.hospitalinfo.Models

class StoringData(fullname: String, username: String, email: String, phoneno: String, password: String){

    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String

    init {
        this.username = username
        this.email = email
        this.password = password
    }

    public fun getUsername(): String{
        return username
    }
    public fun setUsername(username: String){
        this.username = username
    }

    public fun getEmail(): String{
        return email
    }
    public fun setEmail(email: String){
        this.email = email
    }

    public fun getPassword(): String{
        return password
    }
    public fun setPassword(password: String){
        this.password = password
    }

}