package com.example.chatting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {      //泛型
    private List<Msg> mMsgList;

    public MsgAdapter(List<Msg> msgList) {                                            //构造方法，传值为List<Msg>
        this.mMsgList = msgList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout, rightLayout;                                        //声明控件类变量
        TextView leftMsg, rightMsg;                                                  //声明控件类变量

        public ViewHolder(View itemView) {
            super(itemView);
            leftLayout = (LinearLayout) itemView.findViewById(R.id.layout_left);     //获得创建好的layout_left id 布局控件
            rightLayout = (LinearLayout) itemView.findViewById(R.id.layout_rigin);   //获得创建好的layout_rigin id 布局控件
            leftMsg = (TextView) itemView.findViewById(R.id.mess_left);              //获取TextView_left_id,并赋值给leftMsgid
            rightMsg = (TextView) itemView.findViewById(R.id.mess_reght);            //获取TextView_reght_id,并赋值给rightMsgid
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {                              //加载itme资源方法
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false);   //加载itemlayout资源
        return new ViewHolder(view);                                                                    //新实例化上文泛型，参数为刚刚过去的messitem.xml View
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {                 //循环执行方法
        Msg msg = mMsgList.get(position);                                             //获取当前下标

        if (msg.getType() == Msg.TYPE_RECEIVED_SD)                                   //如果收到消息 显示左侧的消息布局隐藏右边布局
        {
            holder.leftLayout.setVisibility(View.VISIBLE);                          //设置左侧消息框可见
            holder.rightLayout.setVisibility(View.GONE);                            //设置右侧消息框隐藏
            holder.leftMsg.setText(msg.getContent());                               //设置接收到的内容

        } else if (msg.getType() == Msg.TYPE_SENT_FC)                                   //如果是发出消息 显示右侧消息，隐藏左侧消息
        {
            holder.leftLayout.setVisibility(View.GONE);                             //设置左侧消息框可见
            holder.rightLayout.setVisibility(View.VISIBLE);                         //设置右侧消息框隐藏
            holder.rightMsg.setText(msg.getContent());                              //设置发送消息
        }
    }

    @Override
    public int getItemCount() {                                                     //返回项的总数量
        return mMsgList.size();                                                     //返回list的总数
    }
}