package mohan.com.recyclerviewswipereveal;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

import mohan.com.utils.OnMenuListChangedListener;
import mohan.com.utils.OnStartDragListener;
import mohan.com.utils.SimpleItemTouchHelperCallback;

public class MainActivity extends AppCompatActivity  implements OnMenuListChangedListener,OnStartDragListener {
    private ItemTouchHelper mItemTouchHelper;
    private OnStartDragListener mDragStartListener;
    private OnMenuListChangedListener mListChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        MainListAdapter mainListAdapter = new MainListAdapter(getMealList(),this,this,this);
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mainListAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        /*mRecyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(this)
                .colorResId(R.color.colorPrimaryDark)
                .size(2)
                .build());*/
        recyclerView.setAdapter(mainListAdapter);
    }

    public List<String> getMealList() {
        List<String> mealList = new ArrayList<>();
        mealList.add("Green Thai Curry");
        mealList.add("Granola");
        mealList.add("Poached Eggs");
        mealList.add("Spaghetti");
        mealList.add("Apple Pie");
        mealList.add("Grilled Cheese Sandwich");
        mealList.add("Vegetable Soup");
        mealList.add("Chicken Noodles");
        mealList.add("Fajitas");
        mealList.add("Chicken Pot Pie");
        mealList.add("Pasta and cauliflower casserole with chicken");
        mealList.add("Vegetable stir-fry");
        mealList.add("Sweet potato and orange soup");
        mealList.add("Vegetable Broth");
        return mealList;
    }

    @Override
    public void onNoteListChanged(List<String> foodMenus) {
       /* List<String> resultFoodMenu=new ArrayList<String>();
        resultFoodMenu=foodMenus;
        for(int i=0;resultFoodMenu.size()>0;i++){
            System.out.println("Position"+resultFoodMenu.get(i));
        }*/
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}
