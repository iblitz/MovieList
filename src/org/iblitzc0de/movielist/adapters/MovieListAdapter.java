package org.iblitzc0de.movielist.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;

import com.squareup.picasso.Picasso;

import org.iblitzc0de.movielist.MovieListFragment.Callbacks;
import org.iblitzc0de.movielist.apis.daos.MovieDao;
import org.iblitzc0de.popularlist.R;
import org.iblitzc0de.popularlist.utils.Constant;

import java.util.ArrayList;
import java.util.List;

public class MovieListAdapter extends Adapter <ViewHolder> {
    private Callbacks mCallbacks;
    private List<MovieDao> mDataset = new ArrayList();

    public static class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @Bind({2131492974})
        ImageView mIvPoster;
        public View mRoot;
        @Bind({2131492975})
        TextView mTvTitle;

        public ViewHolder(View v) {
            super(v);
            this.mRoot = v;
            ButterKnife.bind(this, v);
        }
    }

    public MovieListAdapter(List<MovieDao> myDataset, Callbacks callbacks) {
        this.mDataset = myDataset;
        this.mCallbacks = callbacks;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_media_cancel_action, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        final MovieDao item = (MovieDao) this.mDataset.get(position);
        Context context = holder.mRoot.getContext();
        holder.mTvTitle.setText(item.getTitle());
        Picasso.with(context).load(Constant.ROOT_POSTER_IMAGE_URL + item.getPoster_path()).placeholder((int) R.color.grey).error(17170445).into(holder.mIvPoster);
        holder.mRoot.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (MovieListAdapter.this.mCallbacks != null) {
                    MovieListAdapter.this.mCallbacks.onItemSelected(item);
                }
            }
        });
    }

    public int getItemCount() {
        return this.mDataset.size();
    }

	@Override
	public void onBindViewHolder(
			android.support.v7.widget.RecyclerView.ViewHolder arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
}
