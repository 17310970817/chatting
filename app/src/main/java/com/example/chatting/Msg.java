package com.example.chatting;


public class Msg {
         public  static final int TYPE_RECEIVED_SD=0;    //收到的消息标记
        public  static final int TYPE_SENT_FC=1;        //发出的消息标记
         private String content;                        //消息内容
         private int type;                              //消息类型

                 public Msg(String content,int type)           //声明两参构造方法，声明get set方法
        {
                    this.content=content;
                    this.type=type;
                 }
         public String getContent() {
                     return content;
                 }

                 public void setContent(String content) {
                     this.content = content;
                 }

                public int getType() {
                     return type;
                 }

                 public void setType(int type) {
                     this.type = type;
                 }
    }