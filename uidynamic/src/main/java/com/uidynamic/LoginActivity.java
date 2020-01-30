package com.uidynamic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edTxt_email= findViewById(R.id.edTxt_email);
        edTxt_password= findViewById(R.id.edTxt_password);
        button_login= findViewById(R.id.button_login);

        button_login.setOnClickListener(this);

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_login:

                String mInputEmail=edTxt_email.getText().toString().trim();

                if(isEmailValid(mInputEmail)) {

                    if (mInputEmail.length() > 0) {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("LOGIN", mInputEmail); // Storing string
                    editor.putString("SETTHEME", "false"); // Storing string
                    editor.apply();
                    gotoActivity();
                }
                }else{
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

        return matcher.matches();
    }
}
