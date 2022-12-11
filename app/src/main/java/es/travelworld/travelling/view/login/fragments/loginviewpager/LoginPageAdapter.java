package es.travelworld.travelling.view.login.fragments.loginviewpager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
