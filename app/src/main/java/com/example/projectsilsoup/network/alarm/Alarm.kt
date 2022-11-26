package com.example.projectsilsoup.network.alarm

import android.app.*
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import com.example.projectsilsoup.R
import com.example.projectsilsoup.view.activity.MainActivity
import com.example.projectsilsoup.view.activity.RatingActivity

class Alarm : BroadcastReceiver() {
    lateinit var manage : NotificationManager
    lateinit var builder: NotificationCompat.Builder

    private val channel_ID = "channel1"
    private val channel_name = "channel1"

    override fun onReceive(context: Context?, intent: Intent?) {
        var am = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        manage = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val importance = NotificationManager.IMPORTANCE_DEFAULT

        val notificationChannel = NotificationChannel(channel_ID, "name", importance)

        notificationChannel.enableLights(true)
        notificationChannel.enableVibration(true)
        notificationChannel.vibrationPattern = longArrayOf(100L, 200L, 300L)
        manage.createNotificationChannel(notificationChannel)

        builder = NotificationCompat.Builder(context, channel_ID)

        val intent1 = Intent(context, RatingActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        val pending = PendingIntent.getActivity(context,0, intent1,PendingIntent.FLAG_IMMUTABLE)

        builder.setContentTitle("오늘 계획은 잘 지키셨나요?")
        builder.setContentText("그럼 별점을 매겨보세요")
        builder.setSmallIcon(R.drawable.pen)
        builder.priority = NotificationCompat.PRIORITY_DEFAULT
        builder.setContentIntent(pending).setAutoCancel(true)
        val notification = builder.build()
        manage.notify(1, notification)
    }
}