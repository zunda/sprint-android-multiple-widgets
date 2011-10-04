package org.freeshell.zunda.android.SprintMultipleWidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SprintMultipleWidgetsActivity extends Activity {
	private final String LogTag = "SprintMultipleWidgetsActivity";
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Log.v(LogTag, "onCreate()");
		setContentView(R.layout.main);

		((Button) findViewById(R.id.toastButton))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						startSprintMultipleWidgetsService();
					}
				});
	}
	
	private void startSprintMultipleWidgetsService() {
		Log.v(LogTag, "startSprintMultipleWidgetsService()");
		Intent intent = new Intent();
		intent.setClass(this, SprintMultipleWidgetsService.class);
		intent.putExtra("MSG", "Hello, World!");		
		startService(intent);
	}
}