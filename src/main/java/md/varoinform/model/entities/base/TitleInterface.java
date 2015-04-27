package md.varoinform.model.entities.base;

import md.varoinform.model.entities.base.Language;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 4/7/14
 * Time: 11:40 AM
 */
public interface TitleInterface {
    Long getId();
    Language getLanguage();
    String getTitle();
}
