package com.example.scanner;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText email;
    private EditText pass;
    private ImageView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        email = findViewById(R.id.ed_email);
        pass = findViewById(R.id.ed_password);
        result = findViewById(R.id.result);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public  void enter(View view){
        int password = Integer.parseInt(pass.getText().toString());
        result.setVisibility(View.VISIBLE);
        result.setAlpha(1.0f);
        if (password > 999999){
            result.setImageResource(R.drawable.red);
            Toast.makeText(MainActivity.this,"more then 6 words", Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("more then 6 words!!!!!")
                    .setPositiveButton("OK",null)
                    .show();
        }else if(password < 99999){
            result.setImageResource(R.drawable.red);
            Toast.makeText(MainActivity.this,"less then 6 words", Toast.LENGTH_LONG).show();
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage("less then 6 words!!!!!")
                    .setPositiveButton("OK",null)
                    .show();
        }else {
            result.setImageResource(R.drawable.green);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
