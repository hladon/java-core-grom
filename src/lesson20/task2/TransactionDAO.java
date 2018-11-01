package lesson20.task2;

import lesson20.task2.Exception.BadRequestException;
import lesson20.task2.Exception.InternalServerException;
import lesson20.task2.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

public class TransactionDAO {

    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {


        validate(transaction);


        for (Transaction tr: transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new LimitExceeded("Already exist such transaction" + transaction.getId() + ". Can`t be saved");
            }
        }

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                transactions[i] = transaction;

                return transactions[i];
            }
        }

        throw new InternalServerException("Base is full " + transaction.getId() + ". Can`t be saved");

    }

    private void validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount()) {
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can`t be saved");
        }

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum >= utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded(
                    "Transaction limit per day amount exceed " + transaction.getId() + ". Can`t be saved");
        }

        if (count >= utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded(
                    "Transaction limit per day count exceed " + transaction.getId() + ". Can`t be saved");
        }

        for (String city : utils.getCities()) {
            if (city.equalsIgnoreCase(transaction.getCity())) {
                return;
            }
        }
        throw new BadRequestException("Transaction from not allowed city " + transaction.getId() + ". Can`t be saved");
    }

    public Transaction[] transactionList() {
        return sort(transactions);

    }

    private Transaction[] sort(Transaction[] array) {
        int count = 0;
        for (Transaction tr : array) {
            if (tr != null) {
                count++;
            }
        }

        Transaction[] resultList = new Transaction[count];
        int index = 0;
        for (Transaction tr : array) {
            if (tr != null) {
                resultList[index] = tr;
                index++;
            }
        }
        return resultList;
    }

    public Transaction[] transactionList(String city) throws Exception {
        if (city == null) {
            throw new BadRequestException("Wrong input data");
        }
        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equalsIgnoreCase(city)) {
                count++;
            }
        }
        if (count == 0) {
            throw new BadRequestException("No transactions from this city");
        }
        Transaction[] resultList = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equalsIgnoreCase(city)) {
                resultList[index] = tr;
                index++;
            }
        }
        return resultList;
    }

    Transaction[] transactionList(int amount) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                count++;
            }
        }

        Transaction[] resultList = new Transaction[count];
        int index = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getAmount() == amount) {
                resultList[index] = tr;
                index++;
            }
        }
        return resultList;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    count++;
                }
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }
}

