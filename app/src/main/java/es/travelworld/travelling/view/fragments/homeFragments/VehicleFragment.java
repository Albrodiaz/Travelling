package es.travelworld.travelling.view.fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentHome1Binding;
import es.travelworld.travelling.view.recyclerhome.VehicleAdapter;
import es.travelworld.travelling.view.viewmodels.VehicleViewModel;

public class VehicleFragment extends Fragment {

    FragmentHome1Binding binding;
    private VehicleViewModel vehicleViewModel;

    public VehicleFragment() {
    }

    public static VehicleFragment newInstance() {
        return new VehicleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentHome1Binding.bind(view);
        vehicleViewModel = new ViewModelProvider(requireActivity()).get(VehicleViewModel.class);
        vehicleViewModel.loadVehicles();
        initRecyclerVehicles();
    }

    private void initRecyclerVehicles() {
        binding.rvTransport.setHasFixedSize(true);
        binding.rvTransport.setLayoutManager(new LinearLayoutManager(requireContext()));
        vehicleViewModel.getVehicles().observe(getViewLifecycleOwner(), vehicles -> binding.rvTransport.setAdapter(new VehicleAdapter(vehicles)));
    }
}