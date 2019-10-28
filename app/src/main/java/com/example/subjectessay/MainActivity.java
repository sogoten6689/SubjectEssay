package com.example.subjectessay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text_input);

    }


    public void startService(View view) {
        String input = editText.getText().toString();

        Intent intent = new Intent(this, NotiService.class);
        intent.putExtra("inputExtra", input);

        startService(intent);
    }


    public void stopService(View view) {

        Intent intent = new Intent(this, NotiService.class);

        stopService(intent);
    }

    public void viewMySchedule(View view) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.schedule:
                Intent intent  = new Intent(this, ScheduleActivity.class);
                startService(intent);
            case R.id.exit:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
