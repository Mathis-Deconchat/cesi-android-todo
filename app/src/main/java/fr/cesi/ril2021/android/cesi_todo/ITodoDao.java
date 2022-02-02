package fr.cesi.ril2021.android.cesi_todo;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ITodoDao {
    @Query("SELECT * FROM todo")
    List<Todo> getAll();

    @Insert
    void insertAll(Todo... todos);

    @Delete
    void delete(Todo todo);
}
