package com.falceso.falcesoemmanueljohnpracticalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private TextView txt_sbj, txt_comments;
    private Button btn_send, btn_prev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        StringBuffer sbjs = new StringBuffer();
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = openFileInput("data1.txt");
            int token;

            while ((token = fileInputStream.read()) != -1) {
                sbjs.append((char) token);
            }
        } catch (FileNotFoundException e) {
            Toast.makeText(this, "File not Found", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "IOException found", Toast.LENGTH_SHORT).show();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        txt_sbj = findViewById(R.id.txt_sbj);
        String str[] = sbjs.toString().split(",");
        for (int i = 0; i < str.length-1; i++) {
                txt_sbj.append(str[i] + "\n");

        }

        txt_comments = findViewById(R.id.txt_comments);
        txt_comments.append(str[str.length-1].replace("comment:",""));
        btn_prev = findViewById(R.id.btn_prev);

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prevActivity();
            }
        });

        btn_send = findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Request Sent", Toast.LENGTH_LONG).show();
            }

        });



    }

    public void prevActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
