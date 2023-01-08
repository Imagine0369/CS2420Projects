package assign06;

import java.net.URL;
import java.util.NoSuchElementException;

/**
 * @author Mike Phelps
 * 
 *         This class simulates the functionality of a web browser. It
 *         specifically simulates a web browsers ability to track what pages
 *         you've been on the ability to move forward and back.
 *
 */
public class WebBrowser {

	public URL current;
	private ArrayStack<URL> forward;
	private ArrayStack<URL> back;

	/**
	 * Default constructor which creates a Web Browser with no current page, no
	 * previous pages, and no back pages.
	 */
	public WebBrowser() {
		current = null;
		forward = new ArrayStack<URL>();
		back = new ArrayStack<URL>();

	}

	/**
	 * Constructor that initializes a current page, back pages, and forward pages
	 * based on a SinglyLinkedList passed in as an argument. The first item in the
	 * list will be counted as the current page and the the most recent pages will
	 * follow.
	 * 
	 * @param history SinglyLinkedList representing history of web pages visited
	 */
	public WebBrowser(SinglyLinkedList<URL> history) {
		forward = new ArrayStack<URL>();
		back = new ArrayStack<URL>();

		int limit = history.size() - 1;

		for (int i = limit; i >= 0; i--) {
			this.visit(history.get(i));
		}
	}

	/**
	 * Simulates the act of visiting a new webpage. The parameter URL is the new
	 * current URL, the previous current URL is added to the back button, and the
	 * forward button is cleared.
	 * 
	 * @param webpage current webpage bing visited
	 */
	public void visit(URL webpage) {
		if (current == null) {
			current = webpage;
			forward.clear();
		} else {
			back.push(current);
			current = webpage;
			forward.clear();
		}

	}

	/**
	 * Simulates hitting the back button on your web browser. Will set the previous
	 * page to current and will store the old current page within the forward
	 * option.
	 * 
	 * @return webpage returned to
	 * @throws NoSuchElementException
	 */
	public URL back() throws NoSuchElementException {
		forward.push(current);
		current = back.pop();
		return current;

	}

	/**
	 * Simulates using the forward button on your web browser. Will set the
	 * forwarded page to current and add the old current page to the back button.
	 * 
	 * @return webpage forwarded to
	 * @throws NoSuchElementException
	 */
	public URL forward() throws NoSuchElementException {
		back.push(current);
		current = forward.pop();
		return current;
	}

	/**
	 * This method returns a list of webpages visited in chronological order
	 * starting with the current webpage as the most recent.
	 * 
	 * @return list of URL's visited in chronological order
	 */
	public SinglyLinkedList<URL> history() {
		if (current == null && back.size() == 0) {
			return new SinglyLinkedList<URL>();
		}
		SinglyLinkedList<URL> history = new SinglyLinkedList<URL>();

		int limit = back.size();
		for (int i = 0; i < limit; i++) {
			URL item = back.pop();
			history.insert(i, item);
			forward.push(item);
		}
		history.insertFirst(current);

		int limit2 = forward.size();
		for (int j = 0; j < limit2; j++) {
			back.push(forward.pop());
		}

		return history;

	}

}
