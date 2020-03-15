/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectfinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author VOSTRO
 //Beatriz Morales 101159722   
 //Paul Ikhane 101162941
 //Collins Mbuton 101175934 
 */

public class ProjectFinal extends Application implements EventHandler<ActionEvent> {

    Stage window;
    Scene mainScene;
    Button addAccountMenu, depositMenu, withdrawMenu, transferMenu, viewAccountsMenu;
    BorderPane mainBorderPane;
    VBox addLayout, depositLayout, withdrawLayout, transferLayout, listLayout;
    HBox hbox, addBtnHbox, depositBtnHbox, withdrawBtnHbox, transferBtnHbox;
    HBox bankMsgAddLbHbox, bankMsgdepLbHbox, bankMsgWitLbHbox, bankMsgTraLbHbox, bankMsgLisLbHbox;
    
    //Scene fields
    Button btnAdd, btnDeposit, btnWithdraw, btnTransfer;
    TextField nameTxt, accountNumTxt, balTxt, accDepositNumTxt, depositTxt;
    TextField accWithdrawNumTxt, withdrawTxt, accTransferFromNumTxt, accTransferToNumTxt, transferAmountTxt; 
    Label addMsg, depMsg, withdrawMsg, tranMsg;
    TextArea showList;
    
    Bank bank;
    
