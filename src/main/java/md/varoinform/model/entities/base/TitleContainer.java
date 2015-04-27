package md.varoinform.model.entities.base;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.IndexedEmbedded;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/4/13
 * Time: 2:32 PM
 */
@MappedSuperclass
public abstract class TitleContainer<T extends Title> {
    protected Integer id;
    protected List<T> titles = new ArrayList<>();
    private Map<String, String> titleMap = new HashMap<>();

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


    public void setTitles(List<T> titles) {
        this.titles = titles;
        for (T title : titles) {
            if (title == null) continue;
            Language language = title.getLanguage();
            String lang = language.getTitle();
            String t = title.getTitle();
            titleMap.put(lang, t);
        }
    }

    public String title(String langTitle){
        String result = titleMap.get(langTitle);
        if (result != null) return result;
        if (titles.size() > 0){
            return titles.get(0).getTitle();
        }
        return "id = " + id;
    }

    @Override
    public String toString() {
        return "titles=" + titles;
    }
}
