package com.github.rajeev02.androidnotificationlibrary;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by rajeev on 12/22/17.
 */
public class NotificationReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            String action = intent.getAction();
            if (AppConstant.YES_ACTION.equals(action)) {
                Toast.makeText(context, "YES CALLED", Toast.LENGTH_SHORT).show();
            }
            else  if (AppConstant.STOP_ACTION.equals(action)) {
                Toast.makeText(context, "STOP CALLED", Toast.LENGTH_SHORT).show();
            }
            else  if (AppConstant.MAYBE_ACTION.equals(action)) {
                Toast.makeText(context, "MAYBE CALLED", Toast.LENGTH_SHORT).show();


            }
        }

    public static void notificationFromFCM() {
        Context mContext = AppConstant.getmContext();
        Intent intent = AppConstant.getIntent();
        String title = AppConstant.getTitle();
        String message = AppConstant.getMessage();
        int icon = R.drawable.ic_stat_notifications;
        int mNotificationId = 001;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(mContext);
        Intent notificationIntent = intent;
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent pintent = PendingIntent.getActivity(mContext, 12345, notificationIntent, 0);
        Notification notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0).setAutoCancel(true).setContentTitle(title).setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentIntent(pintent).setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_stat_notifications)).setContentText(message).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(mNotificationId, notification);
    }
}




/*

      //  PendingIntent resultPendingIntent = PendingIntent.getActivity(AppConstant.getmContext(), 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


   */
/*   //Yes intent
      Intent yesReceive = new Intent();
      yesReceive.setAction(YES_ACTION);
      PendingIntent pendingIntentYes = PendingIntent.getBroadcast(mContext, 12345, yesReceive, PendingIntent.FLAG_UPDATE_CURRENT);
      mBuilder.addAction(R.drawable.ic_stat_notifications, "Yes", pendingIntentYes);

      //Maybe intent
      Intent maybeReceive = new Intent();
      maybeReceive.setAction(MAYBE_ACTION);
      PendingIntent pendingIntentMaybe = PendingIntent.getBroadcast(mContext, 12345, maybeReceive, PendingIntent.FLAG_UPDATE_CURRENT);
      mBuilder.addAction(R.drawable.ic_stat_notifications, "Partly", pendingIntentMaybe);

      //No intent
      Intent noReceive = new Intent();
      noReceive.setAction(STOP_ACTION);
      PendingIntent pendingIntentNo = PendingIntent.getBroadcast(mContext, 12345, noReceive, PendingIntent.FLAG_UPDATE_CURRENT);
      mBuilder.addAction(R.drawable.ic_stat_notifications, "No", pendingIntentNo);


      Intent notificationIntent = new Intent(mContext, MainActivity.class);
      notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
      PendingIntent pintent = PendingIntent.getActivity(mContext, 12345, notificationIntent, 0);
      Notification notification = new Notification();
      if(notification.flags == Notification.FLAG_AUTO_CANCEL){

          resultPendingIntent = pintent;

      }
      else{
          resultPendingIntent = resultPendingIntent;
      }*//*


     // notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0).setAutoCancel(true).setContentTitle(title).setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentIntent(resultPendingIntent).setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_stat_notifications)).setContentText(message).build();

      */
/*notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0).setAutoCancel(true).setContentTitle(title).setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentIntent(pintent).setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_stat_notifications)).setContentText(message).build();
      notification.flags |= Notification.FLAG_AUTO_CANCEL;

*//*

    */
/* Notification notification = mBuilder.setSmallIcon(icon).setTicker(title).setWhen(0).setAutoCancel(true).setContentTitle(title).setStyle(new NotificationCompat.BigTextStyle().bigText(message)).setContentIntent(pintent).setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)).setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(), R.drawable.ic_stat_notifications)).setContentText(message).build();
      notification.flags |= Notification.FLAG_AUTO_CANCEL;

      NotificationManager notificationManager = (NotificationManager) mContext.getSystemService(Context.NOTIFICATION_SERVICE);

      notificationManager.notify(mNotificationId, notification);
  }*//*



  */
/**
 * NotificationManager notificationManager = (NotificationManager) context
 .getSystemService(Context.NOTIFICATION_SERVICE);
 Notification notification = new Notification(icon, message, when);

 Intent notificationIntent = new Intent(context, HomeActivity.class);

 notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
 | Intent.FLAG_ACTIVITY_SINGLE_TOP);

 PendingIntent intent = PendingIntent.getActivity(context, 0,
 notificationIntent, 0);

 notification.setLatestEventInfo(context, title, message, intent);
 notification.flags |= Notification.FLAG_AUTO_CANCEL;
 notificationManager.notify(0, notification);
 * *//*

}*/
