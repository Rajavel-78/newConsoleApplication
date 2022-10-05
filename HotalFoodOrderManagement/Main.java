package hotalfoodordermanagement;

public class Main {
      public static void main(String[] arg) {
    	  Main main=new Main();
    	  main.operation();
      }
      public void operation() {
    	  System.out.println("Hotal IS Avilable");
    	  Booking book=new Booking();
    	  book.storeData();
      }
}
