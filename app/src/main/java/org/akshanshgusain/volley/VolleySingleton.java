package org.akshanshgusain.volley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySingleton {
    private static VolleySingleton mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;
   //Constructor
       public VolleySingleton(Context mContext) {
        this.mContext=mContext;
        mRequestQueue=getmRequestQueue();
    }
    //Method for returning Request Queue
    public RequestQueue getmRequestQueue(){
           if(mRequestQueue==null){
               mRequestQueue= Volley.newRequestQueue(mContext.getApplicationContext());
           }
           return mRequestQueue;
    }
    //Method for returning Instance of this class
    public static synchronized  VolleySingleton getmInstance(Context mContext){
           if(mInstance==null){
               mInstance=new VolleySingleton(mContext);
           }
           return mInstance;
    }
    //method  to add request to requestQure
     public<t> void addToRequestQueue(Request<t> request){
           mRequestQueue.add(request);
     }

}
