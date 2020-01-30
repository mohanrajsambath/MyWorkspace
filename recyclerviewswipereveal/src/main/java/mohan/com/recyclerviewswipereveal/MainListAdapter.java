package mohan.com.recyclerviewswipereveal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.MotionEventCompat;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import mohan.com.utils.ItemTouchHelperAdapter;
import mohan.com.utils.ItemTouchHelperViewHolder;
import mohan.com.utils.OnMenuListChangedListener;
import mohan.com.utils.OnStartDragListener;

/**
 * Created by Mark O'Sullivan on 25th February 2018.
 */

public class MainListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements ItemTouchHelperAdapter {
    private Context mContext;
    private List<String> shoppingList;
    private OnStartDragListener mDragStartListener;
    private OnMenuListChangedListener mListChangedListener;

    public MainListAdapter(List<String> shoppingList,Context context,OnStartDragListener dragLlistener,
                           OnMenuListChangedListener listChangedListener) {
        this.mContext = context;
        this.shoppingList = shoppingList;
        this.mDragStartListener = dragLlistener;
        this.mListChangedListener = listChangedListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_main, parent, false);
        return new MainListItem(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MainListItem mainListItem = (MainListItem) holder;
        mainListItem.mealTV.setText(shoppingList.get(position));
        mainListItem.infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "INFO CLICKED", Toast.LENGTH_SHORT).show();
            }
        });
        mainListItem.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "EDIT CLICKED", Toast.LENGTH_SHORT).show();
            }
        });

        mainListItem.imgVw_HandleDrag.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEventCompat.getActionMasked(event) == MotionEvent.ACTION_DOWN) {
                    mDragStartListener.onStartDrag(holder);
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingList.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(shoppingList, fromPosition, toPosition);
        mListChangedListener.onNoteListChanged(shoppingList);
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public static class MainListItem extends RecyclerView.ViewHolder implements ItemTouchHelperViewHolder {

        protected TextView mealTV;
        protected ImageButton infoButton;
        protected ImageButton editButton;
        protected ImageView imgVw_HandleDrag;


        protected MainListItem(View itemView) {
            super(itemView);
            mealTV = itemView.findViewById(R.id.meal_tv);
            infoButton = itemView.findViewById(R.id.info_button);
            editButton= itemView.findViewById(R.id.edit_button);
            imgVw_HandleDrag= itemView.findViewById(R.id.imgVw_HandleDrag);
        }

        @SuppressLint("ResourceAsColor")
        @Override
        public void onItemSelected() {
            //itemView.setBackgroundColor(getResources().getColor(R.color.material_blue_100));
        }

        @Override
        public void onItemClear() {
            itemView.setBackgroundColor(0);
        }
    }
}
