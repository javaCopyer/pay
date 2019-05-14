package com.minghui.pay.entity;

import java.util.Date;

public class PayAgent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.id
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.agent_num
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private String agentNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.money
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private Double money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.white_ip
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private String whiteIp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.create_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.modify_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private Date modifyTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pay_agent.remark
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.id
     *
     * @return the value of pay_agent.id
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.id
     *
     * @param id the value for pay_agent.id
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.agent_num
     *
     * @return the value of pay_agent.agent_num
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public String getAgentNum() {
        return agentNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.agent_num
     *
     * @param agentNum the value for pay_agent.agent_num
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setAgentNum(String agentNum) {
        this.agentNum = agentNum == null ? null : agentNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.money
     *
     * @return the value of pay_agent.money
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public Double getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.money
     *
     * @param money the value for pay_agent.money
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setMoney(Double money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.white_ip
     *
     * @return the value of pay_agent.white_ip
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public String getWhiteIp() {
        return whiteIp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.white_ip
     *
     * @param whiteIp the value for pay_agent.white_ip
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setWhiteIp(String whiteIp) {
        this.whiteIp = whiteIp == null ? null : whiteIp.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.create_time
     *
     * @return the value of pay_agent.create_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.create_time
     *
     * @param createTime the value for pay_agent.create_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.modify_time
     *
     * @return the value of pay_agent.modify_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.modify_time
     *
     * @param modifyTime the value for pay_agent.modify_time
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pay_agent.remark
     *
     * @return the value of pay_agent.remark
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pay_agent.remark
     *
     * @param remark the value for pay_agent.remark
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}