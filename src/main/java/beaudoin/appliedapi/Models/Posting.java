package beaudoin.appliedapi.Models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "POSTING_TABLE")
public class Posting {
    public Posting() {
        this.dateApplied = new Date();
    }

    public Posting(String title, String company) {
        this.title = title;
        this.company = company;
        this.dateApplied = new Date();
    }

    @Id
    @GeneratedValue
    @Column(name = "POSTING_ID")
    private Integer id;

    @Column(name = "POSTING_TITLE")
    private String title;

    @Column(name = "POSTING_COMPANY")
    private String company;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name = "POSTING_DATE_APPLIED")
    private Date dateApplied;

    @Column(name = "POSTING_URL")
    private String url;

    @Column(name = "POSTING_DESC")
    private String desc;

    @Column(name = "POSTING_PLATFORM")
    private String platform;

    @Column(name = "POSTING_INTERVIEW_COUNT")
    private Integer interviewNo;

    @Column(name = "POSTING_HAS_TASK")
    private boolean hadTask;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getInterviewNo() {
        return interviewNo;
    }

    public void setInterviewNo(Integer interviewNo) {
        this.interviewNo = interviewNo;
    }

    public boolean getIsHadTask() {
        return hadTask;
    }

    public void setIsHadTask(boolean hadTask) {
        this.hadTask = hadTask;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(Date dateApplied) {
        this.dateApplied = dateApplied;
    }

    public Integer getId() {
        return id;
    }
}
