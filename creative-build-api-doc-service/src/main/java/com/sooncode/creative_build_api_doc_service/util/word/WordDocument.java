package com.sooncode.creative_build_api_doc_service.util.word;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTFonts;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

 

public class WordDocument {

	private XWPFDocument document = new XWPFDocument();

	public XWPFDocument getDocument() {
		return document;
	}

	public WordDocument setTitle(String text, String color, int fontSize) {

		XWPFParagraph titleParagraph = document.createParagraph();
		// 设置段落居中
		titleParagraph.setAlignment(ParagraphAlignment.CENTER);

		XWPFRun titleParagraphRun = titleParagraph.createRun();
		titleParagraphRun.setText(text);
		titleParagraphRun.setColor(color);
		titleParagraphRun.setFontSize(fontSize);
		setFonts(titleParagraphRun,"微软雅黑");
		return this;

	}

	public WordDocument addParagraph(String text, String color, int fontSize, ParagraphAlignment paragraphAlignment,String titleType,int tabSize) {

		// 段落
		XWPFParagraph paragraph = document.createParagraph();
		 
		TitleType.setCustomHeadingStyle(document, paragraph, titleType); 
		paragraph.setAlignment(paragraphAlignment);// 水平位置
		
		paragraph.setIndentationFirstLine(tabSize*567);
	 
		
		XWPFRun run = paragraph.createRun();
		run.setText(text);
		run.setColor(color);
		run.setFontSize(fontSize);
		setFonts(run,"微软雅黑");

		// 设置段落背景颜色
		// CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
		// cTShd.setVal(STShd.CLEAR);
		// cTShd.setFill("97FFFF");

		return this;
	}

	public WordDocument addLine() {
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun paragraphRun = paragraph.createRun();
		paragraphRun.setText("\r");
		return this;
	}

	public WordDocument addWordTable(WordTable wordTable) {

		wordTable.setDocument(this.document);
		return this;

	}
	
	
	
	
	

	/**
	 * 输出文件
	 * 
	 * @param filePath
	 */
	public void output(String filePath) {
		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			document.write(out);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void setFonts(XWPFRun run,String fontsName) {
		CTRPr rpr = run.getCTR().isSetRPr() ? run.getCTR().getRPr() : run.getCTR().addNewRPr();
		CTFonts fonts = rpr.isSetRFonts() ? rpr.getRFonts() : rpr.addNewRFonts();
		fonts.setAscii(fontsName);
		fonts.setEastAsia(fontsName);
		fonts.setHAnsi(fontsName);
	}

}
