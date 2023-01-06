package es.travelworld.travelling.view.home.fragments.hotelsadapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import es.travelworld.travelling.databinding.ItemHotelsBinding;
import es.travelworld.travelling.domain.Hotels;

public class HotelsViewHolder extends RecyclerView.ViewHolder {

    private final ItemHotelsBinding binding;
    private final HotelsAdapter.OnHotelSelected listener;

    public HotelsViewHolder(@NonNull ItemHotelsBinding binding, HotelsAdapter.OnHotelSelected listener) {
        super(binding.getRoot());
        this.binding = binding;
        this.listener = listener;
    }

    public void render(Hotels hotel) {
        itemView.setOnClickListener(view -> listener.hotelSelected(hotel));
        binding.hotelName.setText(hotel.getHotelName());
        binding.hotelPrice.setText(hotel.getHotelPrice());
        binding.hotelLocality.setText(hotel.getLocality());
        binding.hotelAdress.setText(hotel.getAddress());
        binding.hotelRating.setText(hotel.getRating());
        Glide.with(binding.hotelImage.getContext()).load(hotel.getHotelPhoto()).into(binding.hotelImage);
    }
}
