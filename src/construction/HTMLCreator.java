package construction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import builder.SimpleHtmlBuilder;

/**
 *
 * @author Risa
 * 試合結果のHTMLの組み立てを行うクラス
 */
public class HTMLCreator {
	private DataSet dataset;
	private String headerfile, footerfile;
	/**
	 *
	 * @param headerfile　生成するHTMLファイルのヘッダー情報
	 * @param footerfile　生成するHTMLファイルのフッター情報
	 * @param dataset 試合結果情報
	 */
	public HTMLCreator(String headerfile, String footerfile, DataSet dataset) {
		this.dataset = dataset;
		this.headerfile = headerfile;
		this.footerfile = footerfile;
	}

	/**
	 *
	 * @param dataset　試合結果情報
	 */
	public HTMLCreator(DataSet dataset) {
		this.dataset = dataset;
	}

	/**
	 * 試合結果（団体戦）のHTMLファイルを生成する。
	 * @return HTMLが生成できたか否か
	 */
	public boolean create() {
		File outFile = new File(dataset.getDate()+((dataset.getFormat()==dataset.BOYS)?"m":(dataset.getFormat()==dataset.GIRLS)?"w":"")+".html");
//		File header = new File(headerfile);
//		File footer = new File(footerfile);
//		System.out.println(getClass().getClassLoader().getResource(headerfile));
		InputStream headis = getClass().getClassLoader().getResourceAsStream(headerfile);
		InputStream footis = getClass().getClassLoader().getResourceAsStream(footerfile);
//		File header = new File(getClass().getClassLoader().getResource(headerfile).toString());
//		File footer = new File(getClass().getClassLoader().getResource(footerfile).toString());
//		if (checkFileExist(header) && checkFileExist(footer)) {
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
				BufferedReader headbr = new BufferedReader((new InputStreamReader(headis,"UTF-8")));
				BufferedReader footbr = new BufferedReader((new InputStreamReader(footis,"UTF-8")));
//				BufferedReader footbr = new BufferedReader((new InputStreamReader(new FileInputStream(footer),"UTF-8")));

				String str;
				while ((str = headbr.readLine()) != null) {
					bw.write(str);
					bw.newLine();
				}

				bw.write(mainHeader().toString());
				bw.newLine();
				bw.write(createOwnTable().toString());
				bw.newLine();
				bw.write(createOpponentTable().toString());
				bw.newLine();
				bw.write(mainFooter().toString());

				while ((str = footbr.readLine()) != null) {
					bw.write(str);
					bw.newLine();
				}
				bw.close();
				headbr.close();
				footbr.close();
				System.out.println("書き込みました。");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
/*		} else {
			System.out.println("ファイルが見つかりません。");
			return false;
		}*/
	}
	/**
	 * 試合結果（個人戦）のHTMLファイルを生成する。
	 * @return HTMLファイルを生成できたか否か
	 */
	public boolean createi() {
		File outFile = new File(dataset.getDate()+"i.html");
		InputStream headis = getClass().getClassLoader().getResourceAsStream(headerfile);
		InputStream footis = getClass().getClassLoader().getResourceAsStream(footerfile);
			try {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
				BufferedReader headbr = new BufferedReader((new InputStreamReader(headis,"UTF-8")));
				BufferedReader footbr = new BufferedReader((new InputStreamReader(footis,"UTF-8")));

				String str;
				while ((str = headbr.readLine()) != null) {
					bw.write(str);
					bw.newLine();
				}

				bw.write(mainHeader().toString());
				bw.newLine();
				bw.write(createITable().toString());
				bw.newLine();
				bw.write(mainFooter().toString());

				while ((str = footbr.readLine()) != null) {
					bw.write(str);
					bw.newLine();
				}
				bw.close();
				headbr.close();
				footbr.close();
				System.out.println("書き込みました。");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
	}

	/**
	 * HTMLのmain部分のヘッダーの生成をする。
	 */
	public SimpleHtmlBuilder mainHeader() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		int thisYear = (dataset.getMonth() > 5)?dataset.getYear():dataset.getYear()-1;
        builder
            .main()
            .newline()
            	.a("../../scores/index.html").line("試合結果")._a()
            	.line(" &gt; ")
            	.a((thisYear - (dataset.getYear()/100)*100)+"top.html")
            	.line(thisYear+"年度")._a()
            	.line(" &gt; ")
            	.line("対"+dataset.getOpponent()+"練習試合")
            	.newline()
            	.H2("対"+dataset.getOpponent()+"練習試合")
            	.newline()
            	.H3(dataset.getYear()+"."+dataset.getMonth()+"."+dataset.getDay()+"@"+dataset.getPlace());
        return builder;
	}
	/**
	 * HTMLのmain部分のフッターの生成をする。
	 */
	public SimpleHtmlBuilder mainFooter() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		if(dataset.getFormat() != dataset.INDIVIDUAL) {
	        builder
        	.p("gameresult")
        	.line((dataset.getScoreSum1()>dataset.getScoreSum2())?"京都大学の勝ち"
        			:(dataset.getScoreSum1()<dataset.getScoreSum2()?"京都大学の負け":"引き分け"))
        	._p().newline();
		}
	        builder
        	.div("right")
        	.a("totop", "#page")
        	.line("PAGE TOP")
        	._a()
        	._div()
        	._main();
        return builder;
	}
	/**
	 * 試合結果テーブル（自校）
	 * @return 試合結果テーブル（自校）のbuilder
	 */
	public SimpleHtmlBuilder createOwnTable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("scoretable")
                .newline()
                	.caption("京都大学").newline()
                	.thead().newline()
                	.tr().th("targetnum","的").newline()
                	.th("name", "氏名").newline()
                	.th("year", "学年").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "備考等")
                	._tr()._thead()
                		.append(rows(dataset.getMember1()))
                	.tfoot()
                	.tr().th(5).line((dataset.getFormat()==DataSet.BOYS)?"eight":"five")._th()
                	.th(2).line(dataset.getScoreSum1()+"")._th()._tr()._tfoot()
                	.newline()
                	._table();
        return builder;
	}

	/**
	 * 試合結果テーブル（個人戦）
	 * @return 試合結果テーブル（個人戦）のbuilder
	 */
	public SimpleHtmlBuilder createITable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("iscoretable")
                .newline()
                	.thead().newline()
                	.tr().th("name", "氏名").newline()
                	.th("year", "学年").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "備考等")
                	._tr()._thead()
                		.append(rows(dataset.getMember1()))
                	._table();
        return builder;
	}

	/**
	 * 試合結果テーブルの各行を生成する。
	 * @param members テーブルに表示する情報
	 * @return 生成したbuilder
	 */
	public SimpleHtmlBuilder rows(ArrayList<Member> members) {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		for (int i = 0; i < members.size(); i++) {
			builder.tr().newline();
//					.td(members.get(i).isOpnen()?("&#"+(9312+i)+";"):(i+1 + "")).newline()
			if(dataset.getFormat() != dataset.INDIVIDUAL) {
				builder.td(members.get(i).isOpnen()?("&#"+(9312+i)+";"):(i+1 + "")).newline();
			}
			builder
					.td(members.get(i).getName()).newline()
					.td(members.get(i).getGrade() + "").newline()
					.td()
					.append(redMark(members.get(i).getScore1Num()>=270, members.get(i).getScore1()+""))
					._td().newline()
					.td()
					.append(redMark(members.get(i).getScore2Num()>=330, members.get(i).getScore2()+""))
					._td().newline()
					.td()
					.append(redMark(members.get(i).getTotalNum()>=600, members.get(i).getTotal()+""))
					._td().newline()
					.td(members.get(i).getRemark()).newline()
					._tr().newline();
		}
		return builder;
	}
	/**
	 * flagがtrueの場合、入力された文字列を赤字に変えるタグを生成する。
	 * @param flag 赤字にするかどうか
	 * @param s 赤字に変える文字列
	 * @return 生成したbuilder
	 */
	public SimpleHtmlBuilder redMark(boolean flag, String s) {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		if(flag) {
			builder
				.span("red")
				.line(s)
				._span();
		}else {
			builder.line(s);
		}
		return builder;
	}

	/**
	 * 試合結果テーブル（相手校）を生成する。
	 * @return 生成されたbuilder
	 */
	public SimpleHtmlBuilder createOpponentTable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("scoretable")
                .newline()
                	.caption(dataset.getOpponent()).newline()
                	.thead().newline()
                	.tr().th("targetnum","的").newline()
                	.th("name", "氏名").newline()
                	.th("year", "学年").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "備考等")
                	._tr()._thead()
                		.append(rows(dataset.getMember2()))
                	.tfoot()
                	.tr().th(5).line((dataset.getFormat()==DataSet.BOYS)?"eight":"five")._th()
                	.th(2).line(dataset.getScoreSum2()+"")._th()._tr()._tfoot().newline()
                	._table();
        return builder;
	}
/*
	private static boolean checkFileExist(File file) {
		if (file.exists()) {
			if (file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}
	*/
}
