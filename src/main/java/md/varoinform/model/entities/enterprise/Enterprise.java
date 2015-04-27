package md.varoinform.model.entities.enterprise;

import md.varoinform.model.entities.base.Brand;
import md.varoinform.model.entities.base.EnterpriseType;
import md.varoinform.model.utils.DB;
import org.apache.solr.analysis.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Vladimir Borovic
 * Date: 10/7/13
 * Time: 11:12 AM
 */
@SuppressWarnings("UnusedDeclaration")
@Entity
@Indexed
@AnalyzerDef(name = "customanalyzer",
        tokenizer = @TokenizerDef(factory = WhitespaceTokenizerFactory.class,
                params = {
                    @Parameter(name = "pattern", value = "\\W")
        }),
        filters = {
                @TokenFilterDef(factory = ASCIIFoldingFilterFactory.class),
                @TokenFilterDef(factory = LowerCaseFilterFactory.class),
                @TokenFilterDef(factory = RemoveDuplicatesTokenFilterFactory.class),
                @TokenFilterDef(factory = WordDelimiterFilterFactory.class),
                @TokenFilterDef(factory = EdgeNGramFilterFactory.class,
                        params = {
                                @Parameter(name = "minGramSize", value = "3"),
                                @Parameter(name = "maxGramSize", value = "15"),
                                @Parameter(name = "side", value = "front")
                        } ),
                @TokenFilterDef(factory = StopFilterFactory.class, params = {@Parameter(name = "ignoreCase", value = "true"),
                        @Parameter(name = "words", value = "word.txt")}),
                @TokenFilterDef(factory = SynonymFilterFactory.class,
                        params = {
                            @Parameter(name = "ignoreCase", value = "true"),
                            @Parameter(name = "synonyms", value = "synonyms.txt")
                        }),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "Russian"),
                }),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "English")
                }),
                @TokenFilterDef(factory = SnowballPorterFilterFactory.class, params = {
                        @Parameter(name = "language", value = "Romanian")
                })
        })
@Table(name = DB.SCHEMA + DB.ENTERPRISE + "enterprise")
public class Enterprise implements Serializable {
    private Integer id;
    private String status;
    private String idno;
    private Short creationYear;
    private Short numberOfJobs;
    private Date lastChange;
    private EnterpriseType enterpriseType;
    private Boolean tva;

    private List<Contact> contacts = new ArrayList<>();
    private List<Email> emails = new ArrayList<>();
    private List<WWW> urls = new ArrayList<>();
    private List<Location> locations = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();
    private List<Brand> brands = new ArrayList<>();
    private Set<EnterpriseProduct> goods = new HashSet<>();
    private List<EnterpriseTitle> titles = new ArrayList<>();

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

    @Column(name = "idno")
    @Field(analyze = Analyze.NO)
    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    @ManyToOne
    @JoinColumn(name = "entity_type_id")
    @IndexedEmbedded(includePaths = { "titles.title" })
    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(EnterpriseType enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    @Column(name = "creation_year")
    public Short getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Short creationYear) {
        this.creationYear = creationYear;
    }


    @Column(name = "number_of_jobs")
    public Short getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setNumberOfJobs(Short numberOfJobs) {
        this.numberOfJobs = numberOfJobs;
    }

    @Column(name = "last_change")
    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"phones.phone"})
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"firstName.titles.title", "lastName.titles.title", "phones.phone"})
    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @ManyToMany
    @JoinTable(name = DB.SCHEMA + DB.ENTERPRISE + "enterprise_brands", joinColumns = @JoinColumn(name = "enterprise_id"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
    @IndexedEmbedded(includePaths = {"title"})
    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }

    @OneToMany
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"product.titles.title"})
    public Set<EnterpriseProduct> getGoods() {
        return goods;
    }

    public void setGoods(Set<EnterpriseProduct> goods) {
        this.goods = goods;
    }

    @OneToMany
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"title", "appendix.titles.title"})
    public List<EnterpriseTitle> getTitles() {
        return titles;
    }

    public void setTitles(List<EnterpriseTitle> titles) {
        this.titles = titles;
    }

    @OneToMany
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"email"})
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @OneToMany
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded
    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "tva")
    public Boolean getTva() {
        return tva;
    }

    public void setTva(Boolean tva) {
        this.tva = tva;
    }

    @OneToMany
    @JoinColumn(name = "enterprise_id")
    @IndexedEmbedded(includePaths = {"url"})
    public List<WWW> getUrls() {
        return urls;
    }

    public void setUrls(List<WWW> urls) {
        this.urls = urls;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "title =" + titles +

                '}';
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Enterprise && id.equals(((Enterprise) obj).id);
    }
}
