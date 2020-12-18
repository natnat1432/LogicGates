import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


//LOGICGATES METHOD 
class LogicGates  {
   public boolean buffer(boolean a){
      if(a==false)
         return false;
      else
         return true;
      }
   public boolean inverter(boolean a){
      if(a==false)
         return true;
      else
         return false;
      }
   public boolean twoAND(boolean a, boolean b){
       if(a==true && b==true)
         return true; 
       else
         return false;
      }
   public boolean twoNAND(boolean a, boolean b){
       if(a==true && b==true)
         return false; 
       else
         return true;
      }
   public boolean twoOR(boolean a, boolean b){     
       if(a==false && b==false)
         return false; 
       else
         return true;
      }
   public boolean twoNOR(boolean a, boolean b){
       if(a==false && b==false)
         return true; 
       else
         return false;
      }
   public boolean twoEXOR(boolean a, boolean b){
       if( (a==false && b==false) || (a==true && b==true))
         return false; 
       else
         return true;
      }
   public boolean twoEXNOR(boolean a, boolean b){
       if( (a==false && b==false) || (a==true && b==true))
         return true; 
       else
         return false;
   }
 
}

//LOGICGATESGUI method
class LogicGatesGUI extends JFrame implements ItemListener
{
   JLabel la, lb, label,result;
   JTextField tres;
   JComboBox Options,ta,tb;
   Container c = getContentPane();
   boolean a,b;
   String res;
   String aoption[] = {"True", "False"};
   String boption[] = {"True", "False"};
   String optrs[] = {"Buffer", "Inverter(NOT Gate)", "AND-Gate", "NAND-Gate", "OR-Gate", "NOR-Gate", "EX-OR-Gate", "EX-NOR-Gate"};
   
   public LogicGatesGUI()
   {
      super("Logic Gates");
      la = new JLabel("Select value for A: ");
      lb = new JLabel("Select value for B: ");
      label = new JLabel("Select a Logic Function ");
      result = new JLabel("Result ");
      
      ta = new JComboBox(aoption);
      ta.addItemListener(this);
      tb = new JComboBox(boption);
      tb.addItemListener(this);
      tres = new JTextField(10); 
      tres.setEditable(false);
      
      Options = new JComboBox(optrs); Options.addItemListener(this);
      
      c.setLayout(new GridLayout(4, 2));
      c.add(label);c.add(Options);
      c.add(la); c.add(ta);
      c.add(lb); c.add(tb);
      c.add(result);c.add(tres);
         
      setSize(300, 200);//to set the size of the frame
      setDefaultCloseOperation(EXIT_ON_CLOSE);//to use the x button to stop the program from running
      setResizable(false);
      setVisible(true);
    }

      public void	itemStateChanged(ItemEvent ie)   {
 
      LogicGates lg = new LogicGates();
      //Translating the String options to boolean for method parameters.
         if(ta.getSelectedIndex()==0)
         {
            a=true;
         }
         else
         {
            a=false;
         }  
         if(tb.getSelectedIndex()==0)
         {
            b=true;
         }
         else
         {
            b=false;
         }
      //Disables the second input if Buffer and Inverter is choosen.
         if(Options.getSelectedIndex()==0 || Options.getSelectedIndex()==1)   {
             //Hides the second input for two inputs.
            c.getComponent(4).setVisible(false);
            c.getComponent(5).setVisible(false);
            if(Options.getSelectedIndex()==0)
            {
               res= lg.buffer(a)+"";
            }
            else if(Options.getSelectedIndex()==1)
            {
               res= lg.inverter(a)+"";
            }
           }
         else
         {
            //Shows the second input for two inputs.
            c.getComponent(4).setVisible(true);
            c.getComponent(5).setVisible(true);
          
            if(Options.getSelectedIndex()==2)
               res = lg.twoAND(a,b)+"";
            else if(Options.getSelectedIndex()==3)
               res = lg.twoNAND(a,b)+"";
            else if(Options.getSelectedIndex()==4)
               res = lg.twoOR(a,b)+"";
            else if(Options.getSelectedIndex()==5)
               res = lg.twoNOR(a,b)+"";
            else if(Options.getSelectedIndex()==6)
               res = lg.twoEXOR(a,b)+"";
            else if(Options.getSelectedIndex()==7)
               res = lg.twoEXNOR(a,b)+"";
         }
       tres.setText(res.toUpperCase()+"");
       repaint();   
   }
   }
 
        
//LOGIC GATES DEMO Main Method
public class LogicGatesDEMO
{
   public static void main(String args[])
   {
      LogicGatesGUI logic = new LogicGatesGUI();
   }
}
