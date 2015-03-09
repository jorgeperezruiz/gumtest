package com.akudreams.gumtree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.akudreams.gumtree.io.DataService;
import com.akudreams.model.Item;
import com.novoda.notils.caster.Views;

import java.util.List;

public class MainActivity extends ActionBarActivity {

    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Load in background
        items = DataService.newInstance(this).retrieveResponse();

        Button n64Button = Views.findById(this, R.id.item_2_button);
        n64Button.setOnClickListener(n64Listener);

        Button gameboyButton = Views.findById(this, R.id.item_1_button);
        gameboyButton.setOnClickListener(gameboyListener);
    }

    private final View.OnClickListener n64Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
            intent.putExtra(ItemDetailActivity.ITEM_EXTRA, items.get(0));
            startActivity(intent);
        }
    };

    private final View.OnClickListener gameboyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
            intent.putExtra(ItemDetailActivity.ITEM_EXTRA, items.get(1));
            startActivity(intent);
        }
    };

}
