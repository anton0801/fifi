package app.beer.fifi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import app.beer.fifi.models.user.LocalUser
import app.beer.fifi.utils.Constants

@Database(entities = [LocalUser::class], version = Constants.DB_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null)
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, Constants.DB_NAME)
                    .build()
            return INSTANCE!!
        }
    }

}