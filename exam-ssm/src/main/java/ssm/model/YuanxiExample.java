package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class YuanxiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YuanxiExample() {
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

        public Criteria andYuidIsNull() {
            addCriterion("YuId is null");
            return (Criteria) this;
        }

        public Criteria andYuidIsNotNull() {
            addCriterion("YuId is not null");
            return (Criteria) this;
        }

        public Criteria andYuidEqualTo(Integer value) {
            addCriterion("YuId =", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotEqualTo(Integer value) {
            addCriterion("YuId <>", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidGreaterThan(Integer value) {
            addCriterion("YuId >", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("YuId >=", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidLessThan(Integer value) {
            addCriterion("YuId <", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidLessThanOrEqualTo(Integer value) {
            addCriterion("YuId <=", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidIn(List<Integer> values) {
            addCriterion("YuId in", values, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotIn(List<Integer> values) {
            addCriterion("YuId not in", values, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidBetween(Integer value1, Integer value2) {
            addCriterion("YuId between", value1, value2, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotBetween(Integer value1, Integer value2) {
            addCriterion("YuId not between", value1, value2, "yuid");
            return (Criteria) this;
        }

        public Criteria andYunamIsNull() {
            addCriterion("YuNam is null");
            return (Criteria) this;
        }

        public Criteria andYunamIsNotNull() {
            addCriterion("YuNam is not null");
            return (Criteria) this;
        }

        public Criteria andYunamEqualTo(String value) {
            addCriterion("YuNam =", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamNotEqualTo(String value) {
            addCriterion("YuNam <>", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamGreaterThan(String value) {
            addCriterion("YuNam >", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamGreaterThanOrEqualTo(String value) {
            addCriterion("YuNam >=", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamLessThan(String value) {
            addCriterion("YuNam <", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamLessThanOrEqualTo(String value) {
            addCriterion("YuNam <=", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamLike(String value) {
            addCriterion("YuNam like", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamNotLike(String value) {
            addCriterion("YuNam not like", value, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamIn(List<String> values) {
            addCriterion("YuNam in", values, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamNotIn(List<String> values) {
            addCriterion("YuNam not in", values, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamBetween(String value1, String value2) {
            addCriterion("YuNam between", value1, value2, "yunam");
            return (Criteria) this;
        }

        public Criteria andYunamNotBetween(String value1, String value2) {
            addCriterion("YuNam not between", value1, value2, "yunam");
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