package com.practice.java.dsa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *  There is one meeting room in a firm. 
 *  You are given two arrays, start and end each of size N.For an index ‘i’, 
 *  start[i] denotes the starting time of the ith meeting while end[i]  will denote the ending time of the ith meeting. 
 *  Find the maximum number of meetings that can be accommodated if only one meeting can happen in the room at a  
 *  particular time. Print the order in which these meetings will be performed.
 */

class meeting {
  int start;
  int end;
  int pos;
   
  meeting(int start, int end, int pos)
  {
      this.start = start;
      this.end = end;
      this.pos = pos;
  }
}
class meetingComparator implements Comparator<meeting>
{
  @Override
  public int compare(meeting o1, meeting o2) 
  {
      if (o1.end < o2.end)
          return -1;
      else if (o1.end > o2.end)
          return 1;
      else if(o1.pos < o2.pos)
          return -1;
      return 1; 
  }
}

public class NMeetingsInOneRoom {

  public static void main(String[] args) {
    int n = 6;
    int start[] = {2,1,3};
    int end[] = {3,4,4,};
    maxMeetings(start,end,n);
  }
  

  static void maxMeetings(int start[], int end[], int n) {
    ArrayList<meeting> meet = new ArrayList<>();
    
    for(int i = 0; i < start.length; i++)
        meet.add(new meeting(start[i], end[i], i+1));
    
    meetingComparator mc = new meetingComparator(); 
    Collections.sort(meet, mc); 
    ArrayList<Integer> answer = new ArrayList<>();
    answer.add(meet.get(0).pos);
    int limit = meet.get(0).end; 
    
    for(int i = 1;i<start.length;i++) {
        if(meet.get(i).start > limit) {
            limit = meet.get(i).end; 
            answer.add(meet.get(i).pos);
        }
    }
    System.out.println("The order in which the meetings will be performed is ");
    for(int i = 0;i<answer.size(); i++) {
        System.out.print(answer.get(i) + " ");
    }
}

}
