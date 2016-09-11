package rbs.module.transaction.dao;

import java.sql.Date;
import java.util.ArrayList;

import rbs.module.transaction.model.Transaction;

public interface Dao {
	ArrayList<Transaction> getTransactions(Date date);
	ArrayList<Transaction> getTransactions(String accountType);
}
