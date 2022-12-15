public class TheaterSeats {
    public static void main(String[] args){
        int cnt = 0;
        byte[][] seats = {
            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}
        };

        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                if(seats[i][j] == 1){
                    cnt++;
                }
            }
        }

        System.out.println("관객 수: " + cnt);
    }
}
