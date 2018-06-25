package builder;

/**
 * �^�O�̎�ނ��i�[����񋓌^
 */
public enum TagType {
	/** {@code <html>�^�O} */
	HTML("<html>"),
	/** {@code </html>�^�O} */
	_HTML("</html>"),
	/** {@code <main>�^�O} */
	MAIN("<main>"),
	/** {@code </main>�^�O} */
	_MAIN("</main>"),
	/** {@code <div>�^�O} */
	DIV("<div>"),
	/** {@code </div>�^�O} */
	_DIV("</div>"),
	/** {@code <head>�^�O} */
	HEAD("<head>"),
	/** {@code </head>�^�O} */
	_HEAD("</head>"),
	/** {@code <title>�^�O} */
	TITLE("<title>"),
	/** {@code <html>�^�O} */
	_TITLE("</title>"),
	/** {@code <meta>�^�O} */
	META("<meta>"),
	/** {@code </meta>�^�O} */
	_META("</meta>"),
	/** {@code <body>�^�O} */
	BODY("<body>"),
	/** {@code </body>�^�O} */
	_BODY("</body>"),
	/** {@code <table>�^�O} */
	TABLE("<table>"),
	/** {@code </table> �^�O} */
	_TABLE("</table>"),
	/** {@code <th> �^�O} */
	TH("<th>"),
	/** {@code <th> �^�O} */
	_TH("</th>"),
	/** {@code <tr> �^�O} */
	TR("<tr>"),
	/** {@code </tr> �^�O} */
	_TR("</tr>"),
	/** {@code <td>�^�O} */
	TD("<td>"),
	/** {@code </td>�^�O} */
	_TD("</td>"),
	/** {@code <thead>�^�O} */
	THEAD("<thead>"),
	/** {@code </thead>�^�O} */
	_THEAD("</thead>"),
	/** {@code <tfoot>�^�O} */
	TFOOT("<tfoot>"),
	/** {@code </tfoot>�^�O} */
	_TFOOT("</tfoot>"),
	/** {@code <caption>�^�O} */
	CAPTION("<caption>"),
	/** {@code </caption>�^�O} */
	_CAPTION("</caption>"),
	/** {@code <span>�^�O} */
	SPAN("<span>"),
	/** {@code </span>�^�O} */
	_SPAN("</span>"),
	/** {@code <h1>�^�O} */
	H1("<h1>"),
	/** {@code </h1>�^�O} */
	_H1("</h1>"),
	/** {@code <h2>�^�O} */
	H2("<h2>"),
	/** {@code </h2>�^�O} */
	_H2("</h2>"),
	/** {@code <h3>�^�O} */
	H3("<h3>"),
	/** {@code </h3>�^�O} */
	_H3("</h3>"),
	/** {@code <a>�^�O} */
	A("<a>"),
	/** {@code </a>�^�O} */
	_A("</a>"),
	/** {@code <p>�^�O} */
	P("<p>"),
	/** {@code </p>�^�O} */
	_P("</p>"),
	/** {@code <br> �^�O} */
	BR("<br>");

	/** HTML�^�O */
	private String tag;

	private TagType(String tag) {
		this.tag = tag;
	}

	@Override public String toString() {
		return tag;
		}
	}
