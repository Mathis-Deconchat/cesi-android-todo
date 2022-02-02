package fr.cesi.ril2021.android.cesi_todo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class TodoAdapter extends ArrayAdapter<Todo> {


    public TodoAdapter(@NonNull Context context, List<Todo> todos) {
        super(context, 0, todos);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Todo todo = getItem(position);

      if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.todo_item, parent, false);
        }

        //CheckBox todoCheck = convertView.findViewById(R.id.checkbox_todo);
        TextView tvTitle = convertView.findViewById(R.id.todoItemTitle);
        tvTitle.setText(todo.title);

        ((TextView) convertView.findViewById(R.id.todoItemContent)).setText(todo.content);


        return convertView;
    }
}
