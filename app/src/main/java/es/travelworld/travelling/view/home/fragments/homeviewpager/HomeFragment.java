package es.travelworld.travelling.view.home.fragments.homeviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import java.util.List;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentHomeBinding;
import es.travelworld.travelling.domain.Hotels;
import es.travelworld.travelling.repository.HotelsRespository;
import es.travelworld.travelling.view.home.fragments.hotelsadapter.HotelsAdapter;
import es.travelworld.travelling.view.home.viewmodels.HomeViewModel;
import es.travelworld.travelling.view.home.viewmodels.HotelsViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    private HotelsViewModel hotelViewModel;

    public HomeFragment() {
    }

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
    }

    @Override
    public void onResume() {
        super.onResume();
        homeViewModel.setCurrentFragment(this);
    }

    private void observers() {
        hotelViewModel.getHotelList().observe(getViewLifecycleOwner(), this::initHotelsRecycler);
    }

    private void initViewModels() {
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        hotelViewModel = new ViewModelProvider(requireActivity(), (ViewModelProvider.Factory) new HotelsViewModel.Factory(new HotelsRespository())).get(HotelsViewModel.class);
        hotelViewModel.loadHotels();
    }

    private void initHotelsRecycler(List<Hotels> list) {
        HotelsAdapter adapter = new HotelsAdapter(list, hotel -> {
            hotelViewModel.setHotelSelected(hotel);
            Navigation.findNavController(requireView()).navigate(R.id.action_mainFragment_to_mapFragment);
        });
        binding.hotelsRecyclerView.setHasFixedSize(true);
        binding.hotelsRecyclerView.setAdapter(adapter);
    }
}
















