package shop;

import shop.store.UserStore;
import shop.user.User;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Timer;
import java.util.TimerTask;

public class ReschedulableTimer extends Timer
{
    private  Runnable  task;
    private  TimerTask timerTask;



    public void schedule(Runnable runnable, long delay)
    {


            System.out.println("timer started");
            task = runnable;
            timerTask = new TimerTask() {
                @Override
                public void run() {
                    task.run();
                }
            };
            this.schedule(timerTask, delay);


    }



    public void reschedule(long delay)
    {

        this.timerTask.cancel();
        this.timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                task.run();
            }
        };
        this.schedule(timerTask, delay);
        System.out.println("rescheduled");
    }





}