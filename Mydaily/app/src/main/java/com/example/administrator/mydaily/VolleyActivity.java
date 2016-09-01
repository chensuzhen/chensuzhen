package com.example.administrator.mydaily;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.mydaily.model.TopStory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/8/13.
 */
public class VolleyActivity extends Activity /*implements AdapterView.OnItemClickListener*/{

    private TextView sendTxt, showTxt;
    private RequestQueue mQueue;
    private String URL = "http://news-at.zhihu.com/api/4/news/latest";//单一职责
    private List<TopStory> topStoryOfList = new ArrayList<TopStory>();
    private ListView mTopStoryListView;
    private StoryAdapter mStoryAdapter;



    //private int[] numArr = {1,2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley);
        initView();
        getData();
    }

    private void initView() {
        //sendTxt = (TextView) findViewById(R.id.send);
        //showTxt = (TextView) findViewById(R.id.show);
        mQueue = Volley.newRequestQueue(VolleyActivity.this);
        mTopStoryListView = (ListView) findViewById(R.id.story_list);

    }

    private void getData() {
        JsonObjectRequest jsonRequest = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            topStoryData(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(VolleyActivity.this, "checkout intent", Toast.LENGTH_SHORT).show();
                    }
                });
        mQueue.add(jsonRequest);
    }

    /*private void topStoryData(JSONObject data) {//json {} 对象  [] 数组
        JSONArray topData = data.optJSONArray("top_stories");


        if (topData == null || topData.length() < 0) {
            return;//topData == null
        }
        for (int i = 0, len = topData.length(); i < len; i++) {
            if (topData.isNull(i)) return;
            JSONObject item = topData.optJSONObject(i);
            String id = item.optString("id");
            String title = item.optString("title");
            String image = item.optString("image");
            if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(title) && !TextUtils.isEmpty(image)) {
                TopStory topStory = new TopStory(id, title, image);
//                TopStory topStory = new TopStory();
//                topStory.setId(id);
//                topStory.setTitle(title);
//                topStory.setImage(image);
                topStoryOfList.add(topStory);

            }
           // return topStoryOfList;
        }
        mStoryAdapter = new StoryAdapter(VolleyActivity.this, topStoryOfList);
        mTopStoryListView.setAdapter(mStoryAdapter);
    }*/

    private void topStoryData(JSONObject data) throws JSONException {
        JSONArray topData = data.optJSONArray("stories");
        if (topData == null || topData.length() < 0) {
            return;
        }
        for (int i = 0, len = topData.length(); i < len; i++) {
            if (topData.isNull(i)) return;
            JSONObject item = topData.optJSONObject(i);
            String id = item.optString("id");
            String title = item.optString("title");
            String image = (String) item.getJSONArray("images").get(0);

            if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(title) && !TextUtils.isEmpty(image)) {
                TopStory topStory = new TopStory(id, title, image);
                topStoryOfList.add(topStory);
            }
        }
        mStoryAdapter = new StoryAdapter(VolleyActivity.this, topStoryOfList);
        mTopStoryListView.setAdapter(mStoryAdapter);
    }

    /*@Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(VolleyActivity.this,StoryDetailActivity.class);
        intent.putExtra();
        startActivity(intent);
    }*/

}
