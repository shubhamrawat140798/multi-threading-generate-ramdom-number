/*
Java program that implements a multi-thread application that has three threads. First thread generates a 
random integer every 1 second and if the value is even, the second thread computes the square of the number and prints. 
If the value is odd, the third thread will print the value of the cube of the number.
*/
import java.util.Random;
import java.util.Scanner;

class MultiThreading{
    public static void main(String[] args) {
        RandomNumber th=new RandomNumber();
        th.run();
    }
}
class RandomNumber extends Thread {
    public void run() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter the number of random numbers which you want to generate.");
        int numOfRandom= scanner.nextInt();
        Random random = new Random();
        for(int i=0;i<numOfRandom;i++){
            int randomNumber = random.nextInt(100);
            System.out.print("Generating..........");
            for (int j =0; j<5; j++){
//                we are printing every half second for waiting
                System.out.print(".");
                try {
                    Thread.sleep(500);
                }catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println(" ");
            if(randomNumber % 2==0){
                SquareThread squareThread=new SquareThread(randomNumber);
                squareThread.start();
            }else{
                CubeThread cubeThread=new CubeThread(randomNumber);
                cubeThread.start();
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                ex.printStackTrace();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}
class SquareThread extends Thread {
    int number;
    SquareThread(int number){
        this.number = number ;
    }
    public void run(){
        System.out.println("Square of "+number+" : "+number * number);
    }
}
class CubeThread extends Thread{
    int number;
    CubeThread(int number){
        this.number = number;
    }
    public void run(){
        System.out.println("Cube of "+number+" : "+number*number*number);
    }
}
