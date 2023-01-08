package lab06;

import java.util.ArrayList;

public class ALQueue <T> implements Queue<T> {

	private ArrayList<T> alist;
	
	public ALQueue()
	{
		// TODO:
		alist = new ArrayList<T>();
	}
	
	@Override
	public void offer(T element) {
		// TODO:
		alist.add(element);
	}

	@Override
	public T poll() {
		// TODO:
		return alist.remove(0);
	}

	@Override
	public T peek() {
		// TODO:
		return alist.get(0);
	}

}
