package es.travelworld.travelling.view.home.fragments.hotelsadapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.travelworld.travelling.databinding.ItemHotelsBinding;
import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.view.home.viewmodels.HotelsViewModel;

public class HotelsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Hotels> hotelsList;
    private final OnHotelSelected hotelListener;

    public interface OnHotelSelected{
        void hotelSelected(Hotels hotel);
    }

    public HotelsAdapter(List<Hotels> hotels, OnHotelSelected hotelListener) {
        hotelsList = hotels;
        this.hotelListener = hotelListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHotelsBinding binding = ItemHotelsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HotelsViewHolder(binding, hotelListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotelsViewHolder) {
            ((HotelsViewHolder) holder).render(hotelsList.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return hotelsList.size();
    }
}
