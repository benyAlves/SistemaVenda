package bernardo.venda.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class ValidarCampo extends PlainDocument {

    /**
     *
     */
    //private static final long serialVersionUID = 1L;
    private int quantMax;

    public ValidarCampo(int maxLen) {
        super();
        if (maxLen <= 0) throw new IllegalArgumentException("Especifique a quantidade");
        quantMax = maxLen;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null || getLength() == quantMax)
            return;
        int totalQuantia = (getLength() + str.length());
        if (totalQuantia <= quantMax) {
            super.insertString(offset, str.replaceAll("[^0-9|]", ""), attr);
            return;
        }
        String nova = str.substring(0, getLength() - quantMax);
        super.insertString(offset, nova, attr);
    }

}
