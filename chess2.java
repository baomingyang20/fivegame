package fivegame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class chess2 extends MouseAdapter implements ActionListener {

	private chessPiece chesses[][];

	private chessPiece now;

	private int max;

	private int weightDate[][];

	private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

	private ArrayList<chessPiece> ar;

	private boolean bw, flag;

	private Graphics2D g;

	private int x0, y0;

	private JPanel jj;

	private String type, typeM;

	chess2(JPanel jp) {
		chesses = new chessPiece[18][18];
		weightDate = new int[18][18];
		ar = new ArrayList<chessPiece>();
		bw = true;
		flag = false;
		jj = jp;
		typeM = "人人对战";
		max = 0;
		map.put(22, 0);
		map.put(10, 10);
		map.put(20, 100);
		map.put(30, 1000);
		map.put(40, 10000);
		map.put(11, 2);
		map.put(21, 10);
		map.put(31, 100);
		map.put(41, 1000);
	}

	public ArrayList<chessPiece> getChesses() {
		return ar;
	}

	public void getG(Graphics gr) {
		g = (Graphics2D) gr;
	}

	public chessPiece getNow() {
		return now;
	}

	public void actionPerformed(ActionEvent e) {
		type = e.getActionCommand();
		if (type.equals("新游戏")) {
			ar.clear();
			chesses = new chessPiece[18][18];
			bw = true;
			flag = false;
			jj.addMouseListener(this);
			jj.repaint();
		}
		if (type.equals("认输")) {
			if (bw) {
				JOptionPane.showMessageDialog(null, "辣鸡","比赛结果",JOptionPane.PLAIN_MESSAGE);
//				System.out.println("白棋胜利");
			}
			if (!bw) {
				JOptionPane.showMessageDialog(null, "你赢了","比赛结果",JOptionPane.PLAIN_MESSAGE);
//				System.out.println("黑棋胜利");
			}
			jj.removeMouseListener(this);
		}
		if (type.equals("退出")) {
			System.exit(0);
		}
		if (type.equals("人机对战") || type.equals("人人对战")) {
			typeM = type;
		}
		if (type.equals("悔棋")) {
			if (!ar.isEmpty()) {
				chessPiece xx;
				xx = ar.remove(ar.size() - 1);
				chesses[xx.getX()][xx.getY()] = null;
				xx = ar.remove(ar.size() - 1);
				chesses[xx.getX()][xx.getY()] = null;
				jj.repaint();
			}
		}
	}

	public void judge(chessPiece a, boolean b) {
		int x = a.getX();
		int y = a.getY();
		int count[] = new int[8];
		// int count[]=new int[4];
		// 横竖捺撇
		boolean pos[] = new boolean[8];
		// 0 boolean left=true;
		// 1 boolean leftUp=true;
		// 2 boolean leftDown=true;
		// 3 boolean up=true;
		// 4 boolean down=true;
		// 5 boolean rightUp=true;
		// 6 boolean rightDown=true;
		// 7 boolean right=true;

		for (int i = 0; i < 8; i++) {
			pos[i] = true;
		}
		if (!b) {
			weightDate[x][y] = 0;
		}

		// for(int i=1;i<6;i++)
		// {
		// int
		// hl0[][]={{x,y-i},{x-i,y-i},{x+i,y-i},{x-i,y},{x+i,y},{x-i,y+i},{x+i,y+i},{x,y+i}};
		// int
		// hl1[][]={{x,y-1},{x-1,y-1},{x+1,y-1},{x-1,y},{x+1,y},{x-1,y+1},{x+1,y+1},{x,y+1}};
		// boolean
		// hl[]={(y-i)<0,(x-i)<0||(y-i)<0,(x+i)>17||(y-i)<0,(x-i)<0,(x+i)>17,(x-i)<0||(y+i)>17,(y+i)>17||(x+i)>17,(y+i)>17};
		// for(int j=0;j<4;j++)
		// {
		// int as=-1;
		// if(b)
		// {
		// if(pos[j])
		// {
		// if(null==chesses[hl0[j][0]][hl0[j][1]]||chesses[hl0[j][0]][hl0[j][1]].getColor()!=a.getColor())
		// {
		// pos[j]=false;
		// }
		// else
		// {
		// count[j]++;
		// }
		// }
		// if(pos[7-j])
		// {
		// if(null==chesses[hl0[7-j][0]][hl0[7-j][1]]||chesses[hl0[7-j][0]][hl0[7-j][1]].getColor()!=a.getColor())
		// {
		// pos[7-j]=false;
		// }
		// else
		// {
		// count[j]++;
		// }
		// }
		// }
		// else
		// {
		// if(pos[j])
		// {
		// if(null==chesses[hl0[j][0]][hl0[j][1]])
		// {
		// if(count[j]!=0)
		// {
		// as=0;
		// }
		// pos[j]=false;
		// }
		// else
		// {
		// boolean aa=chesses[hl1[j][0]][hl1[j][1]].getColor();
		// if(chesses[hl0[j][0]][hl0[j][1]].getColor()!=aa)
		// {
		// pos[j]=false;
		// as=1;
		// }
		// }
		// if(pos[j])
		// {
		// count[j]++;
		// }
		// }
		// if(pos[7-j])
		// {
		// if(null==chesses[hl0[7-j][0]][hl0[7-j][1]])
		// {
		// if(count[j]!=0)
		// {
		// as=0;
		// }
		// pos[j]=false;
		// }
		// else
		// {
		// boolean aa=chesses[hl1[7-j][0]][hl1[7-j][1]].getColor();
		// if(chesses[hl0[7-j][0]][hl0[7-j][1]].getColor()!=aa)
		// {
		// pos[7-j]=false;
		// if(as!=-1)
		// {
		// as++;
		// }
		// else
		// {
		// as=1;
		// }
		//
		// }
		// }
		// if(pos[7-j])
		// {
		// count[j]++;
		// }
		// }
		// }
		// }
		// }
		// if(b)
		// {
		// for(int i=0;i<4;i++)
		// {
		// if(count[i]>=4)
		// {
		// if(a.getColor())
		// {
		// System.out.println("黑棋胜利");
		// }
		// if(!a.getColor())
		// {
		// System.out.println("白棋胜利");
		// }
		// jj.removeMouseListener(this);
		// count[i]=0;
		// }
		// }
		// }

		for (int i = 1; i < 6; i++) {
			int hl0[][] = { { x, y - i }, { x - i, y - i }, { x + i, y - i }, { x - i, y }, { x + i, y },
					{ x - i, y + i }, { x + i, y + i }, { x, y + i } };
			int hl1[][] = { { x, y - 1 }, { x - 1, y - 1 }, { x + 1, y - 1 }, { x - 1, y }, { x + 1, y },
					{ x - 1, y + 1 }, { x + 1, y + 1 }, { x, y + 1 } };
			boolean hl[] = { (y - i) < 0, (x - i) < 0 || (y - i) < 0, (x + i) > 17 || (y - i) < 0, (x - i) < 0,
					(x + i) > 17, (x - i) < 0 || (y + i) > 17, (y + i) > 17 || (x + i) > 17, (y + i) > 17 };
			for (int j = 0; j < 8; j++) {
				int as = 2;
				if (pos[j]) {
					if (hl[j]) {
						pos[j] = false;
						as = 1;
					} else {
						if (b) {
							if (null == chesses[hl0[j][0]][hl0[j][1]]
									|| chesses[hl0[j][0]][hl0[j][1]].getColor() != a.getColor()) {
								pos[j] = false;
							}
							if (pos[j]) {
								count[j]++;
							}
						}
						if (!b) {
							if (null == chesses[hl0[j][0]][hl0[j][1]]) {
								if (count[j] != 0) {
									as = 0;
								}
								pos[j] = false;
							} else {
								boolean aa = chesses[hl1[j][0]][hl1[j][1]].getColor();
								if (chesses[hl0[j][0]][hl0[j][1]].getColor() != aa) {
									pos[j] = false;
									as = 1;
								}
							}
							if (pos[j]) {
								count[j]++;
							}
						}
					}
					if (!b) {
						if (as == 0 || as == 1) {
							as = as + count[j] * 10;
							if (as > 9) {
								weightDate[x][y] = weightDate[x][y] + map.get(as);
							}
						}
					}
				}
			}
		}

		if (b) {
			for (int i = 0; i < 4; i++) {
				if (count[i] + count[7 - i] >= 4) {
					if (a.getColor()) {
						System.out.println("黑棋胜利");
					}
					if (!a.getColor()) {
						System.out.println("白棋胜利");
					}
					jj.removeMouseListener(this);
					count[i] = 0;
					count[7 - i] = 0;
				}
			}
		}
	}

	public void mousePressed(MouseEvent e) {
		int x1, y1;
		x1 = e.getX();
		y1 = e.getY();
		int a1, b1, a2, b2;
		if (x1 >= 30 && y1 >= 20 && x1 <= (50 + 17 * 40 + 20) && y1 <= (40 + 17 * 40 + 20)) {
			if (bw) {
				g.setColor(Color.BLACK);
			}
			if (typeM.equals("人人对战")) {
				if (!bw) {
					g.setColor(Color.white);
				}
			}
			a2 = Math.abs(y1 - 40) / 40;
			b2 = Math.abs(y1 - 40) % 40;
			a1 = Math.abs(x1 - 50) / 40;
			b1 = Math.abs(x1 - 50) % 40;
			if (b1 <= 20 && b2 <= 20) {
				if (chesses[a2][a1] == null) {
					chesses[a2][a1] = new chessPiece(a2, a1, bw);
					bw = !bw;
				} else {
					flag = true;
				}
			}
			if (b1 <= 20 && b2 > 20) {
				a2++;
				if (chesses[a2][a1] == null) {
					chesses[a2][a1] = new chessPiece(a2, a1, bw);
					bw = !bw;
				} else {
					flag = true;
				}
			}
			if (b1 > 20 && b2 <= 20) {
				a1++;
				if (chesses[a2][a1] == null) {
					chesses[a2][a1] = new chessPiece(a2, a1, bw);
					bw = !bw;
				} else {
					flag = true;
				}
			}
			if (b1 > 20 && b2 > 20) {
				a1++;
				a2++;
				if (chesses[a2][a1] == null) {
					chesses[a2][a1] = new chessPiece(a2, a1, bw);
					bw = !bw;
				} else {
					flag = true;
				}
			}
			x0 = a1 * 40 + 50;
			y0 = a2 * 40 + 40;
			if (!flag) {
				g.fillOval(x0 - 20, y0 - 20, 40, 40);
				ar.add(chesses[a2][a1]);
				weightDate[a2][a1] = 1;
				judge(chesses[a2][a1], true);
				for (int i = 0; i < 18; i++) {
					for (int j = 0; j < 18; j++) {
						if (null == chesses[i][j]) {
							chesses[i][j] = new chessPiece(i, j);
							judge(chesses[i][j], false);
							chesses[i][j] = null;
							if (weightDate[i][j] > max) {
								max = weightDate[i][j];
								now = new chessPiece(i, j);
							}
						}
					}
				}
				if (typeM.equals("人机对战")) {
					g.setColor(Color.white);
					g.fillOval(now.getY() * 40 + 50 - 20, now.getX() * 40 + 40 - 20, 40, 40);
					ar.add(now);
					chesses[now.getX()][now.getY()] = new chessPiece(now.getX(), now.getY(), bw);
					weightDate[now.getX()][now.getY()] = 1;
					judge(chesses[now.getX()][now.getY()], true);
					bw = !bw;
				}
				max = 0;
				now = null;
				System.out.println(max);
				for (int k = 0; k < 18; k++) {
					for (int j = 0; j < 18; j++) {
						System.out.print(weightDate[k][j] + "\t");
					}
					System.out.println("");
				}
				System.out.println("");
			}
			flag = false;
		}
	}
}
