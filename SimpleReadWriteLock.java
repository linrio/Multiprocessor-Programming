package Thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

/*
 @author: 201628017729008 ÁÖÁé·æ
 */


public class SimpleReadWriteLock implements ReadWriteLock{

	int readers;
	boolean writer;
	Lock lock;
	Condition condition;
	Lock readLock, writeLock; 
	public SimpleReadWriteLock(){
		writer = false;
		readers = 0;
		lock = new ReentrantLock();
		readLock = new ReadLock();
		writeLock = new WriteLock();
		condition = lock.newCondition();
	}
	@Override
	public Lock readLock() {
		// TODO Auto-generated method stub
		return readLock;
	}

	@Override
	public Lock writeLock() {
		// TODO Auto-generated method stub
		return writeLock;
	}
	
	class ReadLock implements Lock{

		@Override
		public synchronized void lock() {
			// TODO Auto-generated method stub
			lock.lock();
			try{
				while(writer){
					try {
						this.wait();
						//condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				readers ++;
			}finally{
				lock.unlock();
			}
		}

		@Override
		public void lockInterruptibly() throws InterruptedException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean tryLock() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void unlock() {
			// TODO Auto-generated method stub
			lock.lock();
			try{
				readers --;
				if(readers == 0)
					this.notify();
					//condition.signalAll();
			}finally{
				lock.unlock();
			}
		}

		@Override
		public Condition newCondition() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

	protected class WriteLock implements Lock {

		@Override
		public synchronized void lock() {
			// TODO Auto-generated method stub
			lock.lock();
			try{
				while(readers > 0 || writer){
					try {
						this.wait();
						//condition.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				writer = true;
			}finally{
				lock.unlock();
			}
		}

		@Override
		public void lockInterruptibly() throws InterruptedException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean tryLock() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void unlock() {
			// TODO Auto-generated method stub
			lock.lock();
			try{
				writer = false;
				this.notify();
				//condition.signalAll();
			}finally{
				lock.unlock();
			}
		}

		@Override
		public Condition newCondition() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
/*
	public static void main(String[] args){
		final ReadLock readlock = new SimpleReadWriteLock.ReadLock();
		final WriteLock writelock = new SimpleReadWriteLock.WriteLock();
		new Thread(
					for(int i=1; i<10; i++){
						readlock.lock();
					}
		).start();
		
		new Thread(
				for(int i=1; i<10; i++){
					writelock.lock();
				}
			).start();

	}
	*/
}

