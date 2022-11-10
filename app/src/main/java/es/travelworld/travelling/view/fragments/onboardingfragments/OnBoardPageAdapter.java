package es.travelworld.travelling.view.fragments.onboardingfragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.travelworld.travelling.view.OnBoardActivity;

public class OnBoardPageAdapter extends FragmentStateAdapter {

    public OnBoardPageAdapter(@NonNull OnBoardActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = FragmentOnboardingFirst.newInstance();
                break;
            case 1:
                fragment = FragmentOnboardingSecond.newInstance();
                break;
            case 2:
                fragment = FragmentOnboardingThird.newInstance();
                break;
            default:
                throw new IllegalStateException("Valor no encontrado: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}