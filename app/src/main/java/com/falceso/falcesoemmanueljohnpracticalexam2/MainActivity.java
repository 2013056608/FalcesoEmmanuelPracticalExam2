package com.falceso.falcesoemmanueljohnpracticalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private EditText comment;
    private CheckBox bx1,bx2,bx3,bx4,bx5,bx6,bx7,bx8;
    private Button btn_save, btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bx1 = findViewById(R.id.bx1);
        bx2 = findViewById(R.id.bx2);
        bx3 = findViewById(R.id.bx3);
        bx4 = findViewById(R.id.bx4);
        bx5 = findViewById(R.id.bx5);
        bx6 = findViewById(R.id.bx6);
        bx7 = findViewById(R.id.bx7);
        bx8 = findViewById(R.id.bx8);

        final CheckBox[] chkbxs = {bx1,bx2,bx3,bx4,bx5,bx6,bx7,bx8};

        comment = findViewById(R.id.comment_box);

        btn_save = findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer data = new StringBuffer();

                for (CheckBox chkbx: chkbxs){
                    if (chkbx.isChecked()){
                        data.append(chkbx.getText().toString() + ",");
                    }
                }

                data.append("comment:"+comment.getText().toString());

                FileOutputStream writer = null;
                try {
                    writer = openFileOutput("data1.txt", MODE_PRIVATE);
                    writer.write(data.toString().getBytes());
                    Log.d("nigger",data.toString());
                    Toast.makeText(MainActivity.this, "File saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    Toast.makeText(MainActivity.this, "File not found.", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    Toast.makeText(MainActivity.this, "IO Exception", Toast.LENGTH_SHORT).show();
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }

    public void nextActivity(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }}
