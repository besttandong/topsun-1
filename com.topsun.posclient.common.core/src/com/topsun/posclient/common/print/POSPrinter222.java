package com.topsun.posclient.common.print;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.printing.PrintDialog;
import org.eclipse.swt.printing.Printer;
import org.eclipse.swt.printing.PrinterData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.topsun.posclient.common.ProjectUtil;
import com.topsun.posclient.datamodel.Item;
import com.topsun.posclient.datamodel.Receipts;

/**
 * POS小票打印
 * 
 * @author Dong
 *
 */
public class POSPrinter222 {

	private Receipts receipts;

	public POSPrinter222(Receipts receipts) {
		this.receipts = receipts;
	}

	public final Receipts getReceipts() {
		return receipts;
	}
	
	private String getPrintContent(){
		StringBuffer buffer = new StringBuffer();
		buffer.append(receipts.getTitle()+"\n");
		buffer.append("电话："+receipts.getTelephone()+"\n");
		buffer.append("地址："+receipts.getAddress()+"\n");
		buffer.append("收银员："+receipts.getCashier()+"\n");
		buffer.append("日期："+ProjectUtil.getDateString(receipts.getDate())+"\t序"+String.valueOf(System.currentTimeMillis()).substring(8)+"\n");
		buffer.append("--------------------------------------------\n");
		for(Item item : receipts.getItems()){
			buffer.append(item.getItemName()+"\t"+item.getRetailPrice()+"X"+item.getNum()+"\t"+item.getRetailPrice()*item.getNum()+"\n");
		}
		buffer.append("--------------------------------------------\n");
		buffer.append("加盟热线："+receipts.getBootString()+"\n");
		buffer.append("网址："+receipts.getNetAddress()+"\n");
		buffer.append("欢迎您的再次光顾\n");
		return buffer.toString();
	}

	public void printReceipts() {
		final Display display = Display.getDefault();
		final Shell shell = new Shell();

		// 用打印对话框取得一个打印对话printer
		PrintDialog printDlg = new PrintDialog(shell);
		PrinterData printerData = printDlg.open();
		if (printerData != null) {
			Printer printer = new Printer(printerData);
			// 打印文件
			try {
				String contents = getPrintContent();// 取出文件内容
				MyPrinter p = new MyPrinter(printer, contents);
				p.print();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
			printer.dispose();// printer对象没用后要手动dispose掉
		}
		display.dispose();
	}

	/**
	 * 自定义的打印实现类，将所需参数传入，调用print方法即可打印
	 */
	private class MyPrinter {
		private Printer printer; // 打印对象

		private String contents; // 文件名对应的文件内容

		private GC gc; // 一个GC对象

		private int xPos, yPos; // 打印对象printer用的坐标

		private Rectangle bounds; // 打印空间

		private StringBuffer buf; // Holds a word at a time

		private int lineHeight; // The height of a line of text
		
		private int colWidth = 20; //第一列宽度

		/**
		 * 构造函数
		 */
		public MyPrinter(Printer printer, String contents) {
			this.printer = printer;
			this.contents = contents;
		}

		/**
		 * 打印文件的方法
		 */
		public void print() {
			if (printer.startJob("POSPrint")) {// 开始打印任务
				// 设定打印空间
				bounds = computePrintArea(printer);
				xPos = bounds.x;
				yPos = bounds.y;
				// 创建GC对象
				gc = new GC(printer);
				// 设定线的高度
				lineHeight = gc.getFontMetrics().getHeight();
				// 设定tab键的空格数
				int tabWidth = gc.stringExtent(" ").x;
				// 开始打印
				printer.startPage();
				buf = new StringBuffer();
				char c;
				for (int i = 0, n = contents.length(); i < n; i++) {
					// 得到文件内容的字符
					c = contents.charAt(i);
					// 如果读到\n，调用printBuffer方法将buf中的字符打印，并换行
					if (c == '\n') {
						printBuffer();
						printNewline();
					}
					// 如果读到\t，表示要跳过一定的空格
					else if (c == '\t') {
						// 检查是否有空间，如果则打印
						if (Character.isWhitespace(c)) {
							xPos += colWidth;
							gc.drawString(buf.toString(), xPos, yPos, false);
							buf.setLength(0);
						}
					} else {
						buf.append(c);// 将字符添加进buf变量
						// 检查是否有空间，如果则打印
						if (Character.isWhitespace(c))
							printBuffer();

					}
				}
				printer.endPage();
				printer.endJob();
				gc.dispose();
			}
		}

		/**
		 * 打印缓存buf变量中的字符
		 */
		private void printBuffer() {
			// 取得缓存中的字符宽度
			int width = gc.stringExtent(buf.toString()).x;
//			if(width > colWidth){
//				colWidth = width;
//			}
			// 如果宽度不够，则换行
			if (xPos + width > bounds.x + bounds.width)
				printNewline();
			// 打印缓存buf变量中的字符
			gc.drawString(buf.toString(), xPos, yPos, false);
			xPos += width;
			buf.setLength(0);
		}

		/**
		 * 打印换行的方法
		 */
		private void printNewline() {
			// 重设新行的坐标
			xPos = bounds.x;
			yPos += lineHeight;
			// 如果超过页长度，则换一页打印
			if (yPos > bounds.y + bounds.height) {
				yPos = bounds.y;
				printer.endPage();
				printer.startPage();
			}
		}

		/**
		 * 计算打印空间的方法
		 */
		private Rectangle computePrintArea(Printer printer) {
			// 取得打印空间
			Rectangle rect = printer.getClientArea();
			Rectangle trim = printer.computeTrim(10, 10, 10, 10);
			// 取得打印机的DPI（DPI：表示每英寸的点数,即通常说的打印机的分辨率）
			Point dpi = printer.getDPI();
			// 计算可打印空间
			int left = trim.x + dpi.x;
			if (left < rect.x)
				left = rect.x;
			int right = (rect.width + trim.x + trim.width) - dpi.x;
			if (right > rect.width)
				right = rect.width;
			int top = trim.y + dpi.y;
			if (top < rect.y)
				top = rect.y;
			int bottom = (rect.height + trim.y + trim.height) - dpi.y;
			if (bottom > rect.height)
				bottom = rect.height;
			return new Rectangle(left, top, right - left, bottom - top);
		}
	}
	
	public static void main(String[] args){
		Item item1 = new Item();
		item1.setItemName("秘制小龙虾");
		item1.setRetailPrice(30.5);
		item1.setNum(2);
		
		Item item2 = new Item();
		item2.setItemName("小笼包");
		item2.setRetailPrice(20.5);
		item2.setNum(2);
		
		Item item3 = new Item();
		item3.setItemName("清风原木纯品");
		item3.setRetailPrice(20.5);
		item3.setNum(1);
		
		Item item4 = new Item();
		item4.setItemName("洁云抽取式面纸原木纯朴");
		item4.setRetailPrice(20.5);
		item4.setNum(2);
		
		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
		
		Receipts receipts = new Receipts();
		receipts.setTitle("城隍庙豫园小吃");
		receipts.setTelephone("021-23456789");
		receipts.setAddress("上海市豫园");
		receipts.setCashier("张三");
		receipts.setDate(new Date());
		receipts.setItems(items);
		receipts.setBootString("021-678987888");
		receipts.setNetAddress("www.yuyuan.com");
		
		POSPrinter222 printer = new POSPrinter222(receipts);
		printer.printReceipts();
	}
}
