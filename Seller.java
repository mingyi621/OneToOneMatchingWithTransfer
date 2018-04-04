
public class Seller 
{
	double valuation;
	double ask;
	double epsilon;
	int numberOfLinks = 0;
	int sellerNumber;
	int theBuyer;
	
	public Seller(double v, int i, double e)
	{
		setValuation(v);
		setAsk(true);
		setSellerNumber(i);
		setEpsilon(e);
		setTheBuyer();
	}
	public void setValuation(double v)
	{
		valuation = v;
	}
	public double getValuation()
	{
		return valuation;
	}
	public void setAsk(boolean isStart)
	{
		if(isStart)
			ask = valuation;
		else
			ask = ask + epsilon;
	}
	public double getAsk()
	{
		return ask;
	}
	public void setEpsilon(double e)
	{
		epsilon = e;
	}
	public double getEpsilon()
	{
		return epsilon;
	}
	
	public void setNumberOfLinks(Buyer[] b)
	{
		numberOfLinks = 0;
		for(int i = 0; i < b.length; i++)
		{
			if(b[i].whichSeller == sellerNumber)
			{
				numberOfLinks++;
				theBuyer = i;
			}
		}
	}
	public int getNumberOfLinks()
	{
		return numberOfLinks;
	}
	public void setSellerNumber(int n)
	{
		sellerNumber = n;
	}
	public void setTheBuyer()
	{
		theBuyer = -1;
	}
	public int getTheBuyer()
	{
		return theBuyer;
	}
}
