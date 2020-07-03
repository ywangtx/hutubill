package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
	
	public SpendPage getSpendPage(){
		RecordDAO dao = new RecordDAO();
		// ��������
		List<Record> thisMonthRecord = dao.listThisMonth();
	    // ��������
		List<Record> todayRecord = dao.listToday();
	    // ����������
		int thisMonthDay = DateUtil.thisMonthTotalDay();

	    int monthSpend = 0;
	    int todaySpend = 0;
	    int avgSpend = 0;
	    int monthLeft = 0;
	    int dayAvailable = 0;
	    int dayLeft = 0;
	    int usagePercentage = 0;

	    // Ԥ��
	    int monthBudget = new ConfigService().getIntBudget();
	    // ͳ�Ʊ�������
	    for(Record record: thisMonthRecord) {
	    	monthSpend += record.getSpend(); 
	    }
	    // ͳ�ƽ�������
	    for(Record record: todayRecord) {
	    	todaySpend += record.getSpend(); 
	    }
	    // �����վ�����
	    avgSpend = monthSpend / thisMonthDay;
	    // ���㱾��ʣ��
	    monthLeft = monthBudget - monthSpend;
	    // ������ĩ
	    dayLeft = DateUtil.thisMonthLeftDay();
	    // �����վ�����
	    dayAvailable = monthLeft / dayLeft;
	    // ����ʹ�ñ���
	    usagePercentage = monthSpend*100 / monthBudget;
	    // ������Щ��Ϣ������SpendPage����
	    
	    return new SpendPage(monthSpend, todaySpend, avgSpend, monthLeft, dayAvailable, dayLeft, usagePercentage);
	}
	
}
