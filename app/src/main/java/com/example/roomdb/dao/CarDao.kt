package com.example.roomdb.dao

import androidx.room.*
import com.example.roomdb.models.Car

@Dao
interface CarDao
{
    @Insert
    fun insert(vararg users: Car)

    @Update
    fun update(vararg users: Car)

    @Delete
    fun delete(car: Car)

    @Query("SELECT * FROM Car WHERE type = :carT")
    fun searchForUserByID(carT: String): Car


    @get:Query("SELECT * FROM Car")
    val allCars: List<Car>

    @get:Query("SELECT count(*) FROM Car")
    val countOfCars: Int
}