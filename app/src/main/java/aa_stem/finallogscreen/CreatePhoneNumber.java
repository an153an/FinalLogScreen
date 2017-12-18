package aa_stem.finallogscreen;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class CreatePhoneNumber extends AppCompatActivity {
    TextView viewpromptMedName;
    EditText inputmedicineName;
    TextView viewpromptDoseAmt;
    EditText inputdosageAmount;
    TextView viewhomephone;
    EditText inputhomehome;
    TextView viewcellphone;
    EditText inputcellphone;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addphonenumbers);
        viewhomephone = (TextView) findViewById(R.id.prompthomephone);
        inputhomehome = (EditText) findViewById(R.id.homephone) ;
        viewcellphone = (TextView) findViewById(R.id.promptcellphone);
        inputcellphone = (EditText) findViewById(R.id.cellphone) ;


        //Create Button
        Button btnVerifyPhone = (Button) findViewById(R.id.btnVerifyPhone);


        //button click event
        btnVerifyPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreatePhoneNumber.this);

                alertDialog.setTitle("Congratulations!");
                alertDialog.setMessage("Setup is complete.");

                alertDialog.show();


            }
        });

        Button btnHome = (Button) findViewById(R.id.btnHome);
        //button click event
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(CreatePhoneNumber.this);

                alertDialog.setTitle("Create Alert");
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

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}


// When IntakeCt = IntakeCt + 1 Then...
//     In a Scroll View, Make A Layout (Linear) with following Text Views:
//       MedName, DoseAmt, TimeTaken
