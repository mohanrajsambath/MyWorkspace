package mohan.com.chipviewcontacts;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import mohan.com.chipviewemail.R;
import mohan.com.chipviewemail.activity.RuntimePermissionsActivity;

/*
 * Copyright (c) 2019. Created by Mohanraj.S, on 23/2/19 for MyWorkspace
 */
public class ChipViewContactLoaderActivity extends RuntimePermissionsActivity {

    ArrayList<ContactwithImage> listContacts;

    private static final int REQUEST_PERMISSIONS = 30;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chipview_conactloader);
        getPermissionRequest();
    }




    @Override
    public void onPermissionsGranted(int requestCode) {

    }
    private void getPermissionRequest(){
        ChipViewContactLoaderActivity.super.requestAppPermissions(new
                        String[]{Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, R.string
                        .runtime_permissions_txt
                , REQUEST_PERMISSIONS);
    }


}
