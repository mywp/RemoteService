package com.example.scorpio.RemoteService;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class RemoteService extends Service {
    public RemoteService() {
    }

    @Override
    public void onCreate() {
        System.out.println("远程服务被创建了。。。");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        System.out.println("远程服务被销毁了。。。");
        super.onDestroy();
    }
    
    private void methodInService(){
        System.out.println("我是远程服务的方法，我被调用了。。。。");
    }
    
    //1.创建一个中间人 远程服务集成的是ipc的一个实现类
    private class MiddlePerson extends IMiddlePerson.Stub{

        @Override
        public void callMethodInService() throws RemoteException {
            methodInService();
            
        }

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new MiddlePerson();
    }
}
