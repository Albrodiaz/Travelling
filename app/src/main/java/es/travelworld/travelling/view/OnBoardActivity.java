package es.travelworld.travelling.view;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import es.travelworld.travelling.databinding.ActivityOnboardingBinding;
import es.travelworld.travelling.view.fragments.onboardingfragments.OnBoardPageAdapter;

public class OnBoardActivity extends AppCompatActivity {

    private ActivityOnboardingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnboardingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        transparentStatusBar();
        setAdapter();
    }

    private void transparentStatusBar() {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    private void setAdapter() {
        OnBoardPageAdapter pageAdapter = new OnBoardPageAdapter(this);
        binding.obViewPager.setAdapter(pageAdapter);
    }
}