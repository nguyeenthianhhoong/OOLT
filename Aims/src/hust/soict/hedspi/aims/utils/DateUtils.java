package hust.soict.hedspi.aims.utils;

import hust.soict.hedspi.aims.utils.*;

public class DateUtils {
	public static void compare(MyDate a, MyDate b) {
        if(a.getYear() > b.getYear())
        	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " after " +
        						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
        else if (a.getYear() < b.getYear())
        	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " before " +
        						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
        else {
            if(a.getMonth() > b.getMonth())
            	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " after " +
            						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
            else if(a.getMonth() < b.getMonth())
            	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " before " +
            						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
            else {
                if(a.getDay() > b.getDay())
                	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " after " +
                						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
                else if(a.getDay() < b.getDay())
                	System.out.println(a.getDay()+" "+(a.getMonth()+1)+" "+a.getYear()+ " before " +
                						b.getDay()+" "+(b.getMonth()+1)+" "+b.getYear());
                else 
                    System.out.println("two dates are same");
            }
        }
    }


}
