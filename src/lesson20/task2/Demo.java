package lesson20.task2;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Controller test=new Controller();
        Transaction tr1=null;
        Transaction tr2=null;
        Transaction tr3=null;
        Transaction tr4=null;
        
        try{
         tr1=new Transaction(1,"Kiev",10,"test1",TransactionType.INCOME,new Date(28/10/2018));
         tr2=new Transaction(1,"Kiev",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
         tr3=new Transaction(1,"Odessa",10,"test1",TransactionType.INCOME,new Date(28/10/2018));
         tr4=new Transaction(1,"Odessa",20,"test1",TransactionType.INCOME,new Date(28/10/2018));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            test.save(tr1);
            test.save(tr2);
            test.save(tr3);
            test.save(tr4);
            test.transactionList();
            test.transactionList("Kiev");
            test.transactionList(10);


        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
