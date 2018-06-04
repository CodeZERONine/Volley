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
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class SimpleJsonArray extends AppCompatActivity {
    private Button mFetch;
    private TextView mData;
    private String url="https://api.myjson.com/bins/e5aey";
    private String result="";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_json_array);
        mData=(TextView)findViewById(R.id.textView);
        mFetch=(Button)findViewById(R.id.button);
        mFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimpleJsonArray.this, "ONcLICK", Toast.LENGTH_SHORT).show();
                JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Toast.makeText(SimpleJsonArray.this, "oNRESPONSE", Toast.LENGTH_SHORT).show();
                                            int i=0;
                                            String tempResult="";
                                            while(i<response.length()){
                                                try {
                                                    JSONObject mJsonObject=response.getJSONObject(i);
                                                   tempResult=mJsonObject.getString("name");

                                                    tempResult=tempResult+mJsonObject.getString("Phone");
                                                    tempResult=tempResult+ mJsonObject.getString("job");
                                                    tempResult=tempResult+"\n";
                                                    result=result+tempResult;
                                                    Toast.makeText(SimpleJsonArray.this, result, Toast.LENGTH_SHORT).show();

                                                    } catch (JSONException e) {
                                                    e.printStackTrace();
                                                    Toast.makeText(SimpleJsonArray.this, "Exception", Toast.LENGTH_SHORT).show();
                                                    }
                                                mData.setText(result);
                                                i++;
                                                }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(SimpleJsonArray.this, "ERROR  !", Toast.LENGTH_SHORT).show();
                    }
                });//End of      jsonarrayrequest
                VolleySingleton.getmInstance(SimpleJsonArray.this).addToRequestQueue(jsonArrayRequest);

            }
        });
    }
}
