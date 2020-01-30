package mohan.com.multiandsingleselectionrecyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectableViewHolder.OnItemSelectedListener {

    RecyclerView recyclerView;
    SelectableAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = this.findViewById(R.id.selection_list);
        recyclerView.setLayoutManager(layoutManager);
        List<Item> selectableItems = generateItems();
        adapter = new SelectableAdapter(this,selectableItems,false);
        recyclerView.setAdapter(adapter);
    }

    public List<Item> generateItems(){

        List<Item> selectableItems = new ArrayList<>();
        selectableItems.add(new Item("cem","karaca"));
        selectableItems.add(new Item("sezen","aksu"));
        for(int i=1;i<=50;i++){
            selectableItems.add(new Item(i+" baris","manco"));
        }


        return selectableItems;
    }

    @Override
    public void onItemSelected(SelectableItem selectableItem) {

        List<Item> selectedItems = adapter.getSelectedItems();
        /*Snackbar.make(recyclerView,"Selected item is "+selectableItem.getName()+
                ", Totally  selectem item count is "+selectedItems.size(),Snackbar.LENGTH_LONG).show();*/
        Toast.makeText(MainActivity.this,""+selectableItem.getName()+""+selectedItems.size(),Toast.LENGTH_SHORT).show();
    }
}
