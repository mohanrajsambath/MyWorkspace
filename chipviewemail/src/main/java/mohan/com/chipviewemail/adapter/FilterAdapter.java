package mohan.com.chipviewemail.adapter;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mohan.com.chipviewemail.R;
import mohan.com.chipviewemail.chiputils.FilteredArrayAdapter;
import mohan.com.chipviewemail.model.SimpleContact;

public class FilterAdapter extends FilteredArrayAdapter<SimpleContact> {

    public FilterAdapter(Context context, int resource, List<SimpleContact> objects) {
        super(context, resource,  objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_contact, parent, false);
        }

        SimpleContact contact = getItem(position);
        ((TextView) convertView.findViewById(R.id.name)).setText(contact != null ? contact.getName() : null);
        ((TextView) convertView.findViewById(R.id.email)).setText(contact != null ? contact.getEmail() : null);
        assert contact != null;
        ((ImageView) convertView.findViewById(R.id.icon)).setImageResource(contact.getDrawableId());

        return convertView;
    }

    /*@Override
    protected boolean keepObject(SimpleContact person, String mask) {
        mask = mask.toLowerCase();
        return  person.getEmail().toLowerCase().startsWith(mask);
    }*/

    @Override
    protected boolean keepObject(SimpleContact person, String mask) {
        mask = mask.toLowerCase();
        return person.getName().toLowerCase().startsWith(mask) || person.getEmail().toLowerCase().startsWith(mask);
    }


}
