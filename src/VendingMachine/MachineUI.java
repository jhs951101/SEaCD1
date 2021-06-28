package VendingMachine;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief ���Ǳ� �������� �����Ǿ� �ִ� Ŭ����
 * 
 */

public class MachineUI extends JFrame{
	
	private MachineUI thisClass = this;
	
	private int currentMoney;
	
	private Change cg = null;
	private BeverageAction ba = null;
	
	private JPanel mainContent;
	private JButton cokeButton;
	private JButton ciderButton;
	private JButton fantaButton;
	private JButton orangeButton;
	private JButton grapeButton;
	private JButton coffeeButton;
	private JLabel cokeprice;
	private JLabel ciderprice;
	private JLabel fantaprice;
	private JLabel orangeaprice;
	private JLabel grapeprice;
	private JLabel coffeeprice;
	private JLabel cokenumber;
	private JLabel cidernumber;
	private JLabel fantanumber;
	private JLabel orangenumber;
	private JLabel grapenumber;
	private JLabel coffeenumber;
	private JLabel c10number;
	private JLabel c50number;
	private JLabel c100number;
	private JLabel c500number;
	private JLabel moneylabel;
	private JButton inputCoinButton;
	private JButton returnButton;
	private JButton inputChargeButton;
	private JButton inputBeverageButton;
	private JLabel logo;
	private JLabel c1000number;
	
	public MachineUI() {
		setTitle("K-ON Vending Machine");
		setBounds(100, 100, 1300, 850);
		setVisible(true);
		setResizable(false);
		
		initialize();
	}
	
