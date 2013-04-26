package com.example.acelearning;

import java.util.Iterator;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);

		Log.v("Sub", "onCreate()");

		Intent data = getIntent();
		Bundle extras = data.getExtras();
		String item = extras.getString("item");

		TextView tv = (TextView) findViewById(R.id.result_field);

		tv.setText(item);
		
		Button button = (Button) findViewById(R.id.finish_button);
		button.setOnClickListener(new ButtonClickListener());
	}
	
	class ButtonClickListener implements OnClickListener {

		public void onClick(View v) {
			finish();
		}
	}
	@Override
	protected void onStart() {
		super.onStart();
		
		Log.v("Sub", "onStart()");
		
		Intent i = getIntent();
		
		if(i != null){
			Bundle bundle = getIntent().getExtras();
			if(bundle != null){
				Iterator<String> keys = bundle.keySet().iterator();
				while(keys.hasNext()){
					Log.v("Sub getIntent().getExtras()", "key -> " + keys.next());
				}
			}
			Log.v("Sub getIntent().getAction()", "action  -> " + getIntent().getAction());
			Log.v("Sub getIntent().getData()", "data  -> " + getIntent().getData());
			Log.v("Sub getIntent().getDataString()","dataString -> " + getIntent().getDataString());
		}
		
		
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.v("Sub", "onResume()");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.v("Sub", "onStart()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v("Sub", "onRestart()");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.v("Sub", "onStop()");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("Sub", "onDestroy()");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
		return true;
	}

}
