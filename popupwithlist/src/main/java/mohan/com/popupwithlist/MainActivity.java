package mohan.com.popupwithlist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnDialog;
    AlertDialog.Builder alertDialog;
    ArrayList<String> myList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = new ArrayList<>();
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");
        myList.add("India");
        myList.add("China");
        myList.add("South Africa");
        myList.add("USA");
        myList.add("UK");
        myList.add("Japan ");
        myList.add("Canada");

        alertDialog = new AlertDialog.Builder(MainActivity.this);
        btnDialog = findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                // create view for add item in dialog
                View convertView = inflater.inflate(R.layout.list_layout, null);
                // on dialog cancel button listner
                alertDialog.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog,int which) { }});
                // add custom view in dialog
                alertDialog.setView(convertView);
                ListView lv =  convertView.findViewById(R.id.mylistview);
                final AlertDialog alert = alertDialog.create();
                alert.setTitle(" Select country...."); // Title
                MyAdapter myadapter = new MyAdapter(MainActivity.this,R.layout.listview_item, myList);
                lv.setAdapter(myadapter);
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3) {
                        Toast.makeText(MainActivity.this,"You have selected -: " + myList.get(position),Toast.LENGTH_SHORT).show();
                        //alert.cancel();
                    }
                });
                alert.show();
            }
        });
    }

    private class ViewHolder {
        TextView tvSname;
    }

    class MyAdapter extends ArrayAdapter<String> {
        LayoutInflater inflater;
        Context myContext;
        List<String> newList;

        public MyAdapter(Context context, int resource, List<String> list) {
            super(context, resource, list);
            myContext = context;
            newList = list;
            inflater = LayoutInflater.from(context);
        }

        @Override

        public View getView(final int position, View view, ViewGroup parent) {
            final ViewHolder holder;
            if (view == null) {
                holder = new ViewHolder();
                view = inflater.inflate(R.layout.listview_item, null);
                holder.tvSname = view.findViewById(R.id.tvtext_item);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            holder.tvSname.setText(newList.get(position));
            return view;
        }
    }

}
