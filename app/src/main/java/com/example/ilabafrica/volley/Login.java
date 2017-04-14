package com.example.ilabafrica.volley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {

    EditText et_username,et_password;
    Button login;
    TextView register;
    String username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = (EditText) findViewById(R.id.username);
        et_password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        register = (TextView) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = et_username.getText().toString();
                password = et_password.getText().toString();
                //Toast.makeText(Login.this,username + " " + password,Toast.LENGTH_SHORT).show();

                Response.Listener<String> listener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if(success){
                                String name = jsonObject.getString("name");
                                String username = jsonObject.getString("username");
                                String password = jsonObject.getString("password");
                                String email = jsonObject.getString("email");

                                Intent intent = new Intent(Login.this,Profile.class);
                                intent.putExtra("name",name);
                                intent.putExtra("username",username);
                                intent.putExtra("password",password);
                                intent.putExtra("email",email);

                                startActivity(intent);
                            } else{
                                Toast.makeText(Login.this,"Login failed. Please try again.",Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest request = new LoginRequest(username,password,listener);
                RequestQueue queue = Volley.newRequestQueue(Login.this);
                queue.add(request);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
}
