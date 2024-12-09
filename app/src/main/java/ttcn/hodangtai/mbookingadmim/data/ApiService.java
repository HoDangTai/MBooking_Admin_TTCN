package ttcn.hodangtai.mbookingadmim.data;
import retrofit2.Call;
import retrofit2.http.GET;
import ttcn.hodangtai.mbookingadmim.data.entities.Movie;

import java.util.List;

public interface ApiService {
    @GET("/api/movies")
    Call<List<Movie>> getMovies();
}
