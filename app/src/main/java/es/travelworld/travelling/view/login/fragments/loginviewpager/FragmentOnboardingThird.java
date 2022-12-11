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

import es.travelworld.travelling.R;
import es.travelworld.travelling.databinding.FragmentOnboardingThirdBinding;

public class FragmentOnboardingThird extends Fragment {

    public FragmentOnboardingThird() {
    }

    public static FragmentOnboardingThird newInstance() {
        return new FragmentOnboardingThird();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentOnboardingThirdBinding binding = FragmentOnboardingThirdBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        binding.ob3LoginBtn.setOnClickListener(v -> Navigation.findNavController(requireView())
                .navigate(R.id.action_onBoardingFragment_to_loginFragment));
        return view;
    }

    @NonNull
    @Override
    public LayoutInflater onGetLayoutInflater(@Nullable Bundle savedInstanceState) {
        LayoutInflater inflater = super.onGetLayoutInflater(savedInstanceState);
        Context contextTheme = new ContextThemeWrapper(requireContext(), R.style.Theme_OnboardingActivity);
        return inflater.cloneInContext(contextTheme);
    }
}