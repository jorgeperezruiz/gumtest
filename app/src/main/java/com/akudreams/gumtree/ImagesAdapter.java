package com.akudreams.gumtree;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

import com.akudreams.model.ItemImage;

import java.util.List;

public class ImagesAdapter extends FragmentPagerAdapter {

    private List<ItemImage> images;

    public ImagesAdapter(List<ItemImage> images, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Fragment getItem(int position) {
        ItemImage image = images.get(position);
        return ItemImageFragment.newInstance(image);
    }

}
