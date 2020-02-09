package com.retailboosters.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Pref {

	public static String AUTH_TOKEN_KEY = "auth_token";
	public static String USER_ID_KEY = "user_id";
	public static String FIRST_NAME = "first_name";

	public static String MOBILE_NO = "mobile_no";
	public static String LOAN_ID = "loan_id";
	public static String DROP_DOWN_KEY = "drop_down_key";
	public static String WHERE_WORK = "where_work";
	public static String REGISTRATION_STEP = "regi_step";
	public static String STEP_1_RESPONSE = "step_1_response";
	public static String STEP_2_RESPONSE = "step_2_response";
	public static String STEP_3_RESPONSE = "step_3_response";
	public static String STEP_4_RESPONSE = "step_4_response";

	
	public static void saveBooleanPref(Context context , String key, boolean value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putBoolean(key, value);
		editor.commit();
	}
	public static void saveIntPref(Context context , String key, int value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putInt(key, value);
		editor.commit();
	}


	
	public static void saveStringPref(Context context ,String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}
	
	
	public static String loadStringPref(Context context,String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		String name = sharedPreferences.getString(key,null);
		
		return name;
		
	}

	public static boolean loadBooleanPref(Context context,String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		boolean name = sharedPreferences.getBoolean(key,false);
		
		return name;
		
	}
	public static int loadIntPref(Context context,String key) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(context);
		int name = sharedPreferences.getInt(key,-1);
		
		return name;
		
	}

	
}
