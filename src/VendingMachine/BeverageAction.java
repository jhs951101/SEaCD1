package VendingMachine;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Ji-Hoon Shim
 * @date 2016-04-09
 * @brief 음료수에 대한 액션이 구현되어 있는 클래스
 * 
 */

public class BeverageAction{
	
	MachineUI mainFrame = null;
	
	HashMap<Integer, Product> IDnProduct = null;
	
	private Product coke = null;
	private Product cider = null;
	private Product fanta = null;
	private Product orangejuice = null;
	private Product grapejuice = null;
	private Product coffee = null;
	
	
	/**
	 * 
	 * @param f 알림창을 중앙에 띄우기 위해 MachineUI 인스턴스를 불러옴
	 */
	public BeverageAction(MachineUI f){
		coke = new Product("콜라", 800, 0, 10);
		cider = new Product("사이다", 700, 0, 10);
		fanta = new Product("환타", 900, 0, 10);
		orangejuice = new Product("오렌지 주스", 850, 0, 10);
		grapejuice = new Product("포도 주스", 850, 0, 10);
		coffee = new Product("커피", 900, 0, 10);
		
		IDnProduct = new HashMap();
		
		IDnProduct.put(0, coke);  // 0: 콜라, 1: 사이다, 2: 환타, 3: 오렌지주스, 4: 포도주스, 5: 커피
		IDnProduct.put(1, cider);
		IDnProduct.put(2, fanta);
		IDnProduct.put(3, orangejuice);
		IDnProduct.put(4, grapejuice);
		IDnProduct.put(5, coffee);
		
		this.mainFrame = f;
	}
	
	/**
	 * 
	 * @param id IDnProduct의 key
	 * @param currentmoney 자판기에 넣은 돈을 의미
	 */
	public boolean giveBeverage(int id, int currentmoney){
		if(IDnProduct.get(id).getPrice() > currentmoney){  // 지정된 가격보다 현금이 부족한 경우
			JOptionPane.showMessageDialog(mainFrame, "현금이 부족합니다.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(IDnProduct.get(id).getStock() <= 0){  // 선택한 음료수가 재고가 없는 경우
			JOptionPane.showMessageDialog(mainFrame, "죄송합니다. 재고가 없습니다.", "Notice", 
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		// 음료수를 하나 주고 purchased 값과 stock 값을 조절함
		JOptionPane.showMessageDialog(mainFrame, "여기 " + IDnProduct.get(id).getName() + " 있습니다. 좋은 하루 되세요.", "Notice", 
				JOptionPane.INFORMATION_MESSAGE);
		IDnProduct.get(id).setPurchased( IDnProduct.get(id).getPurchased() + 1 );
		IDnProduct.get(id).setStock( IDnProduct.get(id).getStock() - 1 );	
		
		return true;
	}
	
	/**
	 * 
	 * @param coke 추가하려는 콜라의 갯수
	 * @param cider 추가하려는 사이다의 갯수
	 * @param fanta 추가하려는 환타의 갯수
	 * @param orangejuice 추가하려는 오렌지 주스의 갯수
	 * @param grapejuice 추가하려는 포도 주스의 갯수
	 * @param coffee 추가하려는 커피의 갯수
	 */
	public void inputBeverages(int coke, int cider, int fanta, int orangejuice, int grapejuice, int coffee){
		this.coke.setStock(this.coke.getStock() + coke);
		this.cider.setStock(this.cider.getStock() + cider);
		this.fanta.setStock(this.fanta.getStock() + fanta);
		this.orangejuice.setStock(this.orangejuice.getStock() + orangejuice);
		this.grapejuice.setStock(this.grapejuice.getStock() + grapejuice);
		this.coffee.setStock(this.coffee.getStock() + coffee);
		// 음료수를 지정한 수만큼 추가함
	}
}