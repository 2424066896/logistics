package cn.standard.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * sendbill
 * @author 
 */
public class Sendbill implements Serializable {
    /**
     * 运单ID
     */
    private Integer id;

    /**
     * 运单号
     */
    private String sendnum;

    /**
     * 寄件人
     */
    private String sender;

    /**
     * 寄件人电话
     */
    private String serderphone;

    /**
     * 收件人
     */
    private String taker;

    /**
     * 收件人电话
     */
    private String takerphone;

    /**
     * 发货日期
     */
  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String senddate;

    /**
     * 起站
     */
    private String start;

    /**
     * 到站
     */
    private String end;

    /**
     * 货物名称
     */
    private String goods;

    /**
     * 运费
     */
    private Double sendprice;

    /**
     * 结算方式
     */
    private String paytype;

    /**
     * 是否需要回单
     */
    private String reply;

    /**
     * 送货方式
     */
    private String sendtype;

    /**
     * 货物是否提货  0全部 1 未提货 2 已提货 
     */
    private Integer goodsstateid;


    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    private String goodsname;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSendnum() {
        return sendnum;
    }

    public void setSendnum(String sendnum) {
        this.sendnum = sendnum;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSerderphone() {
        return serderphone;
    }

    public void setSerderphone(String serderphone) {
        this.serderphone = serderphone;
    }

    public String getTaker() {
        return taker;
    }

    public void setTaker(String taker) {
        this.taker = taker;
    }

    public String getTakerphone() {
        return takerphone;
    }

    public void setTakerphone(String takerphone) {
        this.takerphone = takerphone;
    }

    public String getSenddate() {
        return senddate;
    }

    public void setSenddate(String senddate) {
        this.senddate = senddate;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public Double getSendprice() {
        return sendprice;
    }

    public void setSendprice(Double sendprice) {
        this.sendprice = sendprice;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getSendtype() {
        return sendtype;
    }

    public void setSendtype(String sendtype) {
        this.sendtype = sendtype;
    }

    public Integer getGoodsstateid() {
        return goodsstateid;
    }

    public void setGoodsstateid(Integer goodsstateid) {
        this.goodsstateid = goodsstateid;
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
        Sendbill other = (Sendbill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSendnum() == null ? other.getSendnum() == null : this.getSendnum().equals(other.getSendnum()))
            && (this.getSender() == null ? other.getSender() == null : this.getSender().equals(other.getSender()))
            && (this.getSerderphone() == null ? other.getSerderphone() == null : this.getSerderphone().equals(other.getSerderphone()))
            && (this.getTaker() == null ? other.getTaker() == null : this.getTaker().equals(other.getTaker()))
            && (this.getTakerphone() == null ? other.getTakerphone() == null : this.getTakerphone().equals(other.getTakerphone()))
            && (this.getSenddate() == null ? other.getSenddate() == null : this.getSenddate().equals(other.getSenddate()))
            && (this.getStart() == null ? other.getStart() == null : this.getStart().equals(other.getStart()))
            && (this.getEnd() == null ? other.getEnd() == null : this.getEnd().equals(other.getEnd()))
            && (this.getGoods() == null ? other.getGoods() == null : this.getGoods().equals(other.getGoods()))
            && (this.getSendprice() == null ? other.getSendprice() == null : this.getSendprice().equals(other.getSendprice()))
            && (this.getPaytype() == null ? other.getPaytype() == null : this.getPaytype().equals(other.getPaytype()))
            && (this.getReply() == null ? other.getReply() == null : this.getReply().equals(other.getReply()))
            && (this.getSendtype() == null ? other.getSendtype() == null : this.getSendtype().equals(other.getSendtype()))
            && (this.getGoodsstateid() == null ? other.getGoodsstateid() == null : this.getGoodsstateid().equals(other.getGoodsstateid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSendnum() == null) ? 0 : getSendnum().hashCode());
        result = prime * result + ((getSender() == null) ? 0 : getSender().hashCode());
        result = prime * result + ((getSerderphone() == null) ? 0 : getSerderphone().hashCode());
        result = prime * result + ((getTaker() == null) ? 0 : getTaker().hashCode());
        result = prime * result + ((getTakerphone() == null) ? 0 : getTakerphone().hashCode());
        result = prime * result + ((getSenddate() == null) ? 0 : getSenddate().hashCode());
        result = prime * result + ((getStart() == null) ? 0 : getStart().hashCode());
        result = prime * result + ((getEnd() == null) ? 0 : getEnd().hashCode());
        result = prime * result + ((getGoods() == null) ? 0 : getGoods().hashCode());
        result = prime * result + ((getSendprice() == null) ? 0 : getSendprice().hashCode());
        result = prime * result + ((getPaytype() == null) ? 0 : getPaytype().hashCode());
        result = prime * result + ((getReply() == null) ? 0 : getReply().hashCode());
        result = prime * result + ((getSendtype() == null) ? 0 : getSendtype().hashCode());
        result = prime * result + ((getGoodsstateid() == null) ? 0 : getGoodsstateid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sendnum=").append(sendnum);
        sb.append(", sender=").append(sender);
        sb.append(", serderphone=").append(serderphone);
        sb.append(", taker=").append(taker);
        sb.append(", takerphone=").append(takerphone);
        sb.append(", senddate=").append(senddate);
        sb.append(", start=").append(start);
        sb.append(", end=").append(end);
        sb.append(", goods=").append(goods);
        sb.append(", sendprice=").append(sendprice);
        sb.append(", paytype=").append(paytype);
        sb.append(", reply=").append(reply);
        sb.append(", sendtype=").append(sendtype);
        sb.append(", goodsstateid=").append(goodsname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}