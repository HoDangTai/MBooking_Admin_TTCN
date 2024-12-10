package ttcn.hodangtai.mbookingadmim;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.Map;

import ttcn.hodangtai.mbookingadmim.viewmodels.LoginViewModel;

import ttcn.hodangtai.mbookingadmim.viewmodels.MovieViewModel;

import ttcn.hodangtai.mbookingadmim.viewmodels.MainViewModel;
import ttcn.hodangtai.mbookingadmim.Session.SessionManager;



public class LoginActivity extends AppCompatActivity{
    private LoginViewModel viewModel;
    private SessionManager sessionManager;
    private void switchToMainView(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        sessionManager = new SessionManager(this);

        // Kiểm tra xem người dùng đã đăng nhập hay chưa
        // Nếu đã đăng nhập thì chuyển qua mainactivity
        if(sessionManager.isLoggedIn()){
            switchToMainView();
        }

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

            if (usernameEditText.getVisibility() != View.VISIBLE || passwordEditText.getVisibility() != View.VISIBLE) {
                // Nếu chưa hiển thị, đặt EditText thành VISIBLE
                usernameEditText.setVisibility(View.VISIBLE);
                passwordEditText.setVisibility(View.VISIBLE);
            } else {
                // Nếu đã hiển thị, lấy dữ liệu từ EditText
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Vui lòng nhập tài khoản và mật khẩu!", Toast.LENGTH_SHORT).show();
                } else {
                    sessionManager.createLoginSession(username, "");
                    // Gọi phương thức chuyển sang MainActivity
                    switchToMainView();
                }

            }
        });

    }

}
