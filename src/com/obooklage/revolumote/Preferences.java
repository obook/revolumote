/* 
 * Project : Revolumote
 * Author : obooklage
 *
 * Last commit by $Author: obooklage $
 * Date - $Date: 2014-07-25 01:52:28 +0200 (ven. 25 juil. 2014) $
 * Revision - $Rev: 9 $
 * Id : $Id: Preferences.java 9 2014-07-24 23:52:28Z obooklage $
 *
 *
 *
*/

package com.obooklage.revolumote;

import com.obooklage.revolumote.R;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.util.Log;


public class Preferences  extends PreferenceActivity implements OnSharedPreferenceChangeListener{
	
	private static final String editTextRemoteCode = "editTextRemoteCode";
	
	private static final String TAG = "revolumote.Preferences";	
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   addPreferencesFromResource(R.xml.preferences);
       // Get a reference to the preferences
	   updatePreference(editTextRemoteCode);
	}

	@SuppressWarnings("deprecation")
	@Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG,"onResume");
        // Set up a listener whenever a key changes            
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG,"onPause");
		// Unregister the listener whenever a key changes
		getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
	}

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
		
    	Log.v(TAG,"onSharedPreferenceChanged: " + key);
		
		updatePreference(key);
    }

	@SuppressWarnings("deprecation")
	private void updatePreference(String key){

		if (key.equals(editTextRemoteCode)){
			Preference preference = findPreference(key);
			if (preference instanceof EditTextPreference){
				EditTextPreference editTextPreference =  (EditTextPreference)preference;
				if (editTextPreference.getText().trim().length() > 0){
					editTextPreference.setSummary( getString(R.string.pref_code_set) + " " + editTextPreference.getText());
				}else{
					editTextPreference.setSummary( getString(R.string.pref_code_sum) );
				}
			}
		}
		
	}
}
