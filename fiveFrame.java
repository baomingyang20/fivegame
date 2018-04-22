package fivegame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class fiveFrame extends JPanel {

	private chess2 ch = new chess2(this);

	public static void main(String[] args) {
		fiveFrame fm = new fiveFrame();
		fm.initUI();
	}

	public void initUI() {
		JFrame frame = new JFrame();
		frame.setTitle("五子棋");
		frame.setSize(950, 800);
		frame.setDefaultCloseOperation(3);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		this.setBackground(new Color(255, 133, 74));
		frame.add(this);

		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(Color.LIGHT_GRAY);
		eastPanel.setPreferredSize(new Dimension(150, 0));
		frame.add(eastPanel, BorderLayout.EAST);

		String array[] = { "新游戏", "悔棋", "认输", "退出", "对战模式：", "人人对战", "人机对战" };

		ButtonGroup bg = new ButtonGroup();

		// chess2 ch=new chess2(this);

		for (int i = 0; i < array.length; i++) {
			if (i < 4) {
				JButton button = new JButton(array[i]);
				button.setPreferredSize(new Dimension(140, 60));
				eastPanel.add(button);
				button.addActionListener(ch);
			} else if (i == 4) {
				JLabel label = new JLabel(array[i]);
				eastPanel.add(label);
			} else {
				JRadioButton button = new JRadioButton(array[i]);
				button.setPreferredSize(new Dimension(140, 60));
				button.setOpaque(false);
				eastPanel.add(button);
				button.setSelected(true);

				bg.add(button);
				button.addActionListener(ch);
			}
		}

		frame.setVisible(true);

		Graphics g = this.getGraphics();

		ch.getG(g);

	}

	public void paint(Graphics g) {
		super.paint(g);
		for (int i = 0; i < 18; i++) {
			g.drawLine(50, 40 + 40 * i, 50 + 17 * 40, 40 + 40 * i);
			g.drawLine(50 + 40 * i, 40, 50 + 40 * i, 40 + 17 * 40);
		}
		for (int i = 0; i < ch.getChesses().size(); i++) {
			chessPiece cp = ch.getChesses().get(i);
			if (cp != null) {
				if (cp.getColor()) {
					g.setColor(Color.black);
				} else {
					g.setColor(Color.white);
				}
				g.fillOval(cp.getY() * 40 + 50 - 20, cp.getX() * 40 + 40 - 20, 40, 40);
			}
		}
	}
}
