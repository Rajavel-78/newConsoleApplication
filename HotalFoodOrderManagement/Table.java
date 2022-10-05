package hotalfoodordermanagement;
public class Table {
 private int no;
 private String status;
public Table(int no,String status) {
	this.no = no;
	this.status = status;
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public void display() {
	System.out.print("\t\t"+no+"\t\t"+status+"\n");
	
}

	
}
