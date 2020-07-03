package util;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.panel.WorkingPanel;

public class CenterPanel extends JPanel{
	private double rate;
	private JComponent c;
	private boolean stretch;
 
	
	public CenterPanel(double rate, boolean stretch) {
		this.setLayout(null);
		this.rate = rate;
		this.stretch = stretch;
	}
	


	public CenterPanel(double rate) {
		super();
		this.rate = rate;
	}




	public void show(JComponent c) {
		//先将组件都移除，再将新组件加起来
		this.c = c;
		Component[] cs = getComponents();
		for(Component p:cs) {
			remove(p);
		}
		add(c);
		//调用updateUI进行渲染
		if(c instanceof WorkingPanel) {
			((WorkingPanel) c).updateData();
		}
		this.updateUI();
		
	}
	
	public void repaint() {
		if(null != c) {
			Dimension containerSize = this.getSize();
			Dimension componentSize = c.getPreferredSize();
			
			if(stretch) {
				c.setSize((int)(containerSize.width*rate), (int)(containerSize.height*rate));
			}else{
				c.setSize(componentSize);
			}
			
			c.setLocation(containerSize.width/2-c.getSize().width/2,containerSize.height/2-c.getSize().height/2 );
		}
		super.repaint();
	}
	
	public static void main(String[] args) {
		JFrame j = new JFrame();
		j.setSize(400, 400);
		j.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(0.5,true);
		j.setContentPane(cp);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setVisible(true);
		JButton jb = new JButton("aaa");
		cp.show(jb);
		
	}
}
