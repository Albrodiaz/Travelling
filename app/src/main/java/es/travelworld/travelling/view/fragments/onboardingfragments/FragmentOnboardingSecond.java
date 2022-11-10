package es.travelworld.travelling.view.fragments.onboardingfragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentOnboardingSecondBinding;
import es.travelworld.travelling.view.LoginActivity;

public class FragmentOnboardingSecond extends Fragment {

    FragmentOnboardingSecondBinding binding;

    public FragmentOnboardingSecond() { }

    public static FragmentOnboardingSecond newInstance() {
        return new FragmentOnboardingSecond();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingSecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        listeners();
        return view;
    }

    private void listeners() {
        binding.ob2SktipBtn.setOnClickListener(v -> {
            startActivity(new Intent(requireContext(), LoginActivity.class));
            requireActivity().finish();
        });

        binding.ob2NextBtn.setOnClickListener(v-> {
            ViewPager2 viewPager = requireActivity().findViewById(R.id.obViewPager);
            viewPager.setCurrentItem(2);
        });
    }
}