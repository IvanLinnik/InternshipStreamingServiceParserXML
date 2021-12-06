package io.skai.okta.internshipstreamingserviceparserxml.item;

//@XmlRootElement(name = "item")
public class Item {

    //    @XmlElement(name = "title", required = true)
    private String title;

    //    @XmlElement(name = "description", required = true)
    private String description;

    //    @XmlElement(name = "pubDate", required = true)
    private String pubDate;

    //    @XmlElement(name = "link", required = true)
    private String link;

    public Item() {
    }

    public Item(String title, String description, String pubDate, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
