package ssm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShijuanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShijuanExample() {
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

        public Criteria andCouidIsNull() {
            addCriterion("CouId is null");
            return (Criteria) this;
        }

        public Criteria andCouidIsNotNull() {
            addCriterion("CouId is not null");
            return (Criteria) this;
        }

        public Criteria andCouidEqualTo(Integer value) {
            addCriterion("CouId =", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotEqualTo(Integer value) {
            addCriterion("CouId <>", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidGreaterThan(Integer value) {
            addCriterion("CouId >", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidGreaterThanOrEqualTo(Integer value) {
            addCriterion("CouId >=", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidLessThan(Integer value) {
            addCriterion("CouId <", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidLessThanOrEqualTo(Integer value) {
            addCriterion("CouId <=", value, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidIn(List<Integer> values) {
            addCriterion("CouId in", values, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotIn(List<Integer> values) {
            addCriterion("CouId not in", values, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidBetween(Integer value1, Integer value2) {
            addCriterion("CouId between", value1, value2, "couid");
            return (Criteria) this;
        }

        public Criteria andCouidNotBetween(Integer value1, Integer value2) {
            addCriterion("CouId not between", value1, value2, "couid");
            return (Criteria) this;
        }

        public Criteria andExamdayIsNull() {
            addCriterion("ExamDay is null");
            return (Criteria) this;
        }

        public Criteria andExamdayIsNotNull() {
            addCriterion("ExamDay is not null");
            return (Criteria) this;
        }

        public Criteria andExamdayEqualTo(Date value) {
            addCriterion("ExamDay =", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayNotEqualTo(Date value) {
            addCriterion("ExamDay <>", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayGreaterThan(Date value) {
            addCriterion("ExamDay >", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayGreaterThanOrEqualTo(Date value) {
            addCriterion("ExamDay >=", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayLessThan(Date value) {
            addCriterion("ExamDay <", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayLessThanOrEqualTo(Date value) {
            addCriterion("ExamDay <=", value, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayIn(List<Date> values) {
            addCriterion("ExamDay in", values, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayNotIn(List<Date> values) {
            addCriterion("ExamDay not in", values, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayBetween(Date value1, Date value2) {
            addCriterion("ExamDay between", value1, value2, "examday");
            return (Criteria) this;
        }

        public Criteria andExamdayNotBetween(Date value1, Date value2) {
            addCriterion("ExamDay not between", value1, value2, "examday");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNull() {
            addCriterion("ExamTime is null");
            return (Criteria) this;
        }

        public Criteria andExamtimeIsNotNull() {
            addCriterion("ExamTime is not null");
            return (Criteria) this;
        }

        public Criteria andExamtimeEqualTo(String value) {
            addCriterion("ExamTime =", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotEqualTo(String value) {
            addCriterion("ExamTime <>", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThan(String value) {
            addCriterion("ExamTime >", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeGreaterThanOrEqualTo(String value) {
            addCriterion("ExamTime >=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThan(String value) {
            addCriterion("ExamTime <", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLessThanOrEqualTo(String value) {
            addCriterion("ExamTime <=", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeLike(String value) {
            addCriterion("ExamTime like", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotLike(String value) {
            addCriterion("ExamTime not like", value, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeIn(List<String> values) {
            addCriterion("ExamTime in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotIn(List<String> values) {
            addCriterion("ExamTime not in", values, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeBetween(String value1, String value2) {
            addCriterion("ExamTime between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamtimeNotBetween(String value1, String value2) {
            addCriterion("ExamTime not between", value1, value2, "examtime");
            return (Criteria) this;
        }

        public Criteria andExamadrIsNull() {
            addCriterion("ExamAdr is null");
            return (Criteria) this;
        }

        public Criteria andExamadrIsNotNull() {
            addCriterion("ExamAdr is not null");
            return (Criteria) this;
        }

        public Criteria andExamadrEqualTo(String value) {
            addCriterion("ExamAdr =", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrNotEqualTo(String value) {
            addCriterion("ExamAdr <>", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrGreaterThan(String value) {
            addCriterion("ExamAdr >", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrGreaterThanOrEqualTo(String value) {
            addCriterion("ExamAdr >=", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrLessThan(String value) {
            addCriterion("ExamAdr <", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrLessThanOrEqualTo(String value) {
            addCriterion("ExamAdr <=", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrLike(String value) {
            addCriterion("ExamAdr like", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrNotLike(String value) {
            addCriterion("ExamAdr not like", value, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrIn(List<String> values) {
            addCriterion("ExamAdr in", values, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrNotIn(List<String> values) {
            addCriterion("ExamAdr not in", values, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrBetween(String value1, String value2) {
            addCriterion("ExamAdr between", value1, value2, "examadr");
            return (Criteria) this;
        }

        public Criteria andExamadrNotBetween(String value1, String value2) {
            addCriterion("ExamAdr not between", value1, value2, "examadr");
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

        public Criteria andTixinscoreIsNull() {
            addCriterion("TixinScore is null");
            return (Criteria) this;
        }

        public Criteria andTixinscoreIsNotNull() {
            addCriterion("TixinScore is not null");
            return (Criteria) this;
        }

        public Criteria andTixinscoreEqualTo(Integer value) {
            addCriterion("TixinScore =", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreNotEqualTo(Integer value) {
            addCriterion("TixinScore <>", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreGreaterThan(Integer value) {
            addCriterion("TixinScore >", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("TixinScore >=", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreLessThan(Integer value) {
            addCriterion("TixinScore <", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreLessThanOrEqualTo(Integer value) {
            addCriterion("TixinScore <=", value, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreIn(List<Integer> values) {
            addCriterion("TixinScore in", values, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreNotIn(List<Integer> values) {
            addCriterion("TixinScore not in", values, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreBetween(Integer value1, Integer value2) {
            addCriterion("TixinScore between", value1, value2, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andTixinscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("TixinScore not between", value1, value2, "tixinscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreIsNull() {
            addCriterion("ToalScore is null");
            return (Criteria) this;
        }

        public Criteria andToalscoreIsNotNull() {
            addCriterion("ToalScore is not null");
            return (Criteria) this;
        }

        public Criteria andToalscoreEqualTo(Integer value) {
            addCriterion("ToalScore =", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreNotEqualTo(Integer value) {
            addCriterion("ToalScore <>", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreGreaterThan(Integer value) {
            addCriterion("ToalScore >", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("ToalScore >=", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreLessThan(Integer value) {
            addCriterion("ToalScore <", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreLessThanOrEqualTo(Integer value) {
            addCriterion("ToalScore <=", value, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreIn(List<Integer> values) {
            addCriterion("ToalScore in", values, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreNotIn(List<Integer> values) {
            addCriterion("ToalScore not in", values, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreBetween(Integer value1, Integer value2) {
            addCriterion("ToalScore between", value1, value2, "toalscore");
            return (Criteria) this;
        }

        public Criteria andToalscoreNotBetween(Integer value1, Integer value2) {
            addCriterion("ToalScore not between", value1, value2, "toalscore");
            return (Criteria) this;
        }

        public Criteria andZujuuserIsNull() {
            addCriterion("ZujuUser is null");
            return (Criteria) this;
        }

        public Criteria andZujuuserIsNotNull() {
            addCriterion("ZujuUser is not null");
            return (Criteria) this;
        }

        public Criteria andZujuuserEqualTo(String value) {
            addCriterion("ZujuUser =", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserNotEqualTo(String value) {
            addCriterion("ZujuUser <>", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserGreaterThan(String value) {
            addCriterion("ZujuUser >", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserGreaterThanOrEqualTo(String value) {
            addCriterion("ZujuUser >=", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserLessThan(String value) {
            addCriterion("ZujuUser <", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserLessThanOrEqualTo(String value) {
            addCriterion("ZujuUser <=", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserLike(String value) {
            addCriterion("ZujuUser like", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserNotLike(String value) {
            addCriterion("ZujuUser not like", value, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserIn(List<String> values) {
            addCriterion("ZujuUser in", values, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserNotIn(List<String> values) {
            addCriterion("ZujuUser not in", values, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserBetween(String value1, String value2) {
            addCriterion("ZujuUser between", value1, value2, "zujuuser");
            return (Criteria) this;
        }

        public Criteria andZujuuserNotBetween(String value1, String value2) {
            addCriterion("ZujuUser not between", value1, value2, "zujuuser");
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