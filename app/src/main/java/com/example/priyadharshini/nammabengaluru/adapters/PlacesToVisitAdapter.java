package com.example.priyadharshini.nammabengaluru.adapters;

import android.graphics.drawable.Drawable;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.priyadharshini.nammabengaluru.R;
import com.example.priyadharshini.nammabengaluru.models.PlaceInfo;

import java.util.List;

/**
 * Created by priya.dharshini on 28/05/16.
 */
public class PlacesToVisitAdapter extends RecyclerView.Adapter<PlacesToVisitAdapter.ViewHolder>{
    private final List<PlaceInfo> places;

    public PlacesToVisitAdapter(List<PlaceInfo> places) {
        this.places = places;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.places_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TextView textViewPlaceName = (TextView) holder.itemView.findViewById(R.id.text);
        PlaceInfo contact = places.get(position);
        if (textViewPlaceName != null) {
            textViewPlaceName.setText(contact.name);
        }
        ImageView image = (ImageView) holder.itemView.findViewById(R.id.image);
        int imageResource = holder.itemView.getResources().getIdentifier(contact.imageSource, null, holder.itemView.getContext().getPackageName());
        Drawable res = holder.itemView.getResources().getDrawable(imageResource);
        image.setImageDrawable(res);

        Button button = (Button) holder.itemView.findViewById(R.id.locate_btn);
        button.setTag(R.string.latitude, contact.latitude);
        button.setTag(R.string.longitude, contact.longitude);
        button.setTag(R.string.location, contact.name);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
