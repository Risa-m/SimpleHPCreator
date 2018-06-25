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
 * �������ʂ�HTML�̑g�ݗ��Ă��s���N���X
 */
public class HTMLCreator {
	private DataSet dataset;
	private String headerfile, footerfile;
	/**
	 * 
	 * @param headerfile�@��������HTML�t�@�C���̃w�b�_�[���
	 * @param footerfile�@��������HTML�t�@�C���̃t�b�^�[���
	 * @param dataset �������ʏ��
	 */
	public HTMLCreator(String headerfile, String footerfile, DataSet dataset) {
		this.dataset = dataset;
		this.headerfile = headerfile;
		this.footerfile = footerfile;
	}

	/**
	 * 
	 * @param dataset�@�������ʏ��
	 */
	public HTMLCreator(DataSet dataset) {
		this.dataset = dataset;
	}

	/**
	 * �������ʁi�c�̐�j��HTML�t�@�C���𐶐�����B
	 * @return HTML�������ł������ۂ�
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
				System.out.println("�������݂܂����B");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
/*		} else {
			System.out.println("�t�@�C����������܂���B");
			return false;
		}*/
	}
	/**
	 * �������ʁi�l��j��HTML�t�@�C���𐶐�����B
	 * @return HTML�t�@�C���𐶐��ł������ۂ�
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
				System.out.println("�������݂܂����B");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
	}

	/**
	 * HTML��main�����̃w�b�_�[�̐���������B
	 */
	public SimpleHtmlBuilder mainHeader() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		int thisYear = (dataset.getMonth() > 5)?dataset.getYear():dataset.getYear()-1;
        builder
            .main()
            .newline()
            	.a("../../scores/index.html").line("��������")._a()
            	.line(" &gt; ")
            	.a((thisYear - (dataset.getYear()/100)*100)+"top.html")
            	.line(thisYear+"�N�x")._a()
            	.line(" &gt; ")
            	.line("��"+dataset.getOpponent()+"���K����")
            	.newline()
            	.H2("��"+dataset.getOpponent()+"���K����")
            	.newline()
            	.H3(dataset.getYear()+"."+dataset.getMonth()+"."+dataset.getDay()+"@"+dataset.getPlace());
        return builder;
	}
	/**
	 * HTML��main�����̃t�b�^�[�̐���������B
	 */
	public SimpleHtmlBuilder mainFooter() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
		if(dataset.getFormat() != dataset.INDIVIDUAL) {
	        builder
        	.p("gameresult")
        	.line((dataset.getScoreSum1()>dataset.getScoreSum2())?"���s��w�̏���"
        			:(dataset.getScoreSum1()<dataset.getScoreSum2()?"���s��w�̕���":"��������"))
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
	 * �������ʃe�[�u���i���Z�j
	 * @return �������ʃe�[�u���i���Z�j��builder
	 */
	public SimpleHtmlBuilder createOwnTable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("scoretable")
                .newline()
                	.caption("���s��w").newline()
                	.thead().newline()
                	.tr().th("targetnum","�I").newline()
                	.th("name", "����").newline()
                	.th("year", "�w�N").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "���l��")
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
	 * �������ʃe�[�u���i�l��j
	 * @return �������ʃe�[�u���i�l��j��builder
	 */
	public SimpleHtmlBuilder createITable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("iscoretable")
                .newline()
                	.thead().newline()
                	.tr().th("name", "����").newline()
                	.th("year", "�w�N").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "���l��")
                	._tr()._thead()
                		.append(rows(dataset.getMember1()))
                	._table();
        return builder;
	}

	/**
	 * �������ʃe�[�u���̊e�s�𐶐�����B
	 * @param members �e�[�u���ɕ\��������
	 * @return ��������builder
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
	 * flag��true�̏ꍇ�A���͂��ꂽ�������Ԏ��ɕς���^�O�𐶐�����B
	 * @param flag �Ԏ��ɂ��邩�ǂ���
	 * @param s �Ԏ��ɕς��镶����
	 * @return ��������builder
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
	 * �������ʃe�[�u���i����Z�j�𐶐�����B
	 * @return �������ꂽbuilder
	 */
	public SimpleHtmlBuilder createOpponentTable() {
		SimpleHtmlBuilder builder = new SimpleHtmlBuilder();
        builder
                .table("scoretable")
                .newline()
                	.caption(dataset.getOpponent()).newline()
                	.thead().newline()
                	.tr().th("targetnum","�I").newline()
                	.th("name", "����").newline()
                	.th("year", "�w�N").newline()
                	.th("dist50", "50m").newline()
                	.th("dist30", "30m").newline()
                	.th("total", "Total").newline()
                	.th("remark", "���l��")
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
