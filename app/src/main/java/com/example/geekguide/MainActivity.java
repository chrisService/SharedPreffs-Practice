package com.example.geekguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        userName = findViewById(R.id.user_name);
        passWord = findViewById(R.id.passwort_log);
        log_switch = findViewById(R.id.remember_switch);
        logbtn = findViewById(R.id.log_btn);
        forget = findViewById(R.id.forget);

        log_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                saveData();
            }
        });

        logbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(passWord.getText().toString().equals(pass) && userName.getText().toString().equals(user)) {

                    Intent intent = new Intent(MainActivity.this, TabPicker.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(MainActivity.this, "Wrong Username or Password !", Toast.LENGTH_SHORT).show();
                }
            }
        });


        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                forgetMe();
            }
        });


        loadData();
        updateViews();



    }


    private String user = "Geek";
    private String pass = "GeeK";


    private EditText userName;
    private EditText passWord;
    private Switch log_switch;
    private Button logbtn;
    private TextView forget;

    private String text1;
    private String text2;
    private boolean switchOnOff;



    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", userName.getText().toString());
        editor.putString("password", passWord.getText().toString());
        editor.putBoolean("switch", log_switch.isChecked());
        editor.apply();
        Toast.makeText(MainActivity.this, "Log In Remembered !", Toast.LENGTH_SHORT).show();

    }

    public void loadData() {
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", MODE_PRIVATE);
        text1 = sharedPreferences.getString("username", "");
        text2 = sharedPreferences.getString("password", "");
        switchOnOff = sharedPreferences.getBoolean("switch", false);
    }

    public void updateViews() {
        userName.setText(text1);
        passWord.setText(text2);
        log_switch.setChecked(switchOnOff);
    }

    public void forgetMe(){
        userName.setText("");
        passWord.setText("");
        log_switch.setChecked(false);
        Toast.makeText(MainActivity.this, "Log In Forgoten !", Toast.LENGTH_SHORT).show();
    }

}
