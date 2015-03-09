package com.akudreams.gumtree;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.akudreams.model.ItemImage;
import com.novoda.notils.caster.Views;
import com.squareup.picasso.Picasso;

public class ItemImageFragment extends Fragment {

    public final static String ITEM_IMAGE = "ITEM_IMAGE";

    public static ItemImageFragment newInstance(ItemImage image) {
        ItemImageFragment fragment = new ItemImageFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ITEM_IMAGE, image);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ImageView imageView = Views.findById(view, R.id.item_image);
        ItemImage itemImage = (ItemImage) getArguments().getSerializable(ITEM_IMAGE);
        Picasso.with(getActivity()).load(itemImage.getUrl()).into(imageView);
    }


}
