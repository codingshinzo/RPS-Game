package RPS;
import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class design {

	JFrame f;
	JButton b1;
	ImageIcon img;

	public design() {

		f = new JFrame("Frame");
		f.setLayout(null);
		f.setSize(350, 600);
		f.setLocationRelativeTo(null);
		Image icon = Toolkit.getDefaultToolkit().getImage("/home/bhagyashri/Desktop/game/RPS/images/th (1).jpeg");    
		f.setIconImage(icon);
		img = new ImageIcon("/home/bhagyashri/Desktop/game/RPS/images/e62584bf-2065-46e0-af97-27e3ae5e1e95.jpeg");

		b1 = new JButton(img);
		b1.setBounds(140, 420, 72, 72);
		b1.setBorder(BorderFactory.createLineBorder(Color.white));

		rps obj1 = new rps(this);
		b1.addActionListener(obj1);

		f.dispose();

		f.add(b1);
		f.add(new MyCanvas());
		f.setVisible(true);

	}

	public static void main(String args[]) {

	}
}

    class MyCanvas extends JPanel {

        public MyCanvas() {

            setSize(350, 600);

        }

        public void paint(Graphics g) {
            {
                String url = "/home/bhagyashri/Desktop/game/RPS/images/90348dc0-e2c8-4421-b75d-adee913bf49a.jpeg";
                Image i = new ImageIcon(url).getImage();
                g.drawImage(i, -322, 20, 995, 450, null);

                String url1 = "/home/bhagyashri/Desktop/game/RPS/images/th (6).jpeg";
                Image i1 = new ImageIcon(url1).getImage();
                g.drawImage(i1, 0, 0, 350, 100, null);

                String url2 = "/home/bhagyashri/Desktop/game/RPS/images/th (5).jpeg";
                Image i2 = new ImageIcon(url2).getImage();
                g.drawImage(i2, 0, 430, 350, 150, null);

            }
        }

    }




