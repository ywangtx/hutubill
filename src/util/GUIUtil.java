package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil {
	    private static String imageFolder = "./img"; 
	//Ƥ��
	public static void useLNF() {
		try {
			javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//�ж��Ƿ�Ϊ��
	public static boolean checkEmpty(JTextField tf, String input) {
		String text = tf.getText().trim();
		if(0 == text.length()) {
			JOptionPane.showMessageDialog(null, input += "����Ϊ�ա�");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	//�ж��Ƿ�Ϊ����
	public static boolean checkNumber(JTextField tf ,String input) {
		if(!checkEmpty(tf,input)) {
			return false;
		}
		String text = tf.getText().trim();
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			JOptionPane.showInputDialog(null, input += "��Ҫ������");
			tf.grabFocus();
			return false;
		}
	}
	
    public static int getInt(JTextField tf) {
        return Integer.parseInt(tf.getText());
    }
	
	//�ж��Ƿ�Ϊ0
	public static boolean checkZero(JTextField tf, String input ) {
		if(!checkNumber(tf, input)) {
			return false;
		}
		String text = tf.getText().trim();
		if(0 == Integer.parseInt(text)) {
			JOptionPane.showInputDialog(null, input += "����Ϊ�㡣");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	//Ϊ�������ǰ��ɫ
	public static void setColor(Color color, JComponent... cs) {
		for(JComponent c:cs) {
			c.setForeground(color);
		}
	}
	
	//����ť����ͼ����ı��Լ���ʾ����
	public static void setImageIcon(JButton jb, String fileName, String tip) {
		ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
		jb.setIcon(i);
		jb.setPreferredSize(new Dimension(61,81));
		jb.setToolTipText(tip);
		jb.setVerticalTextPosition(JButton.BOTTOM);
		jb.setHorizontalTextPosition(JButton.CENTER);
		jb.setText(tip);
	}
	
	//��ʾ���
	public static void showPanel(JPanel jp, Double stretch) {
		GUIUtil.useLNF();
		JFrame jf = new JFrame();
		jf.setSize(60, 60);
		jf.setLocationRelativeTo(null);
		CenterPanel cp = new CenterPanel(stretch);
		jf.setContentPane(cp);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
		cp.show(jp);
	}
	
	public static void showPanel(JPanel jp) {
		showPanel(jp,0.8);
	}
}
