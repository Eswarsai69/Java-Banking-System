package java_bank_system;
import java.util.*;
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
