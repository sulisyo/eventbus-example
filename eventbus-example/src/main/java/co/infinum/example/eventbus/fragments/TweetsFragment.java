package co.infinum.example.eventbus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import co.infinum.example.eventbus.R;

/**
 * Created by dino on 05/01/14.
 */
public class TweetsFragment extends BaseFragment {

    @InjectView(R.id.tweets_list)
    protected ListView tweetsList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tweets, null);
        ButterKnife.inject(this, view);

        return view;
    }
}