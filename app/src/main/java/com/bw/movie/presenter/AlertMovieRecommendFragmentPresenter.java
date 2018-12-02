package com.bw.movie.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.movie.R;
import com.bw.movie.adapter.CinemaCommentListAdapter;
import com.bw.movie.mvp.model.CinemaCommentBean;
import com.bw.movie.mvp.view.AppDelegate;
import com.bw.movie.net.HttpUrl;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertMovieRecommendFragmentPresenter extends AppDelegate{
    private Context context;
    private XRecyclerView mRecyclerList;
    private int cinemaId;
    private int page = 1;
    private List<CinemaCommentBean.ResultBean> list = new ArrayList<>();
    private CinemaCommentListAdapter commentListAdapter;
    @Override
    public int getLayout() {
        return R.layout.fragment_alert_cinema_recommend;
    }

    @Override
    public void initContext(Context context) {
        super.initContext(context);
        this.context = context;
    }

    public void initView(XRecyclerView mRecyclerList, int cinemaId) {
        this.mRecyclerList = mRecyclerList;
        this.cinemaId = cinemaId;
    }

    @Override
    public void initData() {
        super.initData();
        // 请求影院评论接口  适配内容
        commentListAdapter = new CinemaCommentListAdapter(context);
        LinearLayoutManager manager = new LinearLayoutManager(context);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerList.setLayoutManager(manager);
        mRecyclerList.setAdapter(commentListAdapter);

        Map<String,String> map = new HashMap<>();
        map.put("cinemaId",cinemaId+"");
        map.put("page",page+"");
        map.put("count",10+"");
        getBean(0, HttpUrl.CINEMA_COMMENT_ALL,map, CinemaCommentBean.class,false);// 此处要改为true
    }

    @Override
    public <T> void successBean(int type, T bean) {
        super.successBean(type, bean);
        switch (type){
            case 0:
                CinemaCommentBean commentBean = (CinemaCommentBean) bean;
                list = commentBean.getResult();
                commentListAdapter.setList(list);
                break;
        }
    }
}