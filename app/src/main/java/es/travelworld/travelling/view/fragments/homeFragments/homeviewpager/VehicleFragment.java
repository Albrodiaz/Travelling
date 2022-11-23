package es.travelworld.travelling.view.fragments.homeFragments.homeviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentVehicleBinding;
import es.travelworld.travelling.view.recyclerhome.VehicleAdapter;
import es.travelworld.travelling.view.viewmodels.HomeViewModel;
import es.travelworld.travelling.view.viewmodels.VehicleViewModel;

public class VehicleFragment extends Fragment {

    private FragmentVehicleBinding binding;
    private VehicleViewModel vehicleViewModel;
    private HomeViewModel homeViewModel;

    public VehicleFragment() {
    }

    public static VehicleFragment newInstance() {
        return new VehicleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vehicle, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentVehicleBinding.bind(view);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        vehicleViewModel = new ViewModelProvider((ViewModelStoreOwner) getViewLifecycleOwner(), new VehicleViewModel.Factory()).get(VehicleViewModel.class);
        vehicleViewModel.loadVehicles();
        initRecyclerVehicles();
    }

    @Override
    public void onResume() {
        super.onResume();
        homeViewModel.setCurrentFragment(this);
    }

    private void initRecyclerVehicles() {
        binding.rvTransport.setHasFixedSize(true);
        binding.rvTransport.setLayoutManager(new LinearLayoutManager(requireContext()));
        vehicleViewModel.getVehicles().observe(getViewLifecycleOwner(),
                vehicles -> binding.rvTransport.setAdapter(new VehicleAdapter(vehicles)));
    }
}