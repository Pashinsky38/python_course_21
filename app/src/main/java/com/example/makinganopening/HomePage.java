package com.example.makinganopening;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    Button buttonStart;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // Find the start button in the layout
        buttonStart = findViewById(R.id.buttonStart);

        // Set a click listener for the start button
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Cancel the timer if the button is clicked before the timer runs out
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }

                // Create an intent to navigate to the Login activity
                Intent intent = new Intent(HomePage.this, Login.class);
                // Start the Login activity
                startActivity(intent);
            }
        });

        // Start the countdown timer for 5 seconds
        countDownTimer = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // Irrelevant, does nothing
            }

            @Override
            public void onFinish() {
                // Move the user to the login screen after 5 seconds
                Intent intent = new Intent(HomePage.this, Login.class);
                startActivity(intent);

                // Display a toast message saying "Welcome!"
                Toast.makeText(HomePage.this, "Welcome!", Toast.LENGTH_SHORT).show();
            }
        }.start();
    }

    // Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Variable for receiving an input
        int id = item.getItemId();

        if (id == R.id.menuHome) {
            // If clicked on Home Page, goes from HomePage to HomePage
            Intent intent = new Intent(HomePage.this, HomePage.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menuLogin) {
            // If clicked on Login, goes from HomePage to Login
            Intent intent = new Intent(HomePage.this, Login.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menuSignUp) {
            // If clicked on Sign Up, goes from HomePage to Register
            Intent intent = new Intent(HomePage.this, Register.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.menuCloseApp) {
            // If clicked on Close App, the app closes
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
