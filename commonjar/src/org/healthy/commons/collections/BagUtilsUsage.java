package org.healthy.commons.collections;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.BagUtils;
import org.apache.commons.collections.bag.HashBag;

import com.healthy.commons.mybean.Book;

public class BagUtilsUsage {

	public static void demoBagUsage() {

		// data setup
		Book book1 = new Book("Refactoring Workbook", "7-5083-2208-8", 29.8);
		Book book2 = new Book("J2EE Design Patterns", "7-5083-3099-4", 45);
		Book book3 = new Book("Agile Software Development", "7-5083-1503-0", 59);

		// create a bag
        Bag myBag = BagUtils.typedBag(new HashBag(), Book.class);
        myBag.add(book1, 360);
        myBag.add(book2, 500);
        myBag.add(book3, 170);

        double price1 = book1.getRetailPrice();
        double price2 = book2.getRetailPrice();
        double price3 = book3.getRetailPrice();
        int book1Count = myBag.getCount(book1);
        System.out.println(book1Count);
        
        int book2Count = myBag.getCount(book2);
        System.out.println(book2Count);

        
        int book3Count = myBag.getCount(book3);
        System.out.println(book3Count);

        
        double totalValue = (price1 * book1Count) + (price2 * book2Count)
                + (price3 * book3Count);

        System.out.println("There are " + book1Count + " copies of "
                + book1.getName() + ".");
        System.out.println("There are " + book2Count + " copies of "
                + book2.getName() + ".");
        System.out.println("There are " + book3Count + " copies of "
                + book3.getName() + ".");
        System.out.println("The total value of these books is: " + totalValue);


	}

	public static void main(String[] args) {
		demoBagUsage();
	}
}
