package screens;

import java.awt.Color ;
import java.awt.Toolkit;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.GridLayout;

import com.sun.jna.platform.win32.*;

public class Screen { //extends javax.swing.JWindow
	
	public static void main(String args[]) throws IOException, InterruptedException, InstantiationException, IllegalAccessException, ClassNotFoundException, UnsupportedLookAndFeelException{
		
		 Frame frame = new Frame();
	        frame.setVisible(true);
	        
	        WinDef.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame", "Transparent Window");
	        int wl =  User32.INSTANCE.GetWindowLong(hwnd, WinUser.GWL_EXSTYLE);
	        wl = wl | 0x80000 | 0x20;
	        User32.INSTANCE.SetWindowLong(hwnd, WinUser.GWL_EXSTYLE, wl);        
	}
	
	@SuppressWarnings({ "serial" })
	
    static class Frame extends JFrame
    {
        public Frame() throws IOException
        {
            super("Transparent Window");
            
            setUndecorated(true);
            setBackground(new Color(0, 0, 0, 0));
            setAlwaysOnTop(true);
            JPanel panel = new JPanel(new GridLayout(4, 4, 3, 3)); //4, 4, 3, 3 60, 60, 3, 3

            for (int i = 0; i <24 ; i++) { //24 2240
                //JLabel l = new JLabel("rigofel", JLabel.CENTER);
                //l.setSize(30, 30);
                JLabel l = new JLabel(new ImageIcon(ImageIO.read( Frame.class.getResourceAsStream("/imgs/frame.png" ))), JLabel.CENTER);
                
                panel.add(l);
            }    
            setContentPane(panel);
            setOpacity((float) 0.2);
            getContentPane().setPreferredSize(Toolkit.getDefaultToolkit().getScreenSize());
            getRootPane().putClientProperty("apple.awt.draggableWindowBackground", false);
            pack();
            setResizable(false);
        }
    }	        
}
