package org.healthy.commons.collections;

import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;
import org.apache.commons.collections.comparators.FixedOrderComparator;

import com.healthy.commons.mybean.Issue;

public class ComparatorUtilsUsage {
	
	
	
	
	public static void main(String[] args) {
		 demoComparator();
	}

	private static void demoComparator() {
		
	     Issue[] issues = new Issue[] {
	                new Issue(15102, "Major", "John"),
	                new Issue(15103, "Minor", "Agnes"),
	                new Issue(15104, "Critical", "Bill"),
	                new Issue(15105, "Major", "John"),
	                new Issue(15106, "Major", "John"),
	                new Issue(15107, "Critical", "John"),
	                new Issue(15108, "Major", "Agnes"),
	                new Issue(15109, "Minor", "Julie"),
	                new Issue(15110, "Major", "Mary"),
	                new Issue(15111, "Enhancement", "Bill"),
	                new Issue(15112, "Minor", "Julie"),
	                new Issue(15113, "Major", "Julie")
	        };
	     
	     String[] severityOrder = {"Critical", "Major", "Minor", "Enhancement"};
	     Comparator severityComparator = new FixedOrderComparator(severityOrder);

	     ComparatorChain compChain = new ComparatorChain();
	     
	     compChain.addComparator(new BeanComparator("id"));
	     compChain.addComparator(new BeanComparator("severity", severityComparator));
	     compChain.addComparator(new BeanComparator("owner"));
	     
	      Arrays.sort(issues, compChain);
		
	      for (int i = 0; i < issues.length; i++) {
	            System.out.println(issues[i]);
	        }

	}

}
