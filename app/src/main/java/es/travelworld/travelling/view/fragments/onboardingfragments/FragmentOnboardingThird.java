package es.travelworld.travelling.view.fragments.onboardingfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import es.travelworld.travelling.databinding.FragmentOnboardingThirdBinding;
import es.travelworld.travelling.view.LoginActivity;

public class FragmentOnboardingThird extends Fragment {
    public static final String ARG_OBTHIRDFRAGM = "obThirdFragment";

    FragmentOnboardingThirdBinding binding;

    public FragmentOnboardingThird() { }

    public static FragmentOnboardingThird newInstance() {
        return new FragmentOnboardingThird();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.ob3LoginBtn.setOnClickListener(v-> {
            startActivity(new Intent(requireContext(), LoginActivity.class));
            requireActivity().finish();
        });

        return view;
    }
}