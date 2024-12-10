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
import androidx.lifecycle.ViewModelProvider;

import ttcn.hodangtai.mbookingadmim.viewmodels.LoginViewModel;
import ttcn.hodangtai.mbookingadmim.viewmodels.MainViewModel;


public class LoginActivity extends AppCompatActivity{
    private LoginViewModel viewModel;

    private void switchToMainView(String username){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);

        // Truyền thêm dữ liệu nếu cần (ví dụ: username)
        intent.putExtra("USERNAME", username);

        startActivity(intent);

        finish();
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        // Khởi tạo ViewModel
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        // Setup UI
        Button languageButton = findViewById(R.id.languageButton);
        Button signInButton = findViewById(R.id.signInButton);
        EditText usernameEditText = findViewById(R.id.usernameEditText);
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
                    // Gọi phương thức chuyển sang MainActivity
                    switchToMainView(username);
                }
            }
        });

    }



}
