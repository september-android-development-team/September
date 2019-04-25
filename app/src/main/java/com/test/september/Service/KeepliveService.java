package com.test.september.Service;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import com.taobao.sophix.SophixManager;
import com.test.september.BuildConfig;
import com.test.september.util.Keepalive.KeepLiveManager;

/**
 * Created by carmelo on 2018/3/16.
 */

@SuppressLint("Registered")
public class KeepliveService extends Service{
//    /**
//     * 每10分钟检查一次链接状态，确保service不被杀掉
//     */
//    private static final int KEEP_ALIVE_INTERVAL = BuildConfig.DEBUG ? 60 * 1000 : 10 * 60 * 1000;
//    /**
//     * ACTION Start
//     */
//    private static final String ACTION_START = "MainService.Action.Start";
//    /**
//     * ACTION Alarm
//     */
//    private static final String ACTION_ALARM = "MainService.Action.Alarm";
//
//
//    private boolean mIsAddAliveAlarm = false;
    @Override
    public void onCreate() {
        super.onCreate();
        KeepLiveManager.getInstance().registerReceiver(this);

//        addAliveAlarm();
//        mIsAddAliveAlarm = true;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        KeepLiveManager.getInstance().setServiceForeground(this,this);

//        if (null != intent){
//            switch (intent.getAction()){
//                case ACTION_ALARM:
//
//                    break;
//            }
//        }
//        if (!mIsAddAliveAlarm){
//            addAliveAlarm();
//            mIsAddAliveAlarm = true;
//        }

        return START_STICKY;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        KeepLiveManager.getInstance().unRegisterReceiver(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


//    /**
//     * 添加重复唤醒闹钟，用于不停唤起服务
//     */
//    private void addAliveAlarm() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            @SuppressLint("JobSchedulerService")
//            JobInfo.Builder _Builder = new JobInfo.Builder(0, new ComponentName(getApplication(), JobSchedulerService.class));
//            _Builder.setPeriodic(KEEP_ALIVE_INTERVAL);
//            _Builder.setPersisted(true);
//            JobScheduler _JobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
//            _JobScheduler.schedule(_Builder.build());
//        }else {
//            PendingIntent _PendingIntent = PendingIntent.getService(this, 0, getIntentAlarm(this), PendingIntent.FLAG_UPDATE_CURRENT);
//            AlarmManager _AlarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
//            _AlarmManager.cancel(_PendingIntent);
//            _AlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + KEEP_ALIVE_INTERVAL, KEEP_ALIVE_INTERVAL, _PendingIntent);
//        }
//    }
//
//
//    /**
//     * Alarm
//     *
//     * @param pContext
//     */
//    public static Intent getIntentAlarm(Context pContext) {
//        return getActionIntent(pContext, ACTION_ALARM);
//    }
//    /**
//     * Start
//     *
//     * @param pContext
//     */
//    public static Intent getIntentStart(Context pContext) {
//        return getActionIntent(pContext, ACTION_START);
//    }
//
//    /**
//     * Service Intent
//     *
//     * @param pContext
//     * @param pAction
//     * @return
//     */
//    private static Intent getActionIntent(Context pContext, String pAction) {
//        Intent _Intent = new Intent(pContext, KeepliveService.class);
//        _Intent.setAction(pAction);
//        return _Intent;
//    }

}