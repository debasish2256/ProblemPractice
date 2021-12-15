package com.practice.test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ledgerCo {
	
	static Map<String,Map<String, Integer>> repaidLoanMap=new HashMap<>();
	static Map<String,Map<String,Map<Integer,Integer>>> paymentPerMonth = new HashMap<>();
    static Map<String,Map<String,Map<Integer,Integer>>> bankDueForBorrowerMap = new HashMap<>();
	
	public static void main(String[] args) {

		//add your folder path
		File folder = new File("C:\\Users\\debasish.mahana\\Downloads\\Test");
		File[] listOfFiles = folder.listFiles();
		//Iterate to the folder and process all input text file
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			try {
				fileReader(file);
			} catch (Exception e) {
				System.err.println("Exception Occured while processing rules in fileReader Method::"+e);
			}
		}
	}

	//@param is input text file path

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public static void fileReader(File file) throws Exception {
		Scanner sc=new Scanner(new FileInputStream(file));    
		while(sc.hasNextLine())  
		{  
			String commandLine=sc.nextLine();
			//for loan command
			if(commandLine.split(" ")[0].equalsIgnoreCase("LOAN")) {
				String bankName=commandLine.split(" ")[1];
				String borrowerName=commandLine.split(" ")[2];
				float principal=Float.parseFloat(commandLine.split(" ")[3]);
				float term=Float.parseFloat(commandLine.split(" ")[4]);   
				float interest= Float.parseFloat(commandLine.split(" ")[5])/100;
				float totalAmount=principal+(principal*interest*term);

				//Here we make a  map for lookup to know who takes how much loan from which bank 
				repaidLoanMap.put(bankName,new HashMap(){{put(borrowerName,(int)(totalAmount));}});

				Map<String,Map<Integer, Integer>> borrowerPaymentTillMonth=new HashMap<>();
				Map<Integer, Integer> paymentTillMonth=new HashMap<>();

				Map<String,Map<Integer, Integer>> borrowerDueMonthMap=new HashMap<>();
				Map<Integer, Integer> presentMonthVsDueMonth=new HashMap<>();

				int months=(int) (term*12);
				int emi = (int) Math.ceil(totalAmount/months);
				//Here we are creating a look up map for every transaction in every month 
				for(int i=0;i<=months;i++)
				{
					int payment=i*emi;
					if(payment>totalAmount)
					{
						payment=(int) (totalAmount-((i-1)*emi));
						payment+=((i-1)*emi);
					}
					paymentTillMonth.put(i, payment);
					borrowerPaymentTillMonth.put(borrowerName, paymentTillMonth);
					//Here we are creating a map in which we are putting the total emi paid till a particular month
					paymentPerMonth.put(bankName,borrowerPaymentTillMonth);

					presentMonthVsDueMonth.put(i, months-i);
					borrowerDueMonthMap.put(borrowerName, presentMonthVsDueMonth);
					//Total due month of each of the borrower in a specific month
					bankDueForBorrowerMap.put(bankName, borrowerDueMonthMap);
				}
			}
			//for payment command
			if(commandLine.split(" ")[0].equalsIgnoreCase("PAYMENT")) {
				String bankName=commandLine.split(" ")[1];
				String borrowerName=commandLine.split(" ")[2];
				int lumpSumAmount=Integer.parseInt(commandLine.split(" ")[3]);
				int months=Integer.parseInt(commandLine.split(" ")[4]);
				int lastMonth = 0;
				int totalLoan=repaidLoanMap.get(bankName).get(borrowerName);
				for(int k=months;k<paymentPerMonth.get(bankName).get(borrowerName).size();k++)
				{
					//Here we are adding lump sum amount to the given payment month and also after the given payment month. 
					paymentPerMonth.get(bankName).get(borrowerName).replace(k, paymentPerMonth.get(bankName).get(borrowerName).get(k)+lumpSumAmount);
					//
					if(paymentPerMonth.get(bankName).get(borrowerName).get(k)>totalLoan)
					{
						//Here we are updating the total emi paid till month after adding lump sum amount. 
						if(paymentPerMonth.get(bankName).get(borrowerName).get(k-1)>=totalLoan)
						{
							//if the total loan paid by any month after that replace the payment greater then total loan with total loan 
							paymentPerMonth.get(bankName).get(borrowerName).replace(k,totalLoan);
						}
					}
				}
				//Here we are finding that by which month the total loan get paid 
				for(int k=0;k<paymentPerMonth.get(bankName).get(borrowerName).size();k++)
				{
					if(paymentPerMonth.get(bankName).get(borrowerName).get(k)>=totalLoan)
					{
						lastMonth=k;
						break;
					}
				}
				//Here we are updating the due month after making lumpsum amount
				for(int k=months;k<bankDueForBorrowerMap.get(bankName).get(borrowerName).size();k++)
				{
					bankDueForBorrowerMap.get(bankName).get(borrowerName).replace(k, lastMonth-k);
				}
			}
			//for balance command
			if(commandLine.split(" ")[0].equalsIgnoreCase("BALANCE")) {
				String bankName=commandLine.split(" ")[1];
				String borrowerName=commandLine.split(" ")[2];
				int months=Integer.parseInt(commandLine.split(" ")[3]);
				System.out.println(bankName+" "+borrowerName+" "+paymentPerMonth.get(bankName).get(borrowerName).get(months)+" "+bankDueForBorrowerMap.get(bankName).get(borrowerName).get(months));
			}
		}
		System.out.println("-------------------");
		sc.close();    
	}
}
