package es.travelworld.travelling.view.login.fragments.loginviewpager;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentOnboardingSecondBinding;

public class FragmentOnboardingSecond extends Fragment {

    private FragmentOnboardingSecondBinding binding;

    public FragmentOnboardingSecond() {
    }

    public static FragmentOnboardingSecond newInstance() {
        return new FragmentOnboardingSecond();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingSecondBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        listeners();
        return view;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_OnboardingActivity);
        return inflater.cloneInContext(contextTheme);
    }

    private void listeners() {

        binding.ob2NextBtn.setOnClickListener(v -> {
            ViewPager2 viewPager = requireActivity().findViewById(R.id.obViewPager);
            viewPager.setCurrentItem(2);
        });

        binding.ob2SktipBtn.setOnClickListener(v -> Navigation
                .findNavController(requireView())
                .navigate(R.id.action_onBoardingFragment_to_loginFragment));
    }
}