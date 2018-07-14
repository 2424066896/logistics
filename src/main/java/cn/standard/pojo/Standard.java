package cn.standard.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * standard
 * @author 
 */
public class Standard implements Serializable {
    /**
     * 标准id
     */
    private Integer id;

    /**
     * 标准号
     */
    private String stdnum;

    /**
     * 中文名称
     */
    private String zhname;

    /**
     * 版本
     */
    private String version;

    public void setKe(String ke) {
        this.ke = ke;
    }

    public String getKe() {
        return ke;
    }

    /**
     * 关键词
     */
    private String ke;

    /**
     * 发布日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releasedate;

    /**
     * 实施日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date impldate;

    /**
     * 附近路径
     */
    private String packagepath;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStdnum() {
        return stdnum;
    }

    public void setStdnum(String stdnum) {
        this.stdnum = stdnum;
    }

    public String getZhname() {
        return zhname;
    }

    public void setZhname(String zhname) {
        this.zhname = zhname;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }




    public Date getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(Date releasedate) {
        this.releasedate = releasedate;
    }

    public Date getImpldate() {
        return impldate;
    }

    public void setImpldate(Date impldate) {
        this.impldate = impldate;
    }

    public String getPackagepath() {
        return packagepath;
    }

    public void setPackagepath(String packagepath) {
        this.packagepath = packagepath;
    }
}