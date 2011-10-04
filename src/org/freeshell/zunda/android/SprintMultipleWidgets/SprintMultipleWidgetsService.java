package org.freeshell.zunda.android.SprintMultipleWidgets;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class SprintMultipleWidgetsService extends Service {
	private final String LogTag = "SprintMultipleWidgetsService";

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.v(LogTag, "onStart()");

		if (intent == null)
			return;

		Bundle extras = intent.getExtras();
		if (extras != null) {
			Toast.makeText(getApplicationContext(), extras.getString("MSG"),
					Toast.LENGTH_SHORT).show();
		}
	}
}
