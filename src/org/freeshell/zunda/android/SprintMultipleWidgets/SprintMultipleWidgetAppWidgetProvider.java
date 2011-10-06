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

		final int nWidgets = appWidgetIds.length;

		RemoteViews widget = new RemoteViews(context.getPackageName(),
				R.layout.appwidget);

		for (int i = 0; i < nWidgets; i++) {
			widget.setTextViewText(R.id.textView, String.format("%d", i));
			appWidgetManager.updateAppWidget(appWidgetIds[i], widget);
		}

		super.onUpdate(context, appWidgetManager, appWidgetIds);
	}
}