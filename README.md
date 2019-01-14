# README #

## Description ##
Firebase is a mobile and web application development platform developed by Firebase, Inc. in 2011, then acquired by Google in 2014. 
Firebase allows to track analytics, crash reports, log reports of your mobile app, similar to Hockey App or Mobile Azure. 

## App  Description##
The Firebase app is created in Java. It is a kitchen sink, meaning its objective is to demonstrate all the possible capabilities of Firebase inside of an app.  
It demonstrates the following features: 
* Logging 
* Crash Reporting 
* Notifications 
* Storage
* Test Lab 
* Realtime Database 
* Remote Configuration


## Timeline ##
### Training Part 1 ###
* 8h - Onboarding. Create repo. Create app and Read Big Ranch Book. Start Readme in repo.  
* 2h - Implement Firebase in App  (Create perifcient firebase account, so the account is accessible elsewhere. )
* 22h - Implement app to show content on Firebase
    * 4 hours – Implement Logging
    * 4 hours – Implement Crashes
    * 4 hours – Implement notifications
    * 6 hours – Database/Storage Feature of Firebase
    * 4 hours – View Performance and how to update (Errors with Performance)
* 4 hours – Refine everything. Wrap it up.  Update Readme in Repo with screenshots

### Training Part 2 ###
* 2h – Setup Firebase Test Lab
* 8h – Implement Espresso for unit testing in app
* 2h – Setup Firebase Database
* 8h – Implement Database in app (realtime)
* 2h – Setup remote config
* 4h – Implement remote config

## Resources ## 

