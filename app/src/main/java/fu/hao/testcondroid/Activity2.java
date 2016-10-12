package fu.hao.testcondroid;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsgWrapper();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsgWrapper2();
            }
        });
    }

    public void sendMsgByView(View view) {
        sendMessage();
    }

    public void sendMessage(){
        Toast.makeText(this, "SMS sent.", Toast.LENGTH_LONG).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage("+49", null, "damn", null, null);  //sink, leak
    }

    private void sendMsgWrapper() {
        sendMessage();
    }

    private void sendMsgWrapper2() {
        sendMessage();
    }
}
