package fr.cesi.ril2021.android.cesi_todo;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    List<Todo> items;
    ArrayAdapter<Todo> itemsAdapter;
    ListView lvItems;
    ITodoDao todoDao;
    TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db-todo").fallbackToDestructiveMigration().allowMainThreadQueries().build();

        todoDao = db.todoDao();

        lvItems = (ListView) findViewById(R.id.todoListView);
        items = todoDao.getAll();

        this.todoAdapter = new TodoAdapter(this, items);

        lvItems.setAdapter(todoAdapter);

        setupListViewListener();

    }

    public void onShowDialog(View v){
        DialogFragment dt = new DialogTodo();
        dt.show(getSupportFragmentManager(), "pouf");
    }

    public void onAdditem(View v){
        EditText todoEditor = (EditText) findViewById(R.id.textTodoNameInput);
        String todoText = todoEditor.getText().toString();
        Todo todo = new Todo("Titre", todoText);

        todoAdapter.add(todo);
        todoEditor.setText("");
        todoDao.insertAll(todo);

    }

    private void setupListViewListener(){
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                        items.remove(i);
                        todoDao.delete(items.get(i));
                        todoAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );
    }


    }







