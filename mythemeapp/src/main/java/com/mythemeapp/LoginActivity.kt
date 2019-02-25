package com.mythemeapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern


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

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private var edTxt_email: EditText? = null
    private var edTxt_password: EditText? = null
    private var button_login: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edTxt_email = findViewById<View>(R.id.edTxt_email) as EditText
        edTxt_password = findViewById<View>(R.id.edTxt_password) as EditText
        button_login = findViewById<View>(R.id.button_login) as Button
        button_login!!.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_login -> {
                //gotoActivity();
                val mInputEmail = edTxt_email!!.text.toString().trim { it <= ' ' }
                if (isEmailValid(mInputEmail)) {
                    if (mInputEmail.length > 0) {
                        val pref = applicationContext.getSharedPreferences("MyPref", 0) // 0 - for private mode
                        val editor = pref.edit()
                        editor.putString("LOGIN", mInputEmail) // Storing string
                        editor.putString("SETTHEME", "false") // Storing string
                        editor.apply()
                        gotoActivity()
                    }
                } else {
                    Toast.makeText(this@LoginActivity, "Please Enter Valid EMail", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun gotoActivity() {
       /* val io = Intent(this@LoginActivity, MainActivity::class)
        startActivity(io)
        finish()*/
    }

    fun isEmailValid(email: String): Boolean {
        val regExpn = ("^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$")

        val pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)

        return matcher.matches()
    }
}
