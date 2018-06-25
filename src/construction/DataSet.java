package construction;

import java.util.ArrayList;

/**
 * 試合結果のHTMLファイルを生成するために必要なデータを設定するクラス
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
	 * 団体戦に必要なデータを設定し、DataSetを生成する。
	 * @param date 実施日
	 * @param opponent 対戦校
	 * @param place 場所
	 * @param members1 自校の結果
	 * @param members2 相手校の結果
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
	 * データを設定せずに生成する。
	 */
	public DataSet() {	
	}

	/**
	 * 年月日を設定する。
	 * @param date 半角数字8ケタで表される年月日
	 * @return 入力が正しいかどうか
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
//			System.out.println("日付が不正です。");
		}
	}
	/**
	 * 対戦校を設定する。
	 * @param opponent 対戦校名
	 */
	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}
	/**
	 * 場所を設定する。
	 * @param place 場所名
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	/**
	 * 自校の試合結果を設定する。
	 * @param members 自校の試合結果
	 */
	public void setMembers(ArrayList<Member> members) {
		this.members1 = members;
	}
	/**
	 * 相手校の試合結果を設定する。
	 * @param members 相手校の試合結果
	 */
	public void setOpponentMembers(ArrayList<Member> members) {
		this.members2 = members;
	}
	/**
	 * 大会名を設定する。
	 * @param event 大会名
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	/**
	 * 自校の点数の和を計算する。
	 * @return 自校の点数の和
	 */
	public int getScoreSum1() {
		int scoreSum = 0;
		for (int i = 0; i < members1.size(); i++) {
			if(!members1.get(i).isOpnen())scoreSum += members1.get(i).getTotalNum();
		}
		return scoreSum;
	}
	/**
	 * 相手校の点数の和を計算する。
	 * @return 相手校の点数の和
	 */
	public int getScoreSum2() {
		int scoreSum = 0;
		for (int i = 0; i < members2.size(); i++) {
			if(!members2.get(i).isOpnen())scoreSum += members2.get(i).getTotalNum();
		}
		return scoreSum;
	}
	
	/**
	 * 実施年月日を取得する。
	 * @return 実施年月日
	 */
	public String getDate() {
		return date;
	}
	/**
	 * 実施年を取得する。
	 * @return 実施年
	 */
	public int getYear() {
		return year;
	}
	/**
	 * 実施月を取得する。
	 * @return 実施月
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * 実施日を取得する。
	 * @return 実施日
	 */
	public int getDay() {
		return day;
	}
	/**
	 * 対戦校名を取得する。
	 * @return 対戦校名
	 */
	public String getOpponent() {
		return opponent;
	}
	/**
	 * 場所を取得する。
	 * @return 場所
	 */
	public String getPlace() {
		return place;
	}
	/**
	 * 自校の試合結果を取得する。
	 * @return 自校のMember情報
	 */
	public ArrayList<Member> getMember1(){
		return members1;
	}
	/**
	 * 対戦校の試合結果を取得する。
	 * @return 対戦校のMember情報
	 */
	public ArrayList<Member> getMember2(){
		return members2;
	}
	/**
	 * 大会名を取得する。
	 * @return 大会名
	 */
	public String getEvent() {
		return event;
	}
	/**
	 * 生成するファイルのフォーマットをBOYSに設定する。
	 */
	public static void setBoys() {
		format = BOYS;
	}
	/**
	 * 生成するファイルのフォーマットをGIRLSに設定する。
	 */
	public static void setGirls() {
		format = GIRLS;
	}
	/**
	 * 生成するファイルのフォーマットをINDIVIDUALに設定する。
	 */
	public static void setIndividual() {
		format = INDIVIDUAL;
	}
	/**
	 * 設定されたフォーマットを取得する。
	 * @return 設定されたフォーマット
	 */
	public int getFormat() {
		return format;
	}
}
