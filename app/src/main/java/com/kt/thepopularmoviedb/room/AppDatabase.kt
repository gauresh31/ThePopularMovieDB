
package com.kt.thepopularmoviedb.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kt.thepopularmoviedb.models.entity.Movie
import com.kt.thepopularmoviedb.room.converters.IntegerListConverter
import com.kt.thepopularmoviedb.room.converters.KeywordListConverter
import com.kt.thepopularmoviedb.room.converters.ReviewListConverter
import com.kt.thepopularmoviedb.room.converters.StringListConverter

@Database(entities = [(Movie::class)],
  version = 3, exportSchema = false)
@TypeConverters(value = [(StringListConverter::class), (IntegerListConverter::class),
  (KeywordListConverter::class), (ReviewListConverter::class)])
abstract class AppDatabase : RoomDatabase() {
  abstract fun movieDao(): MovieDao
}
