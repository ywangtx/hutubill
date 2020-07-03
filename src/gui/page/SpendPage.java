package gui.page;

public class SpendPage {
	//本月消费
	public String monthSpend;
	//今日消费
	public String todaySpend;
	//日均消费
	public String avgSpend;
	//本月剩余
	public String monthLeft;
	//日均可用
	public String dayAvailable;
	//距离月末
	public String dayLeft;
	//使用比例
    public int usagePercentage;
	//是否超支
	public boolean isOver = false;
	
	public SpendPage(int monthSpend, int todaySpend, int avgSpend, int monthLeft, int dayAvailable, int dayLeft, int usagePercentage) {
		this.monthSpend = "¥"+ monthSpend;
		this.todaySpend = "¥"+ todaySpend;
		this.avgSpend = "¥"+ avgSpend;
		if(monthLeft < 0) {
			isOver = true;
			this.monthLeft = "超支¥"+ (-monthLeft);
			this.dayAvailable = "¥0";
		}else {
			this.monthLeft = "¥"+ monthLeft;
			this.dayAvailable = "¥"+ dayAvailable;
		}		
		this.dayLeft =  dayLeft + "天";
		this.usagePercentage = usagePercentage;
		
		
	}
}
