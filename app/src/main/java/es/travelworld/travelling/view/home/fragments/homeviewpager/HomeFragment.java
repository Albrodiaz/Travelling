package es.travelworld.travelling.view.home.fragments.homeviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentHomeBinding;
import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.HotelsRespository;
import es.travelworld.travelling.view.home.fragments.hotelsadapter.HotelsAdapter;
import es.travelworld.travelling.view.home.viewmodels.HomeViewModel;
import es.travelworld.travelling.view.home.viewmodels.HotelsViewModel;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private HotelsViewModel hotelViewModel;

    public HomeFragment() {}

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModels();
        observers();
        initMap();
    }

    private void initMap() {
        SupportMapFragment mapFragment = SupportMapFragment.newInstance(mapOptions());
        getParentFragmentManager()
                .beginTransaction()
                .add(R.id.map, mapFragment)
                .commit();
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        homeViewModel.setCurrentFragment(this);
    }

    private void observers() {
        hotelViewModel.getHotelList().observe(getViewLifecycleOwner(), hotelsList -> initHotelsRecycler(hotelsList));
    }

    private void initViewModels() {
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        hotelViewModel = new ViewModelProvider(requireActivity(),
                (ViewModelProvider.Factory) new HotelsViewModel.Factory(new HotelsRespository())).get(HotelsViewModel.class);
        hotelViewModel.loadHotels();
    }

    private void initHotelsRecycler(List<Hotels> list) {
        binding.hotelsRecyclerView.setHasFixedSize(true);
        binding.hotelsRecyclerView.setAdapter(new HotelsAdapter(list));
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng localizacion = new LatLng(37.21, -7.4043);
        googleMap.addMarker(new MarkerOptions()
                .position(localizacion)
                .title("Posición aleatoria")
                .snippet("Eooooo"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(localizacion));
    }

    private GoogleMapOptions mapOptions() {
        GoogleMapOptions options = new GoogleMapOptions();
        options.zoomControlsEnabled(true);
        options.zoomGesturesEnabled(true);
        options.minZoomPreference(14);
        return options;
    }
}
















