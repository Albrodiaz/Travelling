package es.travelworld.travelling.view.home.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.nio.charset.StandardCharsets;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentMapBinding;
import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.HotelsRespository;
import es.travelworld.travelling.view.home.viewmodels.HotelsViewModel;

public class MapFragment extends Fragment implements OnMapReadyCallback {

    private FragmentMapBinding binding;
    private HotelsViewModel hotelViewModel;

    public MapFragment() {

    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater, container, false);
        listeners();
        initMap();

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hotelViewModel = new ViewModelProvider(requireActivity(), (ViewModelProvider.Factory) new HotelsViewModel.Factory(new HotelsRespository())).get(HotelsViewModel.class);
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
    public void onMapReady(@NonNull GoogleMap googleMap) {
        Hotels hotelSelected = hotelViewModel.getHotelSelected().getValue();
        if (hotelSelected != null) {
            LatLng localizacion = new LatLng((Double) hotelSelected.getLatitude(), (Double) hotelSelected.getLongitude());
            googleMap.addMarker(new MarkerOptions()
                    .position(localizacion)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                    .title(hotelSelected.getHotelName())
                    .snippet(hotelSelected.getAddress()));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(localizacion, 18), 2000, null);
        }
    }

    private GoogleMapOptions mapOptions() {
        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_NORMAL);
        options.rotateGesturesEnabled(true);
        options.zoomControlsEnabled(true);
        options.zoomGesturesEnabled(true);
        return options;
    }

    private void listeners() {
        binding.closeIcon.setOnClickListener(view -> Navigation.findNavController(binding.closeIcon).navigateUp());
    }
}