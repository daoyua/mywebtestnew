package com.test.server;

public class pass {
    public static boolean boo = false;
    public static int i = 0;
    public static void main(String[] args) {

        Object a = new Object();//顾客的
        Object b = new Object();//商店的
        Object c = new Object();//总共的锁
        Object e = new Object();//总共的锁
        baozi d = new baozi();//创建包子;
        new Thread(new Runnable() {   //顾客的
            @Override
            public void run() {
                while (true){
                    System.out.println("顾客"+i);
                    synchronized (a) {//用a来保证所顾客
                        if (d.bz != 0) {
                            try {
                                d.bz--;
                                a.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        else {//开始制造
                            if(pass.boo)
                                c.notifyAll();
                            synchronized (b){
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("制造包子加"+(d.bz++));
                                    }
                                }).start();
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("制造包子加"+(d.bz++));

                                    }
                                }).start();
                                try {
                                    pass.boo =true;
//                                    Thread.sleep(500l);
                                    a.notify();
                                    b.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }

                        }
                    }
                }
            }
        }).start();
        Thread thread = new Thread(new Runnable() {    //商家的
            @Override
            public void run() {
                while (true) {
                    System.out.println("商家" + i);
                    synchronized (e) {
                        if (d.bz == 0) {
                            try {
                                a.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //开始吃
                            if (pass.boo)
                                b.notifyAll();
                            synchronized (c) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("吃包子减" + (d.bz--));
                                    }
                                }).start();
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("吃包子减" + (d.bz--));
                                    }
                                }).start();
                                try {
//                                        Thread.sleep(500l);
                                    a.notifyAll();
                                    c.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }

                            }


                        }
                    }
                }
            }
        });
        thread.start();
    }}


