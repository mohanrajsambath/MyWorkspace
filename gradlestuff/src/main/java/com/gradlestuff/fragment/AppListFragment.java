package com.gradlestuff.fragment;


import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.support.v4.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gradlestuff.R;
import com.gradlestuff.adapters.AppList;
import com.gradlestuff.adapters.RecycleAppAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AppListFragment extends Fragment {



    View view;
    private RecycleAppAdapter mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager recyclerViewLayoutManager;

    public AppListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_chat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        getActivity().setTitle("AppList");
    }

    private void initViews() {
        recyclerView = view.findViewById(R.id.recycler_view);
        // Passing the column number 1 to show online one column in each row.
        /*RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        adapter = new AppsAdapter(getActivity(), new ApkInfoExtractor(getActivity()).GetAllInstalledApkInfo());
        recyclerView.setAdapter(adapter);*/

        List<AppList> installedApps = getInstalledApps();
        mAdapter = new RecycleAppAdapter(installedApps);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }

    private List<AppList> getInstalledApps() {
        List<AppList> res = new ArrayList<AppList>();
        List<PackageInfo> packs = getActivity().getPackageManager().getInstalledPackages(0);

        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);
            if ((!isSystemPackage(p) )) {
                String appName = p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
                String appDesc = p.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getActivity().getPackageManager());
                res.add(new AppList(appName,appDesc, icon));
            }
        }
        return res;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }
}
