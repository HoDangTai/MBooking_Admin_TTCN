package ttcn.hodangtai.mbookingadmim.data.api;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import ttcn.hodangtai.mbookingadmim.data.entities.Movie;

import java.util.Map;

public interface ApiService {
    @Headers({
            "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjNDQyODFkMTA2ZTMyMzEwMTBkYjRlNzc3ZWQ5OTdlOSIsIm5iZiI6MTczMzI3NjI3NS41NDIsInN1YiI6IjY3NGZiMjczNDNhNmFiZDA2YjZlYTQ4NCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.U7l7kOXrBCbiMRKR7QOuyHBF81JqpdGA-EqCZl70EFU",
            "xaccept: application/json"
    })
    @GET("/v1/tmdb")
    Call<Map<String, Object>> searchMovies(
            @Query("name") String name,
            @Query("page") int page
    );
    Call<Movie> getUpcomingMovies();

}
