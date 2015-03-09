package com.akudreams.gumtree;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.akudreams.model.Item;

public class ItemDetailActivity extends ActionBarActivity {

    public final static String ITEM_EXTRA = "ITEM_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new ItemDetailFragment()).commit();
        }
        Item item = (Item) getIntent().getExtras().get(ITEM_EXTRA);

        setTitle(item.getTitle());
    }

}
