package gallery;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * 
 * @author Risa
 * 1�̃t�H���_�̒��Ɏʐ^���܂Ƃ߁A���̃t�H���_�ɑ΂��鑊�΃p�X���R���X�g���N�^�̈����Ɏ���Ă���B<br>
 * �t�H���_���̃t�@�C�������uimages.json�v�Ƃ����t�@�C���ɗ񋓂���B<br>
 * images.json�͑Ώۃt�H���_���ɐ��������B
 *
 */
public class JsonCreator {
	/*
	public static void main(String[] args){
		new JsonCreator(args[0]);
	}
	*/
	/**
	 * �Ώۃt�H���_�ւ̑��΃p�X���󂯎��A���̃t�H���_���̃t�@�C������json�t�@�C���ɗ񋓂���B
	 * @param path ���΃p�X
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
