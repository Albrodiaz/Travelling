package es.travelworld.travelling.view.fragments.homeFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.travelling.R;

public class HomeFragment1 extends Fragment {

    public HomeFragment1() { }

    public static HomeFragment1 newInstance() {
        return new HomeFragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home1, container, false);
    }
}