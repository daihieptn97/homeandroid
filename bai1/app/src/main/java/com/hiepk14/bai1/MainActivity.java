package com.hiepk14.bai1;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText edtName, edtSchool;
    private TextView edtDate;
    private Button btnAdd, btnShow;
    private Context context;
    private CheckBox cbBongChuyen, cbBongRo, cbBongDa;
    private DatabaseConnect db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mapping();

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                edtDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }
        }, year, month, day);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });

        findViewById(R.id.btnShow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListData.class);
                startActivity(intent);
                //  finish();
            }
        });

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = findViewById(R.id.grRadioSex);
                RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());

                SinhVien sv = new SinhVien();
                sv.setBongchuyen(cbBongChuyen.isChecked() ? 1 : 0);
                sv.setBongda(cbBongDa.isChecked() ? 1 : 0);
                sv.setBongro(cbBongRo.isChecked() ? 1 : 0);

                sv.setDate(edtDate.getText().toString().trim());
                sv.setName(edtName.getText().toString().trim());
                sv.setSchool(edtSchool.getText().toString().trim());
                sv.setSex(radioButton.getText().equals("Nam") ? 1 : 0);
                sv.setId(-1);

                Toast.makeText(context, db.insert(sv) + " ", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void mapping() {
        edtName = findViewById(R.id.edtName);
        edtDate = findViewById(R.id.edtDate);
        edtSchool = findViewById(R.id.edtSchool);

        cbBongChuyen = findViewById(R.id.cbBongChuyen);
        cbBongDa = findViewById(R.id.cbBongDa);
        cbBongRo = findViewById(R.id.cbBongRo);

        db = new DatabaseConnect(context);
    }
}
