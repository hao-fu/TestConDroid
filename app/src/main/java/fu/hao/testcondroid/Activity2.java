package fu.hao.testcondroid;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubView;


public class Activity2 extends Activity implements MoPubView.BannerAdListener {

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

        moPubView = (MoPubView) findViewById(R.id.adview);
        moPubView.setAdUnitId("bcaebdd508184f518e78c8e2797102c1");
        moPubView.loadAd();
        moPubView.setBannerAdListener(this);

    }

    @Override
    public void onBannerLoaded(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
    }


    // Sent when the banner has failed to retrieve an ad. You can use the MoPubErrorCode value to diagnose the cause of failure.
    public void onBannerFailed(MoPubView banner, MoPubErrorCode errorCode) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
    }

    // Sent when the user has tapped on the banner.
    public void onBannerClicked(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
    }

    // Sent when the banner has just taken over the screen.
    public void onBannerExpanded(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
    }

    // Sent when an expanded banner has collapsed back to its original size.
    public void onBannerCollapsed(MoPubView banner) {
        Toast.makeText(getApplicationContext(),
                "Banner successfully loaded.", Toast.LENGTH_SHORT).show();
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

    // Declare an instance variable for your MoPubView.
    private MoPubView moPubView;


    protected void onDestroy() {
        moPubView.destroy();
        super.onDestroy();
    }


}
