package es.travelworld.travelling.view.recyclerhome;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.ItemTransportBinding;
import es.travelworld.travelling.domain.Vehicle;

public class VehicleViewHolder extends RecyclerView.ViewHolder {
    private final ItemTransportBinding binding;

    public VehicleViewHolder(@NonNull ItemTransportBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void render(Vehicle vehicle) {
        binding.transportTitle.setText(vehicle.getType());
        binding.transportPrice.setText(itemView.getContext().getString(R.string.price, vehicle.getPrice()));
        binding.transportImage.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), vehicle.getImage()));
        createTint(vehicle.getColor());
        binding.vehicleContainer.setOnClickListener(v -> Toast.makeText(binding.vehicleContainer.getContext(), vehicle.getType(), Toast.LENGTH_SHORT).show());
    }

    private void createTint(@ColorRes int color) {
        Drawable tintDrawable = binding.itemBackground.getBackground();
        tintDrawable = DrawableCompat.wrap(tintDrawable);
        DrawableCompat.setTint(tintDrawable, ContextCompat.getColor(itemView.getContext(), color));
    }
}
