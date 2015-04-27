package md.varoinform.model.utils;

import md.varoinform.model.entities.enterprise.Enterprise;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

/**
* Created with IntelliJ IDEA.
* User: Vladimir Borovic
* Date: 6/10/14
* Time: 9:18 AM
*/
public class EnterpriseComparator implements Comparator<Enterprise> {

    private final Collator collator;
    private final String lang;


    public EnterpriseComparator(String lang) {
        this.lang = lang;
        Locale locale = new Locale(lang);
        collator = Collator.getInstance(locale);

    }

    @Override
    public int compare(Enterprise o1, Enterprise o2) {
        String titleO1 = o1.title(lang);
        String titleO2 = o2.title(lang);
        return collator.compare(titleO1, titleO2);
    }
}
