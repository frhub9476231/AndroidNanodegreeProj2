package com.nanodegree.myproject1.popularmovieapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by frank on 10/27/15.
 */
public class CustomGridViewAdapter extends ArrayAdapter<GridItem> {

    Context context;

    public CustomGridViewAdapter(Context context, int resource, List<GridItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    private class ViewHolder {
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder vh = null;
        GridItem gridItem = getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.fragment_movie_grid_single, null);
            vh = new ViewHolder();
            vh.imageView = (ImageView) convertView.findViewById(R.id.singleImageId);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        if (null != gridItem.getImageUrl()) {
            Picasso.with(context).load(Constants.BASE_IMAGE_URL + gridItem.getImageUrl()).into(vh.imageView);
        } else {
            // https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/300px-No_image_available.svg.png
            Picasso.with(context).load(R.drawable.noimage300px).into(vh.imageView);
        }

        return convertView;
    }
}
