package es.travelworld.travelling.view.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import es.travelworld.travelling.domain.User;

public class RegisterViewModel extends ViewModel {
    private final MutableLiveData<User> currentUSer = new MutableLiveData<>();

    public LiveData<User> getCurrentUser() {
        return currentUSer;
    }

    public void createUser(String name, String password) {
        User user = new User(name, password);
        currentUSer.setValue(user);
    }
}
