package aa_stem.finallogscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MedicineNotTakenConfirmation extends AppCompatActivity {

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
        setContentView(R.layout.activity_medicine_not_taken_confirmation);

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


        viewpromptMedName.setText("Medicine Name: "+ medicine_name
                + "\r\nfor the dose amount of: " + dose_amt
                + " \r\nwas NOT taken on :"+ start_Date
                + " \r\nat time: "+ start_Time+"."
                + "\r\nInformation is now logged and SMS has been sent to " + cell_phone);


        Button btnHome = (Button) findViewById(R.id.btnHome);

        //button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MedicineNotTakenConfirmation.this);

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
                                Toast.makeText(getApplicationContext(),"You Clicked NO, Please review and Continue.",Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

    }
}
