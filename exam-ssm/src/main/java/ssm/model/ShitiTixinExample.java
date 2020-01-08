package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class ShitiTixinExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShitiTixinExample() {
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