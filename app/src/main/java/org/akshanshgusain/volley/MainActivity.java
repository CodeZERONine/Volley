package org.akshanshgusain.volley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   private ArrayList<String> activityName=new ArrayList<>();
   private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
    }

    private void initList() {
        activityName.add("SimpleJsonObject");
        activityName.add("SimpleJsonArray");
        activityName.add("Volley3");
        initRecycler();
    }

    private void initRecycler() {
            mRecyclerView=findViewById(R.id.recyclerview);
            Adapter mAdapter=new Adapter(MainActivity.this,activityName);
        LinearLayoutManager mLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
