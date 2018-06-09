package mohan.com.bottomsheet.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mohan.com.bottomsheet.R;
import mohan.com.bottomsheet.adapter.RecyclerAdapter;
import mohan.com.bottomsheet.bottomconfig.BottomSheetBehaviorRecyclerManager;
import mohan.com.bottomsheet.bottomconfig.BottomSheetBehaviorv2;
import mohan.com.bottomsheet.bottomconfig.BottomSheetDialogv2;
import mohan.com.bottomsheet.model.TempModel;

public class MainActivity extends AppCompatActivity {

    private Button mRecyclerDialogBtn;
    private CoordinatorLayout mParent;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mParent = (CoordinatorLayout) findViewById(R.id.parent_container);
        mParent.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mRecyclerDialogBtn =(Button)findViewById(R.id.mRecyclerDialogBtn);
        textView =(TextView)findViewById(R.id.textView);
        mRecyclerDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createDialogBtmSheet();
            }


        });
    }

    private void createDialogBtmSheet() {
        BottomSheetDialogv2 bottomSheetDialog = new BottomSheetDialogv2(MainActivity.this);
        View dialogSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

        bottomSheetDialog.setContentView(dialogSheetView);
        bottomSheetDialog.show();

        RecyclerView mBottomSheetRecyclerLeft = (RecyclerView) dialogSheetView.findViewById(R.id.btm_recyclerview_left);
        LinearLayoutManager mLayoutManagerLeft = new LinearLayoutManager(this);
        mBottomSheetRecyclerLeft.setLayoutManager(mLayoutManagerLeft);

        bottomSheetDialog.setCancelable(true);
        bottomSheetDialog.setCanceledOnTouchOutside(true);
        bottomSheetDialog.getBehavior().setPeekHeight(350);
        bottomSheetDialog.getBehavior().setState(BottomSheetBehaviorv2.STATE_COLLAPSED);


        RecyclerAdapter mAdapterLeft = new RecyclerAdapter();
        mBottomSheetRecyclerLeft.setAdapter(mAdapterLeft);
        mAdapterLeft.setOnClickInterface(new RecyclerAdapter.OnClickInterface() {
            @Override
            public void onClick(TempModel tempModel) {
                Toast.makeText(MainActivity.this, "Clicked ".concat(tempModel.getName()), Toast.LENGTH_SHORT).show();
                textView.setText(tempModel.getName());

            }
        });

        List<TempModel> modelsLeft = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            modelsLeft.add(new TempModel(i + " left"));
        }


        mAdapterLeft.update(modelsLeft);
        //helper to rule scrolls
        BottomSheetBehaviorRecyclerManager manager = new BottomSheetBehaviorRecyclerManager(mParent, bottomSheetDialog.getBehavior(), bottomSheetDialog.getBottomSheetView());
        manager.addControl(mBottomSheetRecyclerLeft);
        //manager.addControl(mBottomSheetRecyclerRight);
        manager.create();

    }

}
