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

    public HotelsAdapter(List<Hotels> hotels) {
        hotelsList = hotels;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemHotelsBinding binding = ItemHotelsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HotelsViewHolder(binding);
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
