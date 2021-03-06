package com.bw.movie.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.movie.R;
import com.bw.movie.activity.MovieListActivity;
import com.bw.movie.model.MovieItem;
import com.bw.movie.model.MoviePage;
import com.bw.movie.net.HttpHelper;
import com.bw.movie.net.HttpListener;
import com.bw.movie.net.HttpSaveUtil;
import com.google.gson.Gson;

import java.net.ConnectException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李地坤
 * @date 11/28
 * 电影碎片的适配器
 */
public class MoviePagerAdapter extends RecyclerView.Adapter<MoviePagerAdapter.MyViewHolder> {
	private Context context;
	private List<MoviePage> data;
	private MovieItem movieItem;

	public MoviePagerAdapter(Context context) {
		this.context = context;
	}

	public void setData(List<MoviePage> data) {
		this.data = data;
	}

	@NonNull
	@Override
	public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
		View view = View.inflate(context, R.layout.item_movie, null);
		MyViewHolder holder = new MyViewHolder(view);
		return holder;
	}

	@Override
	public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {
		myViewHolder.title.setText(data.get(i).getName());

		LinearLayoutManager manager = new LinearLayoutManager(context);
		manager.setOrientation(LinearLayoutManager.HORIZONTAL);

		myViewHolder.recyclerView.setLayoutManager(manager);

		final MovieItemAdapter adapter = new MovieItemAdapter(context);
				myViewHolder.recyclerView.setAdapter(adapter);
				myViewHolder.layoutTitle.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						Intent intent = new Intent(context, MovieListActivity.class);
						intent.putExtra("type",i);
						context.startActivity(intent);
					}
				});
		Map<String, String> map = new HashMap<>();
		map.put("page", "1");
		map.put("count", "20");
		//执行网络请求
		new HttpHelper(context).get(data.get(i).getUrl(), map,true).result(new HttpListener() {
			@Override
			public void success(String d) {
				movieItem = new Gson().fromJson(d, MovieItem.class);
				HttpSaveUtil.save(data.get(i).getUrl(),d);
				adapter.setData(movieItem);
				adapter.notifyDataSetChanged();
			}

			@Override
			public void fail(String error) {
				Toast.makeText(context, ""+error, Toast.LENGTH_SHORT).show();
			}
		});


	}

	@Override
	public int getItemCount() {

		if (data == null)
			return 0;
		return data.size();
	}

	public class MyViewHolder extends RecyclerView.ViewHolder {
		TextView title;
		RecyclerView recyclerView;
		RelativeLayout layoutTitle;
		public MyViewHolder(@NonNull View itemView) {
			super(itemView);

			title = itemView.findViewById(R.id.textName);
			recyclerView = itemView.findViewById(R.id.recycleShow);
		    layoutTitle=itemView.findViewById(R.id.layoutTitle);
		}
	}
}
