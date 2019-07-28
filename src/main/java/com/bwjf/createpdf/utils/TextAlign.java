package com.bwjf.createpdf.utils;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;

/**
 * @author admin
 *	文本对齐
 */
public class TextAlign {

	/**
	 * 	左对齐
	 * 
	 * SetSimpleColumn的参数是：
	 * 
	 * @param str
	 *            短语
	 * @param llx
	 *            左下角x(左)
	 * @param lly
	 *            左下角y(底部)
	 * @param urx
	 *            右上角x(右)
	 * @param ury
	 *            右上角y(上)
	 * @param font
	 *            行高(领先)
	 * @param over
	 *            对准。
	 * @throws DocumentException
	 */
	public static void setSimpleTextLeft(String str, float llx, float lly, float urx, float ury, Font font,
			PdfContentByte over) throws DocumentException {
		Phrase text = new Phrase(str, font);
		ColumnText ct = new ColumnText(over);
		ct.setSimpleColumn(text, llx, lly, urx, ury, 8.0F, 0);//0:默认左对齐	1:居中	2:右对齐
		ct.go();
	}


	/**
	 * 居中
	 * 
	 * SetSimpleColumn的参数是：
	 * 
	 * @param str
	 *            短语
	 * @param llx
	 *            左下角x(左)
	 * @param lly
	 *            左下角y(底部)
	 * @param urx
	 *            右上角x(右)
	 * @param ury
	 *            右上角y(上)
	 * @param font
	 *            行高(领先)
	 * @param over
	 *            对准。
	 * @throws DocumentException
	 */
	 public static void setSimpleTextCenter(String str, float llx, float lly, float urx, float ury, Font font,
			PdfContentByte over) throws DocumentException {
		Phrase text = new Phrase(str, font);
		ColumnText ct = new ColumnText(over);
		ct.setSimpleColumn(text, llx, lly, urx, ury, 8.0F, 1);//0:默认左对齐	1:居中	2:右对齐
		ct.go();
	}
	
	/**
	 * 右对齐
	 * 
	 * SetSimpleColumn的参数是：
	 * 
	 * @param str
	 *            短语
	 * @param llx
	 *            左下角x(左)
	 * @param lly
	 *            左下角y(底部)
	 * @param urx
	 *            右上角x(右)
	 * @param ury
	 *            右上角y(上)
	 * @param font
	 *            行高(领先)
	 * @param over
	 *            对准。
	 * @throws DocumentException
	 */
	public static void setSimpleTextRigth(String str, float llx, float lly, float urx, float ury, Font font,
			PdfContentByte over) throws DocumentException {
		Phrase text = new Phrase(str, font);
		ColumnText ct = new ColumnText(over);
		ct.setSimpleColumn(text, llx, lly, urx, ury, 8.0F, 2);//0:默认左对齐	1:居中	2:右对齐
		ct.go();
	}
	
}
