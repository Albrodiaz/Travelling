package es.travelworld.travelling.view.login.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.travelworld.travelling.databinding.FragmentOnBoardingBinding;
import es.travelworld.travelling.view.login.fragments.loginviewpager.LoginPageAdapter;

public class OnBoardingFragment extends Fragment {

    private FragmentOnBoardingBinding binding;

    public OnBoardingFragment() {
    }

    public static OnBoardingFragment newInstance() {
        return new OnBoardingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        transpartentStatusBar();
        setAdapter();
        return view;
    }

    private void setAdapter() {
        LoginPageAdapter pageAdapter = new LoginPageAdapter(this);
        binding.obViewPager.setAdapter(pageAdapter);
    }

    private void transpartentStatusBar() {
        requireActivity().getWindow()
                .setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }
}