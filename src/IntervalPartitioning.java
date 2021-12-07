
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IntervalPartitioning {
    public static void main(String[] args) {
    	ArrayList<Interval> intervals = new ArrayList<>();
    	intervals.add(new Interval(1, 3));
    	intervals.add(new Interval(3, 5));
    	intervals.add(new Interval(5, 8));
    	intervals.add(new Interval(6, 9));
    	intervals.add(new Interval(4, 7));
    	intervals.add(new Interval(4, 6));
    	intervals.add(new Interval(1, 4));
    	colorIntervals(intervals);
    }
    public static void colorIntervals(ArrayList<Interval> intervals) {
    	int colors = 1;
		Collections.sort(intervals, new Comparator<Interval>() {
		    @Override
		    public int compare(Interval i, Interval j) {
				if (i.getStartTime() > j.getStartTime()) {
					return 1;
				}
				else if (i.getStartTime() < j.getStartTime()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
	   /* for (Interval i: intervals) {
	    	System.out.println(i);
	    }*/
	    intervals.get(0).setColor(1);
	    int tempcolor;
 
	    for (int i = 1; i < intervals.size(); i++) {
	    	tempcolor = 1;
	    	int j = 0;
	    	while (j < intervals.size()) {
	    		if (tempcolor > colors) {
	    			colors = tempcolor;
	    		}
	    		intervals.get(i).setColor(tempcolor);
	    		if ((i != j) && (intervals.get(i).getColor() == intervals.get(j).getColor()) && intervals.get(i).overLapping(intervals.get(j))) {
	    			tempcolor++;
	    			j = 0;
	    		}
	    		else {
	    			j++;
	    		}
	    	}
	    }
	    for (int color = 1; color <= colors; color++) {
	    	System.out.print("Color/Classroom " + color + ": ");
	    	boolean firstcase = true;
	    	for (Interval i: intervals) {
		    	if (i.getColor() == color) {
		    		if (firstcase) {
		    			System.out.print(i);
			    		firstcase = false;
		    		}
		    		else {
		    			System.out.print(", " + i);
		    		}
		    	}
		    }
	    	System.out.println();
	    }
    }
    	
}