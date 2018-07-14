package cn.standard.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * fahuodan
 * @author 
 */
public class Fahuodan implements Serializable {
    private Integer id;

    /**
     * 出发地
     */
    private String qizhan;

    /**
     * 到站
     */
    private String daozhan;

    /**
     * 货物名称
     */
    private String huowumin;

    /**
     * 总件数
     */
    private Integer amount;

    /**
     * 货物重量
     */
    private Integer weight;

    private String fahuoren;

    private String shouhuoren;

    /**
     * 发货人电话
     */
    private String fatel;

    /**
     * 收货人电话
     */
    private String shtel;

    /**
     * 发货日期
     */
    private Date fahuodate;

    /**
     * 回单
     */
    private String ishuidan;

    /**
     * 运费
     */
    private Integer yunfei;

    /**
     * 单号
     */
    private String danhao;

    public String getDanhao() {
        return danhao;
    }

    public void setDanhao(String danhao) {
        this.danhao = danhao;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQizhan() {
        return qizhan;
    }

    public void setQizhan(String qizhan) {
        this.qizhan = qizhan;
    }

    public String getDaozhan() {
        return daozhan;
    }

    public void setDaozhan(String daozhan) {
        this.daozhan = daozhan;
    }

    public String getHuowumin() {
        return huowumin;
    }

    public void setHuowumin(String huowumin) {
        this.huowumin = huowumin;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getFahuoren() {
        return fahuoren;
    }

    public void setFahuoren(String fahuoren) {
        this.fahuoren = fahuoren;
    }

    public String getShouhuoren() {
        return shouhuoren;
    }

    public void setShouhuoren(String shouhuoren) {
        this.shouhuoren = shouhuoren;
    }

    public String getFatel() {
        return fatel;
    }

    public void setFatel(String fatel) {
        this.fatel = fatel;
    }

    public String getShtel() {
        return shtel;
    }

    public void setShtel(String shtel) {
        this.shtel = shtel;
    }

    public Date getFahuodate() {
        return fahuodate;
    }

    public void setFahuodate(Date fahuodate) {
        this.fahuodate = fahuodate;
    }

    public String getIshuidan() {
        return ishuidan;
    }

    public void setIshuidan(String ishuidan) {
        this.ishuidan = ishuidan;
    }

    public Integer getYunfei() {
        return yunfei;
    }

    public void setYunfei(Integer yunfei) {
        this.yunfei = yunfei;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Fahuodan other = (Fahuodan) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getQizhan() == null ? other.getQizhan() == null : this.getQizhan().equals(other.getQizhan()))
            && (this.getDaozhan() == null ? other.getDaozhan() == null : this.getDaozhan().equals(other.getDaozhan()))
            && (this.getHuowumin() == null ? other.getHuowumin() == null : this.getHuowumin().equals(other.getHuowumin()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getFahuoren() == null ? other.getFahuoren() == null : this.getFahuoren().equals(other.getFahuoren()))
            && (this.getShouhuoren() == null ? other.getShouhuoren() == null : this.getShouhuoren().equals(other.getShouhuoren()))
            && (this.getFatel() == null ? other.getFatel() == null : this.getFatel().equals(other.getFatel()))
            && (this.getShtel() == null ? other.getShtel() == null : this.getShtel().equals(other.getShtel()))
            && (this.getFahuodate() == null ? other.getFahuodate() == null : this.getFahuodate().equals(other.getFahuodate()))
            && (this.getIshuidan() == null ? other.getIshuidan() == null : this.getIshuidan().equals(other.getIshuidan()))
            && (this.getYunfei() == null ? other.getYunfei() == null : this.getYunfei().equals(other.getYunfei()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getQizhan() == null) ? 0 : getQizhan().hashCode());
        result = prime * result + ((getDaozhan() == null) ? 0 : getDaozhan().hashCode());
        result = prime * result + ((getHuowumin() == null) ? 0 : getHuowumin().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getFahuoren() == null) ? 0 : getFahuoren().hashCode());
        result = prime * result + ((getShouhuoren() == null) ? 0 : getShouhuoren().hashCode());
        result = prime * result + ((getFatel() == null) ? 0 : getFatel().hashCode());
        result = prime * result + ((getShtel() == null) ? 0 : getShtel().hashCode());
        result = prime * result + ((getFahuodate() == null) ? 0 : getFahuodate().hashCode());
        result = prime * result + ((getIshuidan() == null) ? 0 : getIshuidan().hashCode());
        result = prime * result + ((getYunfei() == null) ? 0 : getYunfei().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", qizhan=").append(qizhan);
        sb.append(", daozhan=").append(daozhan);
        sb.append(", huowumin=").append(huowumin);
        sb.append(", amount=").append(amount);
        sb.append(", weight=").append(weight);
        sb.append(", fahuoren=").append(fahuoren);
        sb.append(", shouhuoren=").append(shouhuoren);
        sb.append(", fatel=").append(fatel);
        sb.append(", shtel=").append(shtel);
        sb.append(", fahuodate=").append(fahuodate);
        sb.append(", ishuidan=").append(ishuidan);
        sb.append(", yunfei=").append(yunfei);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}