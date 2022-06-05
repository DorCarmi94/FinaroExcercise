public class Main {

    public static void main(String [] args)
    {
        Investigator investigator= new Investigator();
        int[] answer=investigator.FindBussiestTime(new int[][]
                {
                        new int[]{0,2},
                        new int[]{0,2},
                        new int[]{0,3},
                        new int[]{1,3}
                });

        System.out.println("Start: "+answer[0]);
        System.out.println("End: "+answer[1]);
    }
}
