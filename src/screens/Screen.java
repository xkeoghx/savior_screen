package screens;

import java.awt.Color ;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.io.IOException;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.Rectangle;

import com.sun.jna.platform.win32.*;

public class Screen { //extends javax.swing.JWindow
	
	public static void main(String args[]) throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, UnsupportedLookAndFeelException{
		
		 Frame frame = new Frame();
	     frame.setVisible(true);
	        
	     WinDef.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame", "Transparent Window");
	     int wl =  User32.INSTANCE.GetWindowLong(hwnd, WinUser.GWL_EXSTYLE);
	     wl = wl | WinUser.WS_EX_LAYERED | WinUser.WS_EX_TRANSPARENT;
	     User32.INSTANCE.SetWindowLong(hwnd, WinUser.GWL_EXSTYLE, wl);
	        
	        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice[] gs = ge.getScreenDevices();
	        
	        for (int j = 0; j < gs.length; j++) { 
	        	System.out.println(j);
	            GraphicsDevice gd = gs[j];
	            GraphicsConfiguration[] gc = gd.getConfigurations();
	            
	            Rectangle gcBounds = gc[0].getBounds();
		        int xoffs = gcBounds.x;
		        int yoffs = gcBounds.y;
		        System.out.println(xoffs);
		        System.out.println(yoffs);
		        System.out.println(xoffs);
		        System.out.println(xoffs);
	        }	            
	}
	
	@SuppressWarnings({ "serial" })
	
    static class Frame extends JFrame
    {
        public Frame() throws IOException
        {
            super("Transparent Window");
            
            setUndecorated(true);
            
            setType(Type.UTILITY);
            setBackground(new Color(0, 0, 0, 0));
            setAlwaysOnTop(true);
            JPanel panel = new JPanel(new GridLayout(8, 7, 1, 1)); //4, 4, 3, 3 60, 60, 3, 3

            for (int i = 0; i <56 ; i++) { //24 2240
                //JLabel l = new JLabel("rigofel", JLabel.CENTER);
                //l.setSize(30, 30);
                JLabel l = new JLabel("rigofel", JLabel.CENTER);
                
                l.setFont(l.getFont().deriveFont(20.0f));
                panel.add(l);
            }    
            setContentPane(panel);
            setOpacity((float) 0.2);
   
            getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
            
            //System.out.println(Toolkit.getDefaultToolkit().getScreenSize().setSize(10000, 10000));
            getContentPane().setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
            pack();
            
        }
    }	        
}
