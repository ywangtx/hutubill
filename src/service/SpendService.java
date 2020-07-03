package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService {
	
	public SpendPage getSpendPage(){
		RecordDAO dao = new RecordDAO();
		// 本月数据
		List<Record> thisMonthRecord = dao.listThisMonth();
	    // 今日数据
		List<Record> todayRecord = dao.listToday();
	    // 本月总天数
		int thisMonthDay = DateUtil.thisMonthTotalDay();

	    int monthSpend = 0;
	    int todaySpend = 0;
	    int avgSpend = 0;
	    int monthLeft = 0;
	    int dayAvailable = 0;
	    int dayLeft = 0;
	    int usagePercentage = 0;

	    // 预算
	    int monthBudget = new ConfigService().getIntBudget();
	    // 统计本月消费
	    for(Record record: thisMonthRecord) {
	    	monthSpend += record.getSpend(); 
	    }
	    // 统计今日消费
	    for(Record record: todayRecord) {
	    	todaySpend += record.getSpend(); 
	    }
	    // 计算日均消费
	    avgSpend = monthSpend / thisMonthDay;
	    // 计算本月剩余
	    monthLeft = monthBudget - monthSpend;
	    // 距离月末
	    dayLeft = DateUtil.thisMonthLeftDay();
	    // 计算日均可用
	    dayAvailable = monthLeft / dayLeft;
	    // 计算使用比例
	    usagePercentage = monthSpend*100 / monthBudget;
	    // 根据这些信息，生成SpendPage对象
	    
	    return new SpendPage(monthSpend, todaySpend, avgSpend, monthLeft, dayAvailable, dayLeft, usagePercentage);
	}
	
}
