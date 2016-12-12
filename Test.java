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
		int routenum = 5;     //��������
		int coachnum = 8;     //�г��ĳ�����
		int seatnum = 100;    //ÿ�ڵ���λ��
		int stationnum = 10;  //��ͣվ����
		TicketingDS tds = new TicketingDS(routenum, coachnum, seatnum, stationnum);
		final CountDownLatch countDownLatch = new CountDownLatch(4);
		ExecutorService executorService = Executors.newFixedThreadPool(30);
//		class Thread()
		
//		run function
//			for ִ�д���	10000/thread_num
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
//					System.out.println("����Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
//				" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
//				" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");			
//			}
//			else if(t==3|t==6|t==9){
//				num = tds.inquiry(route, departure2, arrival2);
//				System.out.println("��ѯ������Ϊ" + route + "�Ĵӵ�" + departure2 + 
//						"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");				
//			}
//			else if(t==0)
//				if(ticket != null) {
//					refund = tds.refundTicket(ticket);
//					if(refund)
//						System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��true ��ʾ��Ʊ�ɹ���");
//					else
//						System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��false ��ʾ��Ʊʧ�ܣ�");
//				}
////			for ѭ������
////			thread
//		}
//		
		System.out.println("10000�ι�Ʊ����ѯ����Ʊ��ʼ��");
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
		
		
		System.out.println("���߳�forѭ��ִ�����..");
		long endTime=System.currentTimeMillis();
		//Thread.sleep(5000);
		//long Time=endTime-starTime;
		//System.out.println("4���߳�ִ��ʱ�䣺" + Time);
		
		
		
		
		
		
		
		
//		for (int i = 0; i < 2; i++){
//			Thread thread = new Thread(){
//				public void run(){
//					String passenger = "linlingfeng";
//					int route = 3;
//					int departure = 4;
//					int arrival = 6;
//					Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
//					if(ticket != null)
//					System.out.println("���� Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
//					" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
//					" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
//					
//					int num = 0;
//					int departure2 = 4;
//					int arrival2 = 7;
//					num = tds.inquiry(route, departure2, arrival2);
//					System.out.println("��ѯ������Ϊ" + route + "�Ĵӵ�" + departure2 + 
//							"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");
//					
//					boolean refund = false;
//					refund = tds.refundTicket(ticket);
//					System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��true ��ʾ��Ʊ�ɹ��� false��ʾ��Ʊʧ�ܣ�");
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
//						System.out.println("Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
//						" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
//					    " �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
//					
//					int num = 0;
//					int departure2 = 7;
//					int arrival2 = 9;
//					num = tds.inquiry(route, departure2, arrival2);
//					System.out.println("����Ϊ" + route + "�Ĵӵ�" + departure2 + 
//							"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");
//				}
//			};
//			thread1.start();
//		}
	}		
}
