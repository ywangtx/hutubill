package gui.frame;

import javax.swing.JFrame;

import gui.panel.MainPanel;

public class MainFrame extends JFrame{

	public static MainFrame instance = new MainFrame();
	
	private MainFrame() {
		this.setSize(600, 540);
		this.setTitle("Ò»±¾ºýÍ¿ÕË");
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
