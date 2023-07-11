package com.example.btnhom;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    private EditText nameEditText, emailEditText, passwordEditText, confirmPasswordEditText;
    private TextView twAA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        // Khởi tạo các trường EditText
        nameEditText = findViewById(R.id.txtNameRegister);
        emailEditText = findViewById(R.id.txtEmailRegister);
        passwordEditText = findViewById(R.id.txtPasswordRegister);
        confirmPasswordEditText = findViewById(R.id.txtPasswordRR);
        twAA = findViewById(R.id.twDaCoTaiKhoang);

        // Thiết lập sự kiện click cho nút đăng kí
        Button registerButton = findViewById(R.id.btnRegister);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy giá trị nhập vào từ các trường EditText
                String name = nameEditText.getText().toString().trim();
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                String confirmPassword = confirmPasswordEditText.getText().toString().trim();

                // Thực hiện xác thực thông tin người dùng
                if (TextUtils.isEmpty(name) && TextUtils.isEmpty(email) && TextUtils.isEmpty(password)) {
                    nameEditText.setError("Please enter your name");
                    nameEditText.requestFocus();

                    emailEditText.setError("Please enter your email");
                    emailEditText.requestFocus();

                    passwordEditText.setError("Please enter a password");
                    passwordEditText.requestFocus();
                    return;
                }

                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    emailEditText.setError("Please enter a valid email");
                    emailEditText.requestFocus();
                    return;
                }

                if (password.length() < 6) {
                    passwordEditText.setError("Password must be at least 6 characters long");
                    passwordEditText.requestFocus();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    confirmPasswordEditText.setError("Passwords do not match");
                    confirmPasswordEditText.requestFocus();
                    return;
                }

                // Lưu thông tin người dùng vào cơ sở dữ liệu
                User newUser = new User(name, email, password);
                User.listUser.add(newUser);
                // Code xử lý lưu thông tin người dùng vào cơ sở dữ liệu ở đây

                // Hiển thị thông báo đăng kí thành công
                Toast.makeText(register.this, "Registration successful", Toast.LENGTH_SHORT).show();

                // Chuyển đến màn hình đăng nhập
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
                finish();
            }
        });

        //nhấn để trở về
        twAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register.this, login.class);
                startActivity(intent);
            }
        });
    }
}

