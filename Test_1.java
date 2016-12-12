package ticketingsystem;

public class Test_1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int routenum = 5;     //��������
		int coachnum = 8;     //�г��ĳ�����
		int seatnum = 100;    //ÿ�ڵ���λ��
		int stationnum = 10;  //��ͣվ����
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
							System.out.println("Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + " �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
							
							int num;
							int departure2 = 7;
							int arrival2 = 8;
							num = tds.inquiry(route, departure2, arrival2);
							System.out.println("��Ʊ����Ϊ��"+num);
							System.out.println("����Ϊ" + route + "�Ĵӵ�" + departure2 + "վ����" + arrival2 + "վ����ƱΪ" + num +"��.");						
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
							System.out.println("Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + " �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
							
							int num;
							int departure2 = 3;
							int arrival2 = 8;
							num = tds.inquiry(route, departure2, arrival2);
							System.out.println("��Ʊ����Ϊ��"+ num);
							System.out.println("����Ϊ" + route + "�Ĵӵ�" + departure2 + "վ����" + arrival2 + "վ����ƱΪ" + num +"��.");	
							boolean inquiry = false;
							//inquiry = tds.refundTicket(ticket);
							System.out.println("��Ʊ�����" + inquiry);
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
			System.out.println("���� Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
			" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
			" �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
			
			int num = 0;
			int departure2 = 4;
			int arrival2 = 7;
			num = tds.inquiry(route, departure2, arrival2);
			System.out.println("��ѯ������Ϊ" + route + "�Ĵӵ�" + departure2 + 
					"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");
			
			boolean refund = false;
			refund = tds.refundTicket(ticket);
			System.out.println("��Ʊ��Ʊ��Ϊ "+ticket.tid+"��Ʊ״̬Ϊ" + refund+". ע��true ��ʾ��Ʊ�ɹ��� false��ʾ��Ʊʧ�ܣ�");
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
				System.out.println("Ʊ��Ϊ " + ticket.tid + " �� "+ ticket.passenger + 
				" �˿͹����˳���Ϊ "+ticket.route +" ����Ϊ " +ticket.coach +" ��λ��Ϊ " +ticket.seat +
			    " �Ĵӵ� " + ticket.departure +" վ���� " +ticket.arrival + " վ�ĳ�Ʊһ��.");
			
			int num = 0;
			int departure2 = 7;
			int arrival2 = 9;
			num = tds.inquiry(route, departure2, arrival2);
			System.out.println("����Ϊ" + route + "�Ĵӵ�" + departure2 + 
					"վ����" + arrival2 + "վ����ƱΪ" + num +"��.");
		}
	};
	thread1.start();
}