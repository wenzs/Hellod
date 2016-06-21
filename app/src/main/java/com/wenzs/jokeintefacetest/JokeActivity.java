package com.wenzs.jokeintefacetest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class JokeActivity extends AppCompatActivity  implements Response.Listener<String>,Response.ErrorListener {

    RequestQueue myrequestqueue;
    ImageLoader myimagel;
    Testadapter tadapter;
    ListView Joke_listview;
    EditText date;
    EditText NO;
    Button search;
    String time;
    String page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        date = (EditText) findViewById(R.id.date);
        NO = (EditText) findViewById(R.id.page_test);
        search = (Button) findViewById(R.id.search);
        initView();
        myrequestqueue = Volley.newRequestQueue(this);
        myimagel = new ImageLoader(myrequestqueue, new BitmapCache());
        String url = "https://route.showapi.com/341-2?&showapi_appid=20702&showapi_sign=156a870b34a04857a47c6648f42dd19e";
        StringRequest srequest = new StringRequest(url, this, this);
        myrequestqueue.add(srequest);
    }

//    public void onClick(View v) {
//        time = date.getText().toString();
//        page = NO.getText().toString();
//
//    }

    private void initView() {
        //初始化视图
        Joke_listview = (ListView) findViewById(R.id.Joke_listview);
        //创建适配器对象
        tadapter = new Testadapter(this);
        //将适配器绑定到listview中
        Joke_listview.setAdapter(tadapter);

    }



        @Override
        public void onResponse(String response) {
            if (tadapter != null) {
                tadapter.clear();
            }

            Joke joke = com.alibaba.fastjson.JSONObject.parseObject(response, Joke.class);
            Joke_showapi_res_body showapi_res_body = joke.getShowapi_res_body();
            if (showapi_res_body != null) {
                Joke_contentlist[] Joke_contentlist = showapi_res_body.getContentlist();
                if (Joke_contentlist != null)
                    tadapter.addAll(Joke_contentlist);
            }
        }

        @Override
        public void onErrorResponse(VolleyError error) {

        }



    class Testadapter extends ArrayAdapter<Joke_contentlist> {

        public Testadapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            viewHodle handle = null;
            if (convertView == null) {
                convertView = View.inflate(parent.getContext(), R.layout.activity_viewhandle, null);
                handle = new viewHodle(convertView);
            } else {
                handle = (viewHodle) convertView.getTag();
            }
            Joke_contentlist item = getItem(position);
            handle.Joke_title.setText(item.getTitle());
            handle.net_image.setImageUrl(item.getImg(), myimagel);
            handle.Joke_ct.setText(item.getCt());

            return convertView;
        }

        class viewHodle {
            TextView Joke_title;
            NetworkImageView net_image;
            TextView Joke_ct;

            public viewHodle(View v) {
                System.out.println("第五处");
                Joke_title = (TextView) v.findViewById(R.id.Joke_title);
                net_image = (NetworkImageView) v.findViewById(R.id.net_image);
                Joke_ct = (TextView) v.findViewById(R.id.Joke_ct);
                v.setTag(this);
            }

        }
    }
}

