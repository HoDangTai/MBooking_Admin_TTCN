package ttcn.hodangtai.mbookingadmim.data.repositories;
import androidx.lifecycle.MutableLiveData;
import ttcn.hodangtai.mbookingadmim.data.api.ApiService;
import ttcn.hodangtai.mbookingadmim.data.api.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Map;

public class MovieRepository {
    private final ApiService apiService;

    public MovieRepository() {
        apiService = RetrofitClient.getInstance().create(ApiService.class);
    }

    public MutableLiveData<Map<String, Object>> searchMovies(String name, int page) {
        MutableLiveData<Map<String, Object>> movieData = new MutableLiveData<>();
        apiService.searchMovies(name, page).enqueue(new Callback<Map<String, Object>>() {
            @Override
            public void onResponse(Call<Map<String, Object>> call, Response<Map<String, Object>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    movieData.setValue(response.body());
                } else {
                    movieData.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<Map<String, Object>> call, Throwable t) {
                movieData.setValue(null);
            }
        });
        return movieData;
    }
}
