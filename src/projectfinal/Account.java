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
public class Account {
    private long accountNum;
    private double balance;
    private String owner;
    
    public Account(long accountNum, double balance, String owner){
        this.accountNum = accountNum;
        this.balance = balance;
        this.owner = owner;
    }
    
    public long getAccountNum(){
        return this.accountNum;
    }
    
    public double getBalance(){
        return this.balance;
    }
    
    public String getOwner(){
        return this.owner;
    }
    
    public boolean withdraw(double amount){
        if(amount >= balance){
            return false;
        }
        balance = balance - amount;
        return true;
    }
    
    public void deposit(double amount){
        if(amount > 0){
            balance = balance + amount;
        }
    }
    
    public boolean transfer(Account account, double amount){
        if(withdraw(amount)){
            account.deposit(amount);
            return true;
        }
        return false;
    }
    
    public String toString(){
        return "Account Number: " + getAccountNum() + "\nAccount Balance: " + getBalance() + "\nAccount Owner: " + getOwner();
    }
}