	private void initialize(){
		cg = new Change(thisClass);
		ba = new BeverageAction(thisClass);
		
		mainContent = new JPanel();
		mainContent.setBackground(new Color(255, 255, 153));
		mainContent.setLayout(null);
		setContentPane(mainContent);
		
		cokeButton = new JButton("\uCF5C\uB77C");
		cokeButton.setForeground(Color.WHITE);
		cokeButton.setBackground(new Color(255, 140, 0));
		cokeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean bought = ba.giveBeverage(0, currentMoney);  // ��� �����ϰų� ������ ������ ��찡 �ƴϸ� true�� return��
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(0).getPrice();  // ����� ���ݸ�ŭ ����
					
					cokenumber.setText(String.format("%d��", ba.IDnProduct.get(0).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));  // ����� ������ ���� �ݾ��� �ٽ� ���
					
					if(currentMoney < 700){  // ���� �ݾ��� 700�� �̸��̸� �Ž������� �ڵ����� ����
						boolean b = cg.returnCharges(currentMoney);  // �ܵ��� ���ų� �Ž��� ���� ������ ��찡 �ƴϸ� true�� return��
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
							// �ܵ��� ������ �ٽ� ���
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));  // ���� �ܾ��� 0���� �ʱ�ȭ�ϰ� �ٽ� ���
						}
					}
				}
			}
		});
		cokeButton.setFont(new Font("����", Font.PLAIN, 30));
		cokeButton.setBounds(30, 97, 189, 54);
		mainContent.add(cokeButton);
		
		ciderButton = new JButton("\uC0AC\uC774\uB2E4");
		ciderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bought = ba.giveBeverage(1, currentMoney);
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(1).getPrice();
					
					cidernumber.setText(String.format("%d��", ba.IDnProduct.get(1).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));
					
					if(currentMoney < 700){
						boolean b = cg.returnCharges(currentMoney);
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));
						}
					}
				}
			}
		});
		ciderButton.setForeground(Color.WHITE);
		ciderButton.setBackground(new Color(255, 140, 0));
		ciderButton.setFont(new Font("����", Font.PLAIN, 30));
		ciderButton.setBounds(238, 97, 189, 54);
		mainContent.add(ciderButton);
		
		fantaButton = new JButton("\uD658\uD0C0");
		fantaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bought = ba.giveBeverage(2, currentMoney);
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(2).getPrice();
					
					fantanumber.setText(String.format("%d��", ba.IDnProduct.get(2).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));
					
					if(currentMoney < 700){
						boolean b = cg.returnCharges(currentMoney);
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));
						}
					}
				}
			}
		});
		fantaButton.setForeground(Color.WHITE);
		fantaButton.setBackground(new Color(255, 140, 0));
		fantaButton.setFont(new Font("����", Font.PLAIN, 30));
		fantaButton.setBounds(444, 97, 189, 54);
		mainContent.add(fantaButton);
		
		orangeButton = new JButton("\uC624\uB80C\uC9C0\uC8FC\uC2A4");
		orangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bought = ba.giveBeverage(3, currentMoney);
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(3).getPrice();
					
					orangenumber.setText(String.format("%d��", ba.IDnProduct.get(3).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));
					
					if(currentMoney < 700){
						boolean b = cg.returnCharges(currentMoney);
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));
						}
					}
				}
			}
		});
		orangeButton.setForeground(Color.WHITE);
		orangeButton.setBackground(new Color(255, 140, 0));
		orangeButton.setFont(new Font("����", Font.PLAIN, 30));
		orangeButton.setBounds(650, 97, 189, 54);
		mainContent.add(orangeButton);
		
		grapeButton = new JButton("\uD3EC\uB3C4\uC8FC\uC2A4");
		grapeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bought = ba.giveBeverage(4, currentMoney);
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(4).getPrice();
					
					grapenumber.setText(String.format("%d��", ba.IDnProduct.get(4).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));
					
					if(currentMoney < 700){
						boolean b = cg.returnCharges(currentMoney);
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));
						}
					}
				}
			}
		});
		grapeButton.setForeground(Color.WHITE);
		grapeButton.setBackground(new Color(255, 140, 0));
		grapeButton.setFont(new Font("����", Font.PLAIN, 30));
		grapeButton.setBounds(856, 97, 189, 54);
		mainContent.add(grapeButton);
		
		coffeeButton = new JButton("\uCEE4\uD53C");
		coffeeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bought = ba.giveBeverage(5, currentMoney);
				
				if(bought == true){
					currentMoney = currentMoney - ba.IDnProduct.get(5).getPrice();
					
					coffeenumber.setText(String.format("%d��", ba.IDnProduct.get(5).getStock()));
					moneylabel.setText(String.format("Money: %d", currentMoney));
					
					if(currentMoney < 700){
						boolean b = cg.returnCharges(currentMoney);
						
						if(b == true){
							c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
							c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
							c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
							c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
							c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
						
							currentMoney = 0;
							moneylabel.setText(String.format("Money: %d", currentMoney));
						}
					}
				}
			}
		});
		coffeeButton.setForeground(Color.WHITE);
		coffeeButton.setBackground(new Color(255, 140, 0));
		coffeeButton.setFont(new Font("����", Font.PLAIN, 30));
		coffeeButton.setBounds(1062, 97, 189, 54);
		mainContent.add(coffeeButton);
		
		cokeprice = new JLabel("\\800");
		cokeprice.setFont(new Font("����", Font.PLAIN, 25));
		cokeprice.setBounds(94, 166, 67, 30);
		mainContent.add(cokeprice);
		
		ciderprice = new JLabel("\\700");
		ciderprice.setFont(new Font("����", Font.PLAIN, 25));
		ciderprice.setBounds(299, 166, 67, 30);
		mainContent.add(ciderprice);
		
		fantaprice = new JLabel("\\900");
		fantaprice.setFont(new Font("����", Font.PLAIN, 25));
		fantaprice.setBounds(509, 166, 67, 30);
		mainContent.add(fantaprice);
		
		orangeaprice = new JLabel("\\850");
		orangeaprice.setFont(new Font("����", Font.PLAIN, 25));
		orangeaprice.setBounds(717, 166, 67, 30);
		mainContent.add(orangeaprice);
		
		grapeprice = new JLabel("\\850");
		grapeprice.setFont(new Font("����", Font.PLAIN, 25));
		grapeprice.setBounds(921, 166, 67, 30);
		mainContent.add(grapeprice);
		
		coffeeprice = new JLabel("\\900");
		coffeeprice.setFont(new Font("����", Font.PLAIN, 25));
		coffeeprice.setBounds(1127, 166, 67, 30);
		mainContent.add(coffeeprice);
		
		cokenumber = new JLabel("10\uAC1C");
		cokenumber.setFont(new Font("����", Font.PLAIN, 25));
		cokenumber.setBounds(94, 195, 125, 30);
		mainContent.add(cokenumber);
		
		cidernumber = new JLabel("10\uAC1C");
		cidernumber.setFont(new Font("����", Font.PLAIN, 25));
		cidernumber.setBounds(299, 199, 128, 30);
		mainContent.add(cidernumber);
		
		fantanumber = new JLabel("10\uAC1C");
		fantanumber.setFont(new Font("����", Font.PLAIN, 25));
		fantanumber.setBounds(509, 199, 124, 30);
		mainContent.add(fantanumber);
		
		orangenumber = new JLabel("10\uAC1C");
		orangenumber.setFont(new Font("����", Font.PLAIN, 25));
		orangenumber.setBounds(717, 199, 122, 30);
		mainContent.add(orangenumber);
		
		grapenumber = new JLabel("10\uAC1C");
		grapenumber.setFont(new Font("����", Font.PLAIN, 25));
		grapenumber.setBounds(921, 199, 124, 30);
		mainContent.add(grapenumber);
		
		coffeenumber = new JLabel("10\uAC1C");
		coffeenumber.setFont(new Font("����", Font.PLAIN, 25));
		coffeenumber.setBounds(1127, 199, 124, 30);
		mainContent.add(coffeenumber);
		
		c10number = new JLabel("10\uC6D0: 50\uAC1C");
		c10number.setFont(new Font("����", Font.PLAIN, 30));
		c10number.setBounds(30, 424, 256, 37);
		mainContent.add(c10number);
		
		c50number = new JLabel("50\uC6D0: 50\uAC1C");
		c50number.setFont(new Font("����", Font.PLAIN, 30));
		c50number.setBounds(30, 465, 256, 37);
		mainContent.add(c50number);
		
		c100number = new JLabel("100\uC6D0: 50\uAC1C");
		c100number.setFont(new Font("����", Font.PLAIN, 30));
		c100number.setBounds(30, 506, 256, 37);
		mainContent.add(c100number);
		
		c500number = new JLabel("500\uC6D0: 50\uAC1C");
		c500number.setFont(new Font("����", Font.PLAIN, 30));
		c500number.setBounds(29, 547, 257, 37);
		mainContent.add(c500number);
		
		c1000number = new JLabel("1000\uC6D0: 50\uAC1C");
		c1000number.setFont(new Font("����", Font.PLAIN, 30));
		c1000number.setBounds(29, 588, 257, 37);
		mainContent.add(c1000number);
		
		moneylabel = new JLabel("Money: 0");
		moneylabel.setFont(new Font("����", Font.PLAIN, 40));
		moneylabel.setBounds(905, 412, 372, 54);
		mainContent.add(moneylabel);
		
		inputCoinButton = new JButton("Input");
		inputCoinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InputMoney();
			}
		});
		inputCoinButton.setForeground(Color.WHITE);
		inputCoinButton.setFont(new Font("����", Font.PLAIN, 35));
		inputCoinButton.setBackground(Color.RED);
		inputCoinButton.setBounds(916, 486, 256, 54);
		mainContent.add(inputCoinButton);
		
		returnButton = new JButton("Return Coins");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = cg.returnCharges(currentMoney);  // �ܵ��� ���ų� �Ž��� ���� ������ ��찡 �ƴϸ� true�� return��
				
				if(b == true){
					c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
					c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
					c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
					c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
					c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
				
					currentMoney = 0;  // ���� �ܾ��� 0���� �ʱ�ȭ�ϰ� �ٽ� ���
					moneylabel.setText(String.format("Money: %d", currentMoney));
				}
			}
		});
		returnButton.setForeground(Color.WHITE);
		returnButton.setFont(new Font("����", Font.PLAIN, 35));
		returnButton.setBackground(Color.MAGENTA);
		returnButton.setBounds(918, 557, 254, 54);
		mainContent.add(returnButton);
		
		inputChargeButton = new JButton("\uC794\uB3C8 \uB123\uAE30");
		inputChargeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c10str = JOptionPane.showInputDialog(thisClass,
						"������ 10���� ������ �Է��ϼ���.", "0");
				String c50str = JOptionPane.showInputDialog(thisClass,
						"������ 50���� ������ �Է��ϼ���.", "0");
				String c100str = JOptionPane.showInputDialog(thisClass,
						"������ 100���� ������ �Է��ϼ���.", "0");
				String c500str = JOptionPane.showInputDialog(thisClass,
						"������ 500���� ������ �Է��ϼ���.", "0");
				String c1000str = JOptionPane.showInputDialog(thisClass,
						"������ 1000���� ������ �Է��ϼ���.", "0");  // ������ �Ž����� ���� �Է¹���
				
				if(isNumber(c10str) == false || isNumber(c50str) == false || isNumber(c100str) == false || 
						isNumber(c500str) == false || isNumber(c1000str) == false){
					JOptionPane.showMessageDialog(thisClass, "��ȿ�� ���� �Է��� �ּ���.", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int c10 = Integer.valueOf(c10str);
				int c50 = Integer.valueOf(c50str);
				int c100 = Integer.valueOf(c100str);
				int c500 = Integer.valueOf(c500str);
				int c1000 = Integer.valueOf(c1000str);
				
				cg.inputCharges(c10, c50, c100, c500, c1000);  // �Ž����� ���� ������ ����ŭ �߰���
				
				c10number.setText(String.format("10��: %d��", cg.Coins.get(10).getNumber()));
				c50number.setText(String.format("50��: %d��", cg.Coins.get(50).getNumber()));
				c100number.setText(String.format("100��: %d��", cg.Coins.get(100).getNumber()));
				c500number.setText(String.format("500��: %d��", cg.Coins.get(500).getNumber()));
				c1000number.setText(String.format("1000��: %d��", cg.Coins.get(1000).getNumber()));
				// �Ž����� ���� ������ �ٽ� ���
			}
		});
		inputChargeButton.setFont(new Font("����", Font.PLAIN, 35));
		inputChargeButton.setBackground(Color.WHITE);
		inputChargeButton.setBounds(30, 656, 256, 54);
		mainContent.add(inputChargeButton);
		
		inputBeverageButton = new JButton("\uC74C\uB8CC\uC218 \uB123\uAE30");
		inputBeverageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cokestr = JOptionPane.showInputDialog(thisClass,
						"������ �ݶ��� ������ �Է��ϼ���.", "0");
				String ciderstr = JOptionPane.showInputDialog(thisClass,
						"������ ���̴��� ������ �Է��ϼ���.", "0");
				String fantastr = JOptionPane.showInputDialog(thisClass,
						"������ ȯŸ�� ������ �Է��ϼ���.", "0");
				String orangestr = JOptionPane.showInputDialog(thisClass,
						"������ ������ �ֽ��� ������ �Է��ϼ���.", "0");
				String grapestr = JOptionPane.showInputDialog(thisClass,
						"������ ���� �ֽ��� ������ �Է��ϼ���.", "0");
				String coffeestr = JOptionPane.showInputDialog(thisClass,
						"������ Ŀ���� ������ �Է��ϼ���.", "0");  // ������ ������� ������ �Է¹���
				
				if(isNumber(cokestr) == false || isNumber(ciderstr) == false || isNumber(fantastr) == false || 
						isNumber(orangestr) == false || isNumber(grapestr) == false || isNumber(coffeestr) == false){
					JOptionPane.showMessageDialog(thisClass, "��ȿ�� ���� �Է��� �ּ���.", "Notice", 
							JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				
				int coke = Integer.valueOf(cokestr);
				int cider = Integer.valueOf(ciderstr);
				int fanta = Integer.valueOf(fantastr);
				int orangejuice = Integer.valueOf(orangestr);
				int grapejuice = Integer.valueOf(grapestr);
				int coffee = Integer.valueOf(coffeestr);
				
				ba.inputBeverages(coke, cider, fanta, orangejuice, grapejuice, coffee);  // ������� ������ ������ ����ŭ �߰���
				
				cokenumber.setText(String.format("%d��", ba.IDnProduct.get(0).getStock()));
				cidernumber.setText(String.format("%d��", ba.IDnProduct.get(1).getStock()));
				fantanumber.setText(String.format("%d��", ba.IDnProduct.get(2).getStock()));
				orangenumber.setText(String.format("%d��", ba.IDnProduct.get(3).getStock()));
				grapenumber.setText(String.format("%d��", ba.IDnProduct.get(4).getStock()));
				coffeenumber.setText(String.format("%d��", ba.IDnProduct.get(5).getStock()));
				// ������� ������ �ٽ� ���
			}
		});
		inputBeverageButton.setFont(new Font("����", Font.PLAIN, 35));
		inputBeverageButton.setBackground(Color.WHITE);
		inputBeverageButton.setBounds(30, 726, 256, 54);
		mainContent.add(inputBeverageButton);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(MachineUI.class.getResource("/VendingMachine/KonLogo.png")));
		logo.setBounds(881, 667, 413, 131);
		mainContent.add(logo);
	}
	
	public void InputMoney(){
		String money = JOptionPane.showInputDialog(this,
				"Input money", "0");  // ������� ���� �Է¹���
		
		if(isNumber(money) == false){
			JOptionPane.showMessageDialog(thisClass, "��ȿ�� ���� �Է��� �ּ���.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		int m = Integer.valueOf(money);
		
		if(m%10 != 0){  // 10�� ������ ���� ���� �ʾ��� ���
			JOptionPane.showMessageDialog(thisClass, "10�� ������ ���� �־��ּ���.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		this.currentMoney = this.currentMoney + Integer.valueOf(money);  // ���� �ݾ׿� ������� ����ŭ ���ϰ� �ٽ� ���
		moneylabel.setText(String.format("Money: %d", this.currentMoney));
		
	}
	
	/**
	 * 
	 * @param num �������� �ƴ��� �Ǵܵ� string ��
	 */
	public boolean isNumber(String num){  // string ���� �������� �ƴ��� �Ǵ��ϴ� �Լ�
		
		for(int i=0; i<num.length(); i++){
			char c = num.charAt(i);
			
			if(c != '0' && c != '1' && c != '2' && c != '3' && c != '4' && c != '5' && 
					c != '6' && c != '7' && c != '8' && c != '9')
				return false;
		}
		
		return true;
	}

	public int getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(int currentMoney) {
		this.currentMoney = currentMoney;
	}
}