package com.joaonery.exregistercallparcelable;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialActivity extends AppCompatActivity {

    private EditText etPhone;
    private Button btCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);

        etPhone = findViewById(R.id.da_et_phone);
        btCall = findViewById(R.id.da_bt_call);

        ActivityCompat.requestPermissions(DialActivity.this,new String[]{Manifest.permission.CALL_PHONE},0);

        btCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!etPhone.getText().toString().isEmpty()){
                    if (ContextCompat.checkSelfPermission(DialActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(DialActivity.this, Manifest.permission.CALL_PHONE)) {

                            Toast.makeText(getBaseContext(), getResources().getString(R.string.da_toast_warning), Toast.LENGTH_LONG).show();

                            ActivityCompat.requestPermissions(DialActivity.this, new String[]{Manifest.permission.CALL_PHONE},0);
                        } else {
                            ActivityCompat.requestPermissions(DialActivity.this, new String[]{Manifest.permission.CALL_PHONE},0);
                        }
                    } else {
                        Uri uri = Uri.parse("tel:" + etPhone.getText().toString());
                        Intent it = new Intent(Intent.ACTION_CALL, uri);
                        startActivity(it);
                    }
                } else {
                    Toast.makeText(getBaseContext(), getResources().getString(R.string.da_toast_phone), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
