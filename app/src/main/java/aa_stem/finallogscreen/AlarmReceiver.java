package aa_stem.finallogscreen;

/**
 * Created by mnaveed on 12/20/17.
 */


import android.content.BroadcastReceiver;
import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver{

    private static final String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent)
    {
        // TODO Auto-generated method stub


        // here you can start an activity or service depending on your need
        // for ex you can start an activity to vibrate phone or to ring the phone

        String phoneNumberReciver="4086676907";// phone number to which SMS to be send
        String message="Hi I will be there later, See You soon";// message to send
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumberReciver, null, message, null, null);
        Log.v(TAG,phoneNumberReciver);
        // Show the toast  like in above screen shot
        Toast.makeText(context, "Alarm Triggered and SMS Sent", Toast.LENGTH_LONG).show();
    }

}
