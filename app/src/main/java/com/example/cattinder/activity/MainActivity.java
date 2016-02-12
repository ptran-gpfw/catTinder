package com.example.cattinder.activity;

import com.example.cattinder.R;
import com.example.cattinder.activity.fragment.MainFragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class MainActivity extends Activity {

    private static final String FRAG_TAG_MAIN = "frag_tag_main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Fragment frag = getFragmentManager().findFragmentByTag(FRAG_TAG_MAIN);
        if(frag == null) {
            frag = new MainFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, frag, FRAG_TAG_MAIN)
                    .commit();
        }
    }
}
