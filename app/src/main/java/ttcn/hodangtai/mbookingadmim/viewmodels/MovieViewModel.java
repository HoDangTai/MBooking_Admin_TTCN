package ttcn.hodangtai.mbookingadmim.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.Map;

import ttcn.hodangtai.mbookingadmim.data.entities.Movie;
import ttcn.hodangtai.mbookingadmim.data.repositories.MovieRepository;

public class MovieViewModel extends  ViewModel{
    private final MovieRepository repository;

    public MovieViewModel() {
        repository = new MovieRepository();
    }

    public LiveData<Map<String, Object>> searchMovies(String name, int page) {
        return repository.searchMovies(name, page);
    }
}
