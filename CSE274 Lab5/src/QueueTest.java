import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	
	QueueInterface<Integer> queue;
	
	@Before
	public void createQueue() {
		queue = new ArrayQueue<>(); // change to LinkedQueue when you are ready
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());
		queue.add(10);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void testpeek() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertEquals(47, (int)queue.peek());
		}
	
	}
	
	@Test
	public void testQueueing() {
		int[] data = {47, 83, 55, 99, 66, 27, 68};
		
		for (int n : data) {
			queue.add(n);
			assertFalse(queue.isEmpty());
			assertEquals(n, (int)queue.remove());
			assertTrue(queue.isEmpty());
		}		
		
		for (int n : data) {
			queue.add(n);
		}
		for (int n : data) {
			queue.add(n);
		}
		queue.remove();
		queue.remove();
		for (int n : data) {
			queue.add(n);
		}
		
		for (int i = 2; i < data.length; i++) {
			assertEquals(data[i], (int)queue.remove());
		}
		for (int n : data) {
			assertEquals(n, (int)queue.remove());
		}		
		
		while(!queue.isEmpty()) {
			queue.remove();
		}		
		
		assertTrue(queue.isEmpty());		
		
	}
	
	@Test
	public void clearTest() {
	    int[] data = {47, 83, 55, 99, 66, 27, 68};
        
        for (int n : data) {
            queue.add(n);
        }
        queue.clear();
        assertTrue(queue.isEmpty());
	}
	
	@Test
	public void addEmpty() {
	    int[] data = {47, 83, 55, 99, 66, 27, 68};
	    queue.clear();
	    for (int n : data) {
            queue.add(n);
        }
	    assertFalse(queue.isEmpty());
	    for (int n : data) {
            assertEquals(47, (int) queue.peek());
        }
	}
	
	@Test
	public void addOne() {
	    int[] data = {1};
	    for (int n : data) {
            queue.add(n);
        }
	    
	    int[] temp = {5, 4, 3};
        for (int n : temp) {
            queue.add(n);
        }
        
        assertFalse(queue.isEmpty());
        
	}
	
	@Test
	public void removeOne() {
	    int[] data = {1};
	    for (int n : data) {
	        queue.add(n);
	    }
	    for (int n : data) {
            assertEquals(n, (int)queue.remove());
        }   
	    assertTrue(queue.isEmpty());
	}
}
