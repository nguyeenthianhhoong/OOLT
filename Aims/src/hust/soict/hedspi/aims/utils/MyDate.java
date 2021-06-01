package hust.soict.hedspi.aims.utils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class MyDate {
	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		 if (!dateIsValid(day, this.month, this.year)) {
	            System.out.println("Error");
	        } else {
	            this.day = day;
	        }
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (!dateIsValid(day, this.month, this.year)) {
            System.out.println("Error");
        } else {
            this.month = month;
        }

	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year < 0 )
			System.out.println("Error");
		this.year = year;
	}
	
	public MyDate() {
		Calendar current_date = Calendar.getInstance();
		this.day= current_date.get(Calendar.DAY_OF_MONTH);
		this.month=current_date.get(Calendar.MONTH) ;
		this.year= current_date.get(Calendar.YEAR);
		
	}
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public MyDate(String dateStr) {
		 String str[] = dateStr.split(" ");
		 if (dateIsValid(Integer.parseInt(str[0]), Integer.parseInt(str[1]),Integer.parseInt(str[2]))) {
			 this.day = Integer.parseInt(str[0]);
			 this.month = Integer.parseInt(str[1]);
			 this.year = Integer.parseInt(str[2]);
		  }else System.out.println("Error");
	}
	
    public boolean dateIsValid(int day, int month, int year) {
        if (day < 0 || year < 0) {
            return false;
        }
        switch (month) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                return (day > 31) ? false : true;
            case 4: case 6: case 9:
            case 11:
                return (day > 30) ? false : true;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) ||
                        year % 400 == 0) {
                    return (day > 29) ? false : true;
                }
                return (day > 28) ? false : true;
            default:
                return false;
        }
    }
    
    public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a date (dd mm yyyy):");
		String dateStr= sc.nextLine();
		MyDate d = new MyDate(dateStr);
		System.out.println(d.getDay()+"/"+ d.getMonth()+"/"+d.getYear());
	} 
	
	public void print() {
		//MyDate d = new MyDate();
		//System.out.println(d.getDay()+"/"+ d.getMonth()+"/"+d.getYear());
		Calendar d = Calendar.getInstance();
        d.set(year, month, day);
        String dateFormat;
        
        switch (day) {
            case 1:
                dateFormat = "MMMMM d'st' yyyy";
                break;
            case 2:
                dateFormat = "MMMMM d'nd' yyyy";
                break;
            case 3:
                dateFormat = "MMMMM d'rd' yyyy";
                break;
            default:
                dateFormat = "MMMMM dd'th' yyyy";
                break;
        }
        
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        System.out.println(format.format(d.getTime())); 
	}
	
	
    public MyDate(String day, String month, String year) {
        String[] strDay = {"zero","first","second","third","fourth","fifth","sixth","seventh","eighth","ninth","tenth","eleventh","twelfth","thirteenth",
            "fourteenth","fifteenth","sixteenth","seventeenth","eighteenth","nineteenth","twentieth","twenty-first","twenty-second","twenty-third",
            "twenty-fourth","twenty-fifth","twenty-sixth","twenty-seventh","twenty-eighth","twenty-ninth","thirtieth","thirty-first"};
        String[] strMonth = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        String unitsArray[] = { "zero", "one", "two", "three", "four", "five", "six", 
                      "seven", "eight", "nine", "ten", "eleven", "twelve",
                      "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", 
                      "eighteen", "nineteen" };
        String tensArray[] = { "zero", "ten", "twenty", "thirty", "forty", "fifty",
                      "sixty", "seventy", "eighty", "ninety" };
        for(int i=0;i<=31;i++) {
            if(strDay[i].equals(day))
                this.day = i;
        }
        for(int i=0;i<12;i++) {
            if(strMonth[i].equals(month))
                this.month = i;
        }
        
        String[] yearList = year.split(" ");
        int y = 0;
        switch (yearList.length) {
            case 4:
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) y += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) y += i*100;
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) y += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[3])) y += i;
                break;
            case 3:
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) y += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) y += i*100;
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) y += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) y += i*100;
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[2])) y += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[2])) y += i;
                break;
            case 2:
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[0])) y += i*1000;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[0])) y += i*100;
                for(int i=0;i<10;i++) if(tensArray[i].equals(yearList[1])) y += i*10;
                for(int i=0;i<20;i++) if(unitsArray[i].equals(yearList[1])) y += i; 
                break;
            default:
                break;
        }

        this.year = y;
    }
    
    
    public void printFormat() {
        Calendar d = Calendar.getInstance();
        d.set(year, month, day);
        String dateFormat;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose the date format:");
        System.out.println("1. yyyy-MM-dd");
        System.out.println("2. d/M/yyyy");
        System.out.println("3. dd-MMM-yyyy");
        System.out.println("4. MMM d yyyy");
        System.out.println("5. mm-dd-yyyy");
        int i = sc.nextInt();
        
        switch (i) {
            case 1:
                dateFormat = "yyyy-MM-dd";
                break;
            case 2:
                dateFormat = "d/M/yyyy";
                break;
            case 3:
                dateFormat = "dd-MMM-yyyy";
                break;
            case 4:
                dateFormat = "MMM d yyyy";
                break;
            case 5:
                dateFormat = "mm-dd-yyyy";
                break;
            default:
                dateFormat = "MMMMM dd yyyy";
                break;
        }
        
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        System.out.println(format.format(d.getTime())); 
                                                                
    }

}
