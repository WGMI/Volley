package com.example.ilabafrica.volley;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by iLabAfrica on 4/12/2017.
 */

public class RegisterRequest extends StringRequest{

    private static final String URL = "http://172.16.40.230/volley/register.php";
    private Map<String,String> params;
    Response.Listener<String> listener;

    public RegisterRequest(String name, String username, String password, String email, Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        params = new HashMap<>();
        params.put("name",name);
        params.put("username",username);
        params.put("password",password);
        params.put("email",email);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
