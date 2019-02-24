package builder;

/**
 * タグのプロパティを列挙するクラス
 */
public enum TagProperty {
    /** border */
    BORDER("border="),
    /** charset */
    CHARSET("charset="),
    /** href */
    HREF("href="),
    /** href */
    ALIGN("align="),
    /** charset */
    COLSPAN("colspan="),
	/**	class */
	CLASS("class="),
	/**	id */
	ID("id=");

    /** プロパティ名 */
    private String propertyName;
    private TagProperty(String propertyName) {
    	this.propertyName = propertyName;
    }

    @Override public String toString() {
    	return propertyName;
    }
}
