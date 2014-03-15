package com.rc.project.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RpMiddleExample {
    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by Apache iBATIS ibator.
     * This field corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    protected List oredCriteria;

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public RpMiddleExample() {
        oredCriteria = new ArrayList();
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    protected RpMiddleExample(RpMiddleExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public List getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
    }

    /**
     * This class was generated by Apache iBATIS ibator.
     * This class corresponds to the database table RP_MIDDLE
     *
     * @ibatorgenerated Wed Mar 12 15:11:45 CST 2014
     */
    public static class Criteria {
        protected List criteriaWithoutValue;

        protected List criteriaWithSingleValue;

        protected List criteriaWithListValue;

        protected List criteriaWithBetweenValue;

        protected Criteria() {
            super();
            criteriaWithoutValue = new ArrayList();
            criteriaWithSingleValue = new ArrayList();
            criteriaWithListValue = new ArrayList();
            criteriaWithBetweenValue = new ArrayList();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List list = new ArrayList();
            list.add(value1);
            list.add(value2);
            Map map = new HashMap();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andRpbSnoIsNull() {
            addCriterion("RPB_SNO is null");
            return this;
        }

        public Criteria andRpbSnoIsNotNull() {
            addCriterion("RPB_SNO is not null");
            return this;
        }

        public Criteria andRpbSnoEqualTo(String value) {
            addCriterion("RPB_SNO =", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoNotEqualTo(String value) {
            addCriterion("RPB_SNO <>", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoGreaterThan(String value) {
            addCriterion("RPB_SNO >", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoGreaterThanOrEqualTo(String value) {
            addCriterion("RPB_SNO >=", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoLessThan(String value) {
            addCriterion("RPB_SNO <", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoLessThanOrEqualTo(String value) {
            addCriterion("RPB_SNO <=", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoLike(String value) {
            addCriterion("RPB_SNO like", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoNotLike(String value) {
            addCriterion("RPB_SNO not like", value, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoIn(List values) {
            addCriterion("RPB_SNO in", values, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoNotIn(List values) {
            addCriterion("RPB_SNO not in", values, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoBetween(String value1, String value2) {
            addCriterion("RPB_SNO between", value1, value2, "rpbSno");
            return this;
        }

        public Criteria andRpbSnoNotBetween(String value1, String value2) {
            addCriterion("RPB_SNO not between", value1, value2, "rpbSno");
            return this;
        }

        public Criteria andRpSnoIsNull() {
            addCriterion("RP_SNO is null");
            return this;
        }

        public Criteria andRpSnoIsNotNull() {
            addCriterion("RP_SNO is not null");
            return this;
        }

        public Criteria andRpSnoEqualTo(String value) {
            addCriterion("RP_SNO =", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoNotEqualTo(String value) {
            addCriterion("RP_SNO <>", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoGreaterThan(String value) {
            addCriterion("RP_SNO >", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoGreaterThanOrEqualTo(String value) {
            addCriterion("RP_SNO >=", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoLessThan(String value) {
            addCriterion("RP_SNO <", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoLessThanOrEqualTo(String value) {
            addCriterion("RP_SNO <=", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoLike(String value) {
            addCriterion("RP_SNO like", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoNotLike(String value) {
            addCriterion("RP_SNO not like", value, "rpSno");
            return this;
        }

        public Criteria andRpSnoIn(List values) {
            addCriterion("RP_SNO in", values, "rpSno");
            return this;
        }

        public Criteria andRpSnoNotIn(List values) {
            addCriterion("RP_SNO not in", values, "rpSno");
            return this;
        }

        public Criteria andRpSnoBetween(String value1, String value2) {
            addCriterion("RP_SNO between", value1, value2, "rpSno");
            return this;
        }

        public Criteria andRpSnoNotBetween(String value1, String value2) {
            addCriterion("RP_SNO not between", value1, value2, "rpSno");
            return this;
        }

        public Criteria andRpmSdef1IsNull() {
            addCriterion("RPM_SDEF1 is null");
            return this;
        }

        public Criteria andRpmSdef1IsNotNull() {
            addCriterion("RPM_SDEF1 is not null");
            return this;
        }

        public Criteria andRpmSdef1EqualTo(String value) {
            addCriterion("RPM_SDEF1 =", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1NotEqualTo(String value) {
            addCriterion("RPM_SDEF1 <>", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1GreaterThan(String value) {
            addCriterion("RPM_SDEF1 >", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF1 >=", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1LessThan(String value) {
            addCriterion("RPM_SDEF1 <", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF1 <=", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1Like(String value) {
            addCriterion("RPM_SDEF1 like", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1NotLike(String value) {
            addCriterion("RPM_SDEF1 not like", value, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1In(List values) {
            addCriterion("RPM_SDEF1 in", values, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1NotIn(List values) {
            addCriterion("RPM_SDEF1 not in", values, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1Between(String value1, String value2) {
            addCriterion("RPM_SDEF1 between", value1, value2, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef1NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF1 not between", value1, value2, "rpmSdef1");
            return this;
        }

        public Criteria andRpmSdef2IsNull() {
            addCriterion("RPM_SDEF2 is null");
            return this;
        }

        public Criteria andRpmSdef2IsNotNull() {
            addCriterion("RPM_SDEF2 is not null");
            return this;
        }

        public Criteria andRpmSdef2EqualTo(String value) {
            addCriterion("RPM_SDEF2 =", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2NotEqualTo(String value) {
            addCriterion("RPM_SDEF2 <>", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2GreaterThan(String value) {
            addCriterion("RPM_SDEF2 >", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF2 >=", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2LessThan(String value) {
            addCriterion("RPM_SDEF2 <", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF2 <=", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2Like(String value) {
            addCriterion("RPM_SDEF2 like", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2NotLike(String value) {
            addCriterion("RPM_SDEF2 not like", value, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2In(List values) {
            addCriterion("RPM_SDEF2 in", values, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2NotIn(List values) {
            addCriterion("RPM_SDEF2 not in", values, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2Between(String value1, String value2) {
            addCriterion("RPM_SDEF2 between", value1, value2, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef2NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF2 not between", value1, value2, "rpmSdef2");
            return this;
        }

        public Criteria andRpmSdef3IsNull() {
            addCriterion("RPM_SDEF3 is null");
            return this;
        }

        public Criteria andRpmSdef3IsNotNull() {
            addCriterion("RPM_SDEF3 is not null");
            return this;
        }

        public Criteria andRpmSdef3EqualTo(String value) {
            addCriterion("RPM_SDEF3 =", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3NotEqualTo(String value) {
            addCriterion("RPM_SDEF3 <>", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3GreaterThan(String value) {
            addCriterion("RPM_SDEF3 >", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF3 >=", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3LessThan(String value) {
            addCriterion("RPM_SDEF3 <", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF3 <=", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3Like(String value) {
            addCriterion("RPM_SDEF3 like", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3NotLike(String value) {
            addCriterion("RPM_SDEF3 not like", value, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3In(List values) {
            addCriterion("RPM_SDEF3 in", values, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3NotIn(List values) {
            addCriterion("RPM_SDEF3 not in", values, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3Between(String value1, String value2) {
            addCriterion("RPM_SDEF3 between", value1, value2, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef3NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF3 not between", value1, value2, "rpmSdef3");
            return this;
        }

        public Criteria andRpmSdef4IsNull() {
            addCriterion("RPM_SDEF4 is null");
            return this;
        }

        public Criteria andRpmSdef4IsNotNull() {
            addCriterion("RPM_SDEF4 is not null");
            return this;
        }

        public Criteria andRpmSdef4EqualTo(String value) {
            addCriterion("RPM_SDEF4 =", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4NotEqualTo(String value) {
            addCriterion("RPM_SDEF4 <>", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4GreaterThan(String value) {
            addCriterion("RPM_SDEF4 >", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF4 >=", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4LessThan(String value) {
            addCriterion("RPM_SDEF4 <", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF4 <=", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4Like(String value) {
            addCriterion("RPM_SDEF4 like", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4NotLike(String value) {
            addCriterion("RPM_SDEF4 not like", value, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4In(List values) {
            addCriterion("RPM_SDEF4 in", values, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4NotIn(List values) {
            addCriterion("RPM_SDEF4 not in", values, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4Between(String value1, String value2) {
            addCriterion("RPM_SDEF4 between", value1, value2, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef4NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF4 not between", value1, value2, "rpmSdef4");
            return this;
        }

        public Criteria andRpmSdef5IsNull() {
            addCriterion("RPM_SDEF5 is null");
            return this;
        }

        public Criteria andRpmSdef5IsNotNull() {
            addCriterion("RPM_SDEF5 is not null");
            return this;
        }

        public Criteria andRpmSdef5EqualTo(String value) {
            addCriterion("RPM_SDEF5 =", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5NotEqualTo(String value) {
            addCriterion("RPM_SDEF5 <>", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5GreaterThan(String value) {
            addCriterion("RPM_SDEF5 >", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF5 >=", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5LessThan(String value) {
            addCriterion("RPM_SDEF5 <", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF5 <=", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5Like(String value) {
            addCriterion("RPM_SDEF5 like", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5NotLike(String value) {
            addCriterion("RPM_SDEF5 not like", value, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5In(List values) {
            addCriterion("RPM_SDEF5 in", values, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5NotIn(List values) {
            addCriterion("RPM_SDEF5 not in", values, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5Between(String value1, String value2) {
            addCriterion("RPM_SDEF5 between", value1, value2, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef5NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF5 not between", value1, value2, "rpmSdef5");
            return this;
        }

        public Criteria andRpmSdef6IsNull() {
            addCriterion("RPM_SDEF6 is null");
            return this;
        }

        public Criteria andRpmSdef6IsNotNull() {
            addCriterion("RPM_SDEF6 is not null");
            return this;
        }

        public Criteria andRpmSdef6EqualTo(String value) {
            addCriterion("RPM_SDEF6 =", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6NotEqualTo(String value) {
            addCriterion("RPM_SDEF6 <>", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6GreaterThan(String value) {
            addCriterion("RPM_SDEF6 >", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF6 >=", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6LessThan(String value) {
            addCriterion("RPM_SDEF6 <", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF6 <=", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6Like(String value) {
            addCriterion("RPM_SDEF6 like", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6NotLike(String value) {
            addCriterion("RPM_SDEF6 not like", value, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6In(List values) {
            addCriterion("RPM_SDEF6 in", values, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6NotIn(List values) {
            addCriterion("RPM_SDEF6 not in", values, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6Between(String value1, String value2) {
            addCriterion("RPM_SDEF6 between", value1, value2, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef6NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF6 not between", value1, value2, "rpmSdef6");
            return this;
        }

        public Criteria andRpmSdef7IsNull() {
            addCriterion("RPM_SDEF7 is null");
            return this;
        }

        public Criteria andRpmSdef7IsNotNull() {
            addCriterion("RPM_SDEF7 is not null");
            return this;
        }

        public Criteria andRpmSdef7EqualTo(String value) {
            addCriterion("RPM_SDEF7 =", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7NotEqualTo(String value) {
            addCriterion("RPM_SDEF7 <>", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7GreaterThan(String value) {
            addCriterion("RPM_SDEF7 >", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF7 >=", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7LessThan(String value) {
            addCriterion("RPM_SDEF7 <", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF7 <=", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7Like(String value) {
            addCriterion("RPM_SDEF7 like", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7NotLike(String value) {
            addCriterion("RPM_SDEF7 not like", value, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7In(List values) {
            addCriterion("RPM_SDEF7 in", values, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7NotIn(List values) {
            addCriterion("RPM_SDEF7 not in", values, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7Between(String value1, String value2) {
            addCriterion("RPM_SDEF7 between", value1, value2, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef7NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF7 not between", value1, value2, "rpmSdef7");
            return this;
        }

        public Criteria andRpmSdef8IsNull() {
            addCriterion("RPM_SDEF8 is null");
            return this;
        }

        public Criteria andRpmSdef8IsNotNull() {
            addCriterion("RPM_SDEF8 is not null");
            return this;
        }

        public Criteria andRpmSdef8EqualTo(String value) {
            addCriterion("RPM_SDEF8 =", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8NotEqualTo(String value) {
            addCriterion("RPM_SDEF8 <>", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8GreaterThan(String value) {
            addCriterion("RPM_SDEF8 >", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF8 >=", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8LessThan(String value) {
            addCriterion("RPM_SDEF8 <", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF8 <=", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8Like(String value) {
            addCriterion("RPM_SDEF8 like", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8NotLike(String value) {
            addCriterion("RPM_SDEF8 not like", value, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8In(List values) {
            addCriterion("RPM_SDEF8 in", values, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8NotIn(List values) {
            addCriterion("RPM_SDEF8 not in", values, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8Between(String value1, String value2) {
            addCriterion("RPM_SDEF8 between", value1, value2, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef8NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF8 not between", value1, value2, "rpmSdef8");
            return this;
        }

        public Criteria andRpmSdef9IsNull() {
            addCriterion("RPM_SDEF9 is null");
            return this;
        }

        public Criteria andRpmSdef9IsNotNull() {
            addCriterion("RPM_SDEF9 is not null");
            return this;
        }

        public Criteria andRpmSdef9EqualTo(String value) {
            addCriterion("RPM_SDEF9 =", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9NotEqualTo(String value) {
            addCriterion("RPM_SDEF9 <>", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9GreaterThan(String value) {
            addCriterion("RPM_SDEF9 >", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF9 >=", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9LessThan(String value) {
            addCriterion("RPM_SDEF9 <", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF9 <=", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9Like(String value) {
            addCriterion("RPM_SDEF9 like", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9NotLike(String value) {
            addCriterion("RPM_SDEF9 not like", value, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9In(List values) {
            addCriterion("RPM_SDEF9 in", values, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9NotIn(List values) {
            addCriterion("RPM_SDEF9 not in", values, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9Between(String value1, String value2) {
            addCriterion("RPM_SDEF9 between", value1, value2, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef9NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF9 not between", value1, value2, "rpmSdef9");
            return this;
        }

        public Criteria andRpmSdef10IsNull() {
            addCriterion("RPM_SDEF10 is null");
            return this;
        }

        public Criteria andRpmSdef10IsNotNull() {
            addCriterion("RPM_SDEF10 is not null");
            return this;
        }

        public Criteria andRpmSdef10EqualTo(String value) {
            addCriterion("RPM_SDEF10 =", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10NotEqualTo(String value) {
            addCriterion("RPM_SDEF10 <>", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10GreaterThan(String value) {
            addCriterion("RPM_SDEF10 >", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10GreaterThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF10 >=", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10LessThan(String value) {
            addCriterion("RPM_SDEF10 <", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10LessThanOrEqualTo(String value) {
            addCriterion("RPM_SDEF10 <=", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10Like(String value) {
            addCriterion("RPM_SDEF10 like", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10NotLike(String value) {
            addCriterion("RPM_SDEF10 not like", value, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10In(List values) {
            addCriterion("RPM_SDEF10 in", values, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10NotIn(List values) {
            addCriterion("RPM_SDEF10 not in", values, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10Between(String value1, String value2) {
            addCriterion("RPM_SDEF10 between", value1, value2, "rpmSdef10");
            return this;
        }

        public Criteria andRpmSdef10NotBetween(String value1, String value2) {
            addCriterion("RPM_SDEF10 not between", value1, value2, "rpmSdef10");
            return this;
        }
    }
}