


public class OrdinateurBanque {
	private int key;
	private double TotalPayer;


	/**

	 */
	public OrdinateurBanque()
	{
		TotalPayer = 0;

	}

	public OrdinateurBanque(int key, double totalPayer) {
		this.key=key;
		this.TotalPayer=totalPayer;
	}

	/**

	@param 
	 */
	public void depot(double amount)
	{
		System.out.print("Payer" );
		double payer = 0;

		TotalPayer=0;
	}
	/**

	 @param 
	 */


	/**

	 @return 
	 */
	public double getTotalPayer()
	{
		return TotalPayer;
	}

	public int getkey()
	{
		return key;
	}
	public String toString(){
		return "key "+key +"\n Total a Payer "+TotalPayer;
	}
}




