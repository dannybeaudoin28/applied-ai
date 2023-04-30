package beaudoin.appliedapi.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "POSTING_TABLE")
public class Posting {
    public Posting() {}

    public Posting(String title, boolean isChecked) {
        this.isChecked = isChecked;
        this.title = title;
    }

    @Id
    @GeneratedValue
    @Column(name = "POSTING_ID")
    private Integer id;

    @Column(name = "POSTING_TITLE")
    private String title;

    @Column(name = "POSTING_CHECKED")
    private boolean isChecked;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setisChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    public Integer getId() {
        return id;
    }
}
