package com.joaonery.exregistercallparcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.joaonery.exregistercallparcelable.model.Person;

public class HomeActivity extends AppCompatActivity {

    private Button btRegister;
    private Button btDial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(getIntent().getParcelableExtra("p") != null){
            Person p = (Person) getIntent().getParcelableExtra("p");

            Toast.makeText(getBaseContext(), getResources().getString(R.string.ha_toast_welcome_msg) + ": " + p.getLogin(), Toast.LENGTH_LONG).show();
        }

        btRegister = findViewById(R.id.ha_bt_register);
        btDial = findViewById(R.id.ha_bt_dial);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(it);
            }
        });

        btDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(HomeActivity.this, DialActivity.class);
                startActivity(it);
            }
        });
    }
}
