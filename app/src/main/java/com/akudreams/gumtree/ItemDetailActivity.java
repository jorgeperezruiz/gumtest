package com.akudreams.gumtree;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.akudreams.model.Item;
import com.melnykov.fab.FloatingActionButton;
import com.melnykov.fab.ObservableScrollView;
import com.novoda.notils.caster.Views;

public class ItemDetailActivity extends ActionBarActivity {

    public final static String ITEM_EXTRA = "ITEM_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ObservableScrollView scrollView = Views.findById(this, R.id.scroll_view);
        FloatingActionButton floatingActionButton = Views.findById(this, R.id.fabbutton);
        floatingActionButton.attachToScrollView(scrollView);
        floatingActionButton.setOnClickListener(onContactUser);

        setUpToolbar();
        setUpContent();
    }

    private void setUpContent() {
        Item item = (Item) getIntent().getExtras().get(ITEM_EXTRA);
        setTitle(item.getTitle());

        ViewPager imagesPager = Views.findById(this, R.id.images_pager);
        ImagesAdapter adapter = new ImagesAdapter(item.getImages(), getFragmentManager());
        imagesPager.setAdapter(adapter);

        TextView titleView = Views.findById(this, R.id.title);
        titleView.setText(item.getTitle());
        TextView descriptionView = Views.findById(this, R.id.description);
        descriptionView.setText(item.getDescription());
        TextView postedDateView = Views.findById(this, R.id.date_posted);
        postedDateView.setText(item.getDatePosted());
        TextView locationTextView = Views.findById(this, R.id.location);
        locationTextView.setText(item.getLocation());
        TextView userNameView = Views.findById(this, R.id.user_name);
        userNameView.setText(item.getOwner().getName());
        TextView userCreationDateView = Views.findById(this, R.id.user_creation_date);
        userCreationDateView.setText(item.getOwner().getAccountCreationDate());
    }

    private void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private final View.OnClickListener onContactUser = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            // TODO show fragment dialog so the user can contact with seller
        }
    };

}
