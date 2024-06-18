class Solution {
    public int countDays(int days, int[][] meetings) {
        if(meetings == null || meetings.length == 0){
            return days;
        }
        
        Arrays.sort(meetings , (a,b) -> Integer.compare(a[0],b[0]));
        
        int meetingDays = 0;
        int currentStart = meetings[0][0];
        int currentEnd = meetings[0][1];
        
        for(int i=1; i < meetings.length; i++){
            if(meetings[i][0] <= currentEnd + 1){
                currentEnd = Math.max(currentEnd , meetings[i][1]);
            }
            else{
                meetingDays += currentEnd - currentStart + 1;
                currentStart = meetings[i][0];
                currentEnd = meetings[i][1];
            }
        }
        
        meetingDays += currentEnd - currentStart + 1;
        
        int nonMeetingDays = days - meetingDays;
        
        return nonMeetingDays;
        
    }
}