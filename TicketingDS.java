package ticketingsystem;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketingDS implements TicketingSystem {

	Ticket ticket = new Ticket();
	Seat seat;
	List list;
	public TicketingDS(int routenum, int coachnum, int seatnum, int stationnum){
		 seat = new Seat(routenum, seatnum, stationnum);
		 list = new List(routenum);
	}

	

	public class Seat{
		private int seat[][][] =new int[5][800][10];
		
		public  Seat(int i,int j, int k ){
			for(i=0; i<5; i++)
				for(j=0; j<8*100; j++)
					for (k=0; k<10; k++){
						seat[i][j][k]=0;
					}
		}
		
		public int getseat(int i, int j, int k){
			return seat[i][j][k];
		}
		public void setseat(int i, int j, int k){
			this.seat[i][j][k] = 1;
		}
		public void setseatZero(int i, int j, int k){
			this.seat[i][j][k] = 0;
		}
		public void printseat(int i, int j, int k){
			System.out.println(this.seat[i][j][k]);
		}


	}
	public class List{
		ArrayList List = new ArrayList();
		public List(long i){};
		public void addTid(long i){
			List.add(i);
		}
		public void removeTid(long i){
			List.remove(i);
		}
		public boolean containsTid(long i){
			return List.contains(i);
		}
	}

	 
	@Override
	public Ticket buyTicket(String passenger, int route, int departure, int arrival) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
		int k = route;
		int count=0;
		
		//检索每一张座位的区间。看看我的座位的区间在不在别人的区间内。
		for (int i = 0; i < 8*100; i++){
			lock.lock();
			for(int p = departure; p <= arrival; p++){
				if(seat.getseat(route, i, p)==1) 
					count++;
			}
			
				if (count==0){
					ticket.tid = k*1000 + i/100+100 + i%100;
					ticket.passenger = passenger;
					ticket.route = route;
					ticket.coach = i/100+1;
					ticket.seat = i%100;
					ticket.departure = departure;
					ticket.arrival = arrival;
					//System.out.println(ticket);
					for(int p = departure; p <= arrival; p++){
						seat.setseat(route, i, p);
						//seat.printseat(route, i, p);
					}
					for(int p = departure-1; p <= arrival; p++){
						//seat.printseat(route, i, p);
					}
					list.addTid(ticket.tid);
					lock.unlock();
					return ticket;
				}
			count = 0;
			lock.unlock();
		}
		
		return null;
	}
	
	
	@Override
	public int inquiry(int route, int departure, int arrival) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
		int count = 0;
		int num = 0;
		for (int i = 0; i < 8*100; i++){
			lock.lock();
			for(int p = departure; p <= arrival; p++){
				if(seat.getseat(route, i, p)==1) 
					count++;
			}
			if(count ==0)
				num++;
			count = 0;
			lock.unlock();
		}
		return num;
	}
	@Override
	public boolean refundTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Lock lock = new ReentrantLock();
		int route = ticket.route;
		int departure = ticket.departure;
		int arrival = ticket.arrival;
		int coach = ticket.coach;
		int seat0 = ticket.seat;
		int k = (coach-1) *100+seat0;
		lock.lock();
		if(list.containsTid(ticket.tid)){
			for(int p = departure; p <= arrival; p++){
				seat.setseatZero(route, k, p);
				//seat.printseat(route, k, p);
			}
			list.removeTid(ticket.tid);
			lock.unlock();
			return true;
		}
		lock.unlock();
		return false;
	}

}
