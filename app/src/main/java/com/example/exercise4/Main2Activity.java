package com.example.exercise4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void connect(View view) {
        EditText ip = (EditText) findViewById(R.id.ip);
        final String ipStr =  ip.getText().toString();
        EditText port = (EditText) findViewById(R.id.port);
        final int portInt = Integer.parseInt(port.getText().toString());

        tcpConnect.Instance().connectToServer(ipStr, portInt);
        //TcpClient.Instance().sendMesssage("set controls/flight/rudder -1");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}