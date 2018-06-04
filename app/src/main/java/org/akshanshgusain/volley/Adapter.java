package org.akshanshgusain.volley;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {
    private ArrayList<String> mActivityList=new ArrayList<>();
   private Context mContext;
    public Adapter(Context mContext, ArrayList<String> mActivityList) {
        this.mActivityList=mActivityList;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        Holder holderObject=new Holder(view);
        return holderObject;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {
        holder.mActivityName.setText(mActivityList.get(position));
        holder.mActivityName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(mContext, mActivityList.get(position), Toast.LENGTH_SHORT).show();
                String temp1="org.akshanshgusain.volley."+mActivityList.get(position);
                try {
                    Class temp = Class.forName(temp1);
                    Intent i=new Intent(mContext,temp);
                    mContext.startActivity(i);

                }catch(Exception e){
                    Toast.makeText(mContext, "Exception!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        }

    @Override
    public int getItemCount() {
        return mActivityList.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
          TextView mActivityName;
        public Holder(View itemView) {
            super(itemView);
            mActivityName=itemView.findViewById(R.id.card_textView);
        }
    }
}
