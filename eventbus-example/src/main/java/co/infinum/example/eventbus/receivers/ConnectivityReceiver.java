package co.infinum.example.eventbus.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import co.infinum.example.eventbus.Constants;
import co.infinum.example.eventbus.helpers.ThreadHelper;
import de.greenrobot.event.EventBus;

/**
 * Created by dino on 10/4/13.
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(Constants.LOG_TAG, "Sending event! " + ThreadHelper.getThreadInfo());
        EventBus.getDefault().post(new NetworkConnectionChanged());
    }

    public static class NetworkConnectionChanged {
        // we could send the connection state in this object,
        // but the receiver will check the connection instead,
        // so the information he gets is as fresh as possible
    }
}
