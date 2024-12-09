package ttcn.hodangtai.mbookingadmim.data.repositories;
import androidx.lifecycle.MutableLiveData;
import ttcn.hodangtai.mbookingadmim.data.ApiService;
import ttcn.hodangtai.mbookingadmim.data.entities.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import java.util.List;
public class MovieRepository {
    private static final String BASE_URL = "https://example.com";
    private ApiService apiService;

    public MovieRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public MutableLiveData<List<Movie>> getMovies() {
        MutableLiveData<List<Movie>> moviesData = new MutableLiveData<>();
        apiService.getMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response.isSuccessful()) {
                    moviesData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                moviesData.setValue(null);
            }
        });
        return moviesData;
    }
}
