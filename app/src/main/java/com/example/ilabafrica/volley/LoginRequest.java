package com.example.ilabafrica.volley;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iLabAfrica on 4/12/2017.
 */

public class LoginRequest extends StringRequest {

    private static final String URL = "http://172.16.40.230/volley/login.php";
    private Map<String,String> params;
    Response.Listener<String> listener;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        params = new HashMap<>();
        params.put("username",username);
        params.put("password",password);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
