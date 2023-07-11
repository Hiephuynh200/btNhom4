package com.example.btnhom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class game extends AppCompatActivity {
    int randomNumber;    // Số máy tính phát sinh ngẫu nhiên
    int guessNumber;    // Số mà người chơi đoán
    int guessCount = 0;    // Số lần đoán của người chơi
    String log = "";    // Nhật ký của người chơi

    private TextView txtGuess, txtResult, txtNhatKy, txtViewResult, txtReturn;
    private Button btnNew, btnGUess, btnFinish;
    private String checkGuess(int guessNum, int randNum) {
        String guessStr = Integer.toString(guessNum);
        String randStr = Integer.toString(randNum);

        // Kiểm tra định dạng đầu vào
        if (guessStr.length() != randStr.length() || !guessStr.matches("\\d+") || !randStr.matches("\\d+")) {
            return "Invalid input";
        }

        int a = 0, b = 0;
        boolean[] checked = new boolean[3];

        // Tìm các chữ số trùng nhau và đánh dấu là đã kiểm tra
        for (int i = 0; i < guessStr.length(); i++) {
            if (guessStr.charAt(i) == randStr.charAt(i)) {
                a++;
                checked[i] = true;
            }
        }

        // Tìm các chữ số khác nhau và đánh dấu là đã kiểm tra
        for (int i = 0; i < guessStr.length(); i++) {
            if (!checked[i]) {
                for (int j = 0; j < randStr.length(); j++) {
                    if (!checked[j] && guessStr.charAt(i) == randStr.charAt(j)) {
                        b++;
                        checked[j] = true;
                        break;
                    }
                }
            }
        }

        return Integer.toString(a) + "?" + Integer.toString(b) + "+";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        txtGuess = findViewById(R.id.txtGuess);
        txtResult = findViewById(R.id.twResult);
        txtNhatKy = findViewById(R.id.twNhatky);
        txtViewResult = findViewById(R.id.twVIewResult);
        txtReturn = findViewById(R.id.twReturn);
        btnNew = findViewById(R.id.btnNew);
        btnGUess = findViewById(R.id.btnGuess);
        btnFinish = findViewById(R.id.btnFinish);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Phat sinh so ngau nhien
                Random random = new Random();
                randomNumber = random.nextInt(900) + 100;

                // Xoa noi dung cua cac TextView va EditText
                txtGuess.setText("");
                txtResult.setText("");
                txtNhatKy.setText("");
                txtViewResult.setText("");

                // Dat gia tri cho cac bien
                guessCount = 0;
                log = "";

                // Hien thi thong tin cho nguoi choi
                Toast.makeText(getApplicationContext(), "Bat dau tro choi moi!", Toast.LENGTH_SHORT).show();
            }
        });
    // Khai báo biến randomStr
            String randomStr;

    // Sinh số ngẫu nhiên có 3 chữ số
            Random random = new Random();
        int randomNumber = random.nextInt(900) + 100;
        randomStr = String.valueOf(randomNumber);
        btnGUess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lay gia tri nhap vao tu EditText
                String guessStr = txtGuess.getText().toString().trim();

                // Kiem tra gia tri nhap vao co hop le hay khong
                if (guessStr.length() != 3) {
                    Toast.makeText(getApplicationContext(), "Vui long nhap so co 3 chu so!", Toast.LENGTH_SHORT).show();
                } else {
                    // Tang so lan doan len 1
                    guessCount++;

                    // Chuyen doi chuoi sang so
                    guessNumber = Integer.parseInt(guessStr);

                    // Kiem tra xem nguoi choi da doan dung hay chua
                    if (guessNumber == randomNumber) {
                        txtResult.setText("Chuc mung! Ban da doan dung!");
                        Toast.makeText(getApplicationContext(), "Chuc mung! Ban da doan dung!", Toast.LENGTH_SHORT).show();
                    } else {
                        // Phan hoi ket qua
                        String feedback = "";
                        for (int i = 0; i < 3; i++) {
                            if (guessStr.charAt(i) == randomStr.charAt(i)) {
                                feedback += "+";
                            } else if (randomStr.contains(String.valueOf(guessStr.charAt(i)))) {
                                feedback += "?";
                            }
                        }
                        txtResult.setText(feedback);

                        // Luu ket qua vao TextView
                        txtViewResult.append(guessStr + " - " + feedback + "\n");

                        // Kiem tra so lan doan
                        if (guessCount >= 7) {
                            txtResult.setText("bạn ngu vcl, so can doan la " + randomStr);
                            Toast.makeText(getApplicationContext(), "bạn ngu vcl, so can doan la " + randomStr, Toast.LENGTH_SHORT).show();
                          //  btnGUess.setEnabled(false); // Khong cho nguoi choi nhap tiep
                        }
                    }
                }
            }
        });

        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResult.setText("Game over! So can doan la: " + randomNumber);
                Toast.makeText(getApplicationContext(), "Game over! So can doan la: " + randomNumber, Toast.LENGTH_SHORT).show();
            }
        });

      //  return login page
        txtReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(game.this,  login.class);
                startActivity(intent);
            }
        });
    }

}