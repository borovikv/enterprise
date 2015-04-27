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
    private Integer id;
    private String title;
    private String titleType;
    private TitleAppendix appendix;
    private Enterprise enterprise;
    private Map<DefaultLanguages, String> titleMap;


    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    @Analyzer(definition = "customanalizer")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "title_type")
    @Field(index = Index.NO, analyze = Analyze.YES, store = Store.NO)
    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    @ManyToOne
    @JoinColumn(name = "appendix_id")
    public TitleAppendix getAppendix() {
        return appendix;
    }

    public void setAppendix(TitleAppendix appendix) {
        this.appendix = appendix;
    }


    @ManyToOne
    @JoinColumn(name = "enterprise_id")
    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }


    public Map<DefaultLanguages, String> toMap(){
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
        return toMap().get(language);
    }

    public String titleForLang(String language){
        return toMap().get(DefaultLanguages.getLanguageByTitle(language));
    }
}
