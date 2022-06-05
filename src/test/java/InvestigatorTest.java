import static org.junit.jupiter.api.Assertions.*;

class InvestigatorTest {

    private Investigator investigator;
    public InvestigatorTest()
    {
        investigator=new Investigator();

    }

    @org.junit.jupiter.api.Test
    void findBussiestTime_basic_test() {
        int[] answer=investigator.FindBussiestTime(
                new int[][]
                        {
                                new int[]{0,1},
                                new int[]{0,2},
                                new int[]{0,3},
                                new int[]{1,2},
                        }
        );

        assertEquals(1,answer[0]);
        assertEquals(1,answer[1]);

    }

    @org.junit.jupiter.api.Test
    void findBussiestTime_basic2_test() {
        int[] answer=investigator.FindBussiestTime(
                new int[][]
                        {
                                new int[]{0,0},
                                new int[]{0,1},

                        }
        );

        assertEquals(0,answer[0]);
        assertEquals(0,answer[1]);

    }

    @org.junit.jupiter.api.Test
    void findBussiestTime_noIntersection_test() {
        int[] answer=investigator.FindBussiestTime(
                new int[][]
                        {
                                new int[]{0,1},
                                new int[]{2,3},
                                new int[]{4,5},
                                new int[]{6,7},
                                new int[]{8,9},
                                new int[]{10,11},

                        }
        );

        assertEquals(0,answer[0]);
        assertEquals(1,answer[1]);

    }


    @org.junit.jupiter.api.Test
    void findBussiestTime_fromTheStart_test() {
        int[] answer=investigator.FindBussiestTime(
                new int[][]
                        {
                                new int[]{0,5},
                                new int[]{0,20},
                                new int[]{0,70},
                                new int[]{0,300},

                        }
        );

        assertEquals(0,answer[0]);
        assertEquals(5,answer[1]);

    }

    @org.junit.jupiter.api.Test
    void findBussiestTime_wrong_values_test() {

        int[] wrongAns1=investigator.FindBussiestTime(null);
        assertEquals(-1,wrongAns1[0]);
        assertEquals(-1,wrongAns1[1]);
        int[] wrongAns2=investigator.FindBussiestTime(
                new int[][]
                        {
                                new int[]{0,1,2},
                                new int[]{0,2},
                                new int[]{0,3},
                                new int[]{1,2},
                        }
        );

        assertEquals(-1,wrongAns2[0]);
        assertEquals(-1,wrongAns2[1]);

    }
}