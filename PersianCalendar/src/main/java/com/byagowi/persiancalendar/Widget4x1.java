package com.byagowi.persiancalendar;

import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.byagowi.persiancalendar.service.ApplicationService;
import com.byagowi.persiancalendar.util.UpdateUtils;
import com.byagowi.persiancalendar.util.Utils;

/**
 * 4x1 widget provider, implementation is on {@code CalendarWidget}
 *
 * @author ebraminio
 */
public class Widget4x1 extends AppWidgetProvider {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Utils.getInstance(context).isServiceRunning(ApplicationService.class)) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
                context.startForegroundService(new Intent(context, ApplicationService.class));
            context.startService(new Intent(context, ApplicationService.class));
        }
        UpdateUtils.getInstance(context).update(true);
    }
}
