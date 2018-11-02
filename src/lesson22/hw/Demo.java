package lesson22.hw;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {


        Transaction tr1=new Transaction(1,"Kiev",10,"test1", TransactionType.INCOME,new Date(28/10/2018));
        Transaction tr2=new Transaction(2,"Kiev",20,"test1", TransactionType.INCOME,new Date(28/10/2018));
        Transaction tr3=new Transaction(3,"Odessa",10,"test1", TransactionType.INCOME,new Date(28/10/2018));
        Transaction tr4=new Transaction(4,"Odessa",20,"test1", TransactionType.INCOME,new Date(28/10/2018));

        try{

            Controller.save(tr1);
            Controller.save(tr2);
            Controller.save(tr3);
            Controller.save(tr4);
            Controller.transactionList();
            Controller.transactionList("Kiev");
            Controller.transactionList(10);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}