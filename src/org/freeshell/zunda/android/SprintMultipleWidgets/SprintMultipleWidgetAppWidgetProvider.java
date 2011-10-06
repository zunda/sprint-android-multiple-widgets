package org.freeshell.zunda.android.SprintMultipleWidgets;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class SprintMultipleWidgetAppWidgetProvider extends AppWidgetProvider {
	private final String LogTag = "SprintMultipleWidgetAppWidgetProvider";

	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		Log.v(LogTag, "onUpdate()");

		RemoteViews widget = new RemoteViews(context.getPackageName(),
				R.layout.appwidget);
		widget.setTextViewText(R.id.textView, "Hello");

		appWidgetManager.updateAppWidget(appWidgetIds[0], widget);

		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}