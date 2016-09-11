package rbs.module.transaction.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Formatter;

import rbs.module.transaction.model.Transaction;

public class DaoImplementation implements Dao {

	@Override
	public ArrayList<Transaction> getTransactions(Date date) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		try{	
			Connection c = DatabaseConnection.getConnection();
			PreparedStatement query = c.prepareStatement("select * from transaction where trans_date= to_date(?,'dd-mm-yyyy')");
			query.setString(1, dateToString(date));
    		ResultSet result = query.executeQuery();
    		
    		while(result.next()){
    			Transaction t=new Transaction();
    			t.setTransactionId(result.getDouble(1));
    			t.setTransactionDate(dateToString(result.getDate(2)));
    			t.setTransactionType(result.getString(3));
    			t.setAmount(result.getDouble(4));
    			t.setAccountNumber(result.getDouble(5));
    			t.setAccountType(result.getString(6));
    			
    			transactions.add(t);
    		} 		
    		c.close();
		}
		catch (Exception e) {
			System.out.println("failure");	
		}
		return transactions;
	}

	@Override
	public ArrayList<Transaction> getTransactions(String accountType) {
		// TODO Auto-generated method stub
		return null;
	}
	
	String dateToString(java.sql.Date d){
		return new Formatter().format("%td-%tm-%tY",d,d,d).toString();
    }

}
