package ttcn.hodangtai.mbookingadmim.viewmodels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import ttcn.hodangtai.mbookingadmim.data.entities.Movie;
import ttcn.hodangtai.mbookingadmim.data.repositories.MovieRepository;

public class MovieViewModel {
    private final MovieRepository repository;
    private final MutableLiveData<List<Movie>> movies;

    public MovieViewModel() {
        repository = new MovieRepository();
        movies = repository.getMovies();
    }

    public LiveData<List<Movie>> getMovies() {
        return movies;
    }

//    public int getNowShowingCount(List<Movie> movies) {
//        return (int) movies.stream().filter(movie -> movie.getStatus().equals("now_showing")).count();
//    }
//
//    public int getComingSoonCount(List<Movie> movies) {
//        return (int) movies.stream().filter(movie -> movie.getStatus().equals("coming_soon")).count();
//    }
}
