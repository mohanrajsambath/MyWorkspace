package com.gradlestuff;

 /*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 17/3/18 for MyWorkspace
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

public class Constants {

    public enum Clients{
        HOMEDEPOT,UPS,CYRANO;
    }

    public static final Clients mClients= Clients.CYRANO;
}