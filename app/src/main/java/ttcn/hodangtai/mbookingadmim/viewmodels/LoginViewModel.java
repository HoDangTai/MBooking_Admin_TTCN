package ttcn.hodangtai.mbookingadmim.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
public class LoginViewModel extends  ViewModel{
    private final MutableLiveData<String> selectedLanguage = new MutableLiveData<>("English");

    public LiveData<String> getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String language) {
        selectedLanguage.setValue(language);
    }
}
