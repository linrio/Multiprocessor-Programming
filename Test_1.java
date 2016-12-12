package ticketingsystem;

public class Test_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int routenum = 5;     //车次总数
		int coachnum = 8;     //列车的车厢数
		int seatnum = 100;    //每节的座位数
		int stationnum = 10;  //经停站点数
		TicketingDS tds = new TicketingDS(routenum, coachnum, seatnum, stationnum);
		for (int i = 0; i < 1; i++){
			new Thread(
					new Runnable() {
						
						@Override
						public void run() {
						
							String passenger = "linlingfeng";
							int route = 3;
							int departure = 4;
							int arrival = 6;
							Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
							System.out.println(ticket);
							System.out.println("票号为 " + ticket.tid + " 的 "+ ticket.passenger + " 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +" 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
							
							int num;
							int departure2 = 7;
							int arrival2 = 8;
							num = tds.inquiry(route, departure2, arrival2);
							System.out.println("余票数量为："+num);
							System.out.println("车次为" + route + "的从第" + departure2 + "站到第" + arrival2 + "站的余票为" + num +"张.");						
						}
					}
			).start();
			Thread.sleep(1000);
			new Thread(
					new Runnable() {
						
						@Override
						public void run() {
						
							String passenger = "linlingfengNew";
							int route = 4;
							int departure = 5;
							int arrival = 6;
							Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
							System.out.println(ticket);
							System.out.println("票号为 " + ticket.tid + " 的 "+ ticket.passenger + " 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +" 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
							
							int num;
							int departure2 = 3;
							int arrival2 = 8;
							num = tds.inquiry(route, departure2, arrival2);
							System.out.println("余票数量为："+ num);
							System.out.println("车次为" + route + "的从第" + departure2 + "站到第" + arrival2 + "站的余票为" + num +"张.");	
							boolean inquiry = false;
							//inquiry = tds.refundTicket(ticket);
							System.out.println("退票结果：" + inquiry);
						}
					}
			).start();
		}
	}		
}



for (int i = 0; i < 2; i++){
	Thread thread = new Thread(){
		public void run(){
			String passenger = "linlingfeng";
			int route = 3;
			int departure = 4;
			int arrival = 6;
			Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
			if(ticket != null)
			System.out.println("购买： 票号为 " + ticket.tid + " 的 "+ ticket.passenger + 
			" 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +
			" 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
			
			int num = 0;
			int departure2 = 4;
			int arrival2 = 7;
			num = tds.inquiry(route, departure2, arrival2);
			System.out.println("查询：车次为" + route + "的从第" + departure2 + 
					"站到第" + arrival2 + "站的余票为" + num +"张.");
			
			boolean refund = false;
			refund = tds.refundTicket(ticket);
			System.out.println("退票：票号为 "+ticket.tid+"退票状态为" + refund+". 注：true 表示退票成功！ false表示退票失败！");
		}
	};
	thread.start();
	
	
	
	
	Thread thread1 = new Thread(){
		public void run(){
			String passenger = "linlingfengNew";
			int route = 3;
			int departure = 5;
			int arrival = 6;
			Ticket ticket = tds.buyTicket(passenger, route, departure, arrival);
			if(ticket != null)
				System.out.println("票号为 " + ticket.tid + " 的 "+ ticket.passenger + 
				" 乘客购买了车次为 "+ticket.route +" 车厢为 " +ticket.coach +" 座位号为 " +ticket.seat +
			    " 的从第 " + ticket.departure +" 站到第 " +ticket.arrival + " 站的车票一张.");
			
			int num = 0;
			int departure2 = 7;
			int arrival2 = 9;
			num = tds.inquiry(route, departure2, arrival2);
			System.out.println("车次为" + route + "的从第" + departure2 + 
					"站到第" + arrival2 + "站的余票为" + num +"张.");
		}
	};
	thread1.start();
}