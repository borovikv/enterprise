package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.Language;
import md.varoinform.model.entities.base.TitleAppendix;
import md.varoinform.model.utils.DB;
import md.varoinform.model.utils.DefaultLanguages;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 11:26 AM
 */
@Entity
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "title")
public class EnterpriseTitle{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    @Field(index = org.hibernate.search.annotations.Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Analyzer(definition = "customanalyzer")
    private String title;

    @Column(name = "title_type")
    @Field(index = Index.NO, analyze = Analyze.YES, store = Store.NO)
    private String titleType;

    @ManyToOne
    @JoinColumn(name = "appendix_id")
    private TitleAppendix appendix;

    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    private Enterprise enterprise;


    private Map<DefaultLanguages, String> titleMap;

    public Map<DefaultLanguages, String> getMap(){
        if (titleMap != null) return titleMap;

        titleMap = new HashMap<>();

        for (DefaultLanguages language : DefaultLanguages.values()) {
            String curTitle;
            if (titleType.equalsIgnoreCase("DE JURE")){
                curTitle = title + " " + enterprise.getEnterpriseType() + " " + appendix.title(language.getTitle());
            } else {
                curTitle = title + " " + appendix.title(language.getTitle());
            }
            titleMap.put(language, curTitle);
        }

        return titleMap;
    }

    public String titleForLang(DefaultLanguages language){
        return getMap().get(language);
    }

    public String titleForLang(String language){
        return getMap().get(DefaultLanguages.getLanguageByTitle(language));
    }
}
