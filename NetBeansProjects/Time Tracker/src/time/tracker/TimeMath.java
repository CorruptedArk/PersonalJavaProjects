package time.tracker;

public class TimeMath {
	
	static final int HOUR = 0;
	static final int MINUTE = 1;
	static final int SECOND = 2;
	
	int hour, minute, second;
	
	final int[] times = {hour, minute, second};
	
	void set(int field, int value){
		times[field] = value;
		format();
	}
	
	void add(int field, int value){
		times[field] += value;
		format();
	}
	
	int get(int field){
		return times[field];
	}
	
	void format(){
		boolean isNotFormatted = true;
		do{
			if(times[SECOND] >= 60){
				times[SECOND] -= 60;
				times[MINUTE] += 1;
			}
			if(times[MINUTE] >= 60){
				times[MINUTE] -= 60;
				times[HOUR] += 1;
			}
			if(times[SECOND] < 0 && Math.abs(times[SECOND]) >= 60){
				times[SECOND] += 60;
				times[MINUTE] -= 1;
			}
			if(times[MINUTE] < 0 && Math.abs(times[MINUTE])>= 60){
				times[MINUTE] += 60;
				times[HOUR] -= 1;
			}
			if(times[SECOND] < 60 && times[MINUTE] < 60 && times[SECOND] >= 0 && times[MINUTE] >= 0){
				isNotFormatted = false;
			}
		}while(isNotFormatted);
	}
}
