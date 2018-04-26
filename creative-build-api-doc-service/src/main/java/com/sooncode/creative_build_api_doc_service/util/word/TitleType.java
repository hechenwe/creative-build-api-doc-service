package com.sooncode.creative_build_api_doc_service.util.word;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFStyle;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDecimalNumber;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTOnOff;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTString;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyle;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STStyleType;

public class TitleType {

	public static final String H1="H1";
	public static final String H2="H2";
	public static final String H3="H3";
	public static final String H4="H4";
	
	
	public static void setCustomHeadingStyle(XWPFDocument document,XWPFParagraph paragraph,String TitleType) {
		
		if(H1.equals(TitleType)) {
			setCustomHeadingStyle(document,paragraph,"标题 1",1);
			 
		}
		if(H2.equals(TitleType)) {
			setCustomHeadingStyle(document,paragraph,"标题 2",2);
			 
		}
		if(H3.equals(TitleType)) {
			setCustomHeadingStyle(document,paragraph,"标题 3",3);
			 
		}
		if(H4.equals(TitleType)) {
			setCustomHeadingStyle(document,paragraph,"标题 4",4);
			 
		}
	}
	
	
	private static void setCustomHeadingStyle(XWPFDocument docxDocument,XWPFParagraph paragraph,  String strStyleId, int headingLevel) {

        CTStyle ctStyle = CTStyle.Factory.newInstance();
        ctStyle.setStyleId(strStyleId);

        CTString styleName = CTString.Factory.newInstance();
        styleName.setVal(strStyleId);
        ctStyle.setName(styleName);

        CTDecimalNumber indentNumber = CTDecimalNumber.Factory.newInstance();
        indentNumber.setVal(BigInteger.valueOf(headingLevel));

        // lower number > style is more prominent in the formats bar
        ctStyle.setUiPriority(indentNumber);

        CTOnOff onoffnull = CTOnOff.Factory.newInstance();
        ctStyle.setUnhideWhenUsed(onoffnull);

        // style shows up in the formats bar
        ctStyle.setQFormat(onoffnull);

        // style defines a heading of the given level
        CTPPr ppr = CTPPr.Factory.newInstance();
        ppr.setOutlineLvl(indentNumber);
        ctStyle.setPPr(ppr);

        XWPFStyle style = new XWPFStyle(ctStyle);

        // is a null op if already defined
        XWPFStyles styles = docxDocument.createStyles();

        style.setType(STStyleType.PARAGRAPH);
        styles.addStyle(style);
        paragraph.setStyle(strStyleId);

    }
}
