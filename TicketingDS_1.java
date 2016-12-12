package ticketingsystem;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TicketingDS_1 implements TicketingSystem {

	public TicketingDS_1(int routenum, int coachnum, int seatnum, int stationnum){}
	Ticket ticket = new Ticket();
	
	public class Node{
		protected Node next;
		protected int key;
		
		Lock lock;
		
		public Node(int key){
			this.key = key;
		    this.key = key;
		    this.lock = new ReentrantLock();
		}
		
		public void display(){
			System.out.println(key + " ");
		}
	    /**
	     * Lock Node
	     */
	    void lock() {lock.lock();}
	    /**
	     * Unlock Node
	     */
	    void unlock() {lock.unlock();}
	}
	
	public class MyLinkedList{
	    public Node head;
	    public Node current;
	    
	    //��ӽڵ�
	    public void add(int data) {
	        //���ͷ���Ϊ��,Ϊͷ���
	        if(head == null) {
	            head = new Node(data);
	            current = head;
	        } else {
	            current.next = new Node(data);
	            current = current.next;
	        }
	    }
	
	    //��ӡ����
	    public void print(Node node) {
	        if(node == null) {
	            return;
	        }

	        current = node;
	        while(current != null) {
	            System.out.print(current.key + " ");
	            current = current.next;
	        }
	    }
	    
	    //��������
	    public int get_length(Node head){
	    	if (head == null){
	    		return -1;
	    	}
	    	int length = 0;
	    	current = head;
	    	while(current != null){
	    		length++;
	    		current = current.next;
	    	}
	    	return length;
	    }
	    
		//��ʼ������,���ҷ��ر�ͷ
	    public Node init() {
	        for(int i=0; i<10; i++) {
	            this.add(i);
	        }
	        return head;
	    }
	}
	
	
	
	@Override
	public Ticket buyTicket(String passenger, int route, int departure, int arrival) {
		// TODO Auto-generated method stub
		int k = route;
	    // Add sentinels to start and end
		MyLinkedList list = new MyLinkedList();
		Node head      = list.init();
		//list.add(k);
		list.print(head);
		System.out.println("������Ϊ�� "+ list.get_length(head));
		//����ǰ����㣨��㣩�͵�ǰ�ڵ��Ŀ��ڵ㣨�յ㣩
	    Node predpred = new Node(departure-1);
		Node pred = new Node(departure);
		Node curr = pred.next;
		Node succ = new Node(arrival);
		//predpred.key = departure -1;
		//pred.key = departure;
		//succ.key = arrival;

		
		for (int i = 1; i <= 8*100; i++){
			head.lock();
		    try {
		      pred = head;
		      curr = pred.next;
		      curr.lock();
		      try {
		        while (curr.key < succ.key) {
		    	  //System.out.println(predpred.key);
		          //System.out.println(curr.key + " " + succ.key);
		          pred.unlock();
		          pred = curr;
		          curr = curr.next;
		          curr.lock();
		        }
		        if (curr.key == succ.key) {
		        	predpred.next = curr.next;
					ticket.tid = k*1000 + i/100+100 + i%100;
					ticket.passenger = passenger;
					ticket.route = route;
					ticket.coach = i/100+1;
					ticket.seat = i%100;
					ticket.departure = departure;
					ticket.arrival = arrival;
					//System.out.println("lock"+ ticket);
					return ticket;
		        }
		      } finally {curr.unlock();}
		    } finally {pred.unlock();}
		    i++;
			list.print(head);
			System.out.println("��������Ϊ�� "+ list.get_length(head));
		}

		
		//����ÿһ����λ�����䡣�����ҵ���λ�������ڲ��ڱ��˵������ڡ�
		return null;
	}
	
	Ticket ticket2 = new Ticket();
	@Override
	public int inquiry(int route, int departure, int arrival) {
		// TODO Auto-generated method stub
		int k = route;
		int count = 0;
		ticket2.departure = departure;
		ticket2.arrival = arrival;
		for (int i = 1; i <= 8*100; i++){
			ticket2.seat = i%100;
			if (ticket2.passenger == null){
				if ((departure >= ticket.arrival) | (arrival <= ticket.departure)){
					count ++;
					}
			}
		}
		
		return count;
	}
	@Override
	public boolean refundTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		MyLinkedList list = new MyLinkedList();
		Node head      = list.init();
		Node predpred = new Node(ticket.departure-1);
		head.lock();
	    Node pred = head;
		Node succ = new Node(ticket.arrival);
		
	    try {
	        Node curr = pred.next;
	        curr.lock();
	        try {
	          while (curr.key < succ.key) {
	            pred.unlock();
	            pred = curr;
	            curr = curr.next;
	            curr.lock();
	          }
	          if (curr.key == succ.key) {
	        	  for (int i = ticket.arrival; i >= ticket.departure; i--){
	        		  Node newNode = new Node(i);
	        		  newNode.next = curr;
	        		  pred.next = newNode;
	        		  curr = newNode;
	        		  return true;
	        	  } 
	          }
	        } finally {
	          curr.unlock();
	        }
	      } finally {
	        pred.unlock();
	      }
		
		return false;
	}

}
