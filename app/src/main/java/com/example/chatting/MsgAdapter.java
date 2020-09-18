package com.example.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public abstract class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder>{
    private List<MainActivity.Msg> mMsgList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rjghtMsg;
        public ViewHolder(View view){
            super(view);
            leftLayout=(LinearLayout)view.findViewById(R.id.left_layout);
            rightLayout=(LinearLayout)view.findViewById(R.id.right_layout);
            leftMsg=(TextView)view.findViewById(R.id.left_msg);
            rjghtMsg=(TextView)view.findViewById(R.id.right_msg);
        }
    }
    public MsgAdapter(List<MainActivity.Msg> msgList){
        mMsgList=msgList;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup partent, int viewType){
        View view= LayoutInflater.from(partent.getContext()).inflate(R.layout.msg_item,partent,false);
        return new ViewHolder(view);
    }
    public void onBindViewHoler(ViewHolder holder,int position){
        MainActivity.Msg msg=mMsgList.get(position);
        if (msg.getType()== MainActivity.Msg.TYPE_RECEIVED){
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }
        else if (msg.getType()== MainActivity.Msg.TYPE_SENT){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rjghtMsg.setText(msg.getContent());
        }
    }
    @Override
    public int getItemCount(){
        return mMsgList.size();
    }
}
