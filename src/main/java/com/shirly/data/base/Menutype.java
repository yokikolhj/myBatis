package com.shirly.data.base;

import java.util.Date;

public class Menutype {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menutype.typeId
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    private Integer typeid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menutype.typeName
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    private String typename;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menutype.createTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    private Date createtime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column menutype.updateTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menutype.typeId
     *
     * @return the value of menutype.typeId
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menutype.typeId
     *
     * @param typeid the value for menutype.typeId
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menutype.typeName
     *
     * @return the value of menutype.typeName
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public String getTypename() {
        return typename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menutype.typeName
     *
     * @param typename the value for menutype.typeName
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menutype.createTime
     *
     * @return the value of menutype.createTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menutype.createTime
     *
     * @param createtime the value for menutype.createTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menutype.updateTime
     *
     * @return the value of menutype.updateTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menutype.updateTime
     *
     * @param updatetime the value for menutype.updateTime
     *
     * @mbg.generated Fri Aug 09 16:30:07 CST 2019
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}