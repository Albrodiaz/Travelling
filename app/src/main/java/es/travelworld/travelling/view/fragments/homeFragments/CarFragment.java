package es.travelworld.travelling.view.fragments.homeFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import es.travelworld.travelling.databinding.FragmentCarBinding;

public class CarFragment extends Fragment {

    public CarFragment() {
    }

    public static CarFragment newInstance() {
        return new CarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentCarBinding binding = FragmentCarBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();

        binding.closeFragment.setOnClickListener(v -> Navigation.findNavController(requireView())
                .navigateUp());

        return view;

    }
}