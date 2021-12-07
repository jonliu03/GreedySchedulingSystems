import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalScheduling {
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
    	intervals.add(new Interval(1, 3));
    	intervals.add(new Interval(3, 5));
    	intervals.add(new Interval(5, 8));
    	intervals.add(new Interval(6, 9));
    	intervals.add(new Interval(4, 7));
    	intervals.add(new Interval(4, 6));
    	intervals.add(new Interval(1, 4));
    	scheduleIntervals(intervals);
	}
	public static void scheduleIntervals(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
		    @Override
		    public int compare(Interval i, Interval j) {
				if (i.getEndTime() > j.getEndTime()) {
					return 1;
				}
				else if (i.getEndTime() < j.getEndTime()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
		for (Interval i: intervals) {
			System.out.println(i);
		}
		ArrayList<Interval> schedule = new ArrayList<Interval>();
		boolean overlapped;
		for (int i = 0; i < intervals.size(); i++) {
			overlapped = false;
			for (Interval j: schedule) {
				if (intervals.get(i).overLapping(j)) {
					overlapped = true;
				}
			}
			if (!(overlapped)) {
				schedule.add(intervals.get(i));
			}
		}
		
		System.out.print("Schedule: ");
		boolean firstcase = true;
		for (Interval i: schedule) {
    		if (firstcase) {
    			System.out.print(i);
	    		firstcase = false;
    		}
    		else {
    			System.out.print(", " + i);
    		}
	    	
	    }
	}
}
