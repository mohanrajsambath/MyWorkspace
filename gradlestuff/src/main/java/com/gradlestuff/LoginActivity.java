package com.gradlestuff;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*
 * Copyright (c) 2018. Created by Mohanraj.S, on 20/3/18 for MyWorkspace
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

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edTxt_email,edTxt_password;
    private Button button_login;
    TextWatcher watch;
    private ImageView imgVw_login_logo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edTxt_email=(EditText)findViewById(R.id.edTxt_email);
        edTxt_password=(EditText)findViewById(R.id.edTxt_password);
        imgVw_login_logo= (ImageView)findViewById(R.id.imgVw_login_logo);
        button_login=(Button)findViewById(R.id.button_login);
        button_login.setOnClickListener(this);

        inittextWatch();
        edTxt_email.addTextChangedListener(watch);
    }

    private void inittextWatch() {

        watch = new TextWatcher(){

            @Override
            public void afterTextChanged(Editable edt) {
                String matchWords = edTxt_email.getText().toString().toLowerCase().trim();
                if(edt.length()>0) {
                    /*if (matchWords.contains("hd") || matchWords.contains("hdnews") || matchWords.contains("homedepot")) {
                        imgVw_login_logo.setImageResource(R.drawable.logo_hd);
                    } else*/
                    if (matchWords.contains("ups") || matchWords.contains("united parcel service")
                            || matchWords.contains("unitedparcel service")
                            || matchWords.contains("united parcelservice")
                            || matchWords.contains("unitedparcelservice")) {
                        imgVw_login_logo.setImageResource(R.drawable.logo_ups);
                    } /*else if (matchWords.contains("cyrano")
                            || matchWords.contains("cyranosystems")
                            || matchWords.contains("cyranoapp")) {
                        imgVw_login_logo.setImageResource(R.drawable.logo_cyrano);
                    } */else {
                        imgVw_login_logo.setImageResource(R.mipmap.ic_account_circle_black_48dp);
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,int arg3) {}

            @Override
            public void onTextChanged(CharSequence s, int a, int b, int c) { }};
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:

                String mInputEmail=edTxt_email.getText().toString().trim();
                String mInputPassword=edTxt_password.getText().toString().trim();

                if(isEmailValid(mInputEmail)) {
                    if(mInputPassword.contentEquals("Test@2345")) {

                        if (mInputEmail.length() > 0) {
                            SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("LOGIN", mInputEmail); // Storing string
                            //editor.putString("SETTHEME", "false"); // Storing string
                            editor.apply();
                            gotoActivity();
                        }
                    }else{
                        Toast.makeText(LoginActivity.this,"Please Enter Valid Password",Toast.LENGTH_SHORT).show();
                    }}else{
                    Toast.makeText(LoginActivity.this,"Please Enter Valid EMail",Toast.LENGTH_SHORT).show();
                }

                break;
        }

    }

    private void gotoActivity() {
        Intent io = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(io);
        finish();
    }

    public boolean isEmailValid(String email)
    {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        +"((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        +"([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        +"[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        +"([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(regExpn,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if(matcher.matches())
            return true;
        else
            return false;
    }


}
