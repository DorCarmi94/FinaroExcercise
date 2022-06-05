
import java.util.ArrayList;
import java.util.List;

public class Investigator {
    private List<Character> StartEndsList;
    private List<Integer> NumbersLine;

    public Investigator()
    {
        this.StartEndsList= new ArrayList<>();
        this.NumbersLine= new ArrayList<>();
    }

    /**
     * (Method description)
     * * Clears both StartEndList and NumbersLine to start from zero state
     */
    private void ClearLists()
    {
        this.NumbersLine.clear();
        this.StartEndsList.clear();
    }


    /**
     * (Method description)
     * * Fills both lists, StartEndList and NumbersLine, according to the received times array
     * The first list will contain all the start and end time values, ordered together in a one integer list.
     * The second list will contain indication for each value in the NumbersLineList, whether it represents the start or the end of all call
     * @param times: two-dimension array.
     *             First dimension - the amount of calls,
     *             Second dimension=2: start,end
     *             The array should be sorted, according to start and end times
     */
    private void CreateOneNumbersLine(int[][] times) {
        int currStart=0;
        int currEnd=0;
        this.StartEndsList.add('S');
        this.NumbersLine.add(times[currStart][0]);
        currStart++;

        while(currStart<times.length || currEnd<times.length) {
            if (currStart<times.length &&
                    times[currStart][0] <= times[currEnd][1]) {
                this.StartEndsList.add('S');
                this.NumbersLine.add(times[currStart][0]);
                currStart++;
            } else if (currEnd<times.length) {

                this.StartEndsList.add('E');
                this.NumbersLine.add(times[currEnd][1]);
                currEnd++;
            }
        }

    }

    /**
     * (Method description)
     * * Goes over the NumbersLine list, together with the StartEndList, to find the longest string of starts,
     * before end comes, that represents the bussiest time, according to all the calls
     * @return   array with two values, start and end time, of the bussiest time of the day
     */
    private int[] GetIntervalFromNumbersLine() {
        int currCount=0;
        int bussiestStart=0;
        int bussiestEnd=0;
        int maxCount=0;
        boolean changeEndFlag=true;

        for (int i = 0; i < this.StartEndsList.size(); i++) {
            if(this.StartEndsList.get(i)=='S')
            {
                currCount++;
                if(currCount>maxCount)
                {
                    maxCount=currCount;
                    bussiestStart=this.NumbersLine.get(i);
                    changeEndFlag=true;
                }
            }
            else
            {
                currCount--;
                if(changeEndFlag) {
                    bussiestEnd = this.NumbersLine.get(i);
                    changeEndFlag=false;
                }
            }
        }

        return new int[]{bussiestStart,bussiestEnd};
    }

    /**
     * (Method description)
     * * Returns time interval of the bussiest time of the day,
     * according to time of calls, received as parameter.
     * @param times: two-dimension array.
     *             First dimension - the amount of calls,
     *             Second dimension=2: start,end
     *             The array should be sorted, according to start and end times
     * @return   array with two values, start and end time, of the bussiest time of the day
     */
    public int[] FindBussiestTime(int [][] times)
    {
        if(times==null || times[0].length!=2)
        {
            return new int[]{-1,-1};
        }

        ClearLists();
        CreateOneNumbersLine(times);
        return GetIntervalFromNumbersLine();
      }

}
