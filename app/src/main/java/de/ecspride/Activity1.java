package de.ecspride;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

/**
 * @author Hao
 * @version 0.2
 * @testcase_name Activity1
 * @modified_from DroidBench
 * @author_mail jamesfuhao@gmail.com
 * @description The sink is called after the user clicks a button. The button
 * handler is defined via XML.
 * Add a wrapper to sendMessage
 * @dataflow source: button1, button2 retrive id; sink: intent;
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
        long[] res = getNaturalEvnCtxs();
        long time = res[0];
        long seconds = res[1];
        if (time > seconds) {
            Log.i("0", "1" + time + seconds);
            while (time > 2 && seconds > 3) {
                Log.i("2", "3" + time + seconds);
                // getDevIdWrapper2();
            }
        }

        getDevIdWrapper2();
    }

    private long[] getNaturalEvnCtxs() {
        long[] result = new long[2];
        result[0] = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        result[1] = calendar.get(Calendar.SECOND);

        return result;
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
