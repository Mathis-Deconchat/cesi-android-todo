package fr.cesi.ril2021.android.cesi_todo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Todo {

    public Todo(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Todo(){

    }

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title", defaultValue = "title")
    public String title;

    @ColumnInfo(name ="content")
    public String content;

    @ColumnInfo(name = "is_done", defaultValue = "false")
    public Boolean isDone;


}
