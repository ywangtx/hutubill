package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import gui.panel.BackupPanel;
import gui.panel.ConfigPanel;
import gui.panel.MainPanel;
import service.ConfigService;
import util.MysqlUtil;

public class BackupListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		BackupPanel bp = BackupPanel.instance;
		String mysqlPath = new ConfigService().get(ConfigService.mySqlPath);
		if(0== mysqlPath.length()) {
			JOptionPane.showMessageDialog(bp, "����ǰ��������MySQL��װ·��");
			MainPanel.instance.workingPanel.show(ConfigPanel.instance);
			ConfigPanel.instance.tfMysqlPath.grabFocus();
			return;
		}
		JFileChooser fc = new JFileChooser();
        fc.setSelectedFile(new File("hutubill.sql"));
        fc.setFileFilter(new FileFilter() {
        	
        	@Override
            public String getDescription() {
                return ".sql";
            }
        	
			@Override
			public boolean accept(File f) {
				if(f.isDirectory()) {
					return true;
				}
				return f.getName().toLowerCase().endsWith(".sql");
			}           
        	
        });
        
        int returnVal =  fc.showSaveDialog(bp);
        File file = fc.getSelectedFile();
        System.out.println(file);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            //���������ļ���û����.sql��β���Զ�����.sql
            System.out.println(file);
            if(!file.getName().toLowerCase().endsWith(".sql"))
                file = new File(file.getParent(),file.getName()+".sql");
            System.out.println(file);
             
           try {
               MysqlUtil.backup(mysqlPath, file.getAbsolutePath());
               JOptionPane.showMessageDialog(bp, "���ݳɹ�,�����ļ�λ��:\r\n"+file.getAbsolutePath());
           } catch (Exception e1) {
               e1.printStackTrace();
               JOptionPane.showMessageDialog(bp, "����ʧ��\r\n,����:\r\n"+e1.getMessage());   
           }
             
        } 
	    }

}
