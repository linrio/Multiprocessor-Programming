package ticketingsystem;

import java.util.ArrayList;
import java.util.Random;

public class TdsThread extends Thread {
	private TicketingDS tds;
	private int interval;
	private int start;
	Time time;
	
	public TdsThread(TicketingDS tds, int start, int interval) {
		this.tds = tds;
		this.start = start; // �������
		this.interval = interval; // ���䳤��
	}
	
	public class Time{
		ArrayList<Long> time = new ArrayList<Long>();
		public void time(long i){};
		public void addTid(long i){
			time.add(i);
		}
		public void removeTid(long i){
			time.remove(i);
		}
		public boolean containsTid(long i){
			return time.contains(i);
		}
		public long TimeMax(){
			try{
				long maxD = 0;
				int totalCount = time.size();
				if(totalCount >= 1){
					long max = (long) Double.parseDouble(time.get(0).toString());
					for(int i=0;i<=totalCount;i++){
						long temp = (long) Double.parseDouble(time.get(i).toString());
						if(temp > max){
							max = temp;
						}
					}maxD = max;
				}
				return maxD;
			}catch(Exception ex){
				throw ex;
			}
		}
		
	}
	
	public void run() {
		long starTime=System.currentTimeMillis();
		final int THREAD_EXE_NUM = 10000;
		for (int i = start; i < start + interval; i++) {
			//System.out.println(Thread.currentThread().getName() + " " + i);
			String passenger = "linlingfeng";
			int route = 3;
			int departure = 4;
			int arrival = 6;
			int num = 0;
			int departure2 = 4;
			int arrival2 = 7;
			Ticket ticket = tds.ticket;
			boolean refund = false;
			Random ra = new Random();
			int t = ra.nextInt(THREAD_EXE_NUM)%10;
			if(t==1 | t==2 | t==4|t==5|t==7|t==8){
				ticket = tds.buyTicket(passenger, route, departure, arrival);
				if(ticket != null)
					System.out.println("����Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
				" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
				" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");			
			}
			else if(t==3|t==6|t==9){
				num = tds.inquiry(route, departure2, arrival2);
				System.out.println("��ѯ������Ϊ" + route + "�Ĵӵ�" + departure2 + 
						"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");				
			}
			else if(t==0)
				if(ticket != null) {
					refund = tds.refundTicket(ticket);
					if(refund)
						System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��true ��ʾ��Ʊ�ɹ���");
					else
						System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��false ��ʾ��Ʊʧ�ܣ�");
				}			
		}
	long endTime=System.currentTimeMillis();
	long Time=endTime-starTime;
	System.out.println("128���߳�ִ��ʱ�� "+Time);
	//time.addTid(Time);
	//long max = time.TimeMax();
	//System.out.println("max:"+max);
	}
	
}
