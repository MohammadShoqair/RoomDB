package com.example.roomdb

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.roomdb.dao.CarDao
import com.example.roomdb.models.Car


@Database( entities = [Car::class], version = 1)
abstract class AppDataBase : RoomDatabase()
{
    abstract fun objectCars(): CarDao


    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
//        return null
//    }
//
//    override fun createInvalidationTracker(): InvalidationTracker {
//        return null
//    }

    override fun clearAllTables() {

    }
}