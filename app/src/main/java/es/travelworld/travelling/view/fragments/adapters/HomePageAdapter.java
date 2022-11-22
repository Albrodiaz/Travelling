package es.travelworld.travelling.view.fragments.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import es.travelworld.travelling.view.fragments.homeFragments.homeviewpager.HomeFragment;
import es.travelworld.travelling.view.fragments.homeFragments.homeviewpager.HomeFragment2;
import es.travelworld.travelling.view.fragments.homeFragments.homeviewpager.HomeFragment3;
import es.travelworld.travelling.view.fragments.homeFragments.homeviewpager.VehicleFragment;

public class HomePageAdapter extends FragmentStateAdapter {
    public HomePageAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = HomeFragment.newInstance();
                break;
            case 1:
                fragment = VehicleFragment.newInstance();
                break;
            case 2:
                fragment = HomeFragment2.newInstance();
                break;
            case 3:
                fragment = HomeFragment3.newInstance();
                break;
            default:
                throw new IllegalStateException("Valor no encontrado: " + position);
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
