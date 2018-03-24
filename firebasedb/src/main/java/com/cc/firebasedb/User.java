package com.cc.firebasedb;

 /*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 24/3/18 for MyWorkspace
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


import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {


        public String name;
        public String email;

        // Default constructor required for calls to
        // DataSnapshot.getValue(User.class)
        public User() {
        }

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }

}
