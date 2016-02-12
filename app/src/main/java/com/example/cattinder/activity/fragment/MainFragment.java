package com.example.cattinder.activity.fragment;

import com.example.cattinder.R;
import com.example.cattinder.api.CatService;
import com.example.cattinder.data.CatServiceResponse;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainFragment extends Fragment{

    private static final int INITIAL_CAT_INDEX = 1;
    private static final String KEY_NEXT_CAT = "NextCat";

    private CatService mCatService;
    private SwipeFlingAdapterView mSwipeFlingAdapterView;

    private int nextCatIndex = INITIAL_CAT_INDEX;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.nextCatIndex = savedInstanceState.getInt(KEY_NEXT_CAT, INITIAL_CAT_INDEX);

        inject();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_hotornot, null);
        mSwipeFlingAdapterView = (SwipeFlingAdapterView)view.findViewById(R.id.kittyStack);
        
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();

        getMoreCats();
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(KEY_NEXT_CAT, this.nextCatIndex);
    }


    private void getMoreCats() {
        new AsyncTask<Void, Void, List<CatServiceResponse.Cat>>() {

            @Override
            protected List<CatServiceResponse.Cat> doInBackground(Void... params) {

                CatServiceResponse response = MainFragment.this.mCatService.getCats(MainFragment.this.nextCatIndex);
                List<CatServiceResponse.Cat> cats = response.getCats();
                MainFragment.this.nextCatIndex += cats.size();
                return cats;
            }


            @Override
            protected void onPostExecute(List<CatServiceResponse.Cat> cats) {

                // TODO - Add cats to adapter

            }

        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }



    protected void inject() {
        mCatService = CatService.RestClient.createService().getService();
    }



    // https://github.com/Diolor/Swipecards

    private class CatSwipeAdapter extends BaseAdapter{

        private List<CatServiceResponse.Cat> mData = new ArrayList<>();

        public void addData(List<CatServiceResponse.Cat> newData) {
            mData.addAll(newData);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public CatServiceResponse.Cat getItem(int position) {
            if(position < 0
                    || position >= mData.size()) {
                return null;
            }
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }

    }
}
