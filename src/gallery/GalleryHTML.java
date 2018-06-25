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
 * �ʐ^�ق�HTML�t�@�C���𐶐����邽�߂̃N���X
 * @author Risa
 *
 */
public class GalleryHTML {
	
	private String folder, event, headerfile, footerfile;
	private int thisYear;
	/**
	 * HTML�t�@�C���𐶐����邽�߂ɕK�v�ȏ���ݒ肵�A�t�@�C���𐶐�����B
	 * @param folder �ʐ^���ۑ����ꂽ�t�H���_�ւ̑��΃p�X
	 * @param event �ʐ^�̃C�x���g��
	 * @param headerfile ��������HTML�t�@�C���̃w�b�_�[���
	 * @param footerfile ��������HTML�t�@�C���̃t�b�^�[���
	 * @param thisYear �ʐ^�̃C�x���g���s��ꂽ�N�x
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
	 * �ݒ肳�ꂽ��񂩂�HTML�t�@�C���𐶐�����B�������ꂽ�ꍇ��true��Ԃ��A�����ł��Ȃ������ꍇ��false��Ԃ��B
	 * @return HTML�t�@�C���������ł������ۂ�
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
			System.out.println("�������݂܂����B");
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
}
	/**
	 * HTML�t�@�C����main�̃w�b�_�[�����𐶐�����B
	 * @return �������ꂽbuilder
	 */
	public SimpleHtmlBuilder mainHeader() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
            .main()
            .newline()
            	.a("../../index.html").line("�ʐ^��")._a()
            	.line(" &gt; ")
            	.a("../"+(thisYear - (thisYear/100)*100)+"top.html")
            	.line(thisYear+"�N�x")._a()
            	.line(" &gt; ")
            	.line(event)
            	.newline()
            	.H2(event)
            	.newline();
        return builder;
	}

	
}
