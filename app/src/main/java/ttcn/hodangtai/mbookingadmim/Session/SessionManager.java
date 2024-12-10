package ttcn.hodangtai.mbookingadmim.Session;
import android.content.Context;
import android.content.SharedPreferences;
public class SessionManager {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    // Shared Preferences file name
    private static final String PREF_NAME = "UserSession";
    private static final String IS_LOGGED_IN = "IsLoggedIn";

    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";

    // Constructor
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    // Create a session
    public void createLoginSession(String username, String email) {
        editor.putBoolean(IS_LOGGED_IN, true);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.apply(); // Save changes
    }

    // Check if the user is logged in
    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false);
    }

    // Get user details
    public String getUsername() {
        return sharedPreferences.getString(KEY_USERNAME, null);
    }

    public String getEmail() {
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    // Logout user
    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}
