import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import rbs.module.transaction.dao.DaoImplementation;

public class Test {

	public static void main(String[] args) {
		DaoImplementation d = new DaoImplementation();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date = null;
		try {
			date = format.parse("01-01-2016");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new Date(date.getTime()));
		System.out.println(d.getTransactions(new Date(date.getTime())));

	}

}
