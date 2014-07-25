/* 
 * Project : Revolumote
 * Author : obooklage
 *
 * Last commit by $Author: obooklage $
 * Date - $Date: 2014-07-25 01:52:28 +0200 (ven. 25 juil. 2014) $
 * Revision - $Rev: 9 $
 * Id : $Id: MainActivity.java 9 2014-07-24 23:52:28Z obooklage $
 *
 *
 *
*/

package com.obooklage.revolumote;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import com.obooklage.revolumote.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, OnLongClickListener {

	private static String TAG ="revolumote.MainActivity";
	Intent myIntent = null;
    SharedPreferences prefs = null;
    private String editTextRemoteCode = "";
    private int pref_fontsize_modifier = 0;
    private static int PREFS_UNIQUEID = 461479;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE); /* Pas de BARRE du dessus */

		/*
		 * Interface
		 */
			
		setContentView(R.layout.activity_main);
		
		/* 
 	    * Preferences
 	    * */
 	   
		InitApplication();
	
	}
	
	@Override
	public void onClick(View v) {
		Log.d(TAG,"onClick key " + v.getId());
		if (v.getId() == R.id.button_1) {
			SendKey("1",false);
		}
		else if (v.getId() == R.id.button_2) {
			SendKey("2",false);
		}	
		else if (v.getId() == R.id.button_3) {
			SendKey("3",false);
		}
		else if (v.getId() == R.id.button_4) {
			SendKey("4",false);
		}
		else if (v.getId() == R.id.button_5) {
			SendKey("5",false);
		}
		else if (v.getId() == R.id.button_6) {
			SendKey("6",false);
		}
		else if (v.getId() == R.id.button_7) {
			SendKey("7",false);
		}
		else if (v.getId() == R.id.button_8) {
			SendKey("8",false);
		}
		else if (v.getId() == R.id.button_9) {
			SendKey("9",false);
		}
		else if (v.getId() == R.id.button_0) {
			SendKey("0",false);
		}
		else if (v.getId() == R.id.button_ok) {
			SendKey("ok",false);
		}
		else if (v.getId() == R.id.button_power) {
			SendKey("power",false);
		}	
		else if (v.getId() == R.id.button_vol_inc) {
			SendKey("vol_inc",false);
		}
		else if (v.getId() == R.id.button_vol_dec) {
			SendKey("vol_dec",false);
		}
		else if (v.getId() == R.id.button_prgm_inc) {
			SendKey("prgm_inc",false);
		}
		else if (v.getId() == R.id.button_prgm_dec) {
			SendKey("prgm_dec",false);
		}
		else if (v.getId() == R.id.button_up) {
			SendKey("up",false);
		}
		else if (v.getId() == R.id.button_down) {
			SendKey("down",false);
		}
		else if (v.getId() == R.id.button_left) {
			SendKey("left",false);
		}
		else if (v.getId() == R.id.button_right) {
			SendKey("right",false);
		}
		else if (v.getId() == R.id.button_home) {
			SendKey("home",false);
		}		
		else if (v.getId() == R.id.button_mute) {
			SendKey("mute",false);
		}	
		else if (v.getId() == R.id.button_blue) {
			SendKey("blue",false);
		}	
		else if (v.getId() == R.id.button_green) {
			SendKey("green",false);
		}	
		else if (v.getId() == R.id.button_red) {
			SendKey("red",false);
		}	
		else if (v.getId() == R.id.button_yellow) {
			SendKey("yellow",false);
		}	
		else if (v.getId() == R.id.button_play) {
			SendKey("button_play",false);
		}	
		else if (v.getId() == R.id.button_rec) {
			SendKey("rec",false);
		}	
	}

	@Override
	public boolean onLongClick(View v) {
		Log.d(TAG,"onLongClick key " + v.getId());
		
		if (v.getId() == R.id.button_1) {
			SendKey("1",true);
		}
		else if (v.getId() == R.id.button_2) {
			SendKey("2",true);
		}	
		else if (v.getId() == R.id.button_3) {
			SendKey("3",true);
		}
		else if (v.getId() == R.id.button_4) {
			SendKey("4",true);
		}
		else if (v.getId() == R.id.button_5) {
			SendKey("5",true);
		}
		else if (v.getId() == R.id.button_6) {
			SendKey("6",true);
		}
		else if (v.getId() == R.id.button_7) {
			SendKey("7",true);
		}
		else if (v.getId() == R.id.button_8) {
			SendKey("8",true);
		}
		else if (v.getId() == R.id.button_9) {
			SendKey("9",true);
		}
		else if (v.getId() == R.id.button_0) {
			SendKey("0",true);
		}
		else if (v.getId() == R.id.button_ok) {
			SendKey("ok",true);
		}
		else if (v.getId() == R.id.button_power) {
			SendKey("power",true);
		}	
		else if (v.getId() == R.id.button_vol_inc) {
			SendKey("vol_inc",true);
		}
		else if (v.getId() == R.id.button_vol_dec) {
			SendKey("vol_dec",true);
		}
		else if (v.getId() == R.id.button_prgm_inc) {
			SendKey("prgm_inc",true);
		}
		else if (v.getId() == R.id.button_prgm_dec) {
			SendKey("prgm_dec",true);
		}
		else if (v.getId() == R.id.button_up) {
			SendKey("up",true);
		}
		else if (v.getId() == R.id.button_down) {
			SendKey("down",true);
		}
		else if (v.getId() == R.id.button_left) {
			SendKey("left",true);
		}
		else if (v.getId() == R.id.button_right) {
			SendKey("right",true);
		}
		else if (v.getId() == R.id.button_home) {
			SendKey("home",true);
		}		
		else if (v.getId() == R.id.button_mute) {
			SendKey("mute",true);
		}	
		else if (v.getId() == R.id.button_blue) {
			SendKey("blue",true);
		}	
		else if (v.getId() == R.id.button_green) {
			SendKey("green",true);
		}	
		else if (v.getId() == R.id.button_red) {
			SendKey("red",true);
		}	
		else if (v.getId() == R.id.button_yellow) {
			SendKey("yellow",true);
		}	
		else if (v.getId() == R.id.button_play) {
			SendKey("button_play",true);
		}	
		else if (v.getId() == R.id.button_rec) {
			SendKey("rec",true);
		}
		
		return true;
	}
	
	private void SendKey(String Key, boolean longpress)
	{
		editTextRemoteCode = prefs.getString("editTextRemoteCode", "");
		if(editTextRemoteCode.contentEquals(""))
		{
			Toast.makeText(this, getString(R.string.main_code_missing), Toast.LENGTH_SHORT).show();
			return;
		}
		
		String serverurl = "http://hd1.freebox.fr/pub/remote_control?code=" + editTextRemoteCode;	
		if( longpress == true )
			serverurl = serverurl + "&long=true";

		grabURL(serverurl + "&key="+ Key);			

	}
	
    public void grabURL(String url) {
        GrabURL grabURL = new GrabURL();
        grabURL.execute(url);
    }
    

	/*
	 * Sendkey via http
	 * 
	 * */
	
    private class GrabURL extends AsyncTask<String, Void, Void> {
        private final HttpClient Client = new DefaultHttpClient();
        
        private String Error = null;

        protected Void doInBackground(String... urls) {
            try {
                HttpGet httpget = new HttpGet(urls[0]);
                Log.d(TAG,"doInBackground : " + urls[0]);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                Client.execute(httpget, responseHandler);
            } catch (ClientProtocolException e) {
                Error = e.getMessage();
                cancel(true);
            } catch (IOException e) {
                Error = e.getMessage();
                cancel(true);
            }

            return null;
        }

        protected void onPostExecute(Void unused) {
            if (Error != null) {
            	Log.e(TAG,"onPostExecute : " + Error);
                Toast.makeText(MainActivity.this, Error, Toast.LENGTH_LONG).show();
            }
        }

    }
	
	@Override
	public void onBackPressed()
	{
		Log.d(TAG,"onBackPressed");
		this.finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
    
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		Log.d(TAG,"onMenuItemSelected");

		switch (item.getItemId()) {
		case R.id.menu_settings:
            Intent intent = new Intent(MainActivity.this, Preferences.class);
            startActivityForResult(intent,PREFS_UNIQUEID);
			break;
			
		case R.id.menu_fontplus:
			SetAllFontSize(+4,true);
			break;
			
		case R.id.menu_fontminus:
			SetAllFontSize(-4,true);
			break;
			
		case R.id.menu_quit:
			Log.d(TAG,"onMenuItemSelected.menu_quit");
			this.finish();
			break;
			
		}
		
		return super.onMenuItemSelected(featureId, item);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		Log.d(TAG,"onActivityResult");
		
		if(requestCode == PREFS_UNIQUEID)
		{
			Toast.makeText(this, getString(R.string.main_set_saved), Toast.LENGTH_SHORT).show();
			InitApplication();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	private void SetAllFontSize(int inc, boolean save)
	{
		FontSize(R.id.button_1,inc);
		FontSize(R.id.button_2,inc);
		FontSize(R.id.button_3,inc);
		FontSize(R.id.button_4,inc);
		FontSize(R.id.button_5,inc);
		FontSize(R.id.button_6,inc);
		FontSize(R.id.button_7,inc);
		FontSize(R.id.button_8,inc);
		FontSize(R.id.button_9,inc);
		FontSize(R.id.button_0,inc);
		
		FontSize(R.id.button_ok,inc);
		FontSize(R.id.button_power,inc);
		FontSize(R.id.button_vol_inc,inc);
		FontSize(R.id.button_vol_dec,inc);
		FontSize(R.id.button_prgm_inc,inc);
		FontSize(R.id.button_prgm_dec,inc);
		
		FontSize(R.id.button_up,inc);
		FontSize(R.id.button_down,inc);
		FontSize(R.id.button_left,inc);
		FontSize(R.id.button_right,inc);

		FontSize(R.id.button_home,inc);
		FontSize(R.id.button_blue,inc);
		FontSize(R.id.button_green,inc);
		FontSize(R.id.button_red,inc);
		FontSize(R.id.button_yellow,inc);
		
		FontSize(R.id.button_mute,inc);
		
		FontSize(R.id.button_play,inc);
		FontSize(R.id.button_rec,inc);		
		
		/* Save setting */
		
		if( save == true )
		{
			pref_fontsize_modifier = pref_fontsize_modifier + inc;
			
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
			SharedPreferences.Editor editor = prefs.edit();
			editor.putInt("pref_fontsize_modifier", pref_fontsize_modifier);
			editor.commit();
		}
	}
	
	private void FontSize(int index,int inc)
	{
		Button testButton = (Button) findViewById(index);
		float size = testButton.getTextSize();
		testButton.setTextSize(TypedValue.COMPLEX_UNIT_PX, size + (inc));
	}
	
	private void InitApplication()
	{
		prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		
        /*
         * Font size modifier
         */
		
		pref_fontsize_modifier = prefs.getInt("pref_fontsize_modifier",0);
		
		if( pref_fontsize_modifier != 0 )
		{   
			SetAllFontSize(pref_fontsize_modifier,false);
		}
		
		/*
		 * Get remote code
		 */
		
		editTextRemoteCode = prefs.getString("editTextRemoteCode", "");
				
		if( editTextRemoteCode.contentEquals(""))
		{
			Toast.makeText(this, getString(R.string.main_code_missing), Toast.LENGTH_LONG).show();
		}
		
		SetonClick(R.id.button_1);
		SetonClick(R.id.button_2);
		SetonClick(R.id.button_3);
		SetonClick(R.id.button_4);
		SetonClick(R.id.button_5);
		SetonClick(R.id.button_6);
		SetonClick(R.id.button_7);
		SetonClick(R.id.button_8);
		SetonClick(R.id.button_9);
		SetonClick(R.id.button_0);
		
		SetonClick(R.id.button_ok);
		SetonClick(R.id.button_power);
		SetonClick(R.id.button_vol_inc);
		SetonClick(R.id.button_vol_dec);
		SetonClick(R.id.button_prgm_inc);
		SetonClick(R.id.button_prgm_dec);
		
		SetonClick(R.id.button_up);
		SetonClick(R.id.button_down);
		SetonClick(R.id.button_left);
		SetonClick(R.id.button_right);

		SetonClick(R.id.button_home);
		SetonClick(R.id.button_blue);
		SetonClick(R.id.button_green);
		SetonClick(R.id.button_red);
		SetonClick(R.id.button_yellow);
		
		SetonClick(R.id.button_mute);
		
		SetonClick(R.id.button_play);
		SetonClick(R.id.button_rec);
	}

	
	private void SetonClick(int buttinid)
	{
		findViewById(buttinid).setOnClickListener(this);
		findViewById(buttinid).setOnLongClickListener(this);
	}
}
