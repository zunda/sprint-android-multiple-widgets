package org.freeshell.zunda.android.SprintMultipleWidgets;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class SprintMultipleWidgetAppWidgetProvider extends AppWidgetProvider {
	private final String LogTag = "SprintMultipleWidgetAppWidgetProvider";

	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.v(LogTag, "onUpdate()");

		final int nWidgets = appWidgetIds.length;

		for (int i = 0; i < nWidgets; i++) {
			int appWidgetId = appWidgetIds[i];
			String info = "i:" + i + " appWidgetId:" + appWidgetId;

			Log.v(LogTag, info);
			Intent intent = new Intent(context, SprintMultipleWidgetsService.class);
			intent.putExtra("MSG", info);
			PendingIntent pendingIntent = PendingIntent.getService(context, 0, intent, 0);

			RemoteViews widget = new RemoteViews(context.getPackageName(),
					R.layout.appwidget);
			widget.setOnClickPendingIntent(R.id.textView, pendingIntent);
			widget.setTextViewText(R.id.textView, String.format("%d %d", i, appWidgetId));

			appWidgetManager.updateAppWidget(appWidgetId, widget);
		}

		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}