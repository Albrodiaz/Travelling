package es.travelworld.travelling.view.recyclerhome;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.travelworld.travelling.databinding.ItemTransportBinding;
import es.travelworld.travelling.domain.Vehicle;

public class VehicleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Vehicle> vehicles;

    public VehicleAdapter(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTransportBinding binding = ItemTransportBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new VehicleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VehicleViewHolder) {
            ((VehicleViewHolder) holder).render(vehicles.get(position));
        }
    }


    @Override
    public int getItemCount() {
        return vehicles.size();
    }
}
