package assign06;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Class built to test WebBrowser and all its methods
 * 
 * @author Mike Phelps
 *
 */
class WebBrowserTest {
	WebBrowser browser;
	WebBrowser emptyBrowser;
	URL URL1;
	URL URL2;
	URL URL3;
	URL URL4;
	URL URL5;

	@BeforeEach
	void setUp() throws MalformedURLException {
		browser = new WebBrowser();
		URL1 = new URL("https://a");
		URL2 = new URL("https://b");
		URL3 = new URL("https://c");
		URL4 = new URL("https://d");
		URL5 = new URL("https://e");
		browser.visit(URL1);
		browser.visit(URL2);
		browser.visit(URL3);

	}

	@Test
	void TestBrowserCreationWithList() {
		SinglyLinkedList<URL> list = browser.history();
		emptyBrowser = new WebBrowser(list);

		assertTrue(browser.back().equals(emptyBrowser.back()));
		assertTrue(browser.back().equals(emptyBrowser.back()));
	}

	@Test
	void TestBrowserVisitCurrent() {
		emptyBrowser = new WebBrowser();

		emptyBrowser.visit(URL1);
		emptyBrowser.visit(URL2);
		emptyBrowser.visit(URL3);

		assertTrue(emptyBrowser.current.toString().equals("https://c"));
	}

	@Test
	void TestBrowserVisitClearForward() {
		emptyBrowser = new WebBrowser();

		emptyBrowser.visit(URL1);
		emptyBrowser.visit(URL2);
		emptyBrowser.visit(URL3);

		assertThrows(NoSuchElementException.class, () -> {
			emptyBrowser.forward();
		});
	}

	@Test
	void TestBrowserVisitPopulateBack() {
		emptyBrowser = new WebBrowser();

		emptyBrowser.visit(URL1);
		emptyBrowser.visit(URL2);

		assertTrue((emptyBrowser.back().toString()).equals(URL1.toString()));

	}

	@Test
	void TestBrowserBackOnEmpty() {
		emptyBrowser = new WebBrowser();
		assertThrows(NoSuchElementException.class, () -> {
			emptyBrowser.back();
		});
	}

	@Test
	void TestBrowserBackConsecutive() {
		assertTrue(browser.back().toString().equals(URL2.toString()));
		assertTrue(browser.back().toString().equals(URL1.toString()));
	}

	@Test
	void TestBrowserBackAfterEmptying() {
		assertTrue(browser.back().toString().equals(URL2.toString()));
		assertTrue(browser.back().toString().equals(URL1.toString()));
		assertThrows(NoSuchElementException.class, () -> {
			browser.back();
		});
	}

	@Test
	void TestBrowserBackOnSingleVisit() {
		emptyBrowser = new WebBrowser();
		emptyBrowser.visit(URL1);

		assertThrows(NoSuchElementException.class, () -> {
			emptyBrowser.back();
		});
	}

	@Test
	void TestBrowserForwardAfterBack() {
		browser.back();
		assertTrue(browser.forward().toString().equals(URL3.toString()));
	}

	@Test
	void TestBrowserForwardAfterConsecutiveBack() {
		browser.back();
		browser.back();
		assertTrue(browser.forward().toString().equals(URL2.toString()));
	}

	@Test
	void TestBrowserForwardCleared() {
		browser.back();
		browser.back();
		browser.visit(URL5);

		assertThrows(NoSuchElementException.class, () -> {
			browser.forward();
		});
	}

	@Test
	void TestBrowserForwardAfterOneVisit() {
		emptyBrowser = new WebBrowser();

		assertThrows(NoSuchElementException.class, () -> {
			browser.forward();
		});
	}

	@Test
	void TestBrowserConsecutiveForward() {
		browser.back();
		browser.back();

		assertTrue(browser.forward().toString().equals(URL2.toString()));
		assertTrue(browser.forward().toString().equals(URL3.toString()));
	}

	@Test
	void TestBrowserHistoryAfterOnlyVisits() {
		String expected = ("[https://c, https://b, https://a]");

		assertTrue(Arrays.toString(browser.history().toArray()).equals(expected));
	}

	@Test
	void TestEmptyBrowserHistory() {
		emptyBrowser = new WebBrowser();

		assertTrue(Arrays.toString(emptyBrowser.history().toArray()).equals("[]"));
	}

	@Test
	void TestBrowserHistoryAfterBacks() {
		browser.back();
		browser.back();

		String expected = ("[https://a]");

		assertTrue(Arrays.toString((browser.history().toArray())).equals(expected));
	}
}
