
public class Buyer 
{
	double[] valuations;
	double[] utility;
	int numberOfSellers;
	int whichSeller;
	
	public Buyer(double[] v)
	{
		setValuations(v);
	}
	
	public void setNumberOfSellers(int s)
	{
		numberOfSellers = s;
	}
	public void setValuations(double[] v)
	{
		valuations = v;
	}
	public void setUtility(Seller[] s)
	{
		utility = new double[s.length];
		for(int i = 0; i < s.length; i++)
		{
				utility[i] = valuations[i] - s[i].getAsk();
		}
	}
	public void determineWhichSeller(Seller[] s)
	{
		double maxUtility = 0;
		whichSeller = -1;
		setUtility(s);
		for(int i = 0; i < s.length; i++)
		{
			if(utility[i] > maxUtility && utility[i] >= 0)
			{
				maxUtility = utility[i];
				whichSeller = i;
			}
		}	
	}
	public int getWhichSeller()
	{
		return whichSeller;
	}

}
