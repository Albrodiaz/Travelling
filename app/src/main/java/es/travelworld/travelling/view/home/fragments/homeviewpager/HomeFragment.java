package es.travelworld.travelling.view.home.fragments.homeviewpager;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import java.util.List;

import es.travelworld.travelling.R;
import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.HotelsRespository;
import es.travelworld.travelling.view.home.viewmodels.HomeViewModel;
import es.travelworld.travelling.view.home.viewmodels.HotelsViewModel;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private HotelsViewModel hotelViewModel;

    public HomeFragment() {}

    public static HomeFragment newInstance() {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModels();
        hotelViewModel.getHotelList().observe(getViewLifecycleOwner(), hotelsList -> {
            Log.e("HomeFragment", "Hoteles encontrados: " + hotelsList.size());
        });


    }

    @Override
    public void onResume() {
        super.onResume();
        homeViewModel.setCurrentFragment(this);
    }

    private void initViewModels() {
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        hotelViewModel = new ViewModelProvider((ViewModelStoreOwner) requireActivity(),
                (ViewModelProvider.Factory) new HotelsViewModel.Factory(new HotelsRespository())).get(HotelsViewModel.class);
        hotelViewModel.loadHotels();
    }
}