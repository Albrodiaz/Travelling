package es.travelworld.travelling.view.fragments.homeFragments;

import static es.travelworld.travelling.Constants.EURODISNEYWEB;
import static es.travelworld.travelling.Constants.ICONCAR;
import static es.travelworld.travelling.Constants.ICONCASTLE;
import static es.travelworld.travelling.Constants.TAG_HOMEFRAGMENT;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Objects;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentMainBinding;
import es.travelworld.travelling.view.fragments.homeFragments.homeviewpager.HomePageAdapter;
import es.travelworld.travelling.viewmodel.HomeViewModel;

public class MainFragment extends Fragment {

    private FragmentMainBinding binding;
    private HomeViewModel homeViewModel;

    public MainFragment() {

    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        setAdapter();
        listeners();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(requireActivity()).get(HomeViewModel.class);
        configToolbar();
    }

    private void listeners() {
        binding.homeToolbar.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case ICONCASTLE:
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(EURODISNEYWEB)));
                    break;
                case ICONCAR:
                    Navigation.findNavController(binding.homeToolbar)
                            .navigate(R.id.action_mainFragment_to_carFragment);
                    break;
            }
            return true;
        });
    }

    private void setAdapter() {
        HomePageAdapter pageAdapter = new HomePageAdapter(this);
        binding.homeViewPager.setAdapter(pageAdapter);
        binding.homeViewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        new TabLayoutMediator(binding.homeTabLayout, binding.homeViewPager, ((tab, position) -> {
            if (position == 0) {
                tab.setIcon(R.drawable.ic_baseline_camera_alt_24);
            }
            if (position == 1) {
                tab.setIcon(R.drawable.baseline_directions_car_filled_white_24dp);
            }
            if (position == 2) {
                tab.setIcon(R.drawable.ic_mountain_24);
            }
            if (position == 3) {
                tab.setIcon(R.drawable.baseline_face_black_24dp);
            }
        })).attach();
    }

    private void configToolbar() {
        homeViewModel.getCurrentFragment().observe(getViewLifecycleOwner(), fragment -> {
            if (Objects.equals(fragment.getTag(), TAG_HOMEFRAGMENT)) {
                setHomeMenu();
            } else {
                binding.homeToolbar.setTitle(R.string.vehicle_title);
                binding.homeToolbar.getMenu().clear();
            }
        });
    }

    private void setHomeMenu() {
        binding.homeToolbar.setTitle(R.string.home);
        binding.homeToolbar.getMenu().clear();
        binding.homeToolbar.inflateMenu(R.menu.home_menu);
    }
}