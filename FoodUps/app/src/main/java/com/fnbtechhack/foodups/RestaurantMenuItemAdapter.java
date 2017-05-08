package com.fnbtechhack.foodups;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RestaurantMenuItemAdapter
{
    private int mResource;
    public RestaurantItemAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<RestaurantItem> items)
    {
        super(context, resource, items);
        mResource = resource;
    }

    public static class ViewHolder
    {
        public final TextView name;
        public final ImageView image;
        public final TextView cuisine;

        public ViewHolder(View view)
        {
            name = (TextView) view.findViewById(R.id.restaurant_name_textview);
            image = (ImageView) view.findViewById(R.id.restaurant_image);
            cuisine = (TextView) view.findViewById(R.id.restaurant_cuisine_textview);
        }
    }

    @Override
    public View getView(int position, View convert, ViewGroup parent)
    {
        RestaurantItem item = getItem(position);

        RestaurantItemAdapter.ViewHolder view;
        if(convert == null)
        {
            convert = LayoutInflater.from(getContext()).inflate(mResource, parent, false);
            view = new RestaurantItemAdapter.ViewHolder(convert);
            convert.setTag(view);
        }
        else
        {
            view = (RestaurantItemAdapter.ViewHolder) convert.getTag();
        }

        view.name.setText(item.name);
        view.cuisine.setText(item.cuisine);
        view.image.setImageResource(item.image);

        return convert;
    }
}
