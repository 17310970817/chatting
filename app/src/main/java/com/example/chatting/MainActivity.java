package com.example.chatting;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<>();                                //声明List变量
    private EditText editText;                                                  //声明EdiText类变量
    private Button send;                                                        //声明Button类变量
    private RecyclerView recyclerView;                                          //声明recyclerView类变量
    private MsgAdapter adapter;                                                  //声明adapter类变量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMsgs();                                                             //初始化数据

        editText = (EditText) findViewById(R.id.input_Text);                     //获取组建，赋值给editText类变量
        send = (Button) findViewById(R.id.send_mess);                            //获取组建，赋值给send类变量
        recyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));           //创建显示方式
        adapter = new MsgAdapter(msgList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());   //设置一个GridLayoutManager，图标形式显示，参数一 上下文，参数二，要分成几列显示
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);                         //是横向显示还是纵向显示，两种选项HORIZONTAL,VERTICAL
        recyclerView.setAdapter(adapter);                                                           //给recyclerView设置 adapter事件
        send.setOnClickListener(new View.OnClickListener() {                                        //btn发送消息
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();                       //获取editext内容
                if (!"".equals(content))                                             //判断context是否是“”,或null
                {
                    Msg msg = new Msg(content, Msg.TYPE_SENT_FC);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() - 1);                   //有消息刷新显示
                    recyclerView.scrollToPosition(msgList.size() - 1);                    //将list定位到最后一行
                    editText.setText("");
                }
            }
        });
    }

    private void initMsgs() {
        Msg msg1=new Msg("你好",Msg.TYPE_RECEIVED_SD);
        msgList.add(msg1);
        Msg msg2=new Msg("你好!",Msg.TYPE_SENT_FC);
        msgList.add(msg2);
    }

}