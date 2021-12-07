public class Interval {
	private int start;
	private int end;
	private int color;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	public int getStartTime() {
		return start;
	}
	public int getEndTime() {
		return end;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	
	public boolean overLapping(Interval i) {
		return (start >= i.getStartTime() && start <= i.getEndTime());
	}
	public String toString() {
		return "{" + start + ", " + end + "}";
	}
}
