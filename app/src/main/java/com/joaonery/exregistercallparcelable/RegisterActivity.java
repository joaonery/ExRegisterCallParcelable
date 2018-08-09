package com.joaonery.exregistercallparcelable;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.joaonery.exregistercallparcelable.model.Car;

public class RegisterActivity extends AppCompatActivity {

    private EditText etModel;
    private Spinner spBrand;
    private EditText etYear;
    private Button btRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etModel = findViewById(R.id.ra_et_model);
        spBrand = findViewById(R.id.ra_sp_brand);
        etYear = findViewById(R.id.ra_et_year);
        btRegister = findViewById(R.id.ra_bt_register);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etModel.getText().toString().isEmpty() || spBrand.getSelectedItemPosition() == 0 || btRegister.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.toast_complete_all_fields), Toast.LENGTH_LONG).show();
                }else{
                    Car c = new Car(RegisterActivity.this);

                    c.setModel(etModel.getText().toString());
                    c.setBrand(spBrand.getSelectedItem().toString());
                    c.setYear(Integer.parseInt(etYear.getText().toString()));

                    AlertDialog.Builder msg = new AlertDialog.Builder(RegisterActivity.this);
                    msg.setTitle(getResources().getString(R.string.ra_alert_title));
                    msg.setMessage(c.toString());

                    switch (spBrand.getSelectedItem().toString()){
                        case "Ford":
                            msg.setIcon(ContextCompat.getDrawable(RegisterActivity.this, R.drawable.ford));
                            break;
                        case "Chevrolet":
                            msg.setIcon(ContextCompat.getDrawable(RegisterActivity.this, R.drawable.chevrolet));
                            break;
                        case "Volkswagen":
                            msg.setIcon(ContextCompat.getDrawable(RegisterActivity.this, R.drawable.volkswagen));
                            break;
                        case "Fiat":
                            msg.setIcon(ContextCompat.getDrawable(RegisterActivity.this, R.drawable.fiat));
                            break;
                        case "Renault":
                            msg.setIcon(ContextCompat.getDrawable(RegisterActivity.this, R.drawable.renault));
                            break;
                    }

                    msg.show();
                }
            }
        });
    }
}