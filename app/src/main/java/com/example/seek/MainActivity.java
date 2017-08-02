package com.example.seek;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private String path = "http://qhb.2dyt.com/Bwei/news?page=1&type=7&postkey=ad1AK";
    private String s;
    private List<BweiBean.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);


        AsyncTask<Void, Void, String> get = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {

                try {
                    //创建URL把接口放进来
                    URL url = new URL(path);
                    //得到URL对象的值
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    //请求方式
                    connection.setRequestMethod("GET");
                    //链接超时时间
                    connection.setConnectTimeout(8000);
                    //请求码判断
                    if (connection.getResponseCode() == 200) {
                        //得到InputStream
                        InputStream inputStream = connection.getInputStream();
                        //字节流转换成字符流
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        int len = 0;
                        byte[] buffer = new byte[1024];
                        while ((len = inputStream.read(buffer)) != -1) {
                            baos.write(buffer, 0, len);
                        }
                        s = baos.toString();
                    }
                    return s;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                Gson gson = new Gson();
                //Gson解析
                BweiBean bweiBean=gson.fromJson(s,BweiBean.class);
                //把值赋给List
                list=bweiBean.list;
                MyBase adapter=new MyBase(list,MainActivity.this);
                listView.setAdapter(adapter);
                super.onPostExecute(s);
            }
        };
        get.execute();
    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Intent intent=new Intent(MainActivity.this,Main2Acticity.class);
            intent.putExtra("title",list.get(i).title);
            intent.putExtra("data",list.get(i).date);
            intent.putExtra("pic",list.get(i).pic);
            startActivity(intent);
        }
    });
    }
}
