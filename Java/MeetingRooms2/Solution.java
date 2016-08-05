public int minMeetingRooms(Interval[] intervals) {
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.start - b.start;
			}
		});
		
		PriorityQueue<Interval> minEndHeap = new PriorityQueue<>(new Comparator<Interval>() {
			public int compare(Interval a, Interval b) {
				return a.end - b.end;
			}
		});
		
		//Starts with the first meeting.
		minEndHeap.add(intervals[0]);
		for(int i = 1; i < intervals.length; i++) {
			
			Interval minEnd = minEndHeap.poll();
			if(minEnd.end <= intervals[i].start) {
				//Merge intervals[i] into minEnd
				minEnd.end = intervals[i].end;
				
			} else {
				minEndHeap.offer(intervals[i]);
			}
			minEndHeap.offer(minEnd);
		}
		
		return minEndHeap.size();
	}