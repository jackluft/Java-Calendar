public class Time{

	//holds the hour
	private int hour;
	//hold the minute
	private int min;
	public Time(int hour,int min){
		
		this.hour = hour;
		this.min = min;

	}
	public int getHour(){
		/*
			func: getHour
			args: None
			doc: This function will return the hour

		*/
		return this.hour;
	}
	public int getMin(){
		/*
			func: getMin
			args: None
			doc: This function will return the minutes
		*/
		return this.min;
	}
}