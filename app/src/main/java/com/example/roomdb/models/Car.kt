package com.example.roomdb.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Car")
class Car
{
    @PrimaryKey
var type:String=""

var price: Double? =null
    override fun toString(): String {
        return "$type $price"
    }


}