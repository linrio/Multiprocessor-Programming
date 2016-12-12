package ticketingsystem;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
	public static final int THREAD_EXE_NUM = 10000;
	public static final int THREAD_NUM = 16;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int routenum = 5;     //车次总数
		int coachnum = 8;     //列车的车厢数
		int seatnum = 100;    //每节的座位数
		int stationnum = 10;  //经停站点数
		TicketingDS tds = new TicketingDS(routenum, coachnum, seatnum, stationnum);
		final CountDownLatch countDownLatch = new CountDownLatch(4);
		ExecutorService executorService = Executors.newFixedThreadPool(30);
//		class Thread()
		
//		run function
//			for 执行次数	10000/thread_num
//		for(int i=0;i<10000;i++){
//			String passenger = "linlingfeng";
//			int route = 3;
//			int departure = 4;
//			int arrival = 6;
//			int num = 0;
//			int departure2 = 4;
//			int arrival2 = 7;
//			Ticket ticket = tds.ticket;
//			boolean refund = false;
//			Random ra = new Random();
//			int t = ra.nextInt(THREAD_EXE_NUM)%10;
//			if(t==1 | t==2 | t==4|t==5|t==7|t==8){
//				ticket = tds.buyTicket(passenger, route, departure, arrival);
//				if(ticket != null)
//					System.out.println("购买：票号为 " + ticket.tid + " 的 "+ ticket.passenger + 
//				" 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +
//				" 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");			
//			}
//			else if(t==3|t==6|t==9){
//				num = tds.inquiry(route, departure2, arrival2);
//				System.out.println("查询：车次为" + route + "的从第" + departure2 + 
//						"站到第" + arrival2 + "站的余票为" + num +"张.");				
//			}
//			else if(t==0)
//				if(ticket != null) {
//					refund = tds.refundTicket(ticket);
//					if(refund)
//						System.out.println("退票：票号为 "+ticket.tid+"退票状态为" + refund+". 注：true 表示退票成功！");
//					else
//						System.out.println("退票：票号为 "+ticket.tid+"退票状态为" + refund+". 注：false 表示退票失败！");
//				}
////			for 循环结束
////			thread
//		}
//		
		System.out.println("10000次购票，查询，退票开始！");
		long starTime=System.currentTimeMillis();
//		try{
		for (int i = 0; i < 128; i++) {
			TdsThread tdsThread = new TdsThread(tds, i*THREAD_EXE_NUM/THREAD_NUM, (i+1)*THREAD_EXE_NUM/THREAD_NUM);
			tdsThread.start();
		}
		
//		try{
//			countDownLatch.await();
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}

//		try{
//			boolean loop = true;
//			do{
//				loop = !executorService.awaitTermination(2, TimeUnit.SECONDS);
//			}while(loop);
//		}catch(InterruptedException e){
//			e.printStackTrace();
//		}
//		}catch(Exception e){
//		}
		
		
		System.out.println("主线程for循环执行完毕..");
		long endTime=System.currentTimeMillis();
		//Thread.sleep(5000);
		//long Time=endTime-starTime;
		//System.out.println("4个线程执行时间：" + Time);
		
		
		
		
		
		
		
		
//		for (int i = 0; i < 2; i++){
//			Thread thread = new Thread(){
//				public void run(){
//					String passenger = "linlingfeng";
//					int route = 3;
//					int departure = 4;
//					int arrival = 6;
//					Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
//					if(ticket != null)
//					System.out.println("购买： 票号为 " + ticket.tid + " 的 "+ ticket.passenger + 
//					" 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +
//					" 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
//					
//					int num = 0;
//					int departure2 = 4;
//					int arrival2 = 7;
//					num = tds.inquiry(route, departure2, arrival2);
//					System.out.println("查询：车次为" + route + "的从第" + departure2 + 
//							"站到第" + arrival2 + "站的余票为" + num +"张.");
//					
//					boolean refund = false;
//					refund = tds.refundTicket(ticket);
//					System.out.println("退票：票号为 "+ticket.tid+"退票状态为" + refund+". 注：true 表示退票成功！ false表示退票失败！");
//				}
//			};
//			thread.start();
//			
//			
//			
//			
//			Thread thread1 = new Thread(){
//				public void run(){
//					String passenger = "linlingfengNew";
//					int route = 3;
//					int departure = 5;
//					int arrival = 6;
//					Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
//					if(ticket != null)
//						System.out.println("票号为 " + ticket.tid + " 的 "+ ticket.passenger + 
//						" 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +
//					    " 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
//					
//					int num = 0;
//					int departure2 = 7;
//					int arrival2 = 9;
//					num = tds.inquiry(route, departure2, arrival2);
//					System.out.println("车次为" + route + "的从第" + departure2 + 
//							"站到第" + arrival2 + "站的余票为" + num +"张.");
//				}
//			};
//			thread1.start();
//		}
	}		
}
