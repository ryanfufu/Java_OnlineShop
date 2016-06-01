import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ItemCatalog extends JPanel
                            implements ActionListener
{
  private static final int stock = 1;
  private JButton go, remove, favorite;
  private JTextField display;
  private Clerk vendor;
  private boolean isFavorite;
 
  
  Color brandColor;
  String brandName;
  

  public ItemCatalog(String brand, int price, String fileName) throws IOException{
	  setBackground(Color.WHITE);
    brandName = brand;

    JTextField banner = new JTextField("  " + brandName +
                                       "  " + "$"+ price);
    banner.setEditable(false);
    banner.setFont(new Font("Serif", Font.BOLD, 14));
    banner.setHorizontalAlignment(JTextField.CENTER);

    //creating the images
    BufferedImage i = ImageIO.read(new File(fileName));
    JLabel pickLabel = new JLabel(new ImageIcon(i));

    //creating buttons
    remove = new JButton("Remove from Cart");
    remove.addActionListener(this);
    favorite = new JButton("Add to Favorites");
    favorite.addActionListener(this);
    
    go = new JButton("Add to Cart");
    go.setBackground(Color.PINK);
    go.addActionListener(this);
    JPanel buttons = new JPanel(new GridLayout(3, 1, 5, 0));
    buttons.add(remove);
    buttons.add(favorite);
    
    display = new JTextField("0  ");
    display.setFont(new Font("Monospaced", Font.BOLD, 16));
    display.setBackground(Color.YELLOW);
    display.setEditable(false);
    display.setHorizontalAlignment(JTextField.RIGHT);

    //all for the buttons
    Box b1 = Box.createVerticalBox();
    b1.add(banner);
    b1.add(Box.createVerticalStrut(5));
    b1.add(display);
    b1.add(Box.createVerticalStrut(12));
    Box b2 = Box.createHorizontalBox();
    b2.add(Box.createHorizontalStrut(60));
    Box b3 = Box.createVerticalBox();
    b3.add(go);
    b3.add(Box.createVerticalStrut(8));
    b3.add(buttons);
    b2.add(b3);
    b1.add(b2);
    b1.add(Box.createVerticalStrut(5));
    b1.add(pickLabel);
    add(b1);

    vendor = new Clerk(stock);
  }
  
  
  public int getItemAmount() {
	  return vendor.getDeposit();
  }
  public void setZeroAmount()
  {
	  vendor.setZero();
	  display.setText(" " + vendor.getDeposit() + "  ");
	  
  }
  public boolean getIsFavorite(){
	  return isFavorite;
  }
  public String getBrand(){
	  return brandName;
  }
  public void actionPerformed(ActionEvent e)
  {
    JButton b = (JButton)e.getSource();
    JButton d = (JButton)e.getSource();
    if (b == remove){
    	if(vendor.getDeposit()>0){
    	vendor.removeMoney(1);}}
    else if (b == go)
    {
    	vendor.addMoney(1);
 
    }
    else if (d == favorite)
    {isFavorite = true;}
    
    if (vendor.getStock() > 0)
      display.setText(" " + vendor.getDeposit() + "  ");
    //no need for else statement, because getDeposit() will never equal 0

    repaint();
  }}
