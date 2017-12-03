package aa_stem.finallogscreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class BasicSetup extends AppCompatActivity {
    TextView viewpromptMedName;
    EditText inputmedicineName;
    TextView viewpromptDoseAmt;
    EditText inputdosageAmount;
    String   medicinename;
    Double   dosage;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basicsetup);
        viewpromptMedName = (TextView) findViewById(R.id.promptMedName);
        inputmedicineName = (EditText) findViewById(R.id.medicineName) ;
        viewpromptDoseAmt = (TextView) findViewById(R.id.promptDoseAmt);
        inputdosageAmount = (EditText) findViewById(R.id.dosageAmount) ;
//        String medicinename = inputmedicineName.getText().toString();
//        Double dosage       = inputdosageAmount.get
        System.out.print(medicinename);
        System.out.print(dosage);


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
