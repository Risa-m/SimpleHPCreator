package construction;

/**
 * 選手情報を設定するクラス
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
	 * @param name 名前
	 * @param grade 学年
	 * @param score1 50m
	 * @param score2 30m
	 * @param remark 備考等
	 */
	public Member(String name, String grade, String score1, String score2, String total,  String remark){
		this.name = name;
		this.grade = grade;
		this.score1 = score1;
		this.score2 = score2;
		this.total = total;
		this.remark = remark;
		if(remark.equals("オープン")) {
			open = true;
			this.remark = "";
		}
		else open = false;
	}
	/**
	 * 選手の名前を取得する
	 * @return 選手名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 選手の学年を取得する。
	 * @return 学年
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * 選手の一つ目の得点を取得する。
	 * @return 一つ目の得点
	 */
	public String getScore1() {
		return score1;
	}
	/**
	 * 選手の一つ目の得点をStringからintに変換する。
	 * @return 一つ目の得点
	 */
	public int getScore1Num() {
		return StringToInt(score1);
	}
	/**
	 * 選手の二つ目の得点を取得する。
	 * @return 二つ目の得点
	 */
	public String getScore2() {
		return score2;
	}
	/**
	 * 選手の二つ目の得点をStringからintに変換する。
	 * @return 二つ目の得点
	 */
	public int getScore2Num() {
		return StringToInt(score2);
	}
	/**
	 * 選手の合計点を取得する。
	 * @return 合計点
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * 選手の合計点をStringからintに変換する。
	 * @return 合計点
	 */
	public int getTotalNum() {
		return StringToInt(total);
	}
	/**
	 * 備考を取得する。
	 * @return 備考
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 得点をStringからintに変換する。自己新"☆",試合新"★"の場合は記号を消去してから変換する。
	 * @param str　変換する文字列
	 * @return 変換結果
	 */
	private int StringToInt(String str) {
		try {
		if(str.charAt(str.length()-1)=='☆'||str.charAt(str.length()-1)=='★') {
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
	 * 選手がオープンの選手（勝敗に関係しない選手）かどうかを取得する。
	 * @return オープンの選手か否か
	 */
	public boolean isOpnen() {
		return open;
	}

}
