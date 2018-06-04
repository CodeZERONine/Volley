package org.akshanshgusain.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class SimpleJsonObject extends AppCompatActivity {
    private Button mFetchBtn;
    private TextView mName,mPhone,mJob;
    private String jsonurl="http://api.myjson.com/bins/18v1ii";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_json_object);
        mName=(TextView)findViewById(R.id.name_textView);
        mPhone=(TextView)findViewById(R.id.phone_textView);
        mJob=(TextView)findViewById(R.id.job_textView);
        mFetchBtn=(Button)findViewById(R.id.fetch_Btn);

        mFetchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create a new json oBject request
                JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, jsonurl, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            mName.setText(response.getString("name"));
                            mPhone.setText(response.getString("Phone"));
                            mJob.setText(response.getString("job"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SimpleJsonObject.this, "Error While Fetching", Toast.LENGTH_SHORT).show();
                    }
                });
                VolleySingleton.getmInstance(SimpleJsonObject.this).addToRequestQueue(jsonObjectRequest);

            }
        });//End of Onclick Listner
    }
}
