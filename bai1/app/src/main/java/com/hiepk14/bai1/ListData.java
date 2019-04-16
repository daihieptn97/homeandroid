package com.hiepk14.bai1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListData extends AppCompatActivity {
    private ListView listView;
    private Context context;
    private DatabaseConnect db;
    private ArrayList<SinhVien> sinhViens;
    private AdapterCustom adapterCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
        context = this;
        listView = findViewById(R.id.lv);
        db = new DatabaseConnect(context);
        sinhViens = db.getAllData();

        adapterCustom = new AdapterCustom(context, R.layout.custom_view, sinhViens);
        listView.setAdapter(adapterCustom);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(context, db.delete(sinhViens.get(position).getName()) + " ", Toast.LENGTH_SHORT).show();
                sinhViens.remove(position);
                adapterCustom.notifyDataSetChanged();
                return false;
            }
        });
    }
}
