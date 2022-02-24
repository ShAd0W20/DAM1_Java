package modules;

import java.time.LocalDate;
import java.util.ArrayList;

public class Buy {
	public int buyID;
	public String clientID;
	public LocalDate date;
	public ArrayList<BuyProduct> products = new ArrayList<BuyProduct>();
}
