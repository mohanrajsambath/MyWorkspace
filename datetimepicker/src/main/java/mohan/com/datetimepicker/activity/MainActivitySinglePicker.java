package mohan.com.datetimepicker.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import mohan.com.datetimepicker.R;
import mohan.com.datetimepicker.utils.SingleDateAndTimePicker;
/*https://github.com/mohanrajsambath/SingleDateAndTimePicker*/

public class MainActivitySinglePicker extends AppCompatActivity implements View.OnClickListener{


    private TextView txtVw_date;
    private ImageView imgVw_close_datePicker;
    private FrameLayout fL_date_bottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVw_date = findViewById(R.id.txtVw_date);
        imgVw_close_datePicker = findViewById( R.id.imgVw_close_datePicker);
        fL_date_bottomSheet = findViewById(R.id.fL_date_bottomSheet);
        txtVw_date.setOnClickListener(this);
        imgVw_close_datePicker.setOnClickListener(this);

        setDateTimePicker();



    }

    private void setDateTimePicker() {
        final SingleDateAndTimePicker singleDateAndTimePicker = findViewById(R.id.single_day_picker);
        singleDateAndTimePicker.addOnDateChangedListener(new SingleDateAndTimePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(String displayed, Date date) {
                display(displayed);
            }
        });
    }

    private void display(String toDisplay) {
        //Toast.makeText(this, toDisplay, Toast.LENGTH_SHORT).show();
        txtVw_date.setText(toDisplay);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtVw_date:
                fL_date_bottomSheet.setVisibility(View.VISIBLE);
                break;
            case R.id.imgVw_close_datePicker:
                fL_date_bottomSheet.setVisibility(View.GONE);
                break;
                default:
                    break;

        }
    }
}
