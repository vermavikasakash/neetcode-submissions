class Solution {
    canAttendMeetings(intervals) {
        if (intervals.length === 0) return true;

        intervals.sort((a,b)=> a.start - b.start);

        let interval = intervals[0];

        for(let i = 1; i < intervals.length; i++){
            if(interval.end > intervals[i].start) return false;

            interval.end = Math.max(interval.end, intervals[i].end);
        }

        return true;
    }  
}