[Firebase Documentation](https://firebase.google.com/docs/)

[Android Development](https://developer.android.com)

[Espresso](https://developer.android.com/training/testing/espresso)


## How to implement Firebase in your app ##
Create Your Android project and add Firebase to your application. 
It may take couple hours to start getting crashes on Firebase Console. 
Tip: Use the Firebase UI from the Tools option in Android Studio. It will add the libraries needed to your gradle automatically. 

This is the Dashboard of the application. Each button leads to a section that demonstrate features of Firebase. 

![Dashboard Page](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/93d5cd65130771981661451e6169c6e4bc3e7bd5/Images/Emulator_Dashboard.png?token=07f0abe46255edfae5ef20162abbf50f28a58c7f)

## Logging ##
Upon each activity creation, a log event is triggered. 

![Dashboard Card](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_dashboard_eventCard.png?token=51e57d7a9eb5121f194b84522b41e75d856d75a6)

![Events](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_events.png?token=430c6aa7df59d381abf68cd2f5ac874feb29bbbf)

### Logging with Parameters ###
In the app, user can enter a username and an e-mail. Both are sent to the Logging. 
On the console, the username and e-mail entered show up as part of the log. 

![Logging Emulator Page](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/logging.png?token=7965c6b8976b06c7c4532c35b2b9a9e54ce33a37)

![Events with parameters](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_events_withparams.png?token=06c9cbb84103fbb742665dbce36357f6fc30a9b1)

## Crash Reporting ##
Crash page sends an arithmetic crash to the console by dividing 9 by 0. 

![Crash Reporting](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/crash.png?token=520a35eff9d8314621c569f121ae43c14a8c5cc7)

![Crash Reporting Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/1d2891dbcfd5702a07e8b560bb2ac60818264762/Images/console_crash.png?token=a6b7dc42234f51a12e140a6f8f8010e96da8501a)


## How to authenticate a user by creating a user account that is then stored in Firebase ## 

On the authentication page, you have the option to register for a new account or login to a previous account. 
If the account entered exists, user will be logged in. If the account does not exist, user will be registered. 
Authentication is needed to do things like Storage and Realtime Database. 

See [Video Demo](https://bitbucket.org/bluetube/doubea-pierre-android-firebase/src/bda08da43fdcb5854f6adba08ceda054756cc57e/Videos/AuthenticationDemo_Login_Logout_Register.mov?at=master)

![Authentication Not Logged in Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/f824d1bde1b369f504c5446bae3425dde94c43d8/Images/Authentication_NotLoggedIn.png?token=6f286a1695ef68ae388ae6b5162eb4101831722d)

![Authentication Logged in Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/f824d1bde1b369f504c5446bae3425dde94c43d8/Images/Authentication_LoggedIn.png?token=d8d01ea67a5e1bf2c6d714159d86339885f2e831)

![Authentication Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_authentication.png?token=e0669be2d2730a569db708655a9657f56dc0293c)

## How to handle notifications on the app ##

Notifications can be sent from the console. Notifications don't work on emulators, only work on physical device. 

![Notification Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_notification.png?token=c8fdd5880c1ad1e56c49b645672a4871b3e9d56a)

## How to implement storage and upload image to Firebase ##

User can select an image and upload to the storage in Firebase. User must be authenticated before they can start uploading. 
See [Video Demo](https://bitbucket.org/bluetube/doubea-pierre-android-firebase/src/93d5cd65130771981661451e6169c6e4bc3e7bd5/Videos/Storage_Demo.mov?at=master)

![Storage Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/93d5cd65130771981661451e6169c6e4bc3e7bd5/Images/Emulator_Storage.png?token=02e7922d9a0144371dd86f332c99b69286e7d088)

![Console Storage](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c69344a0da935435e4d0278100dda466454a5929/Images/console_storage_image.png?token=33b7efd0ff2c5b020ca74b24015bee6eeed45022)


## Performance ##

There were some issues with the Performance libraries, as it is in beta currently and the libraries were not compatible with the current Firebase version that was being used. 
It can be looked at some more in the future, once Performance is a bit more stable. 


## RealTime Database ## 

User can view the contacts in the contacts List, add/edit contact. All the contacts are synced in real time to the console. Changes to the console are immediately shown on the device.  
Changes to the contacts in the emulator are immediately available in the console. See [Video Demo](https://bitbucket.org/bluetube/doubea-pierre-android-firebase/src/93d5cd65130771981661451e6169c6e4bc3e7bd5/Videos/RealTimeDatabase_Demo.mov?at=master)

![Contact List Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/93d5cd65130771981661451e6169c6e4bc3e7bd5/Images/Emulator_ContactList.png?token=ecae5e844de386aa4db9e95bc19068d485ba5241)

![Contact Add new Contact Emulator](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Contact_Create.png?token=9ce3d875602c725b0a2129991c6f8615eb90ca63)

![Realtime Database Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/c79369430b1c123a6024c97930ca9130011a5a14/Images/Console_Database.png?token=4edb86d56a1a31995f2f1c3f4239b7efaa37f1d9)


## Remote Config ##

Depending on the language of the device, the text in the center will change based on the remote config found on Firebase. Changes done in the console, need to be published and will be synced to the device. 
See [Video Demo](https://bitbucket.org/bluetube/doubea-pierre-android-firebase/src/93d5cd65130771981661451e6169c6e4bc3e7bd5/Videos/RemoteConfig_Demo.mov?at=master)

![Remote Config Emulator English](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/RemoteConfig_English.png?token=38adc1799310c609a54d04f8bb90ea3f37872c91)

![Remote Config Emulator Spanish](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/RemoteConfig_Spanish.png?token=c1ba74d09720a3585421d9147b52f9295f76b3b1)

![Remote Config Emulator French](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/RemoteConfig_French.png?token=ca51f9a8de830d0f4f97cf8294d7fd331b8612a9)

![Remote Config Parameters](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Console_RemoteConfig_Parameter.png?token=2fd780d697843a0a618e900201cfcb8d40ec9071)

## Test Lab ##

Added Espresso to the Android Project. Created a couple tests. 
Create the APK and the APK test and upload to Test Lab. Select the devices you want to test on and run the test.

![Unit Test APK Upload](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Console_RemoteConfig_APK.png?token=7d93b7702dabf0802a26a94d9bbd517b0e0f0731)

![Test Lab List of Tests Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Console_TestLab_ListofTests.png?token=b2e2f6fba9a94b078b6504174ec42fa6329b6c5b)

![Test Lab List of Devices Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Console_RemoteConfig_TestingComplete.png?token=a459466ce5ef6f4af0afa5b34fec159b6e3dddb6)

![Test Lab Device Detail Console](https://bytebucket.org/bluetube/doubea-pierre-android-firebase/raw/964d8adbd4977d237c38442a69402524962fea52/Images/Console_TestLab_Device_Tests.png?token=5a7ce2e6093f28b65ca0bb95bc7e198d3639b8fc)

## Cloud Messaging ## 

Not implemented but it would be great to implement in the future. 

## Contact Doubea Pierre for more info ##
doubea.pierre@perficient.com