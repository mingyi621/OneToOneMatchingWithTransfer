import java.util.Scanner;
public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.printf("Input the number of sellers:");
		int numberOfSellers = sc.nextInt();
		System.out.printf("Input the sellers' valuations:");
		double[] sellersValuations = new double[numberOfSellers];
		for(int i = 0; i < numberOfSellers; i++)
		{
			sellersValuations[i] = sc.nextDouble();
		}
		
		System.out.printf("Input the number of buyers:");
		int numberOfBuyers = sc.nextInt();
		
		double[][] buyersValuations = new double[numberOfBuyers][numberOfSellers];
		for(int i = 0; i < numberOfBuyers; i++)
		{
			System.out.printf("Input the buyer %d's valuations:", i+1);
			for(int j = 0; j < numberOfSellers; j++)
			{
				buyersValuations[i][j] = sc.nextDouble(); 
			}
		}
		System.out.printf("Set Epsilon:");
		double epsilon = sc.nextDouble();
		//Input Done.
		
		
		Buyer[] buyer = new Buyer[numberOfBuyers];
		for(int i = 0; i < numberOfBuyers; i++)
		{
			buyer[i] = new Buyer(buyersValuations[i]);
		}
		
		Seller[] seller = new Seller[numberOfSellers];
		for(int i = 0; i < numberOfSellers; i++)
		{
			seller[i] = new Seller(sellersValuations[i], i ,epsilon);
		}
		

		int maxNumberOfLinks = 0;
		do{
			// determine which seller
			for(int i = 0; i < numberOfBuyers; i++)
			{
				buyer[i].determineWhichSeller(seller);
				System.out.printf("Buyer %d to seller %d\n", i, buyer[i].getWhichSeller());
			}
			
			// determine the next step of each seller

			maxNumberOfLinks = 0;
			for(int i = 0; i < numberOfSellers; i++)
			{
				seller[i].setNumberOfLinks(buyer);
				
				if(seller[i].getNumberOfLinks() == 0)
				{
					
				}
				else if(seller[i].getNumberOfLinks() == 1)
				{
					
					
				}
				else if(seller[i].getNumberOfLinks() >= 2)
				{
					seller[i].setAsk(false);
					maxNumberOfLinks = seller[i].getNumberOfLinks();
				}
				else;
				System.out.printf("Seller %d number of links = %d, ask = %.2f\n", i, seller[i].getNumberOfLinks(),seller[i].getAsk());
			}
		}while(maxNumberOfLinks>=2);
		
		// Print out the result.
		
		for(int i = 0; i < numberOfSellers; i++)
		{
			if(seller[i].getTheBuyer() == -1)
				System.out.printf("Seller %d with no buyer.\n",i);
			else 
				System.out.printf("Seller %d with buyer %d in %.2f dollars.\n", i, seller[i].getTheBuyer(), seller[i].getAsk());
		}
	}

}
