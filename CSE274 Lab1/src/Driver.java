import java.util.Arrays;

public class Driver {

	public static void main(String[] args) {
		
		// Do your own testing here.  Create a WordList object,
		// add, remove, check what's in th array, and so on.
		// Test edge cases as you go.
	
	    WordList list = new WordList();
	    
		list.add("a");
		list.add("b");
		System.out.println(list + "\n");
		
		list.add(2, "c");
		list.add(3, "d");
		System.out.println(list + "\n");
		
		System.out.println(list.get(3));
		
		list.remove(0);
		System.out.println(list + "\n");
		
		System.out.println(list.contains("a"));
		System.out.println(list.contains("b"));
		
		list.clear();
		System.out.println(list + "\n");
		
		list.add("a");
        list.add("b");
        list.add(2, "c");
        list.add(3, "d");
        System.out.println(list + "\n");
        
        list.remove("a");
        System.out.println(list + "\n");
        
        System.out.println(list.get(1) + "\n");
        
        list.set(0,  "a");
        System.out.println(list + "\n");
        
        String[] newList = list.toArray();
        System.out.println(Arrays.toString(newList));
        
        System.out.println(list.size());
        
	}
	


}
