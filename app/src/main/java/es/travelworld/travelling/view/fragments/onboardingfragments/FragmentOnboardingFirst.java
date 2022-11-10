package es.travelworld.travelling.view.fragments.onboardingfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentOnboardingFirstBinding;

public class FragmentOnboardingFirst extends Fragment {

    FragmentOnboardingFirstBinding binding;

    public FragmentOnboardingFirst() { }

    public static FragmentOnboardingFirst newInstance() {
        return new FragmentOnboardingFirst();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingFirstBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.ob2NextBtn.setOnClickListener(v-> {
            ViewPager2 viewPager = requireActivity().findViewById(R.id.obViewPager);
            viewPager.setCurrentItem(1);
        });

        return view;
    }
}