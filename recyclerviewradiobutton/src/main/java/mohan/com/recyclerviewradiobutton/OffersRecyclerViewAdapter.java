package mohan.com.recyclerviewradiobutton;


import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
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
public class OffersRecyclerViewAdapter extends RecyclerView.Adapter<OffersRecyclerViewAdapter.ViewHolder> {

    private List<OffersModel> offersList;
    private Context context;
    public TemplateSelectionListener mListener;
    private int lastSelectedPosition = -1;
    private RadioButton lastChecked=null;

    public OffersRecyclerViewAdapter(List<OffersModel> offersListIn
            , Context ctx,TemplateSelectionListener Listener) {
        offersList = offersListIn;
        context = ctx;
        this.mListener= Listener;

    }

    @Override
    public OffersRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyc_items, parent, false);

        OffersRecyclerViewAdapter.ViewHolder viewHolder =
                new OffersRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final OffersRecyclerViewAdapter.ViewHolder holder,
                                 final int position) {
         final OffersModel offersModel = offersList.get(position);
        final String mStringOffer =offersModel.getOffer();
        holder.offerName.setText(mStringOffer);
        holder.offerAmount.setText("" + offersModel.getSavings());


        //since only one radio button is allowed to be selected,
        // this condition un-checks previous selections
         holder.selectionState.setChecked(lastSelectedPosition == position);
        holder.selectionState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lastSelectedPosition = position;
                RadioButton rb =(RadioButton) v;
                if(rb.isChecked()){
                    if(lastChecked !=null){
                        lastChecked.setChecked(false);
                    }
                    lastChecked=rb;
                }else{
                    lastChecked = null;
                }
                notifyDataSetChanged();
                //String mStringOffer =holder.offerName.getText().toString();

                Toast.makeText(OffersRecyclerViewAdapter.this.context,
                        "selected offer is " + offersModel.getOffer() ,
                        Toast.LENGTH_LONG).show();
                //mListener.onClick(offerName.getText().toString());
                mListener.onTemplateSelected(offersModel.getOffer(),"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return offersList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView offerName;
        public TextView offerAmount;
        public RadioButton selectionState;

        public ViewHolder(View view) {
            super(view);
            offerName = view.findViewById(R.id.offer_name);
            offerAmount = view.findViewById(R.id.offer_amount);
            selectionState = view.findViewById(R.id.offer_select);
            //since only one radio button is allowed to be selected,
            // this condition un-checks previous selections
            /*selectionState.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                   String s = offerName.getText().toString();

                    Toast.makeText(OffersRecyclerViewAdapter.this.context,
                            "selected offer is " + s,
                            Toast.LENGTH_LONG).show();

                    //mListener.onClick(offerName.getText().toString());
                    //mListener.onClick(offersList.get(position));
                    // mListener.getRecycValueCallBack(String.valueOf(s));
                }
            });*/
        }
    }
}
