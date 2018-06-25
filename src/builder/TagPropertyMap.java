package builder;

import java.util.HashMap;
import java.util.Map;

/**
 * �^�O�̃v���p�e�B���i�[����N���X
 */
public class TagPropertyMap<V> {

	/** �v���p�e�B�i�[�}�b�v */
	private final Map<TagProperty, V> propertyMap = new HashMap<>();

	/**
	 * �v���p�e�B��ǉ����܂��B
	 * @param key �v���p�e�B��
	 * @param value �v���p�e�B�l
	 */
	public void put(TagProperty key, V value) {
		propertyMap.put(key, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (TagProperty key : propertyMap.keySet()) {
			sb.append(key).append("\"").append(propertyMap.get(key)).append("\" ");
		}
		return sb.toString();
	}
}