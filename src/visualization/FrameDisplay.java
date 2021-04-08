package visualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import algorithms.*;

public class FrameDisplay {
	private static FrameDisplay d;
	private JFrame frame;
	private Draw panel;
	private int[] toSortArr;
	private Thread sortThread;
	private JLabel amountMoves, delayTime;
	private SortRun AlgorithmRun = new SortRun(toSortArr, d, "BubbleSort");
	private JMenuItem mix, stop, audioOnOff;
	
	public static void main (String[] args) {
		d = new FrameDisplay();
		d.go();
	}
	
	public void paint(int index1, int index2) {
		panel.paintRectangles(index1, index2);
	}
	
	public void paint(int index) {
		panel.paintRectangles(index);
	}
	
	protected void setArray() {
		int size = toSortArr.length;
		for (int i = 0; i < size; i++) {
			if (size <= 3)
				toSortArr[i] = (int) ((Math.random() * 3));
			else
				toSortArr[i] = (int) ((Math.random() * (size-(size/4))) + (size/4));
		}
	}
	
	private void setArray(int size) {
		toSortArr = new int[size];
		for (int i = 0; i < size; i++) {
			toSortArr[i] = (int) ((Math.random() * (size-(size/5))) + (size/5));
		}
	}
	
	private void go() {
		frame = new JFrame("Sort Algorithms Visualization");
		panel = new Draw();
		panel.setBackground(Color.darkGray);
		amountMoves = new JLabel();
		delayTime = new JLabel();
		JMenuBar Bar = new JMenuBar();
		JMenu menu = new JMenu("Algorithms");
		JMenu utilities = new JMenu("Utilities");
		JMenu setStyle = new JMenu("Set style");
		JMenuItem BubbleSortItem = new JMenuItem("BubbleSort");
		JMenuItem InsertionSortItem = new JMenuItem("InsertionSort");
		JMenuItem SelectionSortItem = new JMenuItem("SelectionSort");
		JMenuItem MergeSortItem = new JMenuItem("MergeSort");
		JMenuItem QuickSortItem = new JMenuItem("QuickSort");
		JMenuItem HeapSortItem = new JMenuItem("HeapSort");
		JMenuItem ShellSortItem = new JMenuItem("ShellSort");
		JMenuItem GnomeSortItem = new JMenuItem("GnomeSort");
		JMenuItem CocktailSortItem = new JMenuItem("CocktailSort");
		
		JMenuItem arraySize = new JMenuItem("Change size");
		JMenuItem plainStyle = new JMenuItem("Plain");
		JMenuItem columnStyle = new JMenuItem("Columns");
		JMenuItem setDelay = new JMenuItem("Set Delay");
		audioOnOff = new JMenuItem("Audio: On");
		mix = new JMenuItem("Mix");
		stop = new JMenuItem("Stop");
		panel.add(amountMoves);
		panel.add(delayTime);
		setStyle.add(plainStyle);
		setStyle.add(columnStyle);
		utilities.add(mix);
		utilities.add(stop);
		utilities.add(arraySize);
		utilities.add(setDelay);
		utilities.add(audioOnOff);
		utilities.add(setStyle);
		menu.add(BubbleSortItem);
		menu.add(InsertionSortItem);
		menu.add(SelectionSortItem);
		menu.add(MergeSortItem);
		menu.add(QuickSortItem);
		menu.add(HeapSortItem);
		menu.add(ShellSortItem);
		menu.add(GnomeSortItem);
		menu.add(CocktailSortItem);
		Bar.add(menu);
		Bar.add(utilities);
		
		BubbleSortItem.addActionListener(new JMenuListener());
		InsertionSortItem.addActionListener(new JMenuListener());
		SelectionSortItem.addActionListener(new JMenuListener());
		MergeSortItem.addActionListener(new JMenuListener());
		QuickSortItem.addActionListener(new JMenuListener());
		HeapSortItem.addActionListener(new JMenuListener());
		ShellSortItem.addActionListener(new JMenuListener());
		GnomeSortItem.addActionListener(new JMenuListener());
		CocktailSortItem.addActionListener(new JMenuListener());
		mix.addActionListener(new MixListener());
		stop.addActionListener(new StopListener());
		setDelay.addActionListener(new setDelayListener());
		plainStyle.addActionListener(new StyleListener());
		columnStyle.addActionListener(new StyleListener());
		arraySize.addActionListener(new ArraySizeListener());
		audioOnOff.addActionListener(new MuteListener());
		
		mix.setAccelerator(KeyStroke.getKeyStroke('m'));
		stop.setAccelerator(KeyStroke.getKeyStroke('s'));
		setDelay.setAccelerator(KeyStroke.getKeyStroke('d'));
		arraySize.setAccelerator(KeyStroke.getKeyStroke('a'));
		audioOnOff.setAccelerator(KeyStroke.getKeyStroke('o'));
		BubbleSortItem.setAccelerator(KeyStroke.getKeyStroke('b'));
		InsertionSortItem.setAccelerator(KeyStroke.getKeyStroke('i'));
		SelectionSortItem.setAccelerator(KeyStroke.getKeyStroke('e'));
		MergeSortItem.setAccelerator(KeyStroke.getKeyStroke('M'));
		QuickSortItem.setAccelerator(KeyStroke.getKeyStroke('q'));
		HeapSortItem.setAccelerator(KeyStroke.getKeyStroke('h'));
		ShellSortItem.setAccelerator(KeyStroke.getKeyStroke('S'));
		GnomeSortItem.setAccelerator(KeyStroke.getKeyStroke('g'));
		CocktailSortItem.setAccelerator(KeyStroke.getKeyStroke('c'));
		
		d.setArray(200);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		amountMoves.setFont(new Font("Verdana", 4, 15));
		amountMoves.setForeground(Color.white);
		delayTime.setFont(new Font("Verdana", 4, 15));
		delayTime.setForeground(Color.white);
		
		frame.add(BorderLayout.NORTH, Bar);
		frame.add(BorderLayout.CENTER, panel);
		frame.setSize(800, 600);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private class MuteListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			boolean isMute = SortAlgorithms.getAudioState();
			if (!isMute) {
				SortAlgorithms.mute(true);
				audioOnOff.setText("Audio: Off"); 
			}else {
				SortAlgorithms.mute(false);
				audioOnOff.setText("Audio: On");
			}
		}
		
	}  
	
	private class ArraySizeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String delayString = JOptionPane.showInputDialog(frame, "Write the size: ", null);
          
			try {
				if (delayString != null) {
					int size = Integer.parseInt(delayString);
					if (size <= 0 || size > 400) { 
						JOptionPane.showMessageDialog(frame, "The number must be between 1 and 400");
					}else {
						setArray(size);
						mix.doClick();
					}
				}
            }catch (Exception e) {
            	JOptionPane.showMessageDialog(frame, "Insert a whole number");
            }
            
		}
		
	}  
	
	private class StyleListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg) {
			JMenuItem item = ((JMenuItem) arg.getSource());   
			if (item.getText() == "Plain") 
				panel.setStyle("Plain");
			else 
				panel.setStyle("Column");
		}
		
	}
	
	private class setDelayListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg) {
			String delayString = JOptionPane.showInputDialog(frame, "Write the delay time: ", null);
			
				try {
					if (delayString != null) {
						int delay = Integer.parseInt(delayString);
						if (delay < 0) 
							JOptionPane.showMessageDialog(frame, "The delay can't be negative");
						else {
							AlgorithmRun.setDelayTime(delay);
							delayTime.setText("DELAY TIME: " + AlgorithmRun.getDelayTime());
						}
					}
				}catch (Exception e) {
					JOptionPane.showMessageDialog(frame, "Insert a whole number");
				}
			}
		
	}
	
	private class JMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg) {
			stop.doClick();
			try {
				Thread.sleep(Integer.parseInt(AlgorithmRun.getDelayTime()) + 1);
			}catch (Exception e) {}
			String  algoName = ((JMenuItem) arg.getSource()).getText();
			AlgorithmRun = new SortRun(toSortArr, d, algoName);
			SortRun.toContinue(true);
			amountMoves.setText("SWAPS PERFORMED: " + AlgorithmRun.getMovesPerformed());
			delayTime.setText("DELAY TIME: " + AlgorithmRun.getDelayTime());
				
			sortThread = new Thread(AlgorithmRun);
			sortThread.setName("Ordenamiento");
			sortThread.start();
		}
		
	}
	
	private class StopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			SortRun.toContinue(false);
		}
		
	}  
	
	private class MixListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			amountMoves.setText("");
			delayTime.setText("");
			SortRun.toContinue(false);
			d.setArray();
			panel.paintRectangles(-1);
		}
		
	}  
	
	public class Draw extends JPanel {
		
		private static final long serialVersionUID = 2504462931000374802L;
		private int rect1 = -1, rect2 = -1;
		private String style = "Columns";
		
		public void setStyle(String s) {
			style = s;
			paintRectangles(-1);
		}
		
		public void paintRectangles(int index) {
			rect1 = index;
			rect2 = -1;
			panel.repaint();
			if (index != -1)
				amountMoves.setText("SWAPS PERFORMED: " + AlgorithmRun.getMovesPerformed());
		} 
		
		public void paintRectangles(int index1, int index2) {
			rect1 = index1;
			rect2 = index2;
			panel.repaint();
			amountMoves.setText("SWAPS PERFORMED: " + AlgorithmRun.getMovesPerformed());
		}
		
		protected void paintComponent(Graphics g) {					
			Graphics2D g2d = (Graphics2D) g;
			g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
			int rectx, recty, rectWidth, rectHeight;
			
			if (style == "Plain")
				rectWidth = frame.getWidth() / toSortArr.length;
			else 
				rectWidth = (frame.getWidth() / toSortArr.length) - 1;
			int rectxAnterior = rectWidth;
			
			for (int i = 0; i < toSortArr.length; i++) {
				rectHeight = toSortArr[i] * (frame.getHeight()/toSortArr.length);
				if (style == "Plain") {
					rectx = (i*rectWidth);
				}else {
					if (i == 0) 
						rectx = 0;
					else { 
						rectx = (rectxAnterior+rectWidth)+1;
					}
					rectxAnterior = rectx;
				}
				recty = frame.getHeight() - rectHeight;
				g2d.setColor(Color.white);
				if ((i == rect1 || i == rect2)) {
					g2d.setColor(Color.red);
				}
				g2d.fillRect(rectx, recty, rectWidth, rectHeight);
			}
			
		}
		
	}
	
}


