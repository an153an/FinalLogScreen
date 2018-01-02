package aa_stem.finallogscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SentSMSActivity extends AppCompatActivity {
    TextView viewpromptMedName;
    TextView viewpromptDoseAmt;
    TextView viewpromptStartDate;
    TextView viewpromptStartTime;
    TextView viewhomephoneNo;
    TextView viewcellphoneNo;
    String medicine_name = "";
    String dose_amt = "";
    String start_Date = "";
    String start_Time = "";
    String cell_phone = "";
    String home_phone = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sent_sms);

        viewpromptMedName = (TextView) findViewById(R.id.medicineName);
        viewpromptDoseAmt = (TextView) findViewById(R.id.dosageAmount);
        viewpromptStartDate = (TextView) findViewById(R.id.startDate);
        viewpromptStartTime = (TextView) findViewById(R.id.startTime);
        viewhomephoneNo = (TextView) findViewById(R.id.homephone);
        viewcellphoneNo = (TextView) findViewById(R.id.cellphone);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        medicine_name = extras.getString("med_name");
        dose_amt = extras.getString("dose_amt");
        start_Date = extras.getString("startDate");
        start_Time = extras.getString("startTime");
        home_phone = extras.getString("homephone");
        cell_phone = extras.getString("cellphone");

        viewpromptMedName.setText("Medicine Name: "+ medicine_name);
        viewpromptDoseAmt.setText("Dosage Amount: "+ dose_amt);
        viewpromptStartDate.setText("Start Date: "+start_Date);
        viewpromptStartTime.setText("Start Time: "+start_Time);
        viewhomephoneNo.setText("Home Phone: "+home_phone);
        viewcellphoneNo.setText("Cell Phone: "+cell_phone);

        Button btnHome = (Button) findViewById(R.id.btnHome);
        Button btnTake = (Button) findViewById(R.id.btnTake);
        Button btnDelay = (Button) findViewById(R.id.btnDelay);
        Button btnDontTake = (Button) findViewById(R.id.btnDontTake);


        //button click event
        btnDontTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SentSMSActivity.this);

                alertDialog.setTitle("Medicine Not Taken Alert");
                alertDialog.setMessage("Medicine is not taken. Please continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),MedicineNotTakenConfirmation.class);
                        i.putExtra("med_name",medicine_name);
                        i.putExtra("dose_amt",dose_amt);
                        i.putExtra("startDate",start_Date);
                        i.putExtra("startTime",start_Time);
                        i.putExtra("cellphone",home_phone);
                        i.putExtra("homephone",cell_phone);
                        startActivity(i);

                    }
                });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"You Clicked NO, Please review details and continue...",Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        //button click event
        btnDelay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SentSMSActivity.this);

                alertDialog.setTitle("Medicine Delay Alert");
                alertDialog.setMessage("Timing is delayed for medicine. Please continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),MedicineDelayConfirmation.class);
                        i.putExtra("med_name",medicine_name);
                        i.putExtra("dose_amt",dose_amt);
                        i.putExtra("startDate",start_Date);
                        i.putExtra("startTime",start_Time);
                        i.putExtra("cellphone",home_phone);
                        i.putExtra("homephone",cell_phone);
                        startActivity(i);
                    }
                });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"You Clicked NO, Please review details and continue...",Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        });

                alertDialog.show();
            }
        });


        //button click event
        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SentSMSActivity.this);

                alertDialog.setTitle("Medicine Taken Alert");
                alertDialog.setMessage("Thanks for taking medicine. Please continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),MedicineTakenConfirmation.class);
                        i.putExtra("med_name",medicine_name);
                        i.putExtra("dose_amt",dose_amt);
                        i.putExtra("startDate",start_Date);
                        i.putExtra("startTime",start_Time);
                        i.putExtra("cellphone",home_phone);
                        i.putExtra("homephone",cell_phone);
                        startActivity(i);
                    }
                });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(),"You Clicked NO, Please review details and continue...",Toast.LENGTH_LONG).show();
                                dialogInterface.cancel();
                            }
                        });

                alertDialog.show();
            }
        });

        //button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(SentSMSActivity.this);

                alertDialog.setTitle("Home Alert");
                alertDialog.setMessage("Are you sure you want to continue..");


                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Intent i = new Intent(getApplicationContext(),BasicSetup.class);
                        startActivity(i);
                    }
                });

                alertDialog.show();
            }
        });

    }

}
