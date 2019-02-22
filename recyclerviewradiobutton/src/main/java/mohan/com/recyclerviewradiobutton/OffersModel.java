package mohan.com.recyclerviewradiobutton;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 7/5/18 for MyWorkspace
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
public class OffersModel {
    public String Offer="";

    public int getSavings() {
        return Savings;
    }

    public void setSavings(int savings) {
        Savings = savings;
    }

    public int Savings;

    public OffersModel(String s, int i) {
        this.Offer =s;
        this.Savings=i;
    }

    public String getOffer() {
        return Offer;
    }

    public void setOffer(String offer) {
        Offer = offer;
    }





}
