package es.travelworld.travelling.view.home.viewmodels;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {
    private final MutableLiveData<Fragment> currentFragment = new MutableLiveData<>();

    public LiveData<Fragment> getCurrentFragment() {
        return currentFragment;
    }
    public void setCurrentFragment(Fragment fragment) {
        currentFragment.setValue(fragment);
    }
}
