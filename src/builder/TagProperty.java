package builder;

/**
 * �^�O�̃v���p�e�B��񋓂���N���X
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

    /** �v���p�e�B�� */
    private String propertyName;
    private TagProperty(String propertyName) {
    	this.propertyName = propertyName; 
    }
    
    @Override public String toString() {
    	return propertyName;
    }
}