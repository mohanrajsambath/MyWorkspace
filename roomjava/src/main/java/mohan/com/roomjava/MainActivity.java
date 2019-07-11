package mohan.com.roomjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnFocusChangeListener, TextView.OnEditorActionListener {
    EditText edTxt_CurrentReading, edTxt_EndReading, edTxt_UnitPrice, edTxt_FilledLitre, edTxt_TotalCost;
    double mUnitPrice = 0.0, mFilledLitre = 0.0, mTotalCost = 0.0;
    String strCurrentReading = "",strEndReading = "",strUnitPrice = "", strFilledLitre = "", strTotalCost = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        edTxt_CurrentReading = findViewById(R.id.edTxt_CurrentReading);
        edTxt_EndReading = findViewById(R.id.edTxt_EndReading);
        edTxt_UnitPrice = findViewById(R.id.edTxt_UnitPrice);
        edTxt_FilledLitre = findViewById(R.id.edTxt_FilledLitre);
        edTxt_TotalCost = findViewById(R.id.edTxt_TotalCost);

        /*edTxt_CurrentReading.setOnFocusChangeListener(this);
        edTxt_EndReading.setOnFocusChangeListener(this);
        edTxt_UnitPrice.setOnFocusChangeListener(this);
        edTxt_FilledLitre.setOnFocusChangeListener(this);
        edTxt_TotalCost.setOnFocusChangeListener(this);*/

        edTxt_CurrentReading.setOnEditorActionListener(this);
        edTxt_EndReading.setOnEditorActionListener(this);
        edTxt_UnitPrice.setOnEditorActionListener(this);
        edTxt_FilledLitre.setOnEditorActionListener(this);
        edTxt_TotalCost.setOnEditorActionListener(this);

    }


    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.edTxt_CurrentReading:
                Toast.makeText(MainActivity.this, "CurrentReading", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_EndReading:
                Toast.makeText(MainActivity.this, "EndReading", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_UnitPrice:
                Toast.makeText(MainActivity.this, "UnitPrice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_FilledLitre:
                Toast.makeText(MainActivity.this, "FilledLitre", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_TotalCost:
                Toast.makeText(MainActivity.this, "TotalCost", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (v.getId()) {
            case R.id.edTxt_CurrentReading:
                strCurrentReading = edTxt_CurrentReading.getText().toString().trim();
                if(strCurrentReading.length()>0) {

                }
                Toast.makeText(MainActivity.this, "CurrentReading", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_EndReading:
                strEndReading = edTxt_EndReading.getText().toString().trim();
                if(strEndReading.length()>0) {

                }
                Toast.makeText(MainActivity.this, "EndReading", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_UnitPrice:
                strTotalCost = edTxt_TotalCost.getText().toString().trim();
                if(strTotalCost.length()>0) {
                    mTotalCost = Double.parseDouble(strTotalCost);
                }
                strFilledLitre = edTxt_FilledLitre.getText().toString().trim();
                if(strFilledLitre.length()>0) {
                    mFilledLitre = Double.parseDouble(strFilledLitre);
                }

                strUnitPrice = edTxt_UnitPrice.getText().toString();
                mUnitPrice=mTotalCost/mFilledLitre;
                edTxt_UnitPrice.setText(""+mUnitPrice);
                Toast.makeText(MainActivity.this, "UnitPrice", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_FilledLitre:
                strUnitPrice = edTxt_UnitPrice.getText().toString().trim();
                if(strUnitPrice.length()>0) {
                    mUnitPrice = Double.parseDouble(strUnitPrice);
                }
                strFilledLitre = edTxt_FilledLitre.getText().toString().trim();
                if(strFilledLitre.length()>0) {
                    mFilledLitre = Double.parseDouble(strFilledLitre);
                }
                mTotalCost = mUnitPrice * mFilledLitre;
                edTxt_TotalCost.setText(""+mTotalCost);
                Toast.makeText(MainActivity.this, "FilledLitre", Toast.LENGTH_SHORT).show();
                break;
            case R.id.edTxt_TotalCost:
                strTotalCost = edTxt_TotalCost.getText().toString().trim();
                if(strTotalCost.length()>0) {
                    mTotalCost = Double.parseDouble(strTotalCost);
                }

                strUnitPrice = edTxt_UnitPrice.getText().toString().trim();
                if(strUnitPrice.length()>0){
                    mUnitPrice = Double.parseDouble(strUnitPrice);
                }else{
                    mUnitPrice=mTotalCost/mFilledLitre;
                    edTxt_UnitPrice.setText(""+mUnitPrice);
                }

                strFilledLitre = edTxt_FilledLitre.getText().toString();

                if(strFilledLitre.length()==0){
                    mFilledLitre=mTotalCost/mUnitPrice;
                    Log.e("Filled Litre", String.valueOf(mFilledLitre));
                    edTxt_FilledLitre.setText(String.valueOf(mFilledLitre));
                }
                Toast.makeText(MainActivity.this, "TotalCost" + mTotalCost, Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return false;
    }
}
