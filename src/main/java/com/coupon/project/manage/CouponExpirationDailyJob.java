package manage;

public class CouponExpirationDailyJob implements Runnable {

	public boolean quite=false;
	
	public CouponDAO couponsDAO;
	
	public CouponExpirationDailyJob()
	throws Exception{
//		run();
	}

	/**
	 * Runs this operation.
	 */
	@Override
	public void run(){
		couponsDAO=new CouponsDBDAO();
		for(int i=0;i<100;i++)
		{
if(i==50)
{
	try
	{
		couponsDAO.deleteCouponPurchase(1, 1);
		stop();
		break;
	}
	catch(Exception e)
	{
		
	}
}
		}
	}

	public void stop()
	{
		quite=true;
	}

	public static void main(String[] args) throws Exception {
		CouponExpirationDailyJob couponExpirationDailyJob=new CouponExpirationDailyJob();
		Thread tg=new Thread(couponExpirationDailyJob);
		tg.start();
		tg.stop();
	}
}
