package com.akudreams.gumtree;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

import com.akudreams.model.Item;
import com.novoda.notils.caster.Views;

public class ItemDetailActivity extends ActionBarActivity {

    public final static String ITEM_EXTRA = "ITEM_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Item item = (Item) getIntent().getExtras().get(ITEM_EXTRA);
        setTitle(item.getTitle());

        ViewPager imagesPager = Views.findById(this, R.id.images_pager);
        ImagesAdapter adapter = new ImagesAdapter(item.getImages(), getFragmentManager());
        imagesPager.setAdapter(adapter);
    }

}
