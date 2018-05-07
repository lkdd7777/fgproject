/*     */ package test;
/*     */ 
/*     */ import java.io.FileOutputStream;
/*     */ import org.apache.poi.xwpf.usermodel.Borders;
/*     */ import org.apache.poi.xwpf.usermodel.BreakClear;
/*     */ import org.apache.poi.xwpf.usermodel.BreakType;
/*     */ import org.apache.poi.xwpf.usermodel.LineSpacingRule;
/*     */ import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
/*     */ import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
/*     */ import org.apache.poi.xwpf.usermodel.VerticalAlign;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFDocument;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFParagraph;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFRun;
/*     */ 
/*     */ public class Word
/*     */ {
/*     */   public static void main(String[] args) throws Exception
/*     */   {
/*  19 */     XWPFDocument doc = new XWPFDocument();
/*     */     
/*  21 */     XWPFParagraph p1 = doc.createParagraph();
/*  22 */     p1.setAlignment(ParagraphAlignment.CENTER);
/*  23 */     p1.setBorderBottom(Borders.DOUBLE);
/*  24 */     p1.setBorderTop(Borders.DOUBLE);
/*     */     
/*  26 */     p1.setBorderRight(Borders.DOUBLE);
/*  27 */     p1.setBorderLeft(Borders.DOUBLE);
/*  28 */     p1.setBorderBetween(Borders.SINGLE);
/*     */     
/*  30 */     p1.setVerticalAlignment(org.apache.poi.xwpf.usermodel.TextAlignment.TOP);
/*     */     
/*  32 */     XWPFRun r1 = p1.createRun();
/*  33 */     r1.setBold(true);
/*  34 */     r1.setText("The quick brown fox");
/*  35 */     r1.setBold(true);
/*  36 */     r1.setFontFamily("Courier");
/*  37 */     r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
/*  38 */     r1.setTextPosition(100);
/*     */     
/*  40 */     XWPFParagraph p2 = doc.createParagraph();
/*  41 */     p2.setAlignment(ParagraphAlignment.RIGHT);
/*     */     
/*     */ 
/*  44 */     p2.setBorderBottom(Borders.DOUBLE);
/*  45 */     p2.setBorderTop(Borders.DOUBLE);
/*  46 */     p2.setBorderRight(Borders.DOUBLE);
/*  47 */     p2.setBorderLeft(Borders.DOUBLE);
/*  48 */     p2.setBorderBetween(Borders.SINGLE);
/*     */     
/*  50 */     XWPFRun r2 = p2.createRun();
/*  51 */     r2.setText("jumped over the lazy dog");
/*  52 */     r2.setStrike(true);
/*  53 */     r2.setFontSize(20);
/*     */     
/*  55 */     XWPFRun r3 = p2.createRun();
/*  56 */     r3.setText("and went away");
/*  57 */     r3.setStrike(true);
/*  58 */     r3.setFontSize(20);
/*  59 */     r3.setSubscript(VerticalAlign.SUPERSCRIPT);
/*     */     
/*     */ 
/*  62 */     XWPFParagraph p3 = doc.createParagraph();
/*  63 */     p3.setWordWrap(true);
/*  64 */     p3.setPageBreak(true);
/*     */     
/*     */ 
/*  67 */     p3.setAlignment(ParagraphAlignment.LEFT);
/*  68 */     p3.setSpacingLineRule(LineSpacingRule.EXACT);
/*     */     
/*  70 */     p3.setIndentationFirstLine(600);
/*     */     
/*     */ 
/*  73 */     XWPFRun r4 = p3.createRun();
/*  74 */     r4.setTextPosition(20);
/*  75 */     r4.setText("To be, or not to be: that is the question: Whether 'tis nobler in the mind to suffer The slings and arrows of outrageous fortune, Or to take arms against a sea of troubles, And by opposing end them? To die: to sleep; ");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  80 */     r4.addBreak(BreakType.PAGE);
/*  81 */     r4.setText("No more; and by a sleep to say we end The heart-ache and the thousand natural shocks That flesh is heir to, 'tis a consummation Devoutly to be wish'd. To die, to sleep; To sleep: perchance to dream: ay, there's the rub; .......");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  87 */     r4.setItalic(true);
/*     */     
/*     */ 
/*  90 */     XWPFRun r5 = p3.createRun();
/*  91 */     r5.setTextPosition(-10);
/*  92 */     r5.setText("For in that sleep of death what dreams may come");
/*  93 */     r5.addCarriageReturn();
/*  94 */     r5.setText("When we have shuffled off this mortal coil,Must give us pause: there's the respectThat makes calamity of so long life;");
/*     */     
/*     */ 
/*  97 */     r5.addBreak();
/*  98 */     r5.setText("For who would bear the whips and scorns of time,The oppressor's wrong, the proud man's contumely,");
/*     */     
/*     */ 
/* 101 */     r5.addBreak(BreakClear.ALL);
/* 102 */     r5.setText("The pangs of despised love, the law's delay,The insolence of office and the spurns.......");
/*     */     
/*     */ 
/* 105 */     FileOutputStream out = new FileOutputStream("G://simple.docx");
/* 106 */     doc.write(out);
/* 107 */     out.close();
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\test\Word.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */