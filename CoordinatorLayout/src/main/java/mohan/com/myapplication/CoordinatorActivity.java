package mohan.com.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 10/5/18 for CoordinatorWorkspace
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
public class CoordinatorActivity extends AppCompatActivity implements View.OnClickListener,TemplateSelectionListener {
    private LinearLayout bottomSheet_PrivacySettings,bottomSheetTemplateSettings,bottomSheet_Countrylist;
    private BottomSheetBehavior<LinearLayout> mBottomSheetBehavior_PrivacySettings,mBottomSheetBehavior_TemplateSettings,mBottomSheetBehavior_Countrylist;
    private Button btn_signup;
    private TextView textView_Phone,textView_Address,textView_Country;
    private RecyclerView offerRecyclerView;
    TemplateSelectionListener mlistener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        offerRecyclerView = (RecyclerView) findViewById(R.id.offers_lst);
        btn_signup = (Button)findViewById(R.id.btn_signup);
        textView_Phone= (TextView)findViewById(R.id.textView_Phone);
        textView_Address= (TextView)findViewById(R.id.textView_Address);
        textView_Country= (TextView)findViewById(R.id.textView_Country);
        btn_signup.setOnClickListener(this);
        textView_Phone.setOnClickListener(this);
        textView_Address.setOnClickListener(this);
        textView_Country.setOnClickListener(this);

        LinearLayoutManager recyclerLayoutManager = new LinearLayoutManager(this);
        offerRecyclerView.setLayoutManager(recyclerLayoutManager);
        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(offerRecyclerView.getContext(),
                        recyclerLayoutManager.getOrientation());
        offerRecyclerView.addItemDecoration(dividerItemDecoration);
        OffersRecyclerViewAdapter recyclerViewAdapter = new OffersRecyclerViewAdapter(getBrands(),this, mlistener);
        offerRecyclerView.setAdapter(recyclerViewAdapter);

        bottomSheet_PrivacySettings = (LinearLayout) findViewById(R.id.bottomSheet_PrivacySettings);
        mBottomSheetBehavior_PrivacySettings = BottomSheetBehavior.from(bottomSheet_PrivacySettings);
        mBottomSheetBehavior_PrivacySettings.setHideable(true);
        mBottomSheetBehavior_PrivacySettings.setPeekHeight(300);
        mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);

        bottomSheetTemplateSettings = (LinearLayout) findViewById(R.id.bottomSheet_TemplateSettings);
        mBottomSheetBehavior_TemplateSettings = BottomSheetBehavior.from(bottomSheetTemplateSettings);
        mBottomSheetBehavior_TemplateSettings.setHideable(true);
        mBottomSheetBehavior_TemplateSettings.setPeekHeight(300);
        mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_HIDDEN);
        //bottomSheet_Countrylist

        bottomSheet_Countrylist = (LinearLayout) findViewById(R.id.bottomSheet_Countrylist);
        mBottomSheetBehavior_Countrylist = BottomSheetBehavior.from(bottomSheet_Countrylist);
        mBottomSheetBehavior_Countrylist.setHideable(true);
        mBottomSheetBehavior_Countrylist.setPeekHeight(300);
        mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_HIDDEN);






        mBottomSheetBehavior_PrivacySettings.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    //mButton2.setText(R.string.button2_peek);
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //mButton2.setText(R.string.button2_hide);
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    //mButton2.setText(R.string.button2);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        mBottomSheetBehavior_TemplateSettings.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    //mButton2.setText(R.string.button2_peek);
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //mButton2.setText(R.string.button2_hide);
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    //mButton2.setText(R.string.button2);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });

        mBottomSheetBehavior_Countrylist.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                    //mButton2.setText(R.string.button2_peek);
                } else if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    //mButton2.setText(R.string.button2_hide);
                } else if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                    //mButton2.setText(R.string.button2);
                }
            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {
            }
        });
    }

    private void setPrivacyBottomSheetAction() {
        /*if(mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            //mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);

        }else if(mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);

        }else if(mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_EXPANDED);
            // mButton2.setText(R.string.button2_peek);
        }*/

        if (mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //mButton2.setText(R.string.button2_hide);
        } else if (mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mButton2.setText(R.string.button2);
        } else if (mBottomSheetBehavior_PrivacySettings.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_EXPANDED);
            //mButton2.setText(R.string.button2_peek);
        }
    }

    private void setTemplateBottomSheetAction() {


        if (mBottomSheetBehavior_TemplateSettings.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //mButton2.setText(R.string.button2_hide);
        } else if (mBottomSheetBehavior_TemplateSettings.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mButton2.setText(R.string.button2);
        } else if (mBottomSheetBehavior_TemplateSettings.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_EXPANDED);
            //mButton2.setText(R.string.button2_peek);
        }
    }
    private void setCountryBottomSheetAction() {


        if (mBottomSheetBehavior_Countrylist.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //mButton2.setText(R.string.button2_hide);
        } else if (mBottomSheetBehavior_Countrylist.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
            mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_HIDDEN);
            //mButton2.setText(R.string.button2);
        } else if (mBottomSheetBehavior_Countrylist.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_EXPANDED);
            //mButton2.setText(R.string.button2_peek);
        }
    }

    private List<OffersModel> getCountry(){
        List<OffersModel> modelList = new ArrayList<OffersModel>();
        modelList.add(new OffersModel("America", 300));
        modelList.add(new OffersModel("Brazil", 200));
        modelList.add(new OffersModel("China", 600));
        modelList.add(new OffersModel("Ethopia", 500));
        modelList.add(new OffersModel("Nigeria", 100));
        modelList.add(new OffersModel("India", 1600));
        modelList.add(new OffersModel("Pakistan", 300));
        modelList.add(new OffersModel("Burma", 400));
        modelList.add(new OffersModel("Russia", 700));
        modelList.add(new OffersModel("Japan", 600));
        modelList.add(new OffersModel("Korea", 700));
        modelList.add(new OffersModel("SriLanka", 500));
        modelList.add(new OffersModel("Australia", 600));
        return modelList;
    }
    private List<OffersModel> getBrands(){
        List<OffersModel> modelList = new ArrayList<OffersModel>();
        modelList.add(new OffersModel("Get Upto 20% Off Clothing", 300));
        modelList.add(new OffersModel("Free Smart Phone", 200));
        modelList.add(new OffersModel("Pay $100 get big HD TV", 600));
        modelList.add(new OffersModel("Get Upto 40% Off All", 500));
        modelList.add(new OffersModel("Buy One Get One Free", 100));
        modelList.add(new OffersModel("Pay $200 get Laptop", 1600));
        modelList.add(new OffersModel("Get Upto 50% Off Electronics", 300));
        modelList.add(new OffersModel("Free Movie Ticket", 400));
        modelList.add(new OffersModel("Pay $100 Travel Europe", 700));
        modelList.add(new OffersModel("Get Upto 27% Off Appliance", 600));
        modelList.add(new OffersModel("Get Upto 44% Off Jewellery", 700));
        modelList.add(new OffersModel("Free Coupons", 500));
        modelList.add(new OffersModel("Pay $100 get Tablet", 600));
        return modelList;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.textView_Phone:
                bottomSheet_PrivacySettings.setVisibility(View.VISIBLE);
                bottomSheetTemplateSettings.setVisibility(View.GONE);
                bottomSheet_Countrylist.setVisibility(View.GONE);
                setPrivacyBottomSheetAction();
                mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_HIDDEN);
                mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;

            case R.id.textView_Address:
                bottomSheet_PrivacySettings.setVisibility(View.GONE);
                bottomSheetTemplateSettings.setVisibility(View.VISIBLE);
                bottomSheet_Countrylist.setVisibility(View.GONE);
                setTemplateBottomSheetAction();
                mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);
                mBottomSheetBehavior_Countrylist.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.textView_Country:
                bottomSheet_PrivacySettings.setVisibility(View.GONE);
                bottomSheetTemplateSettings.setVisibility(View.GONE);
                bottomSheet_Countrylist.setVisibility(View.VISIBLE);
                setCountryBottomSheetAction();
                mBottomSheetBehavior_TemplateSettings.setState(BottomSheetBehavior.STATE_HIDDEN);
                mBottomSheetBehavior_PrivacySettings.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
        }
    }

    @Override
    public void onTemplateSelected(String templateId, String templateName) {
        if(!templateId.isEmpty()) {
            textView_Country.setText(templateId);
        }else{

        }
    }
}
