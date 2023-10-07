package sk.elct.skolenie.jdbc.gui;

import javax.swing.JFrame;

public class Frame extends JFrame
{
// FIELDS
private Panel panel;

//CONSTRUCTORS
	
public Frame(Panel panel)
{
	super("Books");
	this.panel = panel;
	
	this.add(panel);
	
	this.setSize(950, 400);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
}
//METHODS
}
