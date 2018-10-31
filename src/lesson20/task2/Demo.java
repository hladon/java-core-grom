package lesson20.task2;


import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller test=new Controller();
        Transaction tr1=null;
        Transaction tr2=null;
        Transaction tr3=null;
        Transaction tr4=null;
        Transaction tr5=null;

        try{
            tr1=new Transaction(1,"Kiev",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
            tr2=new Transaction(2,"Kiev",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
            tr3=new Transaction(3,"Odessa",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
            tr4=new Transaction(4,"Odessa",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
            tr5=new Transaction(5,"Odessa",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.save(tr1);
            test.save(tr2);
            test.save(tr3);
            test.save(tr4);
            test.save(tr5);
            System.out.println(Arrays.toString(test.transactionList()));
            System.out.println(Arrays.toString(test.transactionList("Kiev")));
            System.out.println(Arrays.toString(test.transactionList(10)));
            test.transactionList();
            test.transactionList("Kiev");
            test.transactionList(10);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}