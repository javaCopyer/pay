package com.minghui.pay.dao;

import com.minghui.pay.entity.PayAgent;
import com.minghui.pay.entity.PayAgentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayAgentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int countByExample(PayAgentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int deleteByExample(PayAgentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int insert(PayAgent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int insertSelective(PayAgent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    List<PayAgent> selectByExample(PayAgentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    PayAgent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int updateByExampleSelective(@Param("record") PayAgent record, @Param("example") PayAgentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int updateByExample(@Param("record") PayAgent record, @Param("example") PayAgentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int updateByPrimaryKeySelective(PayAgent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pay_agent
     *
     * @mbggenerated Wed Mar 27 17:03:16 CST 2019
     */
    int updateByPrimaryKey(PayAgent record);
}