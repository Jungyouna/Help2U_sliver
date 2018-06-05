package com.example.youna.mayii;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SilverActivity extends AppCompatActivity {
    private Button button;
    private String help_message = "응급상황 입니다!";
    private TextView textView3;
    private TextView textView6;
    private String name, phoneNo, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_silver);
        button = (Button)findViewById(R.id.button);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        textView3 = (TextView)findViewById(R.id.textView3);
        textView6 = (TextView)findViewById(R.id.textView6);
        textView3.setText(name);
        textView6.setText(help_message);
        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("!!!",name);
                phoneNo = name;
                sms = help_message;
                Toast.makeText(getApplicationContext(), "전송중...", Toast.LENGTH_LONG).show();
                try {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNo, null, sms, null, null);
                    Toast.makeText(getApplicationContext(), "메세지 전송이 완료되었습니다", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "메세지 전송이 실패되었습니다." +
                            "\n다시 시도해주세요!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }

            }
        });
    }
}
