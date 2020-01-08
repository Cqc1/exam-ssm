package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class TixinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TixinExample() {
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

        public Criteria andTixinidIsNull() {
            addCriterion("TixinId is null");
            return (Criteria) this;
        }

        public Criteria andTixinidIsNotNull() {
            addCriterion("TixinId is not null");
            return (Criteria) this;
        }

        public Criteria andTixinidEqualTo(Integer value) {
            addCriterion("TixinId =", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidNotEqualTo(Integer value) {
            addCriterion("TixinId <>", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidGreaterThan(Integer value) {
            addCriterion("TixinId >", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidGreaterThanOrEqualTo(Integer value) {
            addCriterion("TixinId >=", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidLessThan(Integer value) {
            addCriterion("TixinId <", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidLessThanOrEqualTo(Integer value) {
            addCriterion("TixinId <=", value, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidIn(List<Integer> values) {
            addCriterion("TixinId in", values, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidNotIn(List<Integer> values) {
            addCriterion("TixinId not in", values, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidBetween(Integer value1, Integer value2) {
            addCriterion("TixinId between", value1, value2, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinidNotBetween(Integer value1, Integer value2) {
            addCriterion("TixinId not between", value1, value2, "tixinid");
            return (Criteria) this;
        }

        public Criteria andTixinnameIsNull() {
            addCriterion("TixinName is null");
            return (Criteria) this;
        }

        public Criteria andTixinnameIsNotNull() {
            addCriterion("TixinName is not null");
            return (Criteria) this;
        }

        public Criteria andTixinnameEqualTo(String value) {
            addCriterion("TixinName =", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameNotEqualTo(String value) {
            addCriterion("TixinName <>", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameGreaterThan(String value) {
            addCriterion("TixinName >", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameGreaterThanOrEqualTo(String value) {
            addCriterion("TixinName >=", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameLessThan(String value) {
            addCriterion("TixinName <", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameLessThanOrEqualTo(String value) {
            addCriterion("TixinName <=", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameLike(String value) {
            addCriterion("TixinName like", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameNotLike(String value) {
            addCriterion("TixinName not like", value, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameIn(List<String> values) {
            addCriterion("TixinName in", values, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameNotIn(List<String> values) {
            addCriterion("TixinName not in", values, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameBetween(String value1, String value2) {
            addCriterion("TixinName between", value1, value2, "tixinname");
            return (Criteria) this;
        }

        public Criteria andTixinnameNotBetween(String value1, String value2) {
            addCriterion("TixinName not between", value1, value2, "tixinname");
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