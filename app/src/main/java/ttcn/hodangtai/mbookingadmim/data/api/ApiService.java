package ttcn.hodangtai.mbookingadmim.data.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

import java.util.Map;

public interface ApiService {
    @Headers({
            "x-rapidapi-host: tmdb-movies-and-tv-shows-api-by-apirobots.p.rapidapi.com",
            "x-rapidapi-key: 3e0c4bdb77msh32f4facb5cc5487p1bce8ejsn6515536f79c3"
    })
    @GET("/v1/tmdb")
    Call<Map<String, Object>> searchMovies(
            @Query("name") String name,
            @Query("page") int page
    );
}
