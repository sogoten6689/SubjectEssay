package com.example.subjectessay;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    EditText edtMa, edtTenThuoc, edtGhiChu;
    Button btnSave,btnSelect,btnExit,btnUpdate,btnDelete;
    GridView gvDisplay;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);
        edtMa = (EditText)findViewById(R.id.edit_text_ma);
        edtTenThuoc = (EditText)findViewById(R.id.edit_text_ten_thuoc);
        edtGhiChu = (EditText)findViewById(R.id.edit_text_ghi_chu);
        gvDisplay = (GridView)findViewById(R.id.grid_view_schedule);
        dbHelper = new DbHelper(this);
        dbHelper.addFirst();
        btnSelect = (Button)findViewById(R.id.btn_Select);
        btnSave = (Button)findViewById(R.id.btn_Save);
        btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> list_string = new ArrayList<>();
                ArrayList<Schedule> list_schedule = new ArrayList<>();
                list_schedule = dbHelper.getMySchedule(0);

                for(Schedule b : list_schedule){
                    list_string.add(b.getId()+"");
                    list_string.add(b.getTenThuoc()+"");
                    list_string.add(b.getGhiChu()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ScheduleActivity.this,android.R.layout.simple_list_item_1,list_string);
                gvDisplay.setAdapter(adapter);
            }
        });
        
    }

}
