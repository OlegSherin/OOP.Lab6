package lab6test;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestBox<complaint> implements ActionListener {

	// Поля классов
	private JFrame frame;
	private JPanel panel;
	private JButton b1, b2_complaint, b3_check;
	private JComboBox cb1, cb2;
	private JTextField tf3;
	private JRadioButton rb1, rb2;
	private JCheckBox t5, t10, no;
	private JTextArea ta;
	private JLabel l3, l6;
	private Coffe coffe;
	private Tea tea;
	private Coffe complaint;

	public static void main(String[] args) {
		TestBox tb = new TestBox();
		tb.interfaceGUI();
	}

	// Создание графического интерфейса программы
	public void interfaceGUI() {

		frame = new JFrame("Coffe shop");
		frame.setSize(580, 350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);

		ta = new JTextArea();
		ta.setBounds(250, 10, 240, 185);
		panel.add(ta);

		b1 = new JButton("Оформить");
		b1.setActionCommand("test");
		b1.setBounds(250, 200, 240, 20);
		b1.addActionListener(this);
		panel.add(b1);

		b2_complaint = new JButton("Подать жалобу на заказ");
		b2_complaint.setActionCommand("compliant");
		b2_complaint.setBounds(250, 250, 200, 30);
		b2_complaint.addActionListener(this);
		panel.add(b2_complaint);

		b3_check = new JButton("Получить чек");
		b3_check.setActionCommand("check");
		b3_check.setBounds(50, 250, 150, 30);
		b3_check.addActionListener(this);
		panel.add(b3_check);

		l3 = new JLabel("Оставить чаевые?");
		l3.setBounds(10, 180, 200, 20);
		panel.add(l3);

		l6 = new JLabel("Сколько сахара?");
		l6.setBounds(10, 90, 140, 20);
		panel.add(l6);

		tf3 = new JTextField();
		tf3.setBounds(10, 110, 100, 20);
		panel.add(tf3);

		rb1 = new JRadioButton("Кофе");
		rb1.setBounds(10, 10, 100, 20);
		rb1.addActionListener(this);
		rb1.setActionCommand("coffe");
		panel.add(rb1);

		rb2 = new JRadioButton("Чай");
		rb2.setActionCommand("tea");
		rb2.addActionListener(this);
		rb2.setBounds(120, 10, 130, 20);
		panel.add(rb2);

		ButtonGroup group = new ButtonGroup();
		rb1.setSelected(true);
		group.add(rb1);
		group.add(rb2);

		t5 = new JCheckBox("5%");
		t10 = new JCheckBox("10%");
		no = new JCheckBox("Без чаевых");
		t5.setBounds(10, 200, 55, 20);
		t10.setBounds(70, 200, 60, 20);
		no.setBounds(130, 200, 100, 20);
		t5.setEnabled(true);
		t10.setEnabled(true);
		no.setEnabled(true);
		panel.add(t5);
		panel.add(t10);
		panel.add(no);

		String[] out = { // кофе выпадающий
		"Лате", "Эспрессо", "Гляссе", };
		cb1 = new JComboBox(out);
		cb1.setActionCommand("box1");
		cb1.addActionListener(this);
		cb1.setBounds(10, 40, 100, 20);
		panel.add(cb1);
		String[] in = { // чай
		"Мятный", "Ромашковый", "Каркаде", };

		cb2 = new JComboBox(in);
		cb2.setActionCommand("box2");
		cb2.addActionListener(this);
		cb2.setBounds(120, 40, 100, 20);
		cb2.setEnabled(false);
		panel.add(cb2);
	}

	// Обработчик программы
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		// Создание заказа и вывод в ТА
		case "tea":
			rb2.setSelected(true);
			cb2.setEnabled(true);
			cb1.setEnabled(false);
			break;
		case "coffe":
			rb1.setSelected(true);
			cb1.setEnabled(true);
			cb2.setEnabled(false);
			break;
		

		// тут будет обработчик программы

		case "test":
			if (rb1.isSelected()) {
				coffe = new Coffe(cb1.getSelectedItem().toString(),
						tf3.getText());
				coffe.paint(panel.getGraphics());
				ta.setText(coffe.toString());
			} else if (rb2.isSelected()) {
				tea = new Tea(cb2.getSelectedItem().toString(), tf3.getText());
				tea.paint(panel.getGraphics());
				ta.setText(tea.toString());
				break;

			}
		case "complaint":
			complaint = new Coffe(cb1.getSelectedItem().toString(),
						tf3.getText(),coffe.complaint);
			complaint.paint(panel.getGraphics());
			ta.setText(complaint.toStringC());
		}
	}
}
