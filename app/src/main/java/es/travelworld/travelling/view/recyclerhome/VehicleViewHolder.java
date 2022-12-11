package es.travelworld.travelling.view.recyclerhome;

import android.graphics.drawable.Drawable;
import android.widget.Toast;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;

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
        setCarTitle(vehicle.getType(), vehicle);
        binding.transportPrice.setText(itemView.getContext().getString(R.string.price, vehicle.getPrice()));
        binding.transportImage.setImageDrawable(ContextCompat.getDrawable(itemView.getContext(), vehicle.getImage()));
        setItemBackground(vehicle.getColor());
        binding.vehicleContainer.setOnClickListener(v -> showToast(vehicle));
    }

    private void setItemBackground(@ColorRes int color) {
        Drawable itemBackground = binding.itemBackground.getBackground();
        itemBackground.setTint(ContextCompat.getColor(itemView.getContext(), color));
    }

    private void showToast(Vehicle vehicle) {
        Toast.makeText(binding.vehicleContainer.getContext(),
                itemView.getContext().getString(R.string.transport, vehicle.getType()),
                Toast.LENGTH_SHORT).show();
    }

    private void setCarTitle(String text, Vehicle vehicle) {
        if (Objects.equals(text, "Classic") || Objects.equals(text, "Sport")
                || Objects.equals(text, "Flying") || Objects.equals(text, "Electric")) {
            binding.transportTitle.setText(itemView.getContext().getString(R.string.typeCar, vehicle.getType()));
        } else {
            binding.transportTitle.setText(vehicle.getType());
        }
    }
}
