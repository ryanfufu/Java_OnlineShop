public class Clerk
{
  // Fields:
 private int stock;
 private int deposit;
 private int price;

  public Clerk (int totalStock)
  {
    stock = totalStock;
  }
  public int getStock ()
  {
    return stock;
  }

  public void removeMoney (int incrementDeduction){
	  deposit = deposit - incrementDeduction;
  }
  public void addMoney (int totalDeposit)
  {
    deposit += totalDeposit;
  }

  public int getDeposit()
  {
    return deposit;
  }

  public int getPrice()
  {
	  return price;
  }
  public void setZero()
  {
	  deposit = 0;
  }
}