package construction;

import java.util.ArrayList;

/**
 * �������ʂ�HTML�t�@�C���𐶐����邽�߂ɕK�v�ȃf�[�^��ݒ肷��N���X
 * @author Risa
 *
 */
public class DataSet {
	private String opponent;
	private String date;
	private String place;
	private String event;
	private int year;
	private int month;
	private int day;
	private ArrayList<Member> members1, members2;
	public static final int BOYS = 0,
			 GIRLS = 1,
			 INDIVIDUAL = 2;
	private static int format = BOYS;

	/**
	 * �c�̐�ɕK�v�ȃf�[�^��ݒ肵�ADataSet�𐶐�����B
	 * @param date ���{��
	 * @param opponent �ΐ�Z
	 * @param place �ꏊ
	 * @param members1 ���Z�̌���
	 * @param members2 ����Z�̌���
	 */
	public DataSet(String date, String opponent, String place, ArrayList<Member> members1, ArrayList<Member> members2) {
		this.date = date;
		setDate(date);
		
		this.opponent = opponent;
		this.place = place;
		this.members1 = members1;
		this.members2 = members2;
	}
	/**
	 * �f�[�^��ݒ肹���ɐ�������B
	 */
	public DataSet() {	
	}

	/**
	 * �N������ݒ肷��B
	 * @param date ���p����8�P�^�ŕ\�����N����
	 * @return ���͂����������ǂ���
	 */
	public boolean setDate(String date) {
		if (date.length() == 8) {
			this.date = date;
			this.year = Integer.parseInt(date) / 10000;
			this.month = (Integer.parseInt(date) - this.year * 10000) / 100;
			this.day = Integer.parseInt(date) - this.year * 10000 - this.month * 100;
			return true;
		} else {
			return false;
//			System.out.println("���t���s���ł��B");
		}
	}
	/**
	 * �ΐ�Z��ݒ肷��B
	 * @param opponent �ΐ�Z��
	 */
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	/**
	 * �ꏊ��ݒ肷��B
	 * @param place �ꏊ��
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * ���Z�̎������ʂ�ݒ肷��B
	 * @param members ���Z�̎�������
	 */
	public void setMembers(ArrayList<Member> members) {
		this.members1 = members;
	}
	/**
	 * ����Z�̎������ʂ�ݒ肷��B
	 * @param members ����Z�̎�������
	 */
	public void setOpponentMembers(ArrayList<Member> members) {
		this.members2 = members;
	}
	/**
	 * ����ݒ肷��B
	 * @param event ��
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * ���Z�̓_���̘a���v�Z����B
	 * @return ���Z�̓_���̘a
	 */
	public int getScoreSum1() {
		int scoreSum = 0;
		for (int i = 0; i < members1.size(); i++) {
			if(!members1.get(i).isOpnen())scoreSum += members1.get(i).getTotalNum();
		}
		return scoreSum;
	}
	/**
	 * ����Z�̓_���̘a���v�Z����B
	 * @return ����Z�̓_���̘a
	 */
	public int getScoreSum2() {
		int scoreSum = 0;
		for (int i = 0; i < members2.size(); i++) {
			if(!members2.get(i).isOpnen())scoreSum += members2.get(i).getTotalNum();
		}
		return scoreSum;
	}
	
	/**
	 * ���{�N�������擾����B
	 * @return ���{�N����
	 */
	public String getDate() {
		return date;
	}
	/**
	 * ���{�N���擾����B
	 * @return ���{�N
	 */
	public int getYear() {
		return year;
	}
	/**
	 * ���{�����擾����B
	 * @return ���{��
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * ���{�����擾����B
	 * @return ���{��
	 */
	public int getDay() {
		return day;
	}
	/**
	 * �ΐ�Z�����擾����B
	 * @return �ΐ�Z��
	 */
	public String getOpponent() {
		return opponent;
	}
	/**
	 * �ꏊ���擾����B
	 * @return �ꏊ
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * ���Z�̎������ʂ��擾����B
	 * @return ���Z��Member���
	 */
	public ArrayList<Member> getMember1(){
		return members1;
	}
	/**
	 * �ΐ�Z�̎������ʂ��擾����B
	 * @return �ΐ�Z��Member���
	 */
	public ArrayList<Member> getMember2(){
		return members2;
	}
	/**
	 * �����擾����B
	 * @return ��
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * ��������t�@�C���̃t�H�[�}�b�g��BOYS�ɐݒ肷��B
	 */
	public static void setBoys() {
		format = BOYS;
	}
	/**
	 * ��������t�@�C���̃t�H�[�}�b�g��GIRLS�ɐݒ肷��B
	 */
	public static void setGirls() {
		format = GIRLS;
	}
	/**
	 * ��������t�@�C���̃t�H�[�}�b�g��INDIVIDUAL�ɐݒ肷��B
	 */
	public static void setIndividual() {
		format = INDIVIDUAL;
	}
	/**
	 * �ݒ肳�ꂽ�t�H�[�}�b�g���擾����B
	 * @return �ݒ肳�ꂽ�t�H�[�}�b�g
	 */
	public int getFormat() {
		return format;
	}
}
