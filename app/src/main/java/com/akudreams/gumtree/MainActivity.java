package com.akudreams.gumtree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

import com.novoda.notils.caster.Views;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button n64Button = Views.findById(this, R.id.nintendo_64_button);
        n64Button.setOnClickListener(n64Listener);

        Button gameboyButton = Views.findById(this, R.id.game_boy_button);
        gameboyButton.setOnClickListener(gameboyListener);
    }

    private final View.OnClickListener n64Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
            startActivity(intent);
        }
    };

    private final View.OnClickListener gameboyListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ItemDetailActivity.class);
            startActivity(intent);
        }
    };

}
