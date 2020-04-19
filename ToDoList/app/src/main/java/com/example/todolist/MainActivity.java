package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private ArrayList<Item> items = new ArrayList<Item>();
    private ItemAdapter itemsAdapter;
    private ListView list;
    private Button btn;
    private String currentDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //itemsAdapter = new ArrayAdapter<ItemAdapter>(this, android.R.layout.simple_list_item_1, items);
        itemsAdapter = new ItemAdapter(MainActivity.this, R.layout.item_todo,items);
        list = (ListView) findViewById(R.id.list);
        btn = findViewById(R.id.btn);
        //ItemAdapter adapter = new ItemAdapter(MainActivity.this, items);
        list.setAdapter(itemsAdapter);
       // setupListViewListener();
        btn.setOnClickListener(this);
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id) {
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }

                });

    }

    private void setupListViewListener() {

    }

    @Override
    public void onClick(View v) {
        DialogFragment datePicker = new DatePickerFragment();
        datePicker.show(getSupportFragmentManager(), "date picker");
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, i);
        c.set(Calendar.MONTH, i1);
        c.set(Calendar.DAY_OF_MONTH, i2);
        String dateString = DateFormat.getDateInstance().format(c.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        currentDate = sdf.format(new Date());
        //itemsAdapter.add(itemText + ("     ")+("    Créé le: ")+(" ")+currentDate+ ("    A faire pour le: ")+(" ")+ dateString);
        EditText input = (EditText) findViewById(R.id.input);
        String itemText = input.getText().toString();
        Item item = new Item(itemText,currentDate);
        items.add(item);

//        list.setAdapter(Myadapter);
        input.setText(" ");
    }
}