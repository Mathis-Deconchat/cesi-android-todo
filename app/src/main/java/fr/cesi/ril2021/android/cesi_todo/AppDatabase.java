package fr.cesi.ril2021.android.cesi_todo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Todo.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ITodoDao todoDao();
}