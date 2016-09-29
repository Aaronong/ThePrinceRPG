package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

	private boolean[] keys;
	public boolean up, down, left, right, select, back;
	private boolean upr, downr, leftr, rightr, selectr, backr;
	
	public KeyManager(){
		// How does this work?
		// Every key on the keyboard has an ID attached to it
		keys = new boolean[256];
		upr = false;
		downr = false;
		leftr = false;
		rightr = false;
		selectr = false;
		backr = false;
	}
	
	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right= keys[KeyEvent.VK_D];
		select = keys[KeyEvent.VK_ENTER];
		back = keys[KeyEvent.VK_BACK_SPACE];
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		//System.out.println(" class KeyManager  Pressed!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		//System.out.println(" class KeyManager  Released!");
		if (e.getKeyCode() == 87)
			upr = true;
		else if (e.getKeyCode() == 83)
			downr = true;
		else if (e.getKeyCode() == 65)
			leftr = true;
		else if (e.getKeyCode() == 68)
			rightr = true;
		else if (e.getKeyCode() == 10)
			selectr = true;
		else if (e.getKeyCode() == 8)
			backr = true;
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	//getters and setters

	public boolean isUpr() {
		return upr;
	}

	public void setUpr(boolean upr) {
		this.upr = upr;
	}

	public boolean isDownr() {
		return downr;
	}

	public void setDownr(boolean downr) {
		this.downr = downr;
	}

	public boolean isLeftr() {
		return leftr;
	}

	public void setLeftr(boolean leftr) {
		this.leftr = leftr;
	}

	public boolean isRightr() {
		return rightr;
	}

	public void setRightr(boolean rightr) {
		this.rightr = rightr;
	}

	public boolean isSelectr() {
		return selectr;
	}

	public void setSelectr(boolean selectr) {
		this.selectr = selectr;
	}

	public boolean isBackr() {
		return backr;
	}

	public void setBackr(boolean backr) {
		this.backr = backr;
	}
	
	

}
