import ParkingService.Park;
import ParkingService.UnPark;
import entities.Parking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        boolean work = true;
        Scanner input = new Scanner(System.in);
        System.out.print("введите количество парковочных мест:");
        int size = input.nextInt();
        new Parking(size);
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        while (work){
            Scanner input2 = new Scanner(System.in);
            System.out.print("введите команду:");
            String command = input2.nextLine();
            switch (command){
                case "l": Parking.getThisParking().list(); break;
                case "c": System.out.println("Количество свободных мест:" + Parking.getThisParking().getEmptyPlaces());break;
                case "e": work = false;break;
                default:
                    StringTokenizer st = new StringTokenizer(command, ":[],");
                     ArrayList<String> str = new ArrayList<String>();
                        while (st.hasMoreTokens()){
                            str.add(st.nextToken());
                        }
                        switch (str.get(0)){
                            case "p":
                                int count = Integer.parseInt(str.get(1));//количество машин на въезд
                                if (count > Parking.getThisParking().getEmptyPlaces()) {
                                    System.out.println("свободных мест не хватает");
                                    break;
                                }
                                for (int i = 0; i < count ; i++) {
                                    System.out.print("Введите номер машины:");

                                    threadPool.submit(new Park(input2.nextLine()));
                                }
                            break;
                            case "u":
                                if (str.size() == 2) threadPool.submit(new UnPark(Integer.parseInt(str.get(1))));
                                else {
                                    for (int i = 1; i < str.size()-1; i++) {
                                        threadPool.submit(new UnPark(Integer.parseInt(str.get(1))));
                                    }
                                }
                        }
                break;
            }
        }
        threadPool.shutdown();
    }
}
