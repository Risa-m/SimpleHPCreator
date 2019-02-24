package builder;

import java.util.HashMap;
import java.util.Map;

	/** プロパティ格納マップ */
	private final Map<TagProperty, V> propertyMap = new HashMap<>();

	/**
	 * プロパティを追加します。
	 * @param key プロパティ名
	 * @param value プロパティ値
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
