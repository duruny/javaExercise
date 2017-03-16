package com;

import java.util.ArrayList;

/**
 * @author jianpeng.zhang
 * @since 2017/3/14.
 */
public class test
{
    private static int j = 0;

    public static void main(String[] args)
    {
        int k = 1;
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 1; i < 11; i++)
        {
            final int finalI = i;
            Thread thread = new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Thread.sleep(1000 * finalI);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    for (int ii = 0; ii < 1000; ii++)
                    {
                            System.out.println(++j);
                            System.out.println(Thread.currentThread().getName());
                    }

                }
            }, "thread" + k++);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads)
        {
            try
            {
                thread.join();
                System.out.println("---------------------------------------"+j);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

    }
}