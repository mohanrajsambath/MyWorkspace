package mohan.com.chipviewcontacts;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mohan.com.chipviewemail.R;
import mohan.com.chipviewemail.activity.RuntimePermissionsActivity;
import mohan.com.chipviewemail.adapter.FilterAdapter;
import mohan.com.chipviewemail.chiputils.TokenCompleteTextView;
import mohan.com.chipviewemail.model.SimpleContact;
import mohan.com.chipviewemail.views.ContactsCompletionView;
import mohan.com.contactloader.Contact;
import mohan.com.contactloader.ContactFetcher;

/*
 * Copyright (c) 2019. Created by Mohanraj.S, on 23/2/19 for MyWorkspace
 */
public class ChipViewContactLoaderActivity extends RuntimePermissionsActivity implements TokenCompleteTextView.TokenListener<SimpleContact>  {

    private static final int REQUEST_PERMISSIONS = 30;
    ArrayList<Contact> listContacts;
    private ArrayList<SimpleContact> contacts;
    private FilterAdapter filterAdapter;
    private ContactsCompletionView autoCompleteTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chipview_conactloader);
        getPermissionRequest();
        autoCompleteTextView = findViewById(R.id.autocomplete_textview);
        getContactListData();
        setContactData();


        //Initializing and attaching adapter for AutocompleteTextView
        filterAdapter = new FilterAdapter(this, R.layout.item_contact, contacts);
        autoCompleteTextView.setAdapter(filterAdapter);

        //Set the listener that will be notified of changes in the Tokenlist
        autoCompleteTextView.setTokenListener(this);


        //Set the action to be taken when a Token is clicked
        autoCompleteTextView.setTokenClickStyle(TokenCompleteTextView.TokenClickStyle.Select);
        final TextView inputContent = findViewById(R.id.input_content);
        View btnGet = findViewById(R.id.btn_get);
        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<SimpleContact> tokens = autoCompleteTextView.getObjects();
                StringBuilder content = new StringBuilder();
                for (int i = 0; i < tokens.size(); i++) {
                    content.append(tokens.get(i)).append("; ");
                }
                inputContent.setText(String.format("You choose: %s", content.toString()));
            }
        });
    }

    private void setContactData() {
        int i,j;
        contacts = new ArrayList<>();
        //try {
            for (i = 0; i < listContacts.size(); i++){
                System.out.println("Device Contacts Name:" + listContacts.get(i).name+","+listContacts.get(i).getEmailId());
                contacts.add(new SimpleContact(R.drawable.ic_person, listContacts.get(i).name, listContacts.get(i).getEmailId()));
            }


    }

    private void getContactListData() {
        listContacts = new ContactFetcher(this).fetchAll();

    }

    @Override
    public void onPermissionsGranted(int requestCode) { }
    private void getPermissionRequest(){
        ChipViewContactLoaderActivity.super.requestAppPermissions(new
                        String[]{Manifest.permission.READ_CONTACTS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, R.string
                        .runtime_permissions_txt
                , REQUEST_PERMISSIONS);
    }


    @Override
    public void onTokenAdded(SimpleContact token) {

    }

    @Override
    public void onTokenRemoved(SimpleContact token) {

    }

    @Override
    public void onTokenIgnored(SimpleContact token) {

    }


}
