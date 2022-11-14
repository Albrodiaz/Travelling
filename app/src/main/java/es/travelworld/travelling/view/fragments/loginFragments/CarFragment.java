package es.travelworld.travelling.view.fragments.loginFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.travelworld.travelling.databinding.FragmentCarBinding;

public class CarFragment extends Fragment {

    private FragmentCarBinding binding;

    public CarFragment() { }

    public static CarFragment newInstance() {
        return new CarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCarBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();

        binding.closeFragment.setOnClickListener(v-> getParentFragmentManager().popBackStack());

        return view;

    }
}