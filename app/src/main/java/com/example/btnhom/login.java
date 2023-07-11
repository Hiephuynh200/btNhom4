//package com.example.btnhom;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class login extends AppCompatActivity {
//    private EditText usernameEditText;
//    private EditText passwordEditText;
//    private Button loginButton;
//    private TextView createTextView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.login);
//
//        usernameEditText = findViewById(R.id.txtName);
//        passwordEditText = findViewById(R.id.txtPassword);
//        loginButton = findViewById(R.id.btnLogin);
//        createTextView = findViewById(R.id.twCreate);
//
//        createTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(login.this, register.class);
//                startActivity(intent);
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//
//            public void onClick(View view) {
//                String username = usernameEditText.getText().toString();
//                String password = passwordEditText.getText().toString();
//
//                if (TextUtils.isEmpty(username) && TextUtils.isEmpty(password)) {
//                    usernameEditText.setError("Please enter information");
//                    usernameEditText.requestFocus();
//                    passwordEditText.setError("Please enter information");
//                    passwordEditText.requestFocus();
//                    return;
//                }
//
//                // Kiểm tra thông tin đăng nhập
//                for (User user : User.listUser) {
//
//                    if (user.UserName.equals(username) && user.Password.equals(password)) {
//                        // Đăng nhập thành công
//                        Intent intent = new Intent(login.this, game.class);
//                        startActivity(intent);
//                        // Chuyển sang activity mới hoặc thực hiện các thao tác cần thiết
//                        break;
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Đăng nhập thất bại. Vui lòng kiểm tra lại tên đăng nhập và mật khẩu", Toast.LENGTH_LONG).show();
//                        // Hiển thị thông báo lỗi hoặc thực hiện các thao tác cần thiết
//                    }
//                }
//            }
//        });
//    }
//}