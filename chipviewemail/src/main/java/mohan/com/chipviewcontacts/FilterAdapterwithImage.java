package mohan.com.chipviewcontacts;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import mohan.com.chipviewcontacts.model.ContactwithImage;
import mohan.com.chipviewemail.R;
import mohan.com.chipviewemail.chiputils.FilteredArrayAdapter;

public class FilterAdapterwithImage extends FilteredArrayAdapter<ContactwithImage> {

    public FilterAdapterwithImage(Context context, int resource, List<ContactwithImage> objects) {
        super(context, resource,  objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {

            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_contact, parent, false);
        }

        ContactwithImage contact = getItem(position);
        ((TextView) convertView.findViewById(R.id.name)).setText(contact != null ? contact.name : null);
        ((TextView) convertView.findViewById(R.id.email)).setText(contact != null ? contact.emails.get(0).address : null);
        assert contact != null;
        ((ImageView) convertView.findViewById(R.id.icon)).setImageResource(contact.getDrawableId());

        return convertView;
    }

    @Override
    protected boolean keepObject(ContactwithImage person, String mask) {
        mask = mask.toLowerCase();
        return person.name.toLowerCase().startsWith(mask) || person.emails.get(0).address.toLowerCase().startsWith(mask);
    }
}
