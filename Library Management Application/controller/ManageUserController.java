package controler;
import java.util.List;

import model.*;
public class ManageUserController {
	public boolean checkBookId(long bookId) {
		List<Book> bookList=LibraryDatabase.getInstance().getBookList();
		for(Book b:bookList) {
			if(b.getId()==bookId&&b.isAvailablity()){
				b.setAvailablity(false);
				return true;
			}
		}
		return false;
	}
	public boolean transactionDetails(int studentId,long bookId) {
		List<BookTransactions>transactionList=LibraryDatabase.getInstance().getBookTransaction();
		for(BookTransactions t:transactionList) {
			if(t.getUserId()==studentId&&t.getBookId()==bookId) {
				System.out.println("userId BookId Verified");
				return true;
			}
		}return false;
	}
	public void addAvilability(long bookId,boolean status){
		List<Book> bookList=LibraryDatabase.getInstance().getBookList();
		for(Book b:bookList) {
			if(b.getId()==bookId){
				b.setAvailablity(status);
			}
		}
	}
}
