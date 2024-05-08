package com.example.assignment1_linatran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String inputUser;
    private int luckyNumber;
    private String luckyNumbertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLuck = (Button) findViewById(R.id.luckButton);
        btnLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView inputName = (TextView) findViewById(R.id.editText);
                inputUser = inputName.getText().toString();
                Random r = new Random();
                luckyNumber = r.nextInt(1000) + 1;
                luckyNumbertxt = String.valueOf(luckyNumber);

                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                intent.putExtra("userName", inputUser);
                intent.putExtra("luckNumber", luckyNumbertxt);

                startActivity(intent);
            }
        });
    }

}