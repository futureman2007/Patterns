package futureman.taschenrecher;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import futureman.taschenrecher.commands.*;

public class TaschenrechnerView extends JFrame implements Observer {

	Taschenrechner t;
	JButton eins, zwei, drei, vier, fuenf, sechs, sieben, acht, neun, nul,
			slash, mal, minus, punkt, gleich, plus;
	JLabel resultLabel;
	NumberHandler nHandler = new NumberHandler();
	OpHandler opHandler = new OpHandler();
	String  input= new String();

	public TaschenrechnerView(Taschenrechner t) {
		this.t = t;
		this.t.addObserver(this);
		resultLabel = new JLabel("0.", SwingConstants.RIGHT);

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4, 4));

		sieben = new JButton("7");
		sieben.addActionListener(nHandler);

		p.add(sieben);
		acht = new JButton("8");
		acht.addActionListener(nHandler);
		p.add(acht);
		neun = new JButton("9");
		neun.addActionListener(nHandler);
		p.add(neun);
		slash = new JButton("/");
		slash.addActionListener(opHandler);
		p.add(slash);
		vier = new JButton("4");
		vier.addActionListener(nHandler);
		p.add(vier);
		fuenf = new JButton("5");
		fuenf.addActionListener(nHandler);
		p.add(fuenf);
		sechs = new JButton("6");
		p.add(sechs);
		sechs.addActionListener(nHandler);
		mal = new JButton("*");
		mal.addActionListener(opHandler);
		p.add(mal);
		eins = new JButton("1");
		eins.addActionListener(nHandler);
		p.add(eins);
		zwei = new JButton("2");
		zwei.addActionListener(nHandler);
		p.add(zwei);
		drei = new JButton("3");
		drei.addActionListener(nHandler);
		p.add(drei);
		minus = new JButton("-");
		minus.addActionListener(opHandler);
		p.add(minus);
		nul = new JButton("0");
		nul.addActionListener(nHandler);
		p.add(nul);
		punkt = new JButton(".");
		punkt.addActionListener(opHandler);
		p.add(punkt);
		gleich = new JButton("=");
		gleich.addActionListener(opHandler);
		p.add(gleich);
		plus = new JButton("+");
		plus.addActionListener(opHandler);
		p.add(plus);

		this.add(resultLabel, BorderLayout.NORTH);
		this.add(p, BorderLayout.SOUTH);

		setSize(300, 400);
		this.pack();
		this.setVisible(true);
	}

	class NumberHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Object o = a.getSource();

			if (o == nul)
				input +="";
			if (o == eins)
				input +="1";
			if (o == zwei)
				input +="2";
			if (o == drei)
				input +="3";
			if (o == vier)
				input +="4";;
			if (o == fuenf)
				input +="5";;
			if (o == sechs)
				input +="6";
			if (o == sieben)
				input +="7";
			if (o == acht)
				input +="8";
			if (o == neun)
				input +="9";
			
			t.setResult(Double.parseDouble(input));

		}
	}
	
	class OpHandler implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			Object o = a.getSource();
			input = "";
			if (o == slash)
				t.setCommand(DivCommand.getDivCommand());
			if (o == mal)
				t.setCommand(MultCommand.getMultCommand());
			if (o == minus)
				t.setCommand(SubCommand.getSubCommand());;
			if (o == plus)
				t.setCommand(AddCommand.getAddCommand());;
			if (o == gleich)
				t.getResult();
		}
	}

	public void update(Observable ob, Object o) {

		double d = t.getResult();
		resultLabel.setText(String.valueOf(d));

	}

}
