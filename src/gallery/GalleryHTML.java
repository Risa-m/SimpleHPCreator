package gallery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import builder.SimpleHtmlBuilder;

/**
 * 写真館のHTMLファイルを生成するためのクラス
 * @author Risa
 *
 */
public class GalleryHTML {
	
	private String folder, event, headerfile, footerfile;
	private int thisYear;
	/**
	 * HTMLファイルを生成するために必要な情報を設定し、ファイルを生成する。
	 * @param folder 写真が保存されたフォルダへの相対パス
	 * @param event 写真のイベント名
	 * @param headerfile 生成するHTMLファイルのヘッダー情報
	 * @param footerfile 生成するHTMLファイルのフッター情報
	 * @param thisYear 写真のイベントが行われた年度
	 */
	public GalleryHTML(String folder, String event,String headerfile, String footerfile, int thisYear) {
		this.folder = folder;
		this.event = event;
		this.headerfile = headerfile;
		this.footerfile = footerfile;
		this.thisYear = thisYear;
		create();
	}

	/**
	 * 設定された情報からHTMLファイルを生成する。生成された場合はtrueを返し、生成できなかった場合はfalseを返す。
	 * @return HTMLファイルが生成できたか否か
	 */
	public boolean create() {
		File outFile = new File(folder + "/index.html");
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
	 * HTMLファイルのmainのヘッダー部分を生成する。
	 * @return 生成されたbuilder
	 */
	public SimpleHtmlBuilder mainHeader() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
            .main()
            .newline()
            	.a("../../index.html").line("写真館")._a()
            	.line(" &gt; ")
            	.a("../"+(thisYear - (thisYear/100)*100)+"top.html")
            	.line(thisYear+"年度")._a()
            	.line(" &gt; ")
            	.line(event)
            	.newline()
            	.H2(event)
            	.newline();
        return builder;
	}

	
}
