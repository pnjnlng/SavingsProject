import java.util.Scanner;
public class SavingsProject {
	public static void main(String[] args) {

		Scanner savingsAccountInfo =  new Scanner(System.in);
		System.out.println("Enter the following data: principal monthly apy compounding years");
		double ID = savingsAccountInfo.nextDouble();
		double MD = savingsAccountInfo.nextDouble();
		double IR = savingsAccountInfo.nextDouble();
		String CF = savingsAccountInfo.next();
		int NY = savingsAccountInfo.nextInt();
		savingsAccountInfo.close();
		
		System.out.printf("Simulating $%,.2f plus $%,.2f per month at %.2f APY compounded " + CF + " for " + NY + " years:\n", ID, MD, IR);
		
		// int = interest , amt = amount
		
		//Yearly Interest Calculator
		double interest = (IR/100);
		double yearCTotalBeforeInt = ID;
		double yearCPrincipalAmt = ID;
		if(CF.equals("yearly")) {
			for(int i = 1; i <= NY; i++) {
				yearCTotalBeforeInt += (MD*12);
				double yearCIntFinal = yearCTotalBeforeInt * ((1+(interest)));
				yearCTotalBeforeInt = yearCIntFinal;
				yearCPrincipalAmt += (MD * 12);
				double yearCIntAdd = yearCTotalBeforeInt - yearCPrincipalAmt;
				double roundedFinal = Math.round(yearCIntFinal * 100.0) / 100.0;
				double roundedIntAdd = Math.round(yearCIntAdd * 100.0) / 100.0;
				System.out.printf("Year " + i + " ending balance is $%,.2f with $%,.2f from interest. \n", roundedFinal, roundedIntAdd);
				
			}
		}
		
		//Monthly Interest Calculator	
		double monthCTotalBeforeInt = ID;
		double monthCPrincipalAmt = ID;	
		if(CF.equals("monthly")) {
			for(int j = 1; j <= NY; j++) {
				for(int k = 1; k <= 12; k++) {
					monthCTotalBeforeInt += MD;
					double monthCTotalFinal = monthCTotalBeforeInt * (1+(interest/12));
					monthCTotalBeforeInt = monthCTotalFinal;
				}
				monthCPrincipalAmt += (MD*12);
				double monthCIntAdd = monthCTotalBeforeInt - monthCPrincipalAmt;
				System.out.printf("Year " + j + " ending balance is $%,.2f with $%,.2f from interest. \n", monthCTotalBeforeInt, monthCIntAdd);
			}
		}
		
		//Daily Interest Calculator
		double dailyCTotalBeforeInt = ID;
		double dailyCPrincipalAmt = ID;
		if(CF.equals("daily")) {
		for(int n=1; n <= NY; n++) {
				for(int o = 1; o <= 12 ; o++) {
				dailyCTotalBeforeInt += MD;
				for(int m = 1; m <= 30; m++){
					double dailyCTotalFinal = dailyCTotalBeforeInt * (1+(interest/360));
					dailyCTotalBeforeInt = dailyCTotalFinal;
				}
			}  
			dailyCPrincipalAmt += (MD*12);
			double dailyCIntAdd = dailyCTotalBeforeInt - dailyCPrincipalAmt;
			System.out.printf("Year " + n + " ending balance is $%,.2f with $%,.2f from interest. \n", dailyCTotalBeforeInt, dailyCIntAdd);
		   }
		}
		
	}
}