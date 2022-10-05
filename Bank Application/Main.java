package bank;

public class Main {

	public static void main(String[] args) {
		Main main=new Main();
		main.operation();
	}
	private void operation() {
		Banking bank=new Banking();
		bank.menu();	
	}

}
