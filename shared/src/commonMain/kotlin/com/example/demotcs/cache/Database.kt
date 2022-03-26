package com.example.demotcs.cache

import com.example.demotcs.entity.Person
import com.tcs.kmp.db.Registration
//internal removed
class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Registration(databaseDriverFactory.createDriver())
    private val dbQuery = database.registrationQueries

    fun clearDatabase(){
        dbQuery.transaction {
              dbQuery.removeAllPersons()
        }
    }

     fun insertPerson(person: Person){
        dbQuery.insertPerson(
            PID = person.id,
            NAME = person.name,
            EMAIL = person.email,
            MOBILE = person.mobile,
            PASSWORD =person.password,
            GENDER = person.gender
        )
    }

     fun getAllPersons(): List<Person>{
        return dbQuery.getAllPersons(::mapPerson).executeAsList()
    }

    private fun mapPerson(
        pID : String,
        name:  String,
        email : String,
        mobile : String,
        password : String,
        gender : String

    ):Person{
        return  Person(
            id = pID,
            name = name,
            email = email,
            mobile = mobile,
            password = password,
            gender = gender

        )
    }



}