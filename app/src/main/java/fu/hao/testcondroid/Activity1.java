package fu.hao.testcondroid;

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
 * @author_mail jamesfuhao@gmail.com
 * @description Test for ConDroid
 */
public class Activity1 extends Activity {
    private static String imei = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);
    }

    public void startActivity2(View view) {
        Toast.makeText(this, "startActivity2!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, Activity2.class);
        intent.putExtra("dev id: ", imei);
        startActivity(intent);
    }

    /*
    @Override
    protected void onResume() {
        super.onResume();

        Toast.makeText(this, "onResume() called.", Toast.LENGTH_LONG).show();
    }*/

}
