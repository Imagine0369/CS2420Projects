package assign06;


import java.util.NoSuchElementException;

public class WebBrowserWords {
	
	public String current;
	public ArrayStack<String> forward;
	public ArrayStack<String> back;
	
	public WebBrowserWords() {
		current = null;
		forward = new ArrayStack<String>();
		back = new ArrayStack<String>(); 
		
	}
	// == [d, y, b, g]
	
	//limit = 3
	//i = 3
	public WebBrowserWords(SinglyLinkedList<String> history) {
		forward = new ArrayStack<String>();
		back = new ArrayStack<String>(); 
		
		int limit = history.size() - 1;
		
		for(int i = limit; i >= 0; i--) {
			this.visit(history.get(i));
		}
		
	}
	
	public void visit (String webpage) {
		if(current == null) {
			current = webpage;
			forward.clear();
		}
		else {
			back.push(current);
			current = webpage;
			forward.clear();
		}
		
	}
	//vist 1 on new browser where current is null
	//[] [] current=a
	//visit b
	//[] [a] current = b
	//visit c
	//[] [a, b] current = c
	
	
	//back.pop = b
	//[] [a]
	//back.pop = a
	//[] []
	public String back() throws NoSuchElementException{
		
			//String firstCur = current;
			forward.push(current);
		//System.out.println("FIRSTCUR:" + firstCur);
			current = back.pop();
			
			//forward.push(firstCur);
			return current;
		//}	
			
			
	}
	
	public String forward() throws NoSuchElementException{
		back.push(current);
		current = forward.pop();
		return current;
	}
	
	public SinglyLinkedList<String> history(){
		SinglyLinkedList<String> history = new SinglyLinkedList<String>();
		
		int limit = back.size();
		for(int i = 0; i < limit; i++) {
			String item = back.pop();
			history.insert(i,item);
			forward.push(item);
		}
		history.insertFirst(current);
		
		int limit2 = forward.size();
		for(int j = 0; j < limit2; j++) {
			back.push(forward.pop());
		}
		
		return history;
		
	}

}

