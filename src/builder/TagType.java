package builder;

/**
 * タグの種類を格納する列挙型
 */
public enum TagType {
	/** {@code <html>タグ} */
	HTML("<html>"),
	/** {@code </html>タグ} */
	_HTML("</html>"),
	/** {@code <main>タグ} */
	MAIN("<main>"),
	/** {@code </main>タグ} */
	_MAIN("</main>"),
	/** {@code <div>タグ} */
	DIV("<div>"),
	/** {@code </div>タグ} */
	_DIV("</div>"),
	/** {@code <head>タグ} */
	HEAD("<head>"),
	/** {@code </head>タグ} */
	_HEAD("</head>"),
	/** {@code <title>タグ} */
	TITLE("<title>"),
	/** {@code <html>タグ} */
	_TITLE("</title>"),
	/** {@code <meta>タグ} */
	META("<meta>"),
	/** {@code </meta>タグ} */
	_META("</meta>"),
	/** {@code <body>タグ} */
	BODY("<body>"),
	/** {@code </body>タグ} */
	_BODY("</body>"),
	/** {@code <table>タグ} */
	TABLE("<table>"),
	/** {@code </table> タグ} */
	_TABLE("</table>"),
	/** {@code <th> タグ} */
	TH("<th>"),
	/** {@code <th> タグ} */
	_TH("</th>"),
	/** {@code <tr> タグ} */
	TR("<tr>"),
	/** {@code </tr> タグ} */
	_TR("</tr>"),
	/** {@code <td>タグ} */
	TD("<td>"),
	/** {@code </td>タグ} */
	_TD("</td>"),
	/** {@code <thead>タグ} */
	THEAD("<thead>"),
	/** {@code </thead>タグ} */
	_THEAD("</thead>"),
	/** {@code <tfoot>タグ} */
	TFOOT("<tfoot>"),
	/** {@code </tfoot>タグ} */
	_TFOOT("</tfoot>"),
	/** {@code <caption>タグ} */
	CAPTION("<caption>"),
	/** {@code </caption>タグ} */
	_CAPTION("</caption>"),
	/** {@code <span>タグ} */
	SPAN("<span>"),
	/** {@code </span>タグ} */
	_SPAN("</span>"),
	/** {@code <h1>タグ} */
	H1("<h1>"),
	/** {@code </h1>タグ} */
	_H1("</h1>"),
	/** {@code <h2>タグ} */
	H2("<h2>"),
	/** {@code </h2>タグ} */
	_H2("</h2>"),
	/** {@code <h3>タグ} */
	H3("<h3>"),
	/** {@code </h3>タグ} */
	_H3("</h3>"),
	/** {@code <a>タグ} */
	A("<a>"),
	/** {@code </a>タグ} */
	_A("</a>"),
	/** {@code <p>タグ} */
	P("<p>"),
	/** {@code </p>タグ} */
	_P("</p>"),
	/** {@code <br> タグ} */
	BR("<br>");

	/** HTMLタグ */
	private String tag;

	private TagType(String tag) {
		this.tag = tag;
	}

	@Override public String toString() {
		return tag;
		}
	}
