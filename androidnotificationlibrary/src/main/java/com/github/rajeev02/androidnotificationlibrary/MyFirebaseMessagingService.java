package com.github.rajeev02.androidnotificationlibrary;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by rajeev on 12/21/17.
 */
public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "FCM Service";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        AppConstant.setMessage(remoteMessage.getNotification().getBody());
        AppConstant.setTitle(remoteMessage.getNotification().getTitle());
        NotificationReceiver.notificationFromFCM();
    }
}