package com.example.assignment1_linatran;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;


public class SecondActivity extends AppCompatActivity {


    private String luckNumbertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView headerTextView = (TextView) findViewById(R.id.txtViewHeader);
        Intent txtUser = getIntent();
        String headerTxt = txtUser.getStringExtra("userName");
        String newHeader = headerTxt + " your lucky number is: ";
        headerTextView.setText(newHeader);

        TextView luckyTextView = (TextView) findViewById(R.id.txtViewLuckyNumber);
        Intent luckNumber = getIntent();
        luckNumbertxt = luckNumber.getStringExtra("luckNumber");
        luckyTextView.setText(luckNumbertxt);

        Button shareButton = (Button) findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                shareText();
            }
        });
    }

    public void shareText (){
        Intent txtName = getIntent();
        String txtInput = txtName.getStringExtra("userName");
        String message;
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        if (txtInput.toString().isEmpty()) {
            message = "Your lucky number is: " + luckNumbertxt;
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        } else {
            message = txtInput + " your lucky number is: " + luckNumbertxt;
            sendIntent.putExtra(Intent.EXTRA_TEXT, message);
            sendIntent.setType("text/plain");

            Intent shareIntent = Intent.createChooser(sendIntent, null);
            startActivity(shareIntent);
        }
    }
}
