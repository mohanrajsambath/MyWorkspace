package com.gradlestuff.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gradlestuff.R;

import java.util.List;

/*
 * Copyright (c) 2018. Created by Mohanraj.S,Innobot Systems on 12/4/18 for MyWorkspace
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
public class RecycleAppAdapter extends RecyclerView.Adapter<RecycleAppAdapter.MyViewHolder>{

    private List<AppList> appList;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView list_app_name,list_app_desc;
        public ImageView app_icon;
        public MyViewHolder(View itemView) {
            super(itemView);
            list_app_name = itemView.findViewById(R.id.list_app_name);
            list_app_desc = itemView.findViewById(R.id.list_app_desc);
            app_icon = itemView.findViewById(R.id.app_icon);
        }
    }

    public RecycleAppAdapter(List<AppList> appList) {
        this.appList = appList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.installed_app_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder( MyViewHolder holder, int position) {
        AppList mApplist = appList.get(position);
        holder.list_app_name.setText(mApplist.getName());
        holder.list_app_desc.setText(mApplist.getAppDesc());
        holder.app_icon.setImageDrawable(mApplist.getIcon());
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }




}
