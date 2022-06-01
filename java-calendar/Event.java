public class Event{
	//Name of event
	private String name;
	//start time of the event
	private Time startTime;

	private TypeEvent type;

	//end time of the event
	private Time endTime;
	public Event(String name){
		this.name = name;

	}
	public Event(String name, Time startTime, Time endTime){
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;

	}
	public TypeEvent getEventType(){
		/*
			func: getEventType
			args: None
			doc: This function will return the type of event (enum)
		*/
		return this.type;
	}
	public void setEventType(TypeEvent type){
		/*	
			func: setEventType
			args: type-> The new TypeEvent to be set.
			doc: This function will change the type of the event.
		*/
		this.type = type;

	}
	public Time getStartTime(){
		/*
			func: getStartTime
			args: None
			doc: This function will return the start time of the event
		*/
		return this.startTime;
	}
	public Time getEndTime(){
		/*
			func: getStartTime
			args: None
			doc: This function will return the end time of the event
		*/
		return this.endTime;
	}
	public String getName(){
		/*	
			func: getName
			args: None
			doc: This function will return the name of the event.
		*/
		return this.name;
	}
	@Override
	public String toString(){
		return this.name;
	}
	
}