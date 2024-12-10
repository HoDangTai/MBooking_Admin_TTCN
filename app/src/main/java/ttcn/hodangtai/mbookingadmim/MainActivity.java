package ttcn.hodangtai.mbookingadmim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import ttcn.hodangtai.mbookingadmim.Session.SessionManager;
import ttcn.hodangtai.mbookingadmim.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sessionManager = new SessionManager(this);
        if(!sessionManager.isLoggedIn()){
            switchToLoginView();
        }
    }

    private void switchToLoginView(){
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
//    public void logOut(View v){
//        sessionManager.logoutUser();
//        switchToLoginView();
//    }
}