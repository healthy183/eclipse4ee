package org.healthy.commons.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.SwitchTransformer;

import com.healthy.commons.mybean.Applicant;
import com.healthy.commons.mybean.Employee;

public class TransformerUtilsUsage {

	public static void main(String[] args) {
		demoTransformerUsage();
		
	}

	private static void demoTransformerUsage() {
		
		  Applicant[] applicants = new Applicant[] {
		            new Applicant("Tony", 26, "Developer"),
		            new Applicant("Michelle", 24, "Tester"),
		            new Applicant("Jack", 28, "Project Manager")
		        };

		  List appList = Arrays.asList(applicants);
		  
		  Predicate isDeveloper = new Predicate() {
	            public boolean evaluate(Object obj) {
	                Applicant app = (Applicant) obj;
	                return "Developer".equalsIgnoreCase(app.getApplyFor());
	            }
	        };
	        
	        Predicate isTester = new Predicate() {
	            public boolean evaluate(Object obj) {
	                Applicant app = (Applicant) obj;
	                return "Tester".equalsIgnoreCase(app.getApplyFor());
	            }
	        };

	        Predicate isPM = new Predicate() {
	            public boolean evaluate(Object obj) {
	                Applicant app = (Applicant) obj;
	                return "Project Manager".equalsIgnoreCase(app.getApplyFor());
	            }
	        };
	        
	        Predicate[] checkApplyFor = new Predicate[] {
	                isDeveloper,
	                isTester,
	                isPM
	            };

	        Transformer developerTransformer = new Transformer() {
	            public Object transform(Object obj) {
	                Applicant app = (Applicant) obj;
	                return new Employee(
	                    app.getName(), app.getAge(), new Date(), "E4", 2000
	                );
	            }
	        };
	        
	        Transformer testerTransformer = new Transformer() {
	            public Object transform(Object obj) {
	                Applicant app = (Applicant) obj;
	                return new Employee(
	                    app.getName(), app.getAge(), new Date(), "E4", 2000
	                );
	            }
	        };
	        Transformer pmTransformer = new Transformer() {
	            public Object transform(Object obj) {
	                Applicant app = (Applicant) obj;
	                return new Employee(
	                    app.getName(), app.getAge(), new Date(), "E5", 3000
	                );
	            }
	        };
	        Transformer[] transformers = new Transformer[] {
	            developerTransformer,
	            testerTransformer,
	            pmTransformer
	        };
	        
	        // transform
	        Transformer employTransformer = new SwitchTransformer(
	            checkApplyFor, transformers, null
	        );
	        Collection employed = CollectionUtils.collect(appList, employTransformer);
	        
	        // output
	        System.out.println("Applicants: ");
	        Iterator iter1 = appList.iterator();
	        while (iter1.hasNext()) {
	            System.out.println(iter1.next());
	        }
	        System.out.println("Employed: ");
	        Iterator iter2 = employed.iterator();
	        while (iter2.hasNext()) {
	            System.out.println(iter2.next());
	        }


	}
}
