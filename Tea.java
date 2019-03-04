package lab6test;

import javax.swing.*;
import java.awt.*;

class Tea extends JPanel {

	private static final long serialVersionUID = 1L;
	public String coffeBew, teaBew, sugar;

	public Tea(String teaBew, String sugar) {

		this.teaBew = teaBew;
		this.sugar = sugar;
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D graphics2D = (Graphics2D) g;
		graphics2D.setColor(Color.BLACK);
		graphics2D.drawRect(5, 5, 110, 170);
	}

	public String getsugar() {
		return sugar;
	}

	public void setsugar(String sugar) {
		this.sugar = sugar;
	}

	public String getCoffeBew() {
		return coffeBew;
	}

	public void setCoffeBew(String coffeBew) {
		this.coffeBew = coffeBew;
	}

	public String getTeaBew() {
		return teaBew;
	}

	public void setTeaBew(String teaBew) {
		this.teaBew = teaBew;
	}

	@Override
	public String toString() {
		return "Заказ чая: " + teaBew + "\nЛожек сахара: " + sugar;
	}
}
