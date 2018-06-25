package builder;

import static builder.TagProperty.*;
import static builder.TagType.*;

/**
 * HTMLを構築するビルダークラス<br>
 * 以下のようにしてHTML形式文字列をメソッドで作成できます。<br><br>
 * {@code new SimpleHtmlBuilder.html().head().title("Sample")._head()
 * .body().line("HelloWorld")._body()._html();}<br>
 * これにより作成されるHTML形式文字列は以下です。<br>
 * {@code <html><head><title>Sample</title></head><body>HelloWorld</body></html>}
 */
public class SimpleHtmlBuilder {

    /** 出力用HTML形式文字列 */
    private final StringBuilder sb = new StringBuilder();

    /**
     * 出力用HTML形式文字列に文字列を追加します。
     * @param str 追加する文字列
     */
    private void append(String str) {
        sb.append(str);
    }

    /**
     * 出力用HTML形式文字列に引数に指定した出力用HTML形式文字列を結合します。
     * @param builder 出力用HTML形式文字列
     * @return 結合後の出力用HTML形式文字列
     */
    public SimpleHtmlBuilder append(SimpleHtmlBuilder builder) {
        append(builder.toString());
        return this;
    }

    /**
     * 出力用HTML形式文字列に文字列を追加します。
     * @param str 追加する文字列
     * @return 文字列が追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder line(String str) {
        append(str);
        return this;
    }
    /**
     * 出力用HTML形式文字列を改行します。
     * @return 改行記号が追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder newline() {
    	String lineCd = System.getProperty("line.separator");
        append(lineCd);
        return this;
    }

    /**
     * 出力用HTML形式文字列にタグを追加します。<br>
     * tagは{@link TagType}で指定します。<br>
     * <br>
     * 例：HTML, _HTML, BODY, _BODYなど<br>
     * HTML, _HTMLはそれぞれ{@code <html>, </html>}に対応します。
     * @param tag 追加するタグの種類
     * @return タグが追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tag(TagType tag) {
        append(tag.toString());
        return this;
    }

    /**
     * 出力用HTML形式文字列にタグを追加します。<br>
     * tagは{@code "<html>"}のように指定します。<br>
     * @param tag 追加するタグの文字列
     * @return タグが追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tag(String tag) {
        append(tag);
        return this;
    }

    /**
     * 出力用HTML形式文字列にタグを追加します。<br>
     * tagは{@link TagType}で指定します。<br>
     * また、引数にプロパティを取り、タグ内にプロパティを記述します。
     * <br>
     * 例：tag=TABLE, property={key:border, value:1}の場合、<br>
     * {@code <table border="1">}のようなタグが追加されます。
     * @param tag 追加するタグの種類
     * @param property タグに記述するプロパティ
     * @return タグが追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tag(TagType tag, TagPropertyMap<?> property) {
        StringBuilder sb = new StringBuilder(tag.toString());
        sb.deleteCharAt(sb.length() - 1)
            .append(" ")
            .append(property.toString())
            .append(">");
        append(sb.toString());
        return this;
    }
    

    /**
     * 出力用HTML形式文字列にタグを追加します。<br>
     * tagは{@link TagType}で指定します。<br>
     * また、引数にプロパティを取り、タグ内にプロパティを記述します。<br>
     * プロパティは id="div1" name="sample" のような完全なプロパティ文字列で指定します。<br>
     * <br>
     * 例：tag=TABLE, property="border="1""の場合、<br>
     * {@code <table border="1">}のようなタグが追加されます。
     * @param tag 追加するタグの種類
     * @param property タグに記述するプロパティ
     * @return タグが追加された出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tag(TagType tag, String property) {
        StringBuilder sb = new StringBuilder(tag.toString());
        sb.deleteCharAt(sb.length() - 1)
            .append(" ")
            .append(property)
            .append(">");
        append(sb.toString());
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <html>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder html() {
        tag(HTML);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </html>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _html() {
        tag(_HTML);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <main>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder main() {
        tag(MAIN);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </main>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _main() {
        tag(_MAIN);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <div>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder div() {
        tag(DIV);
        return this;
    }
    /**
     * 出力用HTML形式文字列に{@code <table border="X">}タグを追加します。<br>
     * Xには引数で指定したborderの値が記述されます。
     * @param border テーブルのborderパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder div(String align) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(ALIGN, align);
        tag(DIV, property);
        return this;
    }


    /**
     * 出力用HTML形式文字列に{@code </div>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _div() {
        tag(_DIV);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <meta charset="XXX">}タグを追加します。<br>
     * XXXには引数charsetで指定した文字エンコードが記述されます。
     * @param charset 文字エンコード
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder meta(String charset) {
        tag(META);
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CHARSET, charset + "");
        tag(_META);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <head>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder head() {
        tag(HEAD);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </head>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _head() {
        tag(_HEAD);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <title>XXX</title>}を追加します。<br>
     * XXXには引数で指定したタイトルが記述されます。
     * @param title タイトル
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder title(String title) {
        tag(TITLE);
        line(title);
        tag(_TITLE);
        return this;
    }
    /**
     * 出力用HTML形式文字列に{@code <h1>XXX</h1>}を追加します。<br>
     * XXXには引数で指定したタイトルが記述されます。
     * @param h1 強調
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder H1(String h1) {
        tag(H1);
        line(h1);
        tag(_H1);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <h2>XXX</h2>}を追加します。<br>
     * XXXには引数で指定したタイトルが記述されます。
     * @param h2 強調
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder H2(String h2) {
        tag(H2);
        line(h2);
        tag(_H2);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <h3>XXX</h3>}を追加します。<br>
     * XXXには引数で指定したタイトルが記述されます。
     * @param h3 強調
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder H3(String h3) {
        tag(H3);
        line(h3);
        tag(_H3);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <caption>XXX</caption>}を追加します。<br>
     * XXXには引数で指定したタイトルが記述されます。
     * @param caption キャプション
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder caption(String caption) {
        tag(CAPTION);
        line(caption);
        tag(_CAPTION);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <body>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder body() {
        tag(BODY);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </body>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _body() {
        tag(_BODY);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <table border="X">}タグを追加します。<br>
     * Xには引数で指定したborderの値が記述されます。
     * @param border テーブルのborderパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder table(int border) {
        TagPropertyMap<Integer> property = new TagPropertyMap<>();
        property.put(BORDER, border);
        tag(TABLE, property);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <table border="X">}タグを追加します。<br>
     * Xには引数で指定したborderの値が記述されます。
     * @param border テーブルのborderパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder table(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        tag(TABLE, property);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </table>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _table() {
        tag(_TABLE);
        return this;
    }
    
    /**
     * 出力用HTML形式文字列に{@code <thead>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder thead() {
        tag(THEAD);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </thead>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _thead() {
        tag(_THEAD);
        return this;
    }
    /**
     * 出力用HTML形式文字列に{@code <tfoot>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tfoot() {
        tag(TFOOT);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </tfoot>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _tfoot() {
        tag(_TFOOT);
        return this;
    }


    
    /**
     * 出力用HTML形式文字列に{@code <th class="">}タグを追加します。
     * @param className classパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder th(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
       	property.put(CLASS, className);
        tag(TH, property);
        return this;
    }
    /**
     * 出力用HTML形式文字列に{@code <th class=""></th>}タグで囲まれた文字列を追加します。
     * @param className classパラメータに与える値
     * @param line thタグで囲む文字列
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder th(String className, String line) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
       	property.put(CLASS, className);
        tag(TH, property);
        line(line);
        tag(_TH);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <th colspan="X">}タグを追加します。<br>
     * @param colspan colspanパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder th(int colspan) {
        TagPropertyMap<Integer> property = new TagPropertyMap<>();
        property.put(COLSPAN, colspan);
        tag(TH, property);
        return this;
    }

    
    /**
     * 出力用HTML形式文字列に{@code </th>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _th() {
        tag(_TH);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <tr>}タグを追加します。<br>
     * 引数に文字列を与えると、その文字列を格納した行を作成します。<br>
     * 例：引数に"a", "b", "c"を与えた場合：{@code <tr><td>a</td><td>b</td><td>c</td></tr>}
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tr(String... rows) {
        tag(TR);
        for(String row : rows) {
            td(row);
        }
        tag(_TR);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <tr></tr>}タグで囲まれた文字列を追加します。
     * @param line trタグで囲む文字列
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tr(String line) {
        tag(TR);
        line(line);
        tag(_TR);
        return this;
    }

    
    /**
     * 出力用HTML形式文字列に{@code <tr>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder tr() {
        tag(TR);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </tr>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _tr() {
        tag(_TR);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <td>XXX</td>}を追加します。<br>
     * XXXには引数で与えた文字列が記述されます。
     * @param str 文字列
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder td(String str) {
        tag(TD);
        line(str);
        tag(_TD);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <td>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder td() {
        tag(TD);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </td>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _td() {
        tag(_TD);
        return this;
    }
    
    /**
     * 出力用HTML形式文字列に{@code <span class="X">}タグを追加します。<br>
     * @param className classに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder span(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        tag(SPAN, property);
        return this;
    }
    
    /**
     * 出力用HTML形式文字列に{@code </span>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _span() {
        tag(_SPAN);
        return this;
    }


    /**
     * 出力用HTML形式文字列に{@code <br>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder br() {
        tag(BR);
        return this;
    }
    
    /**
     * 出力用HTML形式文字列に{@code <p id="X">}タグを追加します。<br>
     * @param id idに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder p(String id) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(ID, id);
        tag(P, property);
        return this;
    }
    
    /**
     * 出力用HTML形式文字列に{@code </p>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _p() {
        tag(_P);
        return this;
    }


    /**
     * 出力用HTML形式文字列に{@code <a href="X">}タグを追加します。<br>
     * @param href テーブルのhrefパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder a(String href) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(HREF, href);
        tag(A, property);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code <a class="X" href="Y">}タグを追加します。<br>
     * @param className classパラメータに与える値
     * @param href hrefパラメータに与える値
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder a(String className, String href) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        property.put(HREF, href);
        tag(A, property);
        return this;
    }

    /**
     * 出力用HTML形式文字列に{@code </p>}タグを追加します。
     * @return 出力用HTML形式文字列
     */
    public SimpleHtmlBuilder _a() {
        tag(_A);
        return this;
    }


    @Override public String toString() {
        return sb.toString();
    }
}