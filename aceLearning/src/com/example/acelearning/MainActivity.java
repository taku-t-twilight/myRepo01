package com.example.acelearning;

import java.util.Iterator;
import java.util.Set;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {
	private static final int LAUNCHED_ACTIVITY = 1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v("Main", "onCreate()");

		ListView listview = (ListView) findViewById(R.id.day_array);
		if(listview != null){
			listview.setOnItemClickListener(new ListItemClickListener());
		}
		
		Intent intent = getIntent();
		if(intent != null){
//		Log.v("DebugLine","A");
			Log.v("MainActivity Intent ", intent.getAction());
//		Log.v("DebugLine","B");
			Log.v("Intent component flatten", intent.getComponent().flattenToString());
			Log.v("Intent component getClassName",intent.getComponent().getClassName());
			Log.v("Intent component getPackageName",intent.getComponent().getPackageName());
			Log.v("Intent component getShortClassName",intent.getComponent().getShortClassName());
//			Log.v("MainActivity Intent ",intent.getScheme());
//			Log.v("MainActivity Intent ",intent.getPackage());
//		Log.v("DebugLine","C");
//			Log.v("MainActivity Intent ",intent.getDataString());
//			Log.v("MainActivity Intent ",intent.getExtras().keySet().toString());
//		Log.v("DebugLine","D");
			Set<String> intentCategories = intent.getCategories();
			Iterator<String> ic = intentCategories.iterator();
			while(ic.hasNext()){
				Log.v("MainActivity categories",ic.next());
			}
		}
	}

	class ListItemClickListener implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//			Log.v("MainActivity:onItemClick","OnClick Event is received. Clicked position was " + position );
			ListView listview = (ListView) parent;
//			Log.v("MainActivity:onItemClick","parent ID - " + parent.getId());
//			Log.v("MainActivity:onItemClick","View   ID - " + view.getId());
			String item = (String) listview.getItemAtPosition(position);
			
//			Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
			
			Intent intent = new Intent(MainActivity.this, NextActivity.class);
			intent.putExtra("item", item);
//			startActivity(intent);
			startActivityForResult(intent, LAUNCHED_ACTIVITY);
		}
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.v("Main", "onStart()");
	}
	@Override
	protected void onResume() {
		super.onResume();
		Log.v("Main", "onResume()");
	}
	@Override
	protected void onPause() {
		super.onPause();
		Log.v("Main", "onStart()");
	}
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v("Main", "onRestart()");
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.v("Main", "onStop()");
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v("Main", "onDestroy()");
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		Log.v("Main", "onActivityResult() : requestCode = " + requestCode + ", resultCode = " + resultCode);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
