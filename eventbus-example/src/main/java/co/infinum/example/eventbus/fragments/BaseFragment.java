package co.infinum.example.eventbus.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.Fragment;

import co.infinum.example.eventbus.R;
import co.infinum.example.eventbus.receivers.ConnectivityReceiver;
import de.greenrobot.event.EventBus;
import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

/**
 * Created by dino on 05/01/14.
 */
public class BaseFragment extends Fragment {

    private static final Configuration CONFIGURATION_INFINITE = new Configuration.Builder()
            .setDuration(Configuration.DURATION_INFINITE)
            .build();

    private static final Style STYLE_ALERT_INFINITE = new Style.Builder().
            setBackgroundColorValue(Style.holoRedLight).setConfiguration(CONFIGURATION_INFINITE)
            .build();

    @Override
    public void onResume() {
        super.onResume();

        onNetworkChange(isNetworkConnected(getActivity()));

        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();

        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(ConnectivityReceiver.NetworkConnectionChanged event) {
        onNetworkChange(isNetworkConnected(getActivity()));
    }

    protected boolean isNetworkConnected(Context context) {

        if (context == null) {
            return true;
        }

        boolean isConnectedWifi = false;
        boolean isConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI")) {
                if (ni.isConnected()) {
                    isConnectedWifi = true;
                }
            }
            if (ni.getTypeName().equalsIgnoreCase("MOBILE")) {
                if (ni.isConnected()) {
                    isConnectedMobile = true;
                }
            }
        }

        return isConnectedWifi || isConnectedMobile;
    }

    private void onNetworkChange(boolean connected) {
        if (!connected) {
            Crouton.makeText(getActivity(), R.string.network_down, STYLE_ALERT_INFINITE).show();
        } else {
            Crouton.cancelAllCroutons();
        }
    }
}
