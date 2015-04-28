package org.healthy.commons.collections;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUtils;
import org.apache.commons.collections.buffer.BoundedFifoBuffer;
import org.apache.commons.lang3.StringUtils;

import com.healthy.commons.mybean.Book;

public class BufferUtilUsage {

	
	
	public static void demoBufferUsage() {
		
		   System.out.println(StringUtils.center(" demoBagUsage ", 40, "="));
		
		   Book book1 = new Book("Refactoring Workbook", "7-5083-2208-8", 29.8);
	        Book book2 = new Book("J2EE Design Patterns", "7-5083-3099-4", 45);
	        Book book3 = new Book("Agile Software Development", "7-5083-1503-0", 59);
	        Book book4 = new Book("Professional JSP", "7-5053-8005-2", 100);

	        
	        // create a Buffer
	        Buffer buffer = 
	            BufferUtils.typedBuffer(new BoundedFifoBuffer(3), Book.class);
	        buffer.add(book1);
	        buffer.add(book2);
	        buffer.add(book3);
	        Book removed = (Book) buffer.remove();
	        System.out.println("Removed:");
	        System.out.println(removed);
	        buffer.add(book4);
	        
	        // get items in buffer
	        for (int i = 0; i < 3; i++) {
	            System.out.println(buffer.get());
	            buffer.remove();
	        }
	 
	        System.out.println(StringUtils.repeat("=", 40));

	}
	
	
	public static void main(String[] args) {
		 demoBufferUsage();
	}

}
