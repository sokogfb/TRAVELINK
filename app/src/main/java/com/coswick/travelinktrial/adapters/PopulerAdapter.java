package com.coswick.travelinktrial.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.coswick.travelinktrial.DetailWIsata;
import com.coswick.travelinktrial.model.PopulerModel;
import com.coswick.travelinktrial.R;
import com.coswick.travelinktrial.FormPembelian;

import java.util.List;

public class PopulerAdapter extends PagerAdapter{

    private List<PopulerModel> populerModels;
    private LayoutInflater layoutInflater;
    private Context context;

    public PopulerAdapter(Context context, List<PopulerModel> populerModels) {
        this.populerModels = populerModels;
        this.context = context;
    }


    @Override
    public int getCount() {
        return populerModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_wisata_populer, container, false);

        ImageView imageView;
        TextView title, desc, harga, kategori;

        imageView = view.findViewById(R.id.image);
        title = view.findViewById(R.id.nama);
        desc = view.findViewById(R.id.desc);
        harga = view.findViewById(R.id.harga);
        kategori =view.findViewById(R.id.kategori);

        imageView.setImageResource(populerModels.get(position).getImage());
        title.setText(populerModels.get(position).getTitle());
        kategori.setText(populerModels.get(position).getKategori());
        desc.setText(populerModels.get(position).getDesc());
        harga.setText(populerModels.get(position).getHarga());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailWIsata.class);
                intent.putExtra("img", populerModels.get(position).getImage());
                intent.putExtra("title", populerModels.get(position).getTitle());
                intent.putExtra("kat", populerModels.get(position).getKategori());
                intent.putExtra("desc", populerModels.get(position).getDesc());
                intent.putExtra("harga", populerModels.get(position).getHarga());
                context.startActivity(intent);
                // finish();
            }
        });

        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}