    public void init(){
        bank = new Bank(10000);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("PrimaryStage");
        
        
        //MENUs
        addAccountMenu = new Button("ADD ACCOUNT");
        addAccountMenu.setStyle("-fx-background-color: #41a9c9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        depositMenu = new Button("DEPOSIT");
        depositMenu.setStyle("-fx-background-color: #41a9c9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        withdrawMenu = new Button("WITHDRAW");
        withdrawMenu.setStyle("-fx-background-color: #41a9c9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        transferMenu = new Button("TRANSFER");
        transferMenu.setStyle("-fx-background-color: #41a9c9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        viewAccountsMenu = new Button("VIEW ACCOUNTS");
        viewAccountsMenu.setStyle("-fx-background-color: #41a9c9; -fx-text-fill: white; -fx-padding: 5 10 5 10;");
        hbox = new HBox();
        hbox.getChildren().addAll(addAccountMenu, depositMenu, withdrawMenu, transferMenu, viewAccountsMenu);
        mainBorderPane = new BorderPane();
        mainBorderPane.setStyle("-fx-background-color: #ececec;");
        mainBorderPane.setTop(hbox);
        

        
        //ADD Scene
        Label aMsg = new Label("Welcome to Trusty Bank");
        aMsg.setStyle("-fx-font: normal bold 20px 'serif'; -fx-text-fill: #c84164 ");
        bankMsgAddLbHbox = new HBox(aMsg);
        bankMsgAddLbHbox.setStyle("-fx-font: normal bold 20px 'serif' ");
        bankMsgAddLbHbox.setPadding(new Insets(0, 0, 70, 120));
        
        Label lbName = new Label("Account Name:");
        lbName.setStyle("-fx-font: normal bold 15px 'serif'; -fx-text-fill: #888888 ");
        nameTxt = new TextField();
        Label lbAccountNum = new Label("Account Number:");
        lbAccountNum.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        accountNumTxt = new TextField();
        Label lbBalance = new Label("Balance:");
        lbBalance.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888");
        balTxt = new TextField();
        btnAdd = new Button("ADD ACCOUNT");
        btnAdd.setStyle("-fx-background-color: #f3622d; -fx-text-fill: white; -fx-effect: dropshadow( three-pass-box ), rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); -fx-padding: 10 20 10 20;");
        addBtnHbox = new HBox(btnAdd);
        addBtnHbox.setPadding(new Insets(15, 0, 0, 0));
        btnAdd.setOnAction(this);
        addAccountMenu.setOnAction(this);
        addLayout = new VBox();
        addLayout.setSpacing(8);
        addMsg = new Label();
        addMsg.setStyle("-fx-font: normal bold 13px 'serif' ");
        addLayout.getChildren().addAll(bankMsgAddLbHbox, lbName, nameTxt, lbAccountNum, accountNumTxt, lbBalance, balTxt, addBtnHbox, addMsg);
        BorderPane.setMargin(addLayout, new Insets(70, 80, 10, 80));
        mainBorderPane.setCenter(addLayout);
        
        
        
        
        //DEPOSIT Scene
        Label dMsg = new Label("Welcome to Trusty Bank");
        dMsg.setStyle("-fx-font: normal bold 20px 'serif'; -fx-text-fill: #c84164 ");
        bankMsgdepLbHbox = new HBox(dMsg);
        bankMsgdepLbHbox.setStyle("-fx-font: normal bold 20px 'serif' ");
        bankMsgdepLbHbox.setPadding(new Insets(0, 0, 70, 120));
        
        Label lbAccountDepositNum = new Label("Account Number:");
        lbAccountDepositNum.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        accDepositNumTxt = new TextField();
        Label lbDepositAmount = new Label("Deposit Amount:");
        lbDepositAmount.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        depositTxt = new TextField();
        btnDeposit = new Button("DEPOSIT");
        btnDeposit.setStyle("-fx-background-color: #f3622d; -fx-text-fill: white; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); -fx-padding: 10 20 10 20;");
        btnDeposit.setOnAction(this);
        depositBtnHbox = new HBox(btnDeposit);
        depositBtnHbox.setPadding(new Insets(15, 0, 0, 0));
        depositMenu.setOnAction(this);
        depMsg = new Label();
        depMsg.setStyle("-fx-font: normal bold 13px 'serif' ");
        depositLayout = new VBox();
        depositLayout.setSpacing(8);
        depositLayout.getChildren().addAll(bankMsgdepLbHbox, lbAccountDepositNum, accDepositNumTxt, lbDepositAmount, depositTxt, depositBtnHbox, depMsg);
        
        
        
        // WITHDRAW Scene
        Label wMsg = new Label("Welcome to Trusty Bank");
        wMsg.setStyle("-fx-font: normal bold 20px 'serif'; -fx-text-fill: #c84164 ");
        bankMsgWitLbHbox = new HBox(wMsg);
        bankMsgWitLbHbox.setStyle("-fx-font: normal bold 20px 'serif' ");
        bankMsgWitLbHbox.setPadding(new Insets(0, 0, 70, 120));
        
        Label lbAccountWithdrawNum = new Label("Account Number:");
        lbAccountWithdrawNum.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        accWithdrawNumTxt = new TextField();
        Label lbWithdrawAmount = new Label("Withdrawal Amount:");
        lbWithdrawAmount.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        withdrawTxt = new TextField();
        btnWithdraw = new Button("WITHDRAW");
        btnWithdraw.setStyle("-fx-background-color: #f3622d; -fx-text-fill: white; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); -fx-padding: 10 20 10 20;");
        withdrawBtnHbox = new HBox(btnWithdraw);
        withdrawBtnHbox.setPadding(new Insets(15, 0, 0, 0));
        btnWithdraw.setOnAction(this);
        withdrawMenu.setOnAction(this);
        withdrawMsg = new Label();
        withdrawMsg.setStyle("-fx-font: normal bold 13px 'serif' ");
        withdrawLayout = new VBox();
        withdrawLayout.setSpacing(8);
        withdrawLayout.getChildren().addAll(bankMsgWitLbHbox, lbAccountWithdrawNum, accWithdrawNumTxt, lbWithdrawAmount, withdrawTxt, withdrawBtnHbox, withdrawMsg);
        
        
        //TRANSFER SCENE
        Label tMsg = new Label("Welcome to Trusty Bank");
        tMsg.setStyle("-fx-font: normal bold 20px 'serif'; -fx-text-fill: #c84164 ");
        bankMsgTraLbHbox = new HBox(tMsg);
        bankMsgTraLbHbox.setStyle("-fx-font: normal bold 20px 'serif' ");
        bankMsgTraLbHbox.setPadding(new Insets(0, 0, 70, 120));
        
        Label lbAccountTransferNum = new Label("Sending Account Number:");
        lbAccountTransferNum.setStyle("-fx-font: normal bold 13px 'serif' ; -fx-text-fill: #888888");
        accTransferFromNumTxt = new TextField();
        Label lbAccountTransferTo = new Label("Receiving Account Number:");
        lbAccountTransferTo.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888  ");
        accTransferToNumTxt = new TextField();
        Label lbTransferAmount = new Label("Transfer Amount:");
        lbTransferAmount.setStyle("-fx-font: normal bold 13px 'serif'; -fx-text-fill: #888888 ");
        transferAmountTxt = new TextField();
        btnTransfer = new Button("TRANSFER");
        btnTransfer.setStyle("-fx-background-color: #f3622d; -fx-text-fill: white; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 ); -fx-padding: 10 20 10 20;");
        transferBtnHbox = new HBox(btnTransfer);
        transferBtnHbox.setPadding(new Insets(15, 0, 0, 0));
        btnTransfer.setOnAction(this);
        transferMenu.setOnAction(this);
        tranMsg = new Label();
        tranMsg.setStyle("-fx-font: normal bold 13px 'serif' ");
        transferLayout = new VBox();
        transferLayout.setSpacing(8);
        transferLayout.getChildren().addAll(bankMsgTraLbHbox, lbAccountTransferNum, accTransferFromNumTxt, lbAccountTransferTo, accTransferToNumTxt, lbTransferAmount, transferAmountTxt, transferBtnHbox, tranMsg);
        
        
        //LIST ACCOUNT SCENE
        Label lMsg = new Label("Welcome to Trusty Bank");
        lMsg.setStyle("-fx-font: normal bold 20px 'serif'; -fx-text-fill: #c84164 ");
        bankMsgLisLbHbox = new HBox(lMsg);
        bankMsgLisLbHbox.setPadding(new Insets(0, 0, 70, 120));
        
        showList = new TextArea();
        showList.setStyle("-fx-font: normal bold 13px 'serif' ");
        viewAccountsMenu.setOnAction(this);
        listLayout = new VBox();
        listLayout.setSpacing(8);
        listLayout.getChildren().addAll(bankMsgLisLbHbox, showList);
        
        
        //Main Scene    
        mainScene = new Scene(mainBorderPane, 600, 600);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
    
    public void handle(ActionEvent e){
        if(e.getSource() == addAccountMenu){
            mainBorderPane.setCenter(addLayout);
            BorderPane.setMargin(addLayout, new Insets(70, 80, 10, 80));
            //depositLayout.setManaged(true);
        }
        if(e.getSource() == depositMenu){
            BorderPane.setMargin(depositLayout, new Insets(70, 80, 10, 80));
            mainBorderPane.setCenter(depositLayout);
            //addLayout.setManaged(true);
        }
        if(e.getSource() == withdrawMenu){
            BorderPane.setMargin(withdrawLayout, new Insets(70, 80, 10, 80));
            mainBorderPane.setCenter(withdrawLayout);
        }
        if(e.getSource() == transferMenu){
            BorderPane.setMargin(transferLayout, new Insets(70, 80, 10, 80));
            mainBorderPane.setCenter(transferLayout);
        }
        if(e.getSource() == viewAccountsMenu){
            BorderPane.setMargin(listLayout, new Insets(70, 80, 10, 80));
            mainBorderPane.setCenter(listLayout);
            showList.setEditable(false);
            showList.setText(bank.printAccounts());
        }
        
        //BUTTONs FOR TRANSACTIONS
        if(e.getSource() == btnAdd){
            long accNum = Long.valueOf(accountNumTxt.getText());
            double bal = Double.valueOf(balTxt.getText());
            bank.addAccount(accNum, bal, nameTxt.getText());
            addMsg.setText("Account Added.");
            accountNumTxt.setText("");
            balTxt.setText("");
            nameTxt.setText("");
        }
        if(e.getSource() == btnDeposit){
            long depNum = Long.valueOf(accDepositNumTxt.getText());
            double depAmount = Double.valueOf(depositTxt.getText());
            bank.depositAccount(depNum, depAmount);
            depMsg.setText("Deposit Successful");
            accDepositNumTxt.setText("");
            depositTxt.setText("");
        }
        if(e.getSource() == btnWithdraw){
            long withdrawAcc = Long.valueOf(accWithdrawNumTxt.getText());
            double withdrawAmount = Double.valueOf(withdrawTxt.getText());
            bank.withdrawAccount(withdrawAcc, withdrawAmount);
            withdrawMsg.setText("Withdraw Successful");
            accWithdrawNumTxt.setText("");
            withdrawTxt.setText("");
        }
        if(e.getSource() == btnTransfer){
            long accTransferFrom = Long.valueOf(accTransferFromNumTxt.getText());
            long accTransferTo = Long.valueOf(accTransferToNumTxt.getText());
            double transferAmount = Double.valueOf(transferAmountTxt.getText());
            bank.transfer(accTransferFrom, accTransferTo, transferAmount);
            tranMsg.setText("Transfer Successful");
            accTransferFromNumTxt.setText("");
            accTransferToNumTxt.setText("");
            transferAmountTxt.setText("");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
