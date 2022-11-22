package es.travelworld.travelling.view.fragments.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.travelworld.travelling.view.fragments.loginFragments.loginviewpager.FragmentOnboardingFirst;
import es.travelworld.travelling.view.fragments.loginFragments.loginviewpager.FragmentOnboardingSecond;
import es.travelworld.travelling.view.fragments.loginFragments.loginviewpager.FragmentOnboardingThird;

public class LoginPageAdapter extends FragmentStateAdapter {

    public LoginPageAdapter(@NonNull Fragment fragment) {
        super(fragment);
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
