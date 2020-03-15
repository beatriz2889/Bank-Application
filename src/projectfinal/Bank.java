/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

/**
 *
 * @author VOSTRO
 //Beatriz Morales 101159722
 //Paul Ikhane 101162941
 //Collins Mbuton 101175934
 */
public class Bank {
    private int numAccount;
   private int maxAccount;
   private Account[] accountList;
   
   public Bank(int max){
       numAccount = 0;
       maxAccount = max;
       accountList = new Account[max];
   }
   
   public boolean addAccount(long accNum, double bal, String own){
       if(numAccount >= maxAccount){
           return false;
       }
       Account a = new Account(accNum, bal, own);
       accountList[numAccount] = a;
       numAccount++;
       return true;
   }
   
   public int findAccount(long accNum){
       for(int x = 0; x < numAccount; x++){
           if(accountList[x].getAccountNum() == accNum){
               return x;
           }
       }
       return -1;
   }
   
   public void depositAccount(long accNum, double amount){
       int accountIndex = findAccount(accNum);
       if(accountIndex != -1){
           accountList[accountIndex].deposit(amount);
       }
   }
   
   public boolean withdrawAccount(long accNum, double amount){
       int accountIndex = findAccount(accNum);
       if(accountIndex == -1){
           return false;
       }
       return accountList[accountIndex].withdraw(amount);
   }
   
   public boolean transfer(long accNumFrom, long accNumTo, double amount){
       int accountFrom = findAccount(accNumFrom);
       int accountTo = findAccount(accNumTo);
       if(accountFrom == -1 || accountTo == -1){
           return false;
       }
       return accountList[accountFrom].transfer(accountList[accountTo], amount);
   }
   
   public String printAccounts(){
       String accounts = "";
       for (int x = 0; x < numAccount; x++){
           accounts += accountList[x].toString() + "\n\n";
       }
       return accounts;
   }
}
