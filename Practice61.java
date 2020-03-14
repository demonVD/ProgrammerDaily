// Given an array of time intervals (start, end) 
// for classroom lectures (possibly overlapping), find the minimum number of rooms required.
import java.util.Collections;
import java.util.ArrayList;
class Solution{
	public int minRooms(ArrayList<Interval> intervals){
		Collections.sort(intervals);
		// display(intervals);
		ArrayList<Integer> rooms = new ArrayList<>();
		for(Interval interval : intervals){
			if(rooms.size() == 0){
				rooms.add(interval.end);
			}
			else{
				for(Integer i : rooms){
					if(i < interval.start){
						rooms.remove(i);
						break;
					}
				}
				rooms.add(interval.end);
			}
		}
		return rooms.size();
	}
	public void display(ArrayList<Interval> intervals){
		for(Interval i : intervals){
			System.out.print(i.start + " " + i.end + " ");
		}
	}
}
class Interval implements Comparable<Interval>{
	int start;
	int end;
	public Interval(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval interval){
		return (interval.start > this.start) ? -1 : ((interval.start == this.start) ? 0 : 1);
	}
}
class Practice61{
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		Interval interval1 = new Interval(30, 70);
		Interval interval2 = new Interval(60, 150);
		Interval interval3 = new Interval(0, 70);
		intervals.add(interval1);
		intervals.add(interval2);
		intervals.add(interval3);
		System.out.println(new Solution().minRooms(intervals));
		
	}
}