package es.travelworld.travelling.view.viewmodels;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {

    private final MutableLiveData<Fragment> fragmentSelected = new MutableLiveData<>();

    public LiveData<Fragment> getFragmentSelected() {
        return fragmentSelected;
    }

    public void setFragmentSelected(Fragment fragment) {
        fragmentSelected.setValue(fragment);
    }
}
