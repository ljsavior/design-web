package com.eternal.design.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TrainingRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrainingRecordExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIsNull() {
            addCriterion("training_name is null");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIsNotNull() {
            addCriterion("training_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingNameEqualTo(String value) {
            addCriterion("training_name =", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotEqualTo(String value) {
            addCriterion("training_name <>", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameGreaterThan(String value) {
            addCriterion("training_name >", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameGreaterThanOrEqualTo(String value) {
            addCriterion("training_name >=", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLessThan(String value) {
            addCriterion("training_name <", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLessThanOrEqualTo(String value) {
            addCriterion("training_name <=", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameLike(String value) {
            addCriterion("training_name like", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotLike(String value) {
            addCriterion("training_name not like", value, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameIn(List<String> values) {
            addCriterion("training_name in", values, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotIn(List<String> values) {
            addCriterion("training_name not in", values, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameBetween(String value1, String value2) {
            addCriterion("training_name between", value1, value2, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingNameNotBetween(String value1, String value2) {
            addCriterion("training_name not between", value1, value2, "trainingName");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeIsNull() {
            addCriterion("training_type is null");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeIsNotNull() {
            addCriterion("training_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeEqualTo(Short value) {
            addCriterion("training_type =", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeNotEqualTo(Short value) {
            addCriterion("training_type <>", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeGreaterThan(Short value) {
            addCriterion("training_type >", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("training_type >=", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeLessThan(Short value) {
            addCriterion("training_type <", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeLessThanOrEqualTo(Short value) {
            addCriterion("training_type <=", value, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeIn(List<Short> values) {
            addCriterion("training_type in", values, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeNotIn(List<Short> values) {
            addCriterion("training_type not in", values, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeBetween(Short value1, Short value2) {
            addCriterion("training_type between", value1, value2, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTrainingTypeNotBetween(Short value1, Short value2) {
            addCriterion("training_type not between", value1, value2, "trainingType");
            return (Criteria) this;
        }

        public Criteria andTimesUsedIsNull() {
            addCriterion("times_used is null");
            return (Criteria) this;
        }

        public Criteria andTimesUsedIsNotNull() {
            addCriterion("times_used is not null");
            return (Criteria) this;
        }

        public Criteria andTimesUsedEqualTo(String value) {
            addCriterion("times_used =", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedNotEqualTo(String value) {
            addCriterion("times_used <>", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedGreaterThan(String value) {
            addCriterion("times_used >", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedGreaterThanOrEqualTo(String value) {
            addCriterion("times_used >=", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedLessThan(String value) {
            addCriterion("times_used <", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedLessThanOrEqualTo(String value) {
            addCriterion("times_used <=", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedLike(String value) {
            addCriterion("times_used like", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedNotLike(String value) {
            addCriterion("times_used not like", value, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedIn(List<String> values) {
            addCriterion("times_used in", values, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedNotIn(List<String> values) {
            addCriterion("times_used not in", values, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedBetween(String value1, String value2) {
            addCriterion("times_used between", value1, value2, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andTimesUsedNotBetween(String value1, String value2) {
            addCriterion("times_used not between", value1, value2, "timesUsed");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(Integer value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Integer value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Integer value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Integer value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Integer value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Integer> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Integer> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Integer value1, Integer value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Integer value1, Integer value2) {
            addCriterion("score not between", value1, value2, "score");
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