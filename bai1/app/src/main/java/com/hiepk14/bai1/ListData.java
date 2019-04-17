package com.hiepk14.bai1;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
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
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao");
                builder.setMessage("Bạn có muốn xoa không?");
                builder.setCancelable(false);
                builder.setPositiveButton("Huy", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                   //     Toast.makeText(ListData.this, "Không thoát được", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(context, db.delete(sinhViens.get(position).getName()) + " ", Toast.LENGTH_SHORT).show();
                        sinhViens.remove(position);
                        adapterCustom.notifyDataSetChanged();
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
                return false;
            }
        });
    }
}
