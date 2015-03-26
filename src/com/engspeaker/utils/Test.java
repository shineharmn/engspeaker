package com.engspeaker.utils;

public class Test {

	private static ThreadLocal<Integer> i = new ThreadLocal<Integer>(){  
        public Integer initialValue() {  
            return 0;  
        }  
    };  
    
    public Test(){}
	
    public int getNextNum() {  
        i.set(i.get() + 1);  
        return i.get();  
    }
	
	
	public static void main(String...strings ){
		Test sn = new Test();
		
		Threaddd t2 = sn.new Threaddd(sn);
		Threaddd t1 = sn.new Threaddd(sn);
		
		t2.start();
		t1.start();
	}
	
	 class Threaddd extends Thread{
		private Test sn;  
		  
        public Threaddd(Test sn) {  
            this.sn = sn;  
        }  
  
        public void run() {  
            for (int i = 0; i < 3; i++) {  
                // ④每个线程打出3个序列值  
                System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["  
                         + sn.getNextNum() + "]");  
            }  
        }  
	}
}
