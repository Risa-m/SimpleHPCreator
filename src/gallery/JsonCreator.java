package gallery;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 * @author Risa
 * 1つのフォルダの中に写真をまとめ、そのフォルダに対する相対パスをコンストラクタの引数に取っている。<br>
 * フォルダ内のファイル名を「images.json」というファイルに列挙する。<br>
 * images.jsonは対象フォルダ中に生成される。
 *
 */
public class JsonCreator {
	/*
	public static void main(String[] args){
		new JsonCreator(args[0]);
	}
	*/
	/**
	 * 対象フォルダへの相対パスを受け取り、そのフォルダ内のファイル名をjsonファイルに列挙する。
	 * @param path 相対パス
	 */
	public JsonCreator(String path) {
		try{
		String str = path;
		File cdir = new File(str);
		
		String[] filelist = cdir.list();
		
		File file = new File(str + "/images.json");
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));

		pw.println("[");
		for (int i = 0; i < filelist.length; i++) {
//			pw.println("{");
//			pw.println("\"image\": \""+ filelist[i] +"\"");
			if(!(filelist[i].equals("images.json")||filelist[i].equals("index.html"))){
				pw.println("\""+filelist[i]+"\"");
				if(i!=filelist.length-1)pw.println(",");
				else pw.println("");
			}
		}
		pw.println("]");
		pw.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
