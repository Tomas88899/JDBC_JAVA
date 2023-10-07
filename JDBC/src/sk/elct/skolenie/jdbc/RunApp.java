package sk.elct.skolenie.jdbc;

import sk.elct.skolenie.jdbc.facade.BooksFacade;
import sk.elct.skolenie.jdbc.gui.Frame;
import sk.elct.skolenie.jdbc.gui.Panel;

public class RunApp
{
/**
 * this represents main class
 * @param args
 */
	public static void main(String[] args) 
	{
		BooksFacade booksFacade = new BooksFacade();
		Panel panel = new Panel(booksFacade);
		Frame frame = new Frame(panel);
	}

}
