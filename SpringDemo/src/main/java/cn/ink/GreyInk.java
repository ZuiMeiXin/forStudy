package cn.ink;

import java.awt.Color;

import cn.printer.Ink;

/**
 * 灰色墨盒。GreyInk实现Ink接口。
 * 
 * @author wlg
 */
public class GreyInk implements Ink {
	// 打印采用灰色
	public String getColor(int r, int g, int b) {
		int c = (r + g + b) / 3;
		Color color = new Color(c, c, c);
		return "#" + Integer.toHexString(color.getRGB()).substring(2);
	}
}
