package com.eternal.design.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommandExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionIsNull() {
            addCriterion("command_function is null");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionIsNotNull() {
            addCriterion("command_function is not null");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionEqualTo(Byte value) {
            addCriterion("command_function =", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionNotEqualTo(Byte value) {
            addCriterion("command_function <>", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionGreaterThan(Byte value) {
            addCriterion("command_function >", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionGreaterThanOrEqualTo(Byte value) {
            addCriterion("command_function >=", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionLessThan(Byte value) {
            addCriterion("command_function <", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionLessThanOrEqualTo(Byte value) {
            addCriterion("command_function <=", value, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionIn(List<Byte> values) {
            addCriterion("command_function in", values, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionNotIn(List<Byte> values) {
            addCriterion("command_function not in", values, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionBetween(Byte value1, Byte value2) {
            addCriterion("command_function between", value1, value2, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandFunctionNotBetween(Byte value1, Byte value2) {
            addCriterion("command_function not between", value1, value2, "commandFunction");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionIsNull() {
            addCriterion("command_description is null");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionIsNotNull() {
            addCriterion("command_description is not null");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionEqualTo(String value) {
            addCriterion("command_description =", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionNotEqualTo(String value) {
            addCriterion("command_description <>", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionGreaterThan(String value) {
            addCriterion("command_description >", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("command_description >=", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionLessThan(String value) {
            addCriterion("command_description <", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionLessThanOrEqualTo(String value) {
            addCriterion("command_description <=", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionLike(String value) {
            addCriterion("command_description like", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionNotLike(String value) {
            addCriterion("command_description not like", value, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionIn(List<String> values) {
            addCriterion("command_description in", values, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionNotIn(List<String> values) {
            addCriterion("command_description not in", values, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionBetween(String value1, String value2) {
            addCriterion("command_description between", value1, value2, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andCommandDescriptionNotBetween(String value1, String value2) {
            addCriterion("command_description not between", value1, value2, "commandDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionIsNull() {
            addCriterion("return_data_description is null");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionIsNotNull() {
            addCriterion("return_data_description is not null");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionEqualTo(String value) {
            addCriterion("return_data_description =", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionNotEqualTo(String value) {
            addCriterion("return_data_description <>", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionGreaterThan(String value) {
            addCriterion("return_data_description >", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("return_data_description >=", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionLessThan(String value) {
            addCriterion("return_data_description <", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionLessThanOrEqualTo(String value) {
            addCriterion("return_data_description <=", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionLike(String value) {
            addCriterion("return_data_description like", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionNotLike(String value) {
            addCriterion("return_data_description not like", value, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionIn(List<String> values) {
            addCriterion("return_data_description in", values, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionNotIn(List<String> values) {
            addCriterion("return_data_description not in", values, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionBetween(String value1, String value2) {
            addCriterion("return_data_description between", value1, value2, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andReturnDataDescriptionNotBetween(String value1, String value2) {
            addCriterion("return_data_description not between", value1, value2, "returnDataDescription");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeIsNull() {
            addCriterion("last_mod_time is null");
            return (Criteria) this;
        }

        public Criteria andLastModTimeIsNotNull() {
            addCriterion("last_mod_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastModTimeEqualTo(Date value) {
            addCriterion("last_mod_time =", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeNotEqualTo(Date value) {
            addCriterion("last_mod_time <>", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeGreaterThan(Date value) {
            addCriterion("last_mod_time >", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_mod_time >=", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeLessThan(Date value) {
            addCriterion("last_mod_time <", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_mod_time <=", value, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeIn(List<Date> values) {
            addCriterion("last_mod_time in", values, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeNotIn(List<Date> values) {
            addCriterion("last_mod_time not in", values, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeBetween(Date value1, Date value2) {
            addCriterion("last_mod_time between", value1, value2, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andLastModTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_mod_time not between", value1, value2, "lastModTime");
            return (Criteria) this;
        }

        public Criteria andModUserIdIsNull() {
            addCriterion("mod_user_id is null");
            return (Criteria) this;
        }

        public Criteria andModUserIdIsNotNull() {
            addCriterion("mod_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andModUserIdEqualTo(String value) {
            addCriterion("mod_user_id =", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotEqualTo(String value) {
            addCriterion("mod_user_id <>", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdGreaterThan(String value) {
            addCriterion("mod_user_id >", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("mod_user_id >=", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdLessThan(String value) {
            addCriterion("mod_user_id <", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdLessThanOrEqualTo(String value) {
            addCriterion("mod_user_id <=", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdLike(String value) {
            addCriterion("mod_user_id like", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotLike(String value) {
            addCriterion("mod_user_id not like", value, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdIn(List<String> values) {
            addCriterion("mod_user_id in", values, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotIn(List<String> values) {
            addCriterion("mod_user_id not in", values, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdBetween(String value1, String value2) {
            addCriterion("mod_user_id between", value1, value2, "modUserId");
            return (Criteria) this;
        }

        public Criteria andModUserIdNotBetween(String value1, String value2) {
            addCriterion("mod_user_id not between", value1, value2, "modUserId");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}