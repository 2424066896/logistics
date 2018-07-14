package cn.standard.pojo;

import java.io.Serializable;

/**
 * driver
 * @author 
 */
public class Driver implements Serializable {
    private Integer id;

    /**
     * 司机姓名
     */
    private String drivername;

    /**
     * 司机电话
     */
    private String driverphone;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDrivername() {
        return drivername;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }

    public String getDriverphone() {
        return driverphone;
    }

    public void setDriverphone(String driverphone) {
        this.driverphone = driverphone;
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
        Driver other = (Driver) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDrivername() == null ? other.getDrivername() == null : this.getDrivername().equals(other.getDrivername()))
            && (this.getDriverphone() == null ? other.getDriverphone() == null : this.getDriverphone().equals(other.getDriverphone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDrivername() == null) ? 0 : getDrivername().hashCode());
        result = prime * result + ((getDriverphone() == null) ? 0 : getDriverphone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drivername=").append(drivername);
        sb.append(", driverphone=").append(driverphone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}