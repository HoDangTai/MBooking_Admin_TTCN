package ttcn.hodangtai.mbookingadmim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import ttcn.hodangtai.mbookingadmim.databinding.ActivityMainBinding;
import ttcn.hodangtai.mbookingadmim.fragments.DashBoardFragment;
import ttcn.hodangtai.mbookingadmim.fragments.MoviemanageFragment;
import ttcn.hodangtai.mbookingadmim.fragments.ScheduleFragment;
import ttcn.hodangtai.mbookingadmim.fragments.TheaterFragment;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replacedFragment(new DashBoardFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.dashboard:
                    replacedFragment(new DashBoardFragment());
                    break;
                case R.id.schedule:
                    replacedFragment(new ScheduleFragment());
                    break;
                case R.id.movies:
                    replacedFragment(new MoviemanageFragment());
                    break;
                case R.id.theaters:
                    replacedFragment(new TheaterFragment());
                    break;
            }
            return true;
        });

    }
    private void  replacedFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}