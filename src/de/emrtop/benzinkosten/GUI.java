package de.emrtop.benzinkosten;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1;
	
	JPanel inhalt = new JPanel();
	JPanel mitte = new JPanel();
	JPanel mitte1 = new JPanel();
	JPanel mitte2 = new JPanel();
	JPanel unten = new JPanel();
	
	JLabel tankLabel = new JLabel("Tank in l");
	JLabel preisLabel = new JLabel("Preis/l");
	JLabel streckeLabel = new JLabel("Strecke");
	JTextField tankField = new JTextField("");
	JTextField preisField = new JTextField("");
	JTextField streckeField = new JTextField("");
	

	JLabel verbrauchLabel = new JLabel("Verbrauch in l");
	JLabel kostenLabel = new JLabel("Kosten in EUR");
	JTextField verbrauchField = new JTextField("");
	JTextField kostenField = new JTextField("");
	
	JButton rechnungButton = new JButton("Werte berechnen");
	
	public GUI() {
		super("Spritverbrauch berechnen");
		
		inhalt.setLayout(new BorderLayout());
		mitte.setLayout(new GridLayout(2, 0));
		mitte1.setLayout(new GridLayout(0, 3, 6, 0));
		mitte2.setLayout(new GridLayout(0, 2, 6, 0));

		mitte1.add(tankLabel);
		mitte1.add(preisLabel);
		mitte1.add(streckeLabel);
		mitte1.add(tankField);
		mitte1.add(preisField);
		mitte1.add(streckeField);
		
		verbrauchField.setEnabled(false);
		kostenField.setEnabled(false);
		mitte2.add(verbrauchLabel);
		mitte2.add(kostenLabel);
		mitte2.add(verbrauchField);
		mitte2.add(kostenField);
		
		mitte.add(mitte1);
		mitte.add(mitte2);
		
		rechnungButton.addActionListener(this);
		
		unten.add(rechnungButton);
		inhalt.add(mitte, BorderLayout.NORTH);
		inhalt.add(unten, BorderLayout.SOUTH);
		
		this.setContentPane(inhalt);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		verbrauchField.setText((Double.parseDouble(streckeField.getText()) / Double.parseDouble(tankField.getText())) + "");
		kostenField.setText((Double.parseDouble(tankField.getText()) * Double.parseDouble(preisField.getText())) + "");
	}
	
}
