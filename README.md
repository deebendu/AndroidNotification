# AndroidNotification
Library for Android Notification

# Sending Push Notifications to Android with Firebase

Before We Start
You'll need the following:

The latest stable Android Studio

A Firebase account

1. Get started
Add a new project or import an existing project to Firebase console.

If you choose to create a new project, you need to set the project name and country. For example, I will call my project FirebaseDemo.

Then select "Add Firebase to your Android app".


Set a package name for your app. I only set my package name and omit the SHA-1 because I don't use Firebase for my app's authentication.

Click the ADD APP button here to download google-services.json. This is an important file and you will need to put it into your app.

2. Add google-services.json to your app folder

Replace the google-services.json in your app folder. 

The Google services plugin for Gradle will load the google-services.json file you just downloaded.

3. Configure gradle files
Open Android Studio and modify your build.gradle files to use the Google services plugin.


(3.1) Update the project-level build.gradle (the one in your project folder)
Add the following line to the build.gradle file:

    buildscript {
      dependencies { 
       classpath 'com.google.gms:google-services:3.1.1' // Add this line
      }
    }
    
(3.2) Update the app-level build.gradle (the one in your project/your app-module)

(a) Add this line to the bottom of the build.gradle file

    apply plugin: 'com.google.gms.google-services'
    
(b) Add Firebase related dependencies

And Firebase related dependencies under dependencies in the same build.gradle file.

    dependencies {
     compile 'com.google.firebase:firebase-core:11.8.0'   // this line must be included to integrate with Firebase
     compile 'com.google.firebase:firebase-messaging:11.8.0' //// this line must be included to use FCM    
    }
    
(c) Update services using com.google.android.gms:play-services

If you add Firebase into an existing project which uses any function of gms:play-services, such as gps location,
you have to update their versions, too. If you get compilation problems, you need to check find out the correct version number.

    compile 'com.google.android.gms:play-services-location:11.8.0'  
    compile 'com.google.android.gms:play-services-places:11.8.0'  
    
(d) Add the applicationId to the defaultConfig section

    android {
      defaultConfig {
         applicationId "com.example.my.app"  // this is the id that your app has
      }
    }
    
4. Add services to your app

Two services should be added to use Firebase Cloud Messaging service: a basic code for testing if push notification works, and other codes to handle receiving message or sending message in your app according to your design.

(1) Add a service that extends FirebaseMessagingService

To be able to receive any notification in your app, you should add a service which extends FirebaseMessagingService like this:

    public class MyFirebaseMessagingService extends FirebaseMessagingService {
     private static final String TAG = "FCM Service";
     @Override
       public void onMessageReceived(RemoteMessage remoteMessage) {
           // TODO: Handle FCM messages here.
           // If the application is in the foreground handle both data and notification messages here.
           // Also if you intend on generating your own notifications as a result of a received FCM
           // message, here is where that should be initiated.
           Log.d(TAG, "From: " + remoteMessage.getFrom());
           Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
      }
    }
    
Then add it into the AndroidManifest.xml file.

        <service android:name=".MyFirebaseMessagingService">
            <intent-filter>
                <action android:name="com.google.firebase.MESSAGING_EVENT"/>
            </intent-filter>
        </service>
        
(2) Add a service that extends FirebaseInstanceIdService

    public class FirebaseIDService extends FirebaseInstanceIdService {
       private static final String TAG = "FirebaseIDService";
       @Override
       public void onTokenRefresh() {
            // Get updated InstanceID token.
            String refreshedToken = FirebaseInstanceId.getInstance().getToken();
            Log.d(TAG, "Refreshed token: " + refreshedToken);
            // TODO: Implement this method to send any registration to your app's servers.
            sendRegistrationToServer(refreshedToken);
       }
       private void sendRegistrationToServer(String token) {
            // Add custom implementation, as needed.
        }
    }

Add it into the AndroidManifest.xml file, this makes sure that the service is loaded

        <service android:name=".FirebaseIDService">
            <intent-filter>
                <action android:name="com.google.firebase.INSTANCE_ID_EVENT"/>
            </intent-filter>
        </service>
        
        
5. Add these two lines in your MainActivity
    
        AppConstant.setmContext(MainActivity.this);
        AppConstant.setIntent(new Intent(MainActivity.this, MainActivity.class));
        
6. Test and send your first push notification!

To see if the setup works, run a test by sending a test message to your own mobile.


Write down your message and choose an app. Click "SEND MESSAGE".


Now you should get a push notification on your Android mobile. If your app is running on the background, you will get it on the mobile's notification center; otherwise you can see it in your Android Monitor log (we have to put a code to log incoming messages) like this.

If the setup is successful, you should get a notification on your mobile. Sometimes, it can take a couple of minutes.

We are done!
