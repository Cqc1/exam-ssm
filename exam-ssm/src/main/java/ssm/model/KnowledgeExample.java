package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public KnowledgeExample() {
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

        public Criteria andKnpoidIsNull() {
            addCriterion("KnpoId is null");
            return (Criteria) this;
        }

        public Criteria andKnpoidIsNotNull() {
            addCriterion("KnpoId is not null");
            return (Criteria) this;
        }

        public Criteria andKnpoidEqualTo(Integer value) {
            addCriterion("KnpoId =", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidNotEqualTo(Integer value) {
            addCriterion("KnpoId <>", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidGreaterThan(Integer value) {
            addCriterion("KnpoId >", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidGreaterThanOrEqualTo(Integer value) {
            addCriterion("KnpoId >=", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidLessThan(Integer value) {
            addCriterion("KnpoId <", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidLessThanOrEqualTo(Integer value) {
            addCriterion("KnpoId <=", value, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidIn(List<Integer> values) {
            addCriterion("KnpoId in", values, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidNotIn(List<Integer> values) {
            addCriterion("KnpoId not in", values, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidBetween(Integer value1, Integer value2) {
            addCriterion("KnpoId between", value1, value2, "knpoid");
            return (Criteria) this;
        }

        public Criteria andKnpoidNotBetween(Integer value1, Integer value2) {
            addCriterion("KnpoId not between", value1, value2, "knpoid");
            return (Criteria) this;
        }

        public Criteria andClassidIsNull() {
            addCriterion("ClassId is null");
            return (Criteria) this;
        }

        public Criteria andClassidIsNotNull() {
            addCriterion("ClassId is not null");
            return (Criteria) this;
        }

        public Criteria andClassidEqualTo(Integer value) {
            addCriterion("ClassId =", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotEqualTo(Integer value) {
            addCriterion("ClassId <>", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThan(Integer value) {
            addCriterion("ClassId >", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ClassId >=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThan(Integer value) {
            addCriterion("ClassId <", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidLessThanOrEqualTo(Integer value) {
            addCriterion("ClassId <=", value, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidIn(List<Integer> values) {
            addCriterion("ClassId in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotIn(List<Integer> values) {
            addCriterion("ClassId not in", values, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidBetween(Integer value1, Integer value2) {
            addCriterion("ClassId between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andClassidNotBetween(Integer value1, Integer value2) {
            addCriterion("ClassId not between", value1, value2, "classid");
            return (Criteria) this;
        }

        public Criteria andZhjieIsNull() {
            addCriterion("ZhJie is null");
            return (Criteria) this;
        }

        public Criteria andZhjieIsNotNull() {
            addCriterion("ZhJie is not null");
            return (Criteria) this;
        }

        public Criteria andZhjieEqualTo(String value) {
            addCriterion("ZhJie =", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieNotEqualTo(String value) {
            addCriterion("ZhJie <>", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieGreaterThan(String value) {
            addCriterion("ZhJie >", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieGreaterThanOrEqualTo(String value) {
            addCriterion("ZhJie >=", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieLessThan(String value) {
            addCriterion("ZhJie <", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieLessThanOrEqualTo(String value) {
            addCriterion("ZhJie <=", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieLike(String value) {
            addCriterion("ZhJie like", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieNotLike(String value) {
            addCriterion("ZhJie not like", value, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieIn(List<String> values) {
            addCriterion("ZhJie in", values, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieNotIn(List<String> values) {
            addCriterion("ZhJie not in", values, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieBetween(String value1, String value2) {
            addCriterion("ZhJie between", value1, value2, "zhjie");
            return (Criteria) this;
        }

        public Criteria andZhjieNotBetween(String value1, String value2) {
            addCriterion("ZhJie not between", value1, value2, "zhjie");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("Content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("Content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("Content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("Content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("Content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("Content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("Content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("Content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("Content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("Content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("Content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("Content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("Content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("Content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andFlourIsNull() {
            addCriterion("Flour is null");
            return (Criteria) this;
        }

        public Criteria andFlourIsNotNull() {
            addCriterion("Flour is not null");
            return (Criteria) this;
        }

        public Criteria andFlourEqualTo(String value) {
            addCriterion("Flour =", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourNotEqualTo(String value) {
            addCriterion("Flour <>", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourGreaterThan(String value) {
            addCriterion("Flour >", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourGreaterThanOrEqualTo(String value) {
            addCriterion("Flour >=", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourLessThan(String value) {
            addCriterion("Flour <", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourLessThanOrEqualTo(String value) {
            addCriterion("Flour <=", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourLike(String value) {
            addCriterion("Flour like", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourNotLike(String value) {
            addCriterion("Flour not like", value, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourIn(List<String> values) {
            addCriterion("Flour in", values, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourNotIn(List<String> values) {
            addCriterion("Flour not in", values, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourBetween(String value1, String value2) {
            addCriterion("Flour between", value1, value2, "flour");
            return (Criteria) this;
        }

        public Criteria andFlourNotBetween(String value1, String value2) {
            addCriterion("Flour not between", value1, value2, "flour");
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