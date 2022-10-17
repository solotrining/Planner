package com.example.projectsilsoup.network.alarm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.projectsilsoup.R
import com.example.projectsilsoup.view.activity.MainActivity

class AlarmReceiver : BroadcastReceiver() {

    private val channelId = "2000"
    private val channelName = "Schedule Review Alarm"


    private var notificationManager : NotificationManager? = null

    override fun onReceive(context : Context?, intent: Intent?) {
        notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        createChannel(context)
        build(context)
    }

    private fun createChannel(context: Context) {
        val channel = NotificationChannel(
            channelId,
            channelName,
            NotificationManager.IMPORTANCE_HIGH
        )

        channel.enableLights(true)
        channel.lightColor = androidx.appcompat.R.color.accent_material_light
        channel.enableVibration(true)
        channel.description = "계획 리뷰 알람"
        notificationManager?.createNotificationChannel(channel)
    }

    private fun build(context : Context) {
        val content = Intent(context, MainActivity::class.java)
        val contentPending = PendingIntent.getActivity(
            context,
            2000,
            content,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val builder = Notification.Builder(context, channelId)
            .setSmallIcon(R.drawable.calendar)
            .setContentTitle("계획서")
            .setContentText("오늘 실행한 계획을 평가해 주세요!")
            .setContentIntent(contentPending)
            .setAutoCancel(true)

        notificationManager?.notify(2000,builder.build())
    }


}