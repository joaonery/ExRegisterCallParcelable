package com.joaonery.exregistercallparcelable;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.joaonery.exregistercallparcelable.model.Person;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etPassword;
    private Button btSignIn;
    private TextView tvRetrieveAcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etLogin = findViewById(R.id.la_et_login);
        etPassword = findViewById(R.id.la_et_password);
        btSignIn = findViewById(R.id.la_bt_sign_in);
        tvRetrieveAcess = findViewById(R.id.la_tv_retrieve_access);

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etLogin.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()){
                    Person p = new Person(etLogin.getText().toString(), etPassword.getText().toString(), LoginActivity.this);
                    if(p.getLogin() != null && p.getPassword() != null){
                        Intent it = new Intent(LoginActivity.this, HomeActivity.class);
                        it.putExtra("p", p);
                        startActivity(it);
                    }else{
                        toast(getResources().getString(R.string.la_toast_invalid_informations));
                    }
                }else{
                    toast(getResources().getString(R.string.toast_complete_all_fields));
                }
            }
        });

        tvRetrieveAcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder msg = new AlertDialog.Builder(LoginActivity.this);
                msg.setTitle(getResources().getString(R.string.la_alert_title));
                msg.setMessage(getResources().getString(R.string.la_alert_message));
                msg.show();
            }
        });
    }

    private void toast(String msg){
        Toast.makeText(getBaseContext(), msg, Toast.LENGTH_LONG).show();
    }
}
