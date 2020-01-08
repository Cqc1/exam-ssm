package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class StuAnswerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StuAnswerExample() {
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

        public Criteria andStuidIsNull() {
            addCriterion("StuId is null");
            return (Criteria) this;
        }

        public Criteria andStuidIsNotNull() {
            addCriterion("StuId is not null");
            return (Criteria) this;
        }

        public Criteria andStuidEqualTo(Integer value) {
            addCriterion("StuId =", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotEqualTo(Integer value) {
            addCriterion("StuId <>", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThan(Integer value) {
            addCriterion("StuId >", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("StuId >=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThan(Integer value) {
            addCriterion("StuId <", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidLessThanOrEqualTo(Integer value) {
            addCriterion("StuId <=", value, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidIn(List<Integer> values) {
            addCriterion("StuId in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotIn(List<Integer> values) {
            addCriterion("StuId not in", values, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidBetween(Integer value1, Integer value2) {
            addCriterion("StuId between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andStuidNotBetween(Integer value1, Integer value2) {
            addCriterion("StuId not between", value1, value2, "stuid");
            return (Criteria) this;
        }

        public Criteria andShijuanidIsNull() {
            addCriterion("ShijuanId is null");
            return (Criteria) this;
        }

        public Criteria andShijuanidIsNotNull() {
            addCriterion("ShijuanId is not null");
            return (Criteria) this;
        }

        public Criteria andShijuanidEqualTo(Integer value) {
            addCriterion("ShijuanId =", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidNotEqualTo(Integer value) {
            addCriterion("ShijuanId <>", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidGreaterThan(Integer value) {
            addCriterion("ShijuanId >", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ShijuanId >=", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidLessThan(Integer value) {
            addCriterion("ShijuanId <", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidLessThanOrEqualTo(Integer value) {
            addCriterion("ShijuanId <=", value, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidIn(List<Integer> values) {
            addCriterion("ShijuanId in", values, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidNotIn(List<Integer> values) {
            addCriterion("ShijuanId not in", values, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidBetween(Integer value1, Integer value2) {
            addCriterion("ShijuanId between", value1, value2, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShijuanidNotBetween(Integer value1, Integer value2) {
            addCriterion("ShijuanId not between", value1, value2, "shijuanid");
            return (Criteria) this;
        }

        public Criteria andShitiidIsNull() {
            addCriterion("ShiTiId is null");
            return (Criteria) this;
        }

        public Criteria andShitiidIsNotNull() {
            addCriterion("ShiTiId is not null");
            return (Criteria) this;
        }

        public Criteria andShitiidEqualTo(Integer value) {
            addCriterion("ShiTiId =", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidNotEqualTo(Integer value) {
            addCriterion("ShiTiId <>", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidGreaterThan(Integer value) {
            addCriterion("ShiTiId >", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ShiTiId >=", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidLessThan(Integer value) {
            addCriterion("ShiTiId <", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidLessThanOrEqualTo(Integer value) {
            addCriterion("ShiTiId <=", value, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidIn(List<Integer> values) {
            addCriterion("ShiTiId in", values, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidNotIn(List<Integer> values) {
            addCriterion("ShiTiId not in", values, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidBetween(Integer value1, Integer value2) {
            addCriterion("ShiTiId between", value1, value2, "shitiid");
            return (Criteria) this;
        }

        public Criteria andShitiidNotBetween(Integer value1, Integer value2) {
            addCriterion("ShiTiId not between", value1, value2, "shitiid");
            return (Criteria) this;
        }

        public Criteria andStuanswerIsNull() {
            addCriterion("StuAnswer is null");
            return (Criteria) this;
        }

        public Criteria andStuanswerIsNotNull() {
            addCriterion("StuAnswer is not null");
            return (Criteria) this;
        }

        public Criteria andStuanswerEqualTo(String value) {
            addCriterion("StuAnswer =", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerNotEqualTo(String value) {
            addCriterion("StuAnswer <>", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerGreaterThan(String value) {
            addCriterion("StuAnswer >", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerGreaterThanOrEqualTo(String value) {
            addCriterion("StuAnswer >=", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerLessThan(String value) {
            addCriterion("StuAnswer <", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerLessThanOrEqualTo(String value) {
            addCriterion("StuAnswer <=", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerLike(String value) {
            addCriterion("StuAnswer like", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerNotLike(String value) {
            addCriterion("StuAnswer not like", value, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerIn(List<String> values) {
            addCriterion("StuAnswer in", values, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerNotIn(List<String> values) {
            addCriterion("StuAnswer not in", values, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerBetween(String value1, String value2) {
            addCriterion("StuAnswer between", value1, value2, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andStuanswerNotBetween(String value1, String value2) {
            addCriterion("StuAnswer not between", value1, value2, "stuanswer");
            return (Criteria) this;
        }

        public Criteria andDecsripIsNull() {
            addCriterion("Decsrip is null");
            return (Criteria) this;
        }

        public Criteria andDecsripIsNotNull() {
            addCriterion("Decsrip is not null");
            return (Criteria) this;
        }

        public Criteria andDecsripEqualTo(String value) {
            addCriterion("Decsrip =", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripNotEqualTo(String value) {
            addCriterion("Decsrip <>", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripGreaterThan(String value) {
            addCriterion("Decsrip >", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripGreaterThanOrEqualTo(String value) {
            addCriterion("Decsrip >=", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripLessThan(String value) {
            addCriterion("Decsrip <", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripLessThanOrEqualTo(String value) {
            addCriterion("Decsrip <=", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripLike(String value) {
            addCriterion("Decsrip like", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripNotLike(String value) {
            addCriterion("Decsrip not like", value, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripIn(List<String> values) {
            addCriterion("Decsrip in", values, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripNotIn(List<String> values) {
            addCriterion("Decsrip not in", values, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripBetween(String value1, String value2) {
            addCriterion("Decsrip between", value1, value2, "decsrip");
            return (Criteria) this;
        }

        public Criteria andDecsripNotBetween(String value1, String value2) {
            addCriterion("Decsrip not between", value1, value2, "decsrip");
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