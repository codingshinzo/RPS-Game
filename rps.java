package RPS;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class rps implements ActionListener {

	design o1;

	rps(design design) {
		this.o1 = o1;
	}

	JFrame f1;
	JLabel pc, user, Lpcs, Lusers, play, com, vs, roundLabel, roundwinner;
	Font font, fo;
	JButton rock, paper, scissor;
	ImageIcon imgS, imgR, imgP, imgshow, imgvs, i1;

	@Override
	public void actionPerformed(ActionEvent e) {

		f1 = new JFrame("frame2");
		f1.setLayout(null);
		f1.setSize(350, 600);
		f1.dispose();
		f1.getContentPane().setBackground(Color.white);
		f1.setVisible(true);
		f1.setLocationRelativeTo(null);

		// reset the score

//labels and font

		font = new Font("Arial", Font.BOLD, 18);
		fo = new Font("Arial", Font.BOLD, 23);

		roundLabel = new JLabel("Round : 1");
		roundLabel.setFont(fo);
		roundLabel.setBounds(120, 10, 150, 50);

		roundwinner = new JLabel();
		roundwinner.setFont(font);
		roundwinner.setBounds(110, 40, 200, 50);

		play = new JLabel("PLAYER");
		play.setFont(font);
		play.setBounds(40, 60, 100, 100);

		imgvs = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/99d8c03e-6ed3-40c0-913a-77a74326696e.jpeg");
		vs = new JLabel();
		vs.setIcon(imgvs);
		vs.setBounds(139, 150, 80, 80);

		com = new JLabel("COMPUTER");
		com.setFont(font);
		com.setBounds(213, 60, 120, 100);

//result images
		user = new JLabel();
		user.setBounds(30, 130, 100, 122);

		pc = new JLabel();
		pc.setBounds(220, 130, 97, 122);

		// score
		Lusers = new JLabel("0");
		Lusers.setFont(fo);
		Lusers.setBounds(70, 260, 100, 100);

		Lpcs = new JLabel("0");
		Lpcs.setFont(fo);
		Lpcs.setBounds(270, 260, 100, 100);

		// user button
		imgR = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/202ccd63-ad56-41ec-8ad9-cc527b880da1.jpeg");
		rock = new JButton(imgR);
		rock.setBounds(10, 395, 100, 122);
		rock.setBorder(BorderFactory.createLineBorder(Color.white));
		rock.setText("rock");
		rock.setHorizontalTextPosition(JButton.CENTER);
		rock.setVerticalTextPosition(JButton.BOTTOM);

		imgP = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/th (7).png");
		paper = new JButton(imgP);
		paper.setBounds(127, 395, 100, 122);
		paper.setBorder(BorderFactory.createLineBorder(Color.white));
		paper.setText("paper");
		paper.setHorizontalTextPosition(JButton.CENTER);
		paper.setVerticalTextPosition(JButton.BOTTOM);

		imgS = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/th (6).png");
		scissor = new JButton(imgS);
		scissor.setBounds(240, 395, 100, 122);
		scissor.setBorder(BorderFactory.createLineBorder(Color.white));
		scissor.setText("scissor");
		scissor.setHorizontalTextPosition(JButton.CENTER);
		scissor.setVerticalTextPosition(JButton.BOTTOM);

		// actionListener
		rock.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				get(rock.getText());

				user.setIcon(imgR);
			}
		});

		paper.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				get(paper.getText());
				user.setIcon(imgP);

			}
		});

		scissor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				get(scissor.getText());
				user.setIcon(imgS);

			}
		});

		f1.add(rock);
		f1.add(paper);
		f1.add(scissor);
		f1.add(pc);
		f1.add(user);
		f1.add(play);
		f1.add(com);
		f1.add(Lpcs);
		f1.add(Lusers);
		f1.add(vs);
		f1.add(roundLabel);
		f1.add(roundwinner);

	}

	// get method
	int us = 1, pcs = 1;
	int uscore = 0, pcscore = 0;
	int choice;
	int uwR = 0, pw = 0, draw = 0;
	int round = 1, pcround = 0, useround = 0;

	public void get(String u) {
		String[] arr = { "rock", "paper", "scissor" };
		Random ra = new Random();
		int a = ra.nextInt(3);
		String p = arr[a];

		if (a == 0) {
			pc.setIcon(imgR);

		} else if (a == 1) {
			pc.setIcon(imgP);
		} else {
			pc.setIcon(imgS);
		}

		if (u == p) {
			uscore++;
			pcscore++;
			roundLabel.setText("Round : " + round);

			// System.out.println("pc score = " + pcscore + " " + "user score = " + uscore +
			// " round = " + round);

		}

		else if ((u == "rock" && p == "paper" || u == "paper" && p == "scissor" || u == "scissor" && p == "rock")) {

			pcscore++;
			roundLabel.setText("Round : " + round);

			// System.out.println("pc score = " + pcscore + " " + "user score = " + uscore +
			// " round = " + round);

		} else {

			uscore++;
			roundLabel.setText("Round : " + round);

			// System.out.println("pc score = " + pcscore + " " + "user score = " + uscore +
			// " round = " + round);

		}
		if (uscore == 2 && pcscore == 2) {

			pw++;
			uwR++;
			// System.out.println("draw = " +"pc = "+pw+"user = "+ uwR );
			uscore = 0;
			pcscore = 0;
			us = 1;
			pcs = 1;
			round++;
			pcround++;
			useround++;
			Lpcs.setText("" + pcround);
			Lusers.setText("" + useround);

			roundwinner.setText("   Draw   ");
		} else if (uscore == 2 && pcscore == 0 || uscore == 2 && pcscore == 1) {
			uwR++;
			// System.out.println("user is winner + " + uwR);

			uscore = 0;
			pcscore = 0;
			us = 1;
			pcs = 1;
			round++;
			useround++;
			Lusers.setText("" + useround);
			roundwinner.setText("Player win..!");

		} else if (pcscore == 2 && uscore == 0 || pcscore == 2 && uscore == 1) {

			pw++;
			// System.out.println("pc is winner + " + pw);

			uscore = 0;
			pcscore = 0;
			us = 1;
			pcs = 1;
			round++;
			pcround++;
			Lpcs.setText("" + pcround);
			roundwinner.setText("Computer win..!");
		}

		if (round > 3) {
			if (uwR == 2 && pw == 1 || uwR == 3) {

				i1 = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/Screenshot from 2022-11-14 18-36-02.png");
				UIManager ui = new UIManager();
				ui.put("OptionPane.background", Color.white);
				ui.put("Panel.background", Color.white);
				JLabel l1 = new JLabel(i1);
				l1.setBounds(0, 0, 50, 50);
				JPanel p1 = new JPanel();
				p1.setLayout(new FlowLayout());
				p1.add(l1);

				choice = JOptionPane.showConfirmDialog(null, p1, "do you wanna exit?", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}

			else if (pw == 2 && uwR == 1 || pw == 3) {

				i1 = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/490ac2b7-860d-4fd9-a160-70fd67766182.png");
				UIManager ui = new UIManager();
				ui.put("OptionPane.background", Color.white);
				ui.put("Panel.background", Color.white);
				JLabel l1 = new JLabel(i1);
				l1.setBounds(0, 0, 50, 50);
				JPanel p1 = new JPanel();
				p1.setLayout(new FlowLayout());
				p1.add(l1);

				choice = JOptionPane.showConfirmDialog(null, p1, "do you wanna exit?", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}

			}

			else if (pw == uwR) {

				i1 = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/Screenshot from 2022-11-14 18-28-18.png");
				UIManager ui = new UIManager();
				ui.put("OptionPane.background", Color.white);
				ui.put("Panel.background", Color.white);
				JLabel l1 = new JLabel(i1);
				l1.setBounds(0, 0, 50, 50);
				JPanel p1 = new JPanel();
				p1.setLayout(new FlowLayout());
				p1.add(l1);

				choice = JOptionPane.showConfirmDialog(null, p1, "do you wanna exit?", JOptionPane.YES_NO_OPTION);
				if (choice == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			round = 1;
			roundwinner.setText(null);
			roundLabel.setText("Round : 1");
			uwR = 0;
			pw = 0;
			pcround = 0;
			useround = 0;
			Lpcs.setText("0");
			Lusers.setText("0");

		}

	}

}
