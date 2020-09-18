package com.example.chatting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public class Msg{
        public static final int TYPE_RECEIVED=0;
        public static final int TYPE_SENT=1;
        private String content;
        private int type;
        public Msg(String content,int type){
            this.content=content;
            this.type=type;
        }

        public int getType() {
            return type;
        }

        public String getContent() {
            return content;
        }
    }

    public class MainActivity extends AppCompatActivity{
        private List<Msg> msgList=new ArrayList<>();
        private EditText inputText;
        private Button send;
        private RecyclerView msgRecyclerView;
        private MsgAdapter adapter;
        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            initMsgs();
            inputText = (EditText) findViewById(R.id.input_text);
            send = (Button) findViewById(R.id.send);
            msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            msgRecyclerView.setLayoutManager(layoutManager);
            adapter = new MsgAdapter(msgList) {
                @Override
                public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

                }
            };
            msgRecyclerView.setAdapter(adapter);
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String content = inputText.getText().toString();
                    if (!"".equals(content)) {
                        Msg msg = new Msg(content, Msg.TYPE_SENT);
                        msgList.add(msg);
                        adapter.notifyItemInserted(msgList.size() - 1);
                        msgRecyclerView.scrollToPosition(msgList.size() - 1);
                        inputText.setText("");
                    }
                }
            });
        }
     private void initMsgs(){
            Msg msg1=new Msg("陈冯缘是爸爸",Msg.TYPE_RECEIVED);
            msgList.add(msg1);
            Msg msg2=new Msg("刘奕苇是臭狗屎",Msg.TYPE_SENT);
            msgList.add(msg2);
     }
    }
}