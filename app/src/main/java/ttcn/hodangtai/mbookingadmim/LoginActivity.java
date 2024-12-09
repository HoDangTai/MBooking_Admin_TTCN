package ttcn.hodangtai.mbookingadmim;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import ttcn.hodangtai.mbookingadmim.viewmodels.LoginViewModel;
import ttcn.hodangtai.mbookingadmim.viewmodels.MainViewModel;


public class LoginActivity extends AppCompatActivity{
    private LoginViewModel viewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        // Khởi tạo ViewModel
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Setup UI
        Button languageButton = findViewById(R.id.languageButton);
        Button signInButton = findViewById(R.id.signInButton);
        EditText usernameEditText = findViewById(R.id.username);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
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
            // Hiển thị EditText khi bấm vào nút Sign In
            usernameEditText.setVisibility(View.VISIBLE);
            passwordEditText.setVisibility(View.VISIBLE);
        });

    }



}
