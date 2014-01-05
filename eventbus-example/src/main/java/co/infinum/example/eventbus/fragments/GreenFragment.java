package co.infinum.example.eventbus.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import co.infinum.example.eventbus.R;
import co.infinum.example.eventbus.receivers.ConnectivityReceiver;

/**
 * Created by dino on 05/01/14.
 */
public class GreenFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_green, null);

        return view;
    }

    @Override
    public void onEventMainThread(ConnectivityReceiver.NetworkConnectionChanged event) {
        super.onEventMainThread(event);

        String text = isNetworkConnected(getActivity()) ?
                ": network connected!" : ": network disconnected!";

        Toast.makeText(getActivity(), getString(R.string.green_fragment) + text,
                Toast.LENGTH_SHORT).show();
    }
}
