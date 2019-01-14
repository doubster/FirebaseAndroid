package com.example.doubea.firebasekitchensink.Utils;

/**
 * Created by doubea on 9/7/17.
 */

public class Constants {

    public static class EventTags {
        public static String MainActivityCreated = "MainActivity_Created";
        public static String LoggingActivityCreated = "LoggingActivity_Created";
        public static String CrashActivityCreated = "CrashActivity_Created";
        public static String StorageActivityCreated = "StorageActivity_Created";
        public static String LoggingUsername = "LoggingActivity_Username";
        public static String LoggingEmail = "LoggingActivity_Email";
        public static String LoggingSignUp = "LoggingActivity_Signup";
        public static String CrashArithmeticError = "CrashArithmeticError";
        public static String AuthenticationActivityCreated = "AuthenticationActivityCreated";
        public static String AuthenticationCreationFailed = "Authentication_Creation_Failed";
        public static String AuthenticationLoginFailed = "Authentication_Login_Failed";
    }

    public static class Description {
        public static String EventLogging = "By pressing the button above, \n You are sending the username \n and the email to the Firebase Console.\n Events provide insight on what is \n happening in your app, such as \n user actions, system events, or errors. ";
    }
}
