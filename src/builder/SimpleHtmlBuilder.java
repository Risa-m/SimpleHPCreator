package builder;

import static builder.TagProperty.*;
import static builder.TagType.*;

/**
 * HTML���\�z����r���_�[�N���X<br>
 * �ȉ��̂悤�ɂ���HTML�`������������\�b�h�ō쐬�ł��܂��B<br><br>
 * {@code new SimpleHtmlBuilder.html().head().title("Sample")._head()
 * .body().line("HelloWorld")._body()._html();}<br>
 * ����ɂ��쐬�����HTML�`��������͈ȉ��ł��B<br>
 * {@code <html><head><title>Sample</title></head><body>HelloWorld</body></html>}
 */
public class SimpleHtmlBuilder {

    /** �o�͗pHTML�`�������� */
    private final StringBuilder sb = new StringBuilder();

    /**
     * �o�͗pHTML�`��������ɕ������ǉ����܂��B
     * @param str �ǉ����镶����
     */
    private void append(String str) {
        sb.append(str);
    }

    /**
     * �o�͗pHTML�`��������Ɉ����Ɏw�肵���o�͗pHTML�`����������������܂��B
     * @param builder �o�͗pHTML�`��������
     * @return ������̏o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder append(SimpleHtmlBuilder builder) {
        append(builder.toString());
        return this;
    }

    /**
     * �o�͗pHTML�`��������ɕ������ǉ����܂��B
     * @param str �ǉ����镶����
     * @return �����񂪒ǉ����ꂽ�o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder line(String str) {
        append(str);
        return this;
    }
    /**
     * �o�͗pHTML�`������������s���܂��B
     * @return ���s�L�����ǉ����ꂽ�o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder newline() {
    	String lineCd = System.getProperty("line.separator");
        append(lineCd);
        return this;
    }

    /**
     * �o�͗pHTML�`��������Ƀ^�O��ǉ����܂��B<br>
     * tag��{@link TagType}�Ŏw�肵�܂��B<br>
     * <br>
     * ��FHTML, _HTML, BODY, _BODY�Ȃ�<br>
     * HTML, _HTML�͂��ꂼ��{@code <html>, </html>}�ɑΉ����܂��B
     * @param tag �ǉ�����^�O�̎��
     * @return �^�O���ǉ����ꂽ�o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder tag(TagType tag) {
        append(tag.toString());
        return this;
    }

    /**
     * �o�͗pHTML�`��������Ƀ^�O��ǉ����܂��B<br>
     * tag��{@code "<html>"}�̂悤�Ɏw�肵�܂��B<br>
     * @param tag �ǉ�����^�O�̕�����
     * @return �^�O���ǉ����ꂽ�o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder tag(String tag) {
        append(tag);
        return this;
    }

    /**
     * �o�͗pHTML�`��������Ƀ^�O��ǉ����܂��B<br>
     * tag��{@link TagType}�Ŏw�肵�܂��B<br>
     * �܂��A�����Ƀv���p�e�B�����A�^�O���Ƀv���p�e�B���L�q���܂��B
     * <br>
     * ��Ftag=TABLE, property={key:border, value:1}�̏ꍇ�A<br>
     * {@code <table border="1">}�̂悤�ȃ^�O���ǉ�����܂��B
     * @param tag �ǉ�����^�O�̎��
     * @param property �^�O�ɋL�q����v���p�e�B
     * @return �^�O���ǉ����ꂽ�o�͗pHTML�`��������
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
     * �o�͗pHTML�`��������Ƀ^�O��ǉ����܂��B<br>
     * tag��{@link TagType}�Ŏw�肵�܂��B<br>
     * �܂��A�����Ƀv���p�e�B�����A�^�O���Ƀv���p�e�B���L�q���܂��B<br>
     * �v���p�e�B�� id="div1" name="sample" �̂悤�Ȋ��S�ȃv���p�e�B������Ŏw�肵�܂��B<br>
     * <br>
     * ��Ftag=TABLE, property="border="1""�̏ꍇ�A<br>
     * {@code <table border="1">}�̂悤�ȃ^�O���ǉ�����܂��B
     * @param tag �ǉ�����^�O�̎��
     * @param property �^�O�ɋL�q����v���p�e�B
     * @return �^�O���ǉ����ꂽ�o�͗pHTML�`��������
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
     * �o�͗pHTML�`���������{@code <html>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder html() {
        tag(HTML);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </html>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _html() {
        tag(_HTML);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <main>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder main() {
        tag(MAIN);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </main>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _main() {
        tag(_MAIN);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <div>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder div() {
        tag(DIV);
        return this;
    }
    /**
     * �o�͗pHTML�`���������{@code <table border="X">}�^�O��ǉ����܂��B<br>
     * X�ɂ͈����Ŏw�肵��border�̒l���L�q����܂��B
     * @param border �e�[�u����border�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder div(String align) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(ALIGN, align);
        tag(DIV, property);
        return this;
    }


    /**
     * �o�͗pHTML�`���������{@code </div>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _div() {
        tag(_DIV);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <meta charset="XXX">}�^�O��ǉ����܂��B<br>
     * XXX�ɂ͈���charset�Ŏw�肵�������G���R�[�h���L�q����܂��B
     * @param charset �����G���R�[�h
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder meta(String charset) {
        tag(META);
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CHARSET, charset + "");
        tag(_META);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <head>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder head() {
        tag(HEAD);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </head>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _head() {
        tag(_HEAD);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <title>XXX</title>}��ǉ����܂��B<br>
     * XXX�ɂ͈����Ŏw�肵���^�C�g�����L�q����܂��B
     * @param title �^�C�g��
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder title(String title) {
        tag(TITLE);
        line(title);
        tag(_TITLE);
        return this;
    }
    /**
     * �o�͗pHTML�`���������{@code <h1>XXX</h1>}��ǉ����܂��B<br>
     * XXX�ɂ͈����Ŏw�肵���^�C�g�����L�q����܂��B
     * @param h1 ����
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder H1(String h1) {
        tag(H1);
        line(h1);
        tag(_H1);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <h2>XXX</h2>}��ǉ����܂��B<br>
     * XXX�ɂ͈����Ŏw�肵���^�C�g�����L�q����܂��B
     * @param h2 ����
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder H2(String h2) {
        tag(H2);
        line(h2);
        tag(_H2);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <h3>XXX</h3>}��ǉ����܂��B<br>
     * XXX�ɂ͈����Ŏw�肵���^�C�g�����L�q����܂��B
     * @param h3 ����
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder H3(String h3) {
        tag(H3);
        line(h3);
        tag(_H3);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <caption>XXX</caption>}��ǉ����܂��B<br>
     * XXX�ɂ͈����Ŏw�肵���^�C�g�����L�q����܂��B
     * @param caption �L���v�V����
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder caption(String caption) {
        tag(CAPTION);
        line(caption);
        tag(_CAPTION);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <body>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder body() {
        tag(BODY);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </body>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _body() {
        tag(_BODY);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <table border="X">}�^�O��ǉ����܂��B<br>
     * X�ɂ͈����Ŏw�肵��border�̒l���L�q����܂��B
     * @param border �e�[�u����border�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder table(int border) {
        TagPropertyMap<Integer> property = new TagPropertyMap<>();
        property.put(BORDER, border);
        tag(TABLE, property);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <table border="X">}�^�O��ǉ����܂��B<br>
     * X�ɂ͈����Ŏw�肵��border�̒l���L�q����܂��B
     * @param border �e�[�u����border�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder table(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        tag(TABLE, property);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </table>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _table() {
        tag(_TABLE);
        return this;
    }
    
    /**
     * �o�͗pHTML�`���������{@code <thead>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder thead() {
        tag(THEAD);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </thead>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _thead() {
        tag(_THEAD);
        return this;
    }
    /**
     * �o�͗pHTML�`���������{@code <tfoot>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder tfoot() {
        tag(TFOOT);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </tfoot>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _tfoot() {
        tag(_TFOOT);
        return this;
    }


    
    /**
     * �o�͗pHTML�`���������{@code <th class="">}�^�O��ǉ����܂��B
     * @param className class�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder th(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
       	property.put(CLASS, className);
        tag(TH, property);
        return this;
    }
    /**
     * �o�͗pHTML�`���������{@code <th class=""></th>}�^�O�ň͂܂ꂽ�������ǉ����܂��B
     * @param className class�p�����[�^�ɗ^����l
     * @param line th�^�O�ň͂ޕ�����
     * @return �o�͗pHTML�`��������
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
     * �o�͗pHTML�`���������{@code <th colspan="X">}�^�O��ǉ����܂��B<br>
     * @param colspan colspan�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder th(int colspan) {
        TagPropertyMap<Integer> property = new TagPropertyMap<>();
        property.put(COLSPAN, colspan);
        tag(TH, property);
        return this;
    }

    
    /**
     * �o�͗pHTML�`���������{@code </th>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _th() {
        tag(_TH);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <tr>}�^�O��ǉ����܂��B<br>
     * �����ɕ������^����ƁA���̕�������i�[�����s���쐬���܂��B<br>
     * ��F������"a", "b", "c"��^�����ꍇ�F{@code <tr><td>a</td><td>b</td><td>c</td></tr>}
     * @return �o�͗pHTML�`��������
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
     * �o�͗pHTML�`���������{@code <tr></tr>}�^�O�ň͂܂ꂽ�������ǉ����܂��B
     * @param line tr�^�O�ň͂ޕ�����
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder tr(String line) {
        tag(TR);
        line(line);
        tag(_TR);
        return this;
    }

    
    /**
     * �o�͗pHTML�`���������{@code <tr>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder tr() {
        tag(TR);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </tr>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _tr() {
        tag(_TR);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <td>XXX</td>}��ǉ����܂��B<br>
     * XXX�ɂ͈����ŗ^���������񂪋L�q����܂��B
     * @param str ������
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder td(String str) {
        tag(TD);
        line(str);
        tag(_TD);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <td>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder td() {
        tag(TD);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </td>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _td() {
        tag(_TD);
        return this;
    }
    
    /**
     * �o�͗pHTML�`���������{@code <span class="X">}�^�O��ǉ����܂��B<br>
     * @param className class�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder span(String className) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        tag(SPAN, property);
        return this;
    }
    
    /**
     * �o�͗pHTML�`���������{@code </span>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _span() {
        tag(_SPAN);
        return this;
    }


    /**
     * �o�͗pHTML�`���������{@code <br>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder br() {
        tag(BR);
        return this;
    }
    
    /**
     * �o�͗pHTML�`���������{@code <p id="X">}�^�O��ǉ����܂��B<br>
     * @param id id�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder p(String id) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(ID, id);
        tag(P, property);
        return this;
    }
    
    /**
     * �o�͗pHTML�`���������{@code </p>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _p() {
        tag(_P);
        return this;
    }


    /**
     * �o�͗pHTML�`���������{@code <a href="X">}�^�O��ǉ����܂��B<br>
     * @param href �e�[�u����href�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder a(String href) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(HREF, href);
        tag(A, property);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code <a class="X" href="Y">}�^�O��ǉ����܂��B<br>
     * @param className class�p�����[�^�ɗ^����l
     * @param href href�p�����[�^�ɗ^����l
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder a(String className, String href) {
        TagPropertyMap<String> property = new TagPropertyMap<>();
        property.put(CLASS, className);
        property.put(HREF, href);
        tag(A, property);
        return this;
    }

    /**
     * �o�͗pHTML�`���������{@code </p>}�^�O��ǉ����܂��B
     * @return �o�͗pHTML�`��������
     */
    public SimpleHtmlBuilder _a() {
        tag(_A);
        return this;
    }


    @Override public String toString() {
        return sb.toString();
    }
}