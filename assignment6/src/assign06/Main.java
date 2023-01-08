package assign06;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws MalformedURLException {
		SinglyLinkedList<Integer> myIntList = new SinglyLinkedList<Integer>();
//		myIntList.insertFirst(7);
//		myIntList.insertFirst(5);
//		myIntList.insertFirst(9);
//		myIntList.insert(0, 7);
//		myIntList.insert(1, 5);
//		myIntList.insert(2, 9);
//		myIntList.insert(3, 6);
//		myIntList.insert(4, 4);
//		myIntList.insert(5, 1);

//		System.out.println("SIZE: " + myIntList.size);
//		System.out.println(Arrays.toString(myIntList.toArray()));
//		System.out.println("Removed: " + myIntList.delete(5));
//		System.out.println("SIZE: " + myIntList.size);
//		System.out.println(Arrays.toString(myIntList.toArray()));

//		System.out.println(myIntList.get(index));
//		System.out.println(myIntList.get(0));
//		System.out.println(myIntList.get(1));
//		System.out.println(myIntList.get(2));
//		System.out.println(myIntList.indexOf(11));
		
//		Iterator<Integer> itr = myIntList.iterator();
//		
//		while(itr.hasNext()) {
//			System.out.println(itr.next());
//		}
//		
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
//		System.out.println(itr.hasNext());
//		System.out.println(itr.next());
		
//		System.out.println(Arrays.toString(myIntList.toArray()));
//		itr.next();
//		itr.remove();
//		System.out.println(Arrays.toString(myIntList.toArray()));
		
//		LinkedListStack<Integer> stack = new LinkedListStack<Integer>(myIntList);
//		stack.push(5);
//		stack.push(7);
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		
//		
//		URL URL1 = new URL("https://a"); 
//		URL URL2 = new URL("https://b"); 
//		URL URL3 = new URL("https://c"); 
//		
//		WebBrowser w = new WebBrowser();
//			      
//				w.visit(URL1);
//				w.visit(URL2);
//				w.visit(URL3);
//
//				System.out.println(w.back());
//				System.out.println(w.back());
		
//-------------------------------------------------------------		
		
	WebBrowserWords w = new WebBrowserWords();	
	
	w.visit("google");
	w.visit("bing");
	w.visit("yahoo");
	w.visit("duckduckgo");
	
	//System.out.println(Arrays.toString(w.history().toArray()));
//	System.out.println("Went to google and then Bing");
//	System.out.println("Current: " + w.current);
//	System.out.println("Click back button");
//	w.back();
//	System.out.println("Current: " + w.current);
//	System.out.println("Click Forwrd Button" );
//	w.forward();
//	System.out.println("Current: " + w.current);
	
	
	
	
//	System.out.println("Forward Button Back to Bing");
//	w.forward();

//	System.out.println("Current: " + w.current);
//	System.out.println("Back Button");
//	w.back();
//	System.out.println(w.current);
//	System.out.println("Back Button");
//	w.back();
//	System.out.println(w.current);
//	System.out.println("Back Button");
//	w.back();
//	System.out.println(w.current);
	
//	System.out.println("FORWARDS");
//	
//	System.out.println(w.forward());
//	System.out.println(w.forward());
//	System.out.println(w.forward());
	

	
//	
//System.out.println(Arrays.toString(w.history().toArray()));
//System.out.println("AFTER HISTORY: ");		
//System.out.println(w.back());
//System.out.println(w.back());
//System.out.println(w.back());
//
//System.out.println("forward...");
//System.out.println(w.forward());
	
SinglyLinkedList<String> list = new SinglyLinkedList<String>();
// == [d, y, b, g]

//d
//y
//b
//g

//[d, y, b, g]

WebBrowserWords t = new WebBrowserWords(list);
System.out.println(t.current);
System.out.println(t.back());

		
		
		
	}

}
