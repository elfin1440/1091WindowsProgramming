package midExamPractice;

import java.util.Scanner;

public class account {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String account, password;
        int i = 0, n = -1;//do-while迴圈條件，輸入錯誤一次就跳回輸入帳密，正確就進入系統, n判斷帳號是否存在
        int cash = 0;//消費金額
        double payFor = 0;//結帳金額
		
        //帳號
        String[] acc = {"elfin1440", "max1234", "jack9487", "bin456", "Right"};
        //密碼
        String[] pass = {"amber0408", "min5678", "boy8741", "go789", "Left"};
        
        /*for(int k = 0; k < acc.length; k++) {
        	System.out.println(acc[k]);
        }*/

        do {
            System.out.println("Enter your account(you have " + (5-i) + " times to try, or you would be locked.): ");
            account = scn.next();
            
            //判斷帳號是否存在
            for(int l = 0; l < acc.length; l++) {
            	if(account.equals(acc[l])) {
            		n = l;
            		break;
            	}
            	else
            		n = -1;
            }
            //System.out.println("n: " + n);
            
            //帳號存在
    		if(n > -1) {
    			System.out.println("Enter your password: ");
                password = scn.next();
    			//輸入密碼在5次以內
    			if(i < 5) {
    				 //帳密皆正確
    	            if(account.equals(acc[n]) && password.equals(pass[n])){
    	            	System.out.println("login success，welcome^^");
    		            i = 0;//讓while迴圈停止
    		            }
    	            //密碼錯誤
    	            else if( account.equals(acc[n]) && !( password.equals(pass[n]) ) ) {
    	            	i++;//讓while迴圈繼續
    	            	if(i >= 5) 
    	    				System.out.println("you try too many times, your account was be locked.");
    	            	else
    	            		System.out.println("Your password is wrong, plz try again.");
    	            }
    		    }
    		}
    		//帳號不存在
    		else if(n == -1) {
    			i++;
    			//帳號錯誤超過5次
    			if(i >= 5) {
    				System.out.println("you try too many times, your account was be locked.");
    			}
    			else 
    				System.out.println("This account isn't exist.");
    			}
            
        }while(i > 0 && i < 5);
        
        if(i == 0) {
        	System.out.println("If you buy more than $2000, you can have 10% discount.");
            System.out.println("If you buy more than $1500, you can have $200 discount.");
            
            System.out.printf("Enter how much do you buy: ");
            cash = scn.nextInt();
            
            if(cash>=2000)//金額超過2000打9折
                payFor = cash - cash*0.1;
            else if(cash>=1500)//金額超過1500折200
                payFor = cash - 200;
            else
                payFor = cash;
                
            System.out.printf("your payfor is %.0f.", payFor);//結帳金額
    		
        }
        
        scn.close();
    }
}