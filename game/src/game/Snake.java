package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
//Key
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
//List
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Snake extends JFrame {

	private Point point = new Point();
	private LinkedList<Point> list = new LinkedList<Point>();

	private int key = 37;

	public void init() {
		// 最初の食い物座標
		point.setLocation(100, 100);
		// ヘビ最初の身長
		for (int i = 0; i < 6; i++) {
			list.add(new Point(300 + 10 * i, 300));

		}
		// 動き
		new Thread(new MoveThread()).start();
	}

	public void paint(Graphics g) {

		//
		Image img = createImage(500, 500);
		BufferedImage bg = null;
		try {

//			bg = ImageIO.read(new File("src/1.jpg"));

		}catch(Exception e) {

			e.printStackTrace();

		}
		// IMAGE
		Graphics g2 = img.getGraphics();
		// 白い背景
		g2.setColor(Color.WHITE);
		// 背景範囲
		g2.fillRect(0, 0, 500, 500);
		// 原点
		g2.translate(50, 50);
		// フレーム色
		g2.setColor(Color.RED);
		g2.drawRect(0, 0, 400, 400);
        // ヘビの色
		g2.setColor(Color.GREEN);
		for (int i = 0; i < list.size(); i++) {
			g2.fillRect(list.get(i).x, list.get(i).y, 10, 10);
		}

		g2.setColor(Color.RED);
		g2.fillRect(point.x, point.y, 10, 10);
//		g.drawImage(bg, 0, 0, null);
		g.drawImage(img, 0, 0, 500, 500, this);

	}

	public Snake() {
		this.setTitle("Snake");
		this.setResizable(false);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// EXIT
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					System.exit(0);
				}
				// 上下左右
				if (e.getKeyCode() >= KeyEvent.VK_LEFT && e.getKeyCode() <= KeyEvent.VK_DOWN) {
					if (Math.abs(key - e.getKeyCode()) != 2) {
						key = e.getKeyCode();
					}
				}
			}
		});
		this.init();

	}

	class MoveThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(150);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Point p = list.getFirst().getLocation();
				switch (key) {
				case 37:
					p.x = p.x - 10;
					break;
				case 38:
					p.y = p.y - 10;
					break;
				case 39:
					p.x = p.x + 10;
					break;
				case 40:
					p.y = p.y + 10;
					break;

				}

				if (p.x < 0 || p.x > 390 || p.y < 0 || p.y > 390 || list.contains(p)) {
					JOptionPane.showMessageDialog(null, "GAME OVER");
					break;
				}
				list.addFirst(p);
				if (p.equals(point)) {
					int x = (int) (Math.random() * 40) * 10;
					int y = (int) (Math.random() * 40) * 10;
					point.setLocation(x, y);
				} else {
					list.removeLast();
				}

				Snake.this.repaint();
			}
		}

	}

	public static void main(String[] args) {

		new Snake();
	}

}
