package co.infinum.example.eventbus.helpers;

import android.os.Looper;

/**
 * Created by dino on 05/01/14.
 */
public class ThreadHelper {

    public static String getThreadInfo() {

        String textMainThread =
                Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId()
                        ? " - the MAIN thread!"
                        : " - NOT the MAIN thread!";

        return "Thread " + Thread.currentThread().getId() + textMainThread;
    }

}
