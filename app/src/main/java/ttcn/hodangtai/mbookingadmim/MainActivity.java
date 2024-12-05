package ttcn.hodangtai.mbookingadmim;

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

import ttcn.hodangtai.mbookingadmim.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Setup UI
        Button languageButton = findViewById(R.id.languageButton);
        Button signInButton = findViewById(R.id.signInButton);

        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        // Observe language changes
        viewModel.getSelectedLanguage().observe(this, language -> {
            languageButton.setText("🌐 " + language);
        });

        // Language button click
        languageButton.setOnClickListener(v -> {
            if (viewModel.getSelectedLanguage().getValue().equals("English")) {
                viewModel.setSelectedLanguage("Vietnamese");
            } else {
                viewModel.setSelectedLanguage("English");
            }
        });

        // Handle button actions
        signInButton.setOnClickListener(v -> {
            // Navigate to sign-in screen
        });
    }
}