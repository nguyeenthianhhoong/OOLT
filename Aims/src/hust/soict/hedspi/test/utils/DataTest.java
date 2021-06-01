package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;

public class DataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyDate a = new MyDate("second","December","fifteen ten");
        MyDate b = new MyDate("twenty-fifth","March","twenty zero");
        MyDate c = new MyDate("twenty-fifth","March","twenty zero");
        MyDate d = new MyDate("twenty-sixth","March","twenty zero");

        a.printFormat();
        a.print();
        b.print();
        DateUtils.compare(a, b);
        DateUtils.compare(c, b);
        DateUtils.compare(c, d);
        
	}

}
