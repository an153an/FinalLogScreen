package aa_stem.finallogscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MedicineTakenConfirmation extends AppCompatActivity {

    TextView viewpromptMedName;
    String medicine_name = "";
    String dose_amt = "";
    String start_Date = "";
    String start_Time = "";
    String cell_phone = "";
    String home_phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_taken_confirmation);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        viewpromptMedName = (TextView) findViewById(R.id.medicineName);
        medicine_name = extras.getString("med_name");
        Log.v("Medicine: ",medicine_name);
        dose_amt = extras.getString("dose_amt");
        start_Date = extras.getString("startDate");
        start_Time = extras.getString("startTime");
        home_phone = extras.getString("homephone");
        cell_phone = extras.getString("cellphone");

        /*
        String bold_m = medicine_name;
        String normal_m= "Medicine Name: ";
        SpannableString str_m = new SpannableString(normal_m +bold_m);
        str_m.setSpan(new StyleSpan(Typeface.BOLD),0,str_m.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        String bold_d = medicine_name;
        String normal_d= "for the dose amount of: ";
        SpannableString str_d = new SpannableString(normal_d +bold_d);
        str_d.setSpan(new StyleSpan(Typeface.BOLD),0,str_d.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        SpannableString str = new SpannableString(str_m.toString() + str_d.toString());
        viewpromptMedName.setText(str);
        */

        viewpromptMedName.setText("Medicine Name: "+ medicine_name
                                    + "\r\nfor the dose amount of: " + dose_amt
                                    + " \r\nwas taken on :"+ start_Date
                                    + " \r\nat time: "+ start_Time+"."
                                    + "\r\nInformation is now logged and SMS has been sent to " + cell_phone);

        Button btnHome = (Button) findViewById(R.id.btnHome);

        //button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MedicineTakenConfirmation.this);

                alertDialog.setTitle("Home Alert");
                alertDialog.setMessage("Are you sure you want to continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),BasicSetup.class);
                        startActivity(i);
                    }
                });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"You Clicked NO, Please review and continue.",Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

    }
}
