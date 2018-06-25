package construction;

/**
 * �I�����ݒ肷��N���X
 * @author Risa
 *
 */
public class Member {
	private String grade;
	private String score1, score2, total;
	private String name, remark;
	private boolean open;
	/**
	 * 
	 * @param name ���O
	 * @param grade �w�N
	 * @param score1 50m
	 * @param score2 30m
	 * @param remark ���l��
	 */
	public Member(String name, String grade, String score1, String score2, String total,  String remark){
		this.name = name;
		this.grade = grade;
		this.score1 = score1;
		this.score2 = score2;
		this.total = total;
		this.remark = remark;
		if(remark.equals("�I�[�v��")) {
			open = true;
			this.remark = "";
		}
		else open = false;
	}
	/**
	 * �I��̖��O���擾����
	 * @return �I�薼
	 */
	public String getName() {
		return name;
	}
	/**
	 * �I��̊w�N���擾����B
	 * @return �w�N
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * �I��̈�ڂ̓��_���擾����B
	 * @return ��ڂ̓��_
	 */
	public String getScore1() {
		return score1;
	}
	/**
	 * �I��̈�ڂ̓��_��String����int�ɕϊ�����B
	 * @return ��ڂ̓��_
	 */
	public int getScore1Num() {
		return StringToInt(score1);
	}
	/**
	 * �I��̓�ڂ̓��_���擾����B
	 * @return ��ڂ̓��_
	 */
	public String getScore2() {
		return score2;
	}
	/**
	 * �I��̓�ڂ̓��_��String����int�ɕϊ�����B
	 * @return ��ڂ̓��_
	 */
	public int getScore2Num() {
		return StringToInt(score2);
	}
	/**
	 * �I��̍��v�_���擾����B
	 * @return ���v�_
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * �I��̍��v�_��String����int�ɕϊ�����B
	 * @return ���v�_
	 */
	public int getTotalNum() {
		return StringToInt(total);
	}
	/**
	 * ���l���擾����B
	 * @return ���l
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * ���_��String����int�ɕϊ�����B���ȐV"��",�����V"��"�̏ꍇ�͋L�����������Ă���ϊ�����B
	 * @param str�@�ϊ����镶����
	 * @return �ϊ�����
	 */
	private int StringToInt(String str) {
		try {
		if(str.charAt(str.length()-1)=='��'||str.charAt(str.length()-1)=='��') {
			return Integer.parseInt(str.substring(0, str.length()-1));
		}else {
			return Integer.parseInt(str);
		}
		}catch(Exception e) {
			return 0;
		}
	}/*
	public void setOpen() {
		open = true;
	}*/
	/**
	 * �I�肪�I�[�v���̑I��i���s�Ɋ֌W���Ȃ��I��j���ǂ������擾����B
	 * @return �I�[�v���̑I�肩�ۂ�
	 */
	public boolean isOpnen() {
		return open;
	}

}
