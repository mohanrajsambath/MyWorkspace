package mohan.com.multiandsingleselectionrecyclerview;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 3/9/18 for MyWorkspace
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
public class SelectableViewHolder extends RecyclerView.ViewHolder {

    public static final int MULTI_SELECTION = 2;
    public static final int SINGLE_SELECTION = 1;
    //CheckedTextView cl_slected_item;
    TextView txtVw_Name;
    ConstraintLayout cl_slected_item;
    CheckBox checkBox;
    SelectableItem mItem;
    OnItemSelectedListener itemSelectedListener;


    public SelectableViewHolder(View view, OnItemSelectedListener listener) {
        super(view);
        itemSelectedListener = listener;
        //cl_slected_item = (CheckedTextView) view.findViewById(R.id.checked_text_item);
        txtVw_Name = view.findViewById(R.id.txtVw_Name);
        cl_slected_item = view.findViewById(R.id.cl_slected_item);
        checkBox = view.findViewById(R.id.checkBox);
        cl_slected_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mItem.isSelected() && getItemViewType() == MULTI_SELECTION) {
                    setChecked(false);
                } else {
                    setChecked(true);
                }
                itemSelectedListener.onItemSelected(mItem);

            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mItem.isSelected() && getItemViewType() == MULTI_SELECTION) {
                    setChecked(false);
                } else {
                    setChecked(true);
                }
                itemSelectedListener.onItemSelected(mItem);

            }
        });
    }

    public void setChecked(boolean value) {
        if (value) {
            cl_slected_item.setBackgroundColor(Color.LTGRAY);
            checkBox.setBackgroundResource(R.drawable.ic_check_regular);
        } else {
            cl_slected_item.setBackgroundColor(Color.parseColor("#51f1a4"));
            checkBox.setBackgroundResource(R.drawable.ic_square_regular);
        }
        mItem.setSelected(value);
        checkBox.setChecked(value);
    }

    public interface OnItemSelectedListener {

        void onItemSelected(SelectableItem item);
    }

}
