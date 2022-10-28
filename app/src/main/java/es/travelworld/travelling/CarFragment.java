package es.travelworld.travelling;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import es.travelworld.travelling.databinding.FragmentCarBinding;

public class CarFragment extends Fragment {

    private FragmentCarBinding binding;

    public CarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCarBinding.inflate(getLayoutInflater(), container, false);
        View view = binding.getRoot();


        binding.closeFragment.setOnClickListener(v -> startActivity(new Intent(getActivity(), HomeActivity.class)));


        return view;

    }
}