package bernardo.venda.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class ValidarNumeroString extends PlainDocument {

    private int quantMax;

    public ValidarNumeroString(int maxLen) {
        super();
        if (maxLen <= 0) throw new IllegalArgumentException("Especifique a quantidade");
        quantMax = maxLen;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null || getLength() == quantMax)
            return;
        int totalQuantia = (getLength() + str.length());
        if (totalQuantia <= quantMax) {
            super.insertString(offset, str.replaceAll("[^0-9|^A-Z|^ ]", "").toUpperCase(), attr);
            return;
        }
        String nova = str.substring(0, getLength() - quantMax);
        super.insertString(offset, nova, attr);
    }

}
