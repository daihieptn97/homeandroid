package com.hiepk14.bai1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCustom extends ArrayAdapter<SinhVien> {
    private Context context;
    private ArrayList<SinhVien> listSV;
    private int resource;
    private TextView tvName, tvDate, tvSex;


    public AdapterCustom(Context context, int resource, ArrayList<SinhVien> object) {
        super(context, resource, object);
        this.context = context;
        this.listSV = object;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource, parent, false);
        mapping(view);

        tvSex.setText(listSV.get(position).getSex() == 1 ? "nam" : "nữ");
        tvName.setText(listSV.get(position).getName());
        tvDate.setText(listSV.get(position).getDate());

        return view;
    }

    private void mapping(View v) {
        tvName = v.findViewById(R.id.tvName);
        tvDate = v.findViewById(R.id.tvDate);
        tvSex = v.findViewById(R.id.tvSex);

    }
}
