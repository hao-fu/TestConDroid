package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/**
 * @testcase_name Activity1
 * @version 0.2
 * @author Hao
 * @modified_from DroidBench
 * @author_mail jamesfuhao@gmail.com
 * 
 * @description The sink is called after the user clicks a button. The button
 *  handler is defined via XML.
 *  Add a wrapper to sendMessage
 * @dataflow  source: button1, button2 retrive id; sink: intent;
 * @number_of_leaks 1
 * @challenges the analysis must analyze the layout xml file and take the lifecycle into account (onCreate is executed before user interaction)
 */
public class Activity1 extends Activity {
	private static String imei = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDevIdWrapperTop();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDevIdWrapper2();
            }
        });
    }

    public void getDevIdWrapperTop() {
        getDevIdWrapper2();
    }

    public void getDevIdWrapper2() {
        getDevId();
    }

    private void getDevId() {
        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        imei = telephonyManager.getDeviceId(); //source
    }

    public void sendMessageWrapper(View view) {
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("dev id: ", imei);
        startActivity(intent);
    }

}
