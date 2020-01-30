package mohan.com.datetimepicker.activity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import mohan.com.datetimepicker.R;
import mohan.com.datetimepicker.utils.SingleDateAndTimePicker;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 10/9/18 for MyWorkspace
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class DatePickerPopUpActivity extends AppCompatActivity {
    Dialog myDialog;
    TextView txtVw_date_label_1,txtVw_date_label_2;
    boolean isDateModified1=false,isDateModified2=false;
    private Date existDate1,existDate2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_datepickerpop);
        txtVw_date_label_1 = findViewById(R.id.txtVw_date_label_1);
        txtVw_date_label_2 = findViewById(R.id.txtVw_date_label_2);
        myDialog = new Dialog(this);
    }

    public void ShowPopup_1(View v) {
        TextView txtVw_done;
        Button btnFollow;
        final mohan.com.datetimepicker.utils.SingleDateAndTimePicker mSingleDateAndTimePicker1;
        ImageView imgVw_close;
        myDialog.setContentView(R.layout.custompopup_datepicker);
        txtVw_done = myDialog.findViewById(R.id.txtVw_done);
        imgVw_close = myDialog.findViewById(R.id.imgVw_close);

        mSingleDateAndTimePicker1 = myDialog.findViewById(R.id.single_day_picker1);
        mSingleDateAndTimePicker1.setVisibility(View.VISIBLE);

        if(isDateModified1){
            mSingleDateAndTimePicker1.setDefaultDate(existDate1);
        }else{
            mSingleDateAndTimePicker1.setDefaultDate(null);
        }



        imgVw_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        txtVw_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSingleDateAndTimePicker1.setVisibility(View.GONE);
                myDialog.dismiss();
            }
        });
        mSingleDateAndTimePicker1.addOnDateChangedListener(new SingleDateAndTimePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(String displayed, Date date) {
                //displayExiparyDate(date);
                existDate1 =date;
                isDateModified1=true;
                txtVw_date_label_1.setText(""+date);


            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
    public void ShowPopup_2(View v) {
        TextView txtVw_done;
        Button btnFollow;
        final mohan.com.datetimepicker.utils.SingleDateAndTimePicker mSingleDateAndTimePicker2;
        ImageView imgVw_close;
        myDialog.setContentView(R.layout.custompopup_datepicker);
        txtVw_done = myDialog.findViewById(R.id.txtVw_done);
        imgVw_close = myDialog.findViewById(R.id.imgVw_close);

        mSingleDateAndTimePicker2 = myDialog.findViewById(R.id.single_day_picker2);
        mSingleDateAndTimePicker2.setVisibility(View.VISIBLE);

        if(isDateModified1){
            mSingleDateAndTimePicker2.setDefaultDate(existDate2);
        }else{
            mSingleDateAndTimePicker2.setDefaultDate(null);
        }

        imgVw_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        txtVw_done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSingleDateAndTimePicker2.setVisibility(View.GONE);
                myDialog.dismiss();
            }
        });
        mSingleDateAndTimePicker2.addOnDateChangedListener(new SingleDateAndTimePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(String displayed, Date date) {
                //displayExiparyDate(date);
                existDate2 =date;
                isDateModified1=true;
                txtVw_date_label_2.setText(""+date);

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
