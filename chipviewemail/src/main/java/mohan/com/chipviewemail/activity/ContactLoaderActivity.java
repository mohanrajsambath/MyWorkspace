package mohan.com.chipviewemail.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import mohan.com.chipviewemail.R;
import mohan.com.contactloader.Contact;
import mohan.com.contactloader.ContactFetcher;
import mohan.com.contactloader.ContactsAdapter;

public class ContactLoaderActivity extends RuntimePermissionsActivity {
	ArrayList<Contact> listContacts;
	ListView lvContacts;
	private static final int REQUEST_PERMISSIONS = 20;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_contacts);
		getPermissionRequest();
		listContacts = new ContactFetcher(this).fetchAll();
		lvContacts =  findViewById(R.id.lvContacts);
		ContactsAdapter adapterContacts = new ContactsAdapter(this, listContacts);
		lvContacts.setAdapter(adapterContacts);
	}

	@Override
	public void onPermissionsGranted(int requestCode) {
		Toast.makeText(this, "Permissions Received.", Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void getPermissionRequest(){
		ContactLoaderActivity.super.requestAppPermissions(new
						String[]{Manifest.permission.READ_CONTACTS,
						Manifest.permission.WRITE_EXTERNAL_STORAGE}, R.string
						.runtime_permissions_txt
				, REQUEST_PERMISSIONS);

	}

}
