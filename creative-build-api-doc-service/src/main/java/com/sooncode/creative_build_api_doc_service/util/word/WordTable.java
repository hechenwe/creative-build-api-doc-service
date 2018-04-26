package com.sooncode.creative_build_api_doc_service.util.word;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTbl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;

public class WordTable {

	private XWPFDocument document;

	private XWPFTable comTable;

	private String[] titles;

	private List<String[]> lines = new LinkedList<>();

	public void setDocument(XWPFDocument document) {
		this.document = document;
		this.setTableTitl();
		this.addTableLines();

	}

	public WordTable setTableTitl(String[] texts) {
		this.titles = texts;
		return this;
	}

	private static void setCellText(XWPFTableCell cell, String text) {
		CTP ctp = CTP.Factory.newInstance();
		XWPFParagraph p = new XWPFParagraph(ctp, cell);
		p.setAlignment(ParagraphAlignment.CENTER);
		// p.setIndentationFirstLine(2*567);
		XWPFRun run = p.createRun();
		run.setColor("7A7878");
		run.setFontSize(5);
		run.setText(text);
		setFonts(run, "微软雅黑");
		cell.setParagraph(p);
	}

	private static void setFonts(XWPFRun run, String fontsName) {
		CTRPr rpr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run.getCTR().addNewRPr();
		CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii(fontsName);
		fonts.setEastAsia(fontsName);
		fonts.setHAnsi(fontsName);
	}

	private void setTableTitl() {

		if (this.titles == null || this.titles.length <= 0) {
			return;
		}
		comTable = document.createTable();
		setTableWidth(comTable, (7730) + "");

		// 列宽自动分割
		/*
		 * CTTblWidth comTableWidth = comTable.getCTTbl().addNewTblPr().addNewTblW();
		 * comTableWidth.setType(STTblWidth.DXA);
		 * comTableWidth.setW(BigInteger.valueOf(9072));
		 */

		XWPFTableRow comTableRowOne = comTable.getRow(0);

		setCellText(comTableRowOne.getCell(0), this.titles[0]);

		for (int i = 1; i < this.titles.length; i++) {
			setCellText(comTableRowOne.addNewTableCell(), this.titles[i]);
		}

	}

	public WordTable addTableLine(String[] texts) {

		this.lines.add(texts);
		return this;

	}

	private void addTableLines() {

		for (String[] texts : lines) {
			XWPFTableRow comTableRowTwo = comTable.createRow();
			for (int i = 0; i < texts.length; i++) {
				setCellText(comTableRowTwo.getCell(i), texts[i]);
			}

		}

	}

	public static void setTableWidth(XWPFTable table, String width) {
		CTTbl ttbl = table.getCTTbl();
		CTTblPr tblPr = ttbl.getTblPr() == null ? ttbl.addNewTblPr() : ttbl.getTblPr();
		CTTblWidth tblWidth = tblPr.isSetTblW() ? tblPr.getTblW() : tblPr.addNewTblW();
		CTJc cTJc = tblPr.addNewJc();
		cTJc.setVal(STJc.Enum.forString("right"));
		 
		tblWidth.setW(new BigInteger(width));
		tblWidth.setType(STTblWidth.DXA);
	}

}
