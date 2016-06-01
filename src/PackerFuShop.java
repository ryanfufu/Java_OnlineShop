import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PackerFuShop extends JFrame
                      implements ActionListener
{
  private ItemCatalog[] machines;
  private JButton checkoutButton;
  private JButton wishlistButton;
  public PackerFuShop() throws IOException
  {
    super("Packer & Fu Co.");
    
    //sets the screen to maximum size
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    
    //creating three different ItemCatalog objects within the PackerFuShop, in array 'ItemCatalog'
    ItemCatalog[] machines =
    {
      new ItemCatalog("Denim Jeans", 25, "LeviJeans.jpeg"),
      new ItemCatalog("RayBan Sunfarer Black Sunglasses", 35, "Rayban_sunglasses.jpg"),
      new ItemCatalog("Stan Smith Triple White Shoes", 23, "stansmithtriplewhite.jpg"),
     // new VendingMachine("Ralph Lauren Polo Shirt", brandColor2, 26, "RLpoloshirt.jpg"),
     // ^^ create a new vending machine
 
    };
    
    //formatting
    //*************
    this.machines = machines;
    
    int w = machines.length * (200+5);
    int h = 310;
    setMinimumSize(new Dimension(w, h));

    Box wall = Box.createHorizontalBox();
    wall.add(Box.createHorizontalStrut(5));
    for (ItemCatalog machine : machines)
    {
      wall.add(machine);
      wall.add(Box.createHorizontalStrut(5));
    }

    JPanel clerk = new JPanel();
    checkoutButton = new JButton("Checkout");
    checkoutButton.addActionListener(this);
    clerk.add(checkoutButton);
    wishlistButton = new JButton("Wish List");
    wishlistButton.addActionListener(this);
    clerk.add(wishlistButton);
   
    Container c = getContentPane();
    c.setBackground(Color.GRAY);
    c.add(wall, BorderLayout.CENTER);
    c.add(clerk, BorderLayout.SOUTH);
  }


  public void actionPerformed(ActionEvent e)
  {
	  JButton g = (JButton)e.getSource();
	  if (g == checkoutButton){
		  int i = 0;
		  	for (ItemCatalog machine : machines){
	    	
		  			if (machine.getItemAmount() != 0){
		  				i++;
					  }
	    }
	       if (i>0){
	    		JOptionPane.showMessageDialog(null,
			        "Thank you for your purchase!",
			        "Receipt", JOptionPane.INFORMATION_MESSAGE);
	    	}
		   else
		    {
		    	JOptionPane.showMessageDialog(null,  "Your cart is empty!", "Error", JOptionPane.ERROR_MESSAGE);
		    	
		    }
	       
	    //clears cart value
	    for (ItemCatalog machine: machines){
		    	
		    	machine.setZeroAmount();
		    }
	    }
	  //wish list button 
	  else{
	  String temp = "";
		  for (ItemCatalog machine : machines){
			  
			  if(machine.getIsFavorite()){
		    		temp+=machine.getBrand();
		    		temp+="\n";
		  }
			 } JOptionPane.showMessageDialog(null,
				        temp,
				        "WishList", JOptionPane.INFORMATION_MESSAGE);}
	    }

  
  //MAIN METHOD
  public static void main(String[] args)
  {
	try{
	//creating the window
    PackerFuShop window = new PackerFuShop();
    window.setLocation(50, 50);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.setVisible(true);
	}catch(Exception e){
    	
    }
  }
}