package es.travelworld.travelling.view.fragments.homeFragments.homeviewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.travelling.R;

public class HomeFragment3 extends Fragment {

    public HomeFragment3() { }

    public static HomeFragment3 newInstance() {
        return new HomeFragment3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home3, container, false);
    }
}