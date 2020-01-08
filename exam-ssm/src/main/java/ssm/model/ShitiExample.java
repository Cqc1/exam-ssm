package ssm.model;

import java.util.ArrayList;
import java.util.List;

public class ShitiExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShitiExample() {
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

        public Criteria andDegreeIsNull() {
            addCriterion("Degree is null");
            return (Criteria) this;
        }

        public Criteria andDegreeIsNotNull() {
            addCriterion("Degree is not null");
            return (Criteria) this;
        }

        public Criteria andDegreeEqualTo(String value) {
            addCriterion("Degree =", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotEqualTo(String value) {
            addCriterion("Degree <>", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThan(String value) {
            addCriterion("Degree >", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeGreaterThanOrEqualTo(String value) {
            addCriterion("Degree >=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThan(String value) {
            addCriterion("Degree <", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLessThanOrEqualTo(String value) {
            addCriterion("Degree <=", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeLike(String value) {
            addCriterion("Degree like", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotLike(String value) {
            addCriterion("Degree not like", value, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeIn(List<String> values) {
            addCriterion("Degree in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotIn(List<String> values) {
            addCriterion("Degree not in", values, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeBetween(String value1, String value2) {
            addCriterion("Degree between", value1, value2, "degree");
            return (Criteria) this;
        }

        public Criteria andDegreeNotBetween(String value1, String value2) {
            addCriterion("Degree not between", value1, value2, "degree");
            return (Criteria) this;
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

        public Criteria andQufenIsNull() {
            addCriterion("QuFen is null");
            return (Criteria) this;
        }

        public Criteria andQufenIsNotNull() {
            addCriterion("QuFen is not null");
            return (Criteria) this;
        }

        public Criteria andQufenEqualTo(String value) {
            addCriterion("QuFen =", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenNotEqualTo(String value) {
            addCriterion("QuFen <>", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenGreaterThan(String value) {
            addCriterion("QuFen >", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenGreaterThanOrEqualTo(String value) {
            addCriterion("QuFen >=", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenLessThan(String value) {
            addCriterion("QuFen <", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenLessThanOrEqualTo(String value) {
            addCriterion("QuFen <=", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenLike(String value) {
            addCriterion("QuFen like", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenNotLike(String value) {
            addCriterion("QuFen not like", value, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenIn(List<String> values) {
            addCriterion("QuFen in", values, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenNotIn(List<String> values) {
            addCriterion("QuFen not in", values, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenBetween(String value1, String value2) {
            addCriterion("QuFen between", value1, value2, "qufen");
            return (Criteria) this;
        }

        public Criteria andQufenNotBetween(String value1, String value2) {
            addCriterion("QuFen not between", value1, value2, "qufen");
            return (Criteria) this;
        }

        public Criteria andShiticontentIsNull() {
            addCriterion("ShitiContent is null");
            return (Criteria) this;
        }

        public Criteria andShiticontentIsNotNull() {
            addCriterion("ShitiContent is not null");
            return (Criteria) this;
        }

        public Criteria andShiticontentEqualTo(String value) {
            addCriterion("ShitiContent =", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentNotEqualTo(String value) {
            addCriterion("ShitiContent <>", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentGreaterThan(String value) {
            addCriterion("ShitiContent >", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentGreaterThanOrEqualTo(String value) {
            addCriterion("ShitiContent >=", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentLessThan(String value) {
            addCriterion("ShitiContent <", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentLessThanOrEqualTo(String value) {
            addCriterion("ShitiContent <=", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentLike(String value) {
            addCriterion("ShitiContent like", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentNotLike(String value) {
            addCriterion("ShitiContent not like", value, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentIn(List<String> values) {
            addCriterion("ShitiContent in", values, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentNotIn(List<String> values) {
            addCriterion("ShitiContent not in", values, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentBetween(String value1, String value2) {
            addCriterion("ShitiContent between", value1, value2, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andShiticontentNotBetween(String value1, String value2) {
            addCriterion("ShitiContent not between", value1, value2, "shiticontent");
            return (Criteria) this;
        }

        public Criteria andTubiaoIsNull() {
            addCriterion("Tubiao is null");
            return (Criteria) this;
        }

        public Criteria andTubiaoIsNotNull() {
            addCriterion("Tubiao is not null");
            return (Criteria) this;
        }

        public Criteria andTubiaoEqualTo(String value) {
            addCriterion("Tubiao =", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoNotEqualTo(String value) {
            addCriterion("Tubiao <>", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoGreaterThan(String value) {
            addCriterion("Tubiao >", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoGreaterThanOrEqualTo(String value) {
            addCriterion("Tubiao >=", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoLessThan(String value) {
            addCriterion("Tubiao <", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoLessThanOrEqualTo(String value) {
            addCriterion("Tubiao <=", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoLike(String value) {
            addCriterion("Tubiao like", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoNotLike(String value) {
            addCriterion("Tubiao not like", value, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoIn(List<String> values) {
            addCriterion("Tubiao in", values, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoNotIn(List<String> values) {
            addCriterion("Tubiao not in", values, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoBetween(String value1, String value2) {
            addCriterion("Tubiao between", value1, value2, "tubiao");
            return (Criteria) this;
        }

        public Criteria andTubiaoNotBetween(String value1, String value2) {
            addCriterion("Tubiao not between", value1, value2, "tubiao");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("Answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("Answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("Answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("Answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("Answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("Answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("Answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("Answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("Answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("Answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("Answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("Answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("Answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("Answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andCishuIsNull() {
            addCriterion("Cishu is null");
            return (Criteria) this;
        }

        public Criteria andCishuIsNotNull() {
            addCriterion("Cishu is not null");
            return (Criteria) this;
        }

        public Criteria andCishuEqualTo(String value) {
            addCriterion("Cishu =", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuNotEqualTo(String value) {
            addCriterion("Cishu <>", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuGreaterThan(String value) {
            addCriterion("Cishu >", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuGreaterThanOrEqualTo(String value) {
            addCriterion("Cishu >=", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuLessThan(String value) {
            addCriterion("Cishu <", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuLessThanOrEqualTo(String value) {
            addCriterion("Cishu <=", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuLike(String value) {
            addCriterion("Cishu like", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuNotLike(String value) {
            addCriterion("Cishu not like", value, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuIn(List<String> values) {
            addCriterion("Cishu in", values, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuNotIn(List<String> values) {
            addCriterion("Cishu not in", values, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuBetween(String value1, String value2) {
            addCriterion("Cishu between", value1, value2, "cishu");
            return (Criteria) this;
        }

        public Criteria andCishuNotBetween(String value1, String value2) {
            addCriterion("Cishu not between", value1, value2, "cishu");
            return (Criteria) this;
        }

        public Criteria andPretimeIsNull() {
            addCriterion("PreTime is null");
            return (Criteria) this;
        }

        public Criteria andPretimeIsNotNull() {
            addCriterion("PreTime is not null");
            return (Criteria) this;
        }

        public Criteria andPretimeEqualTo(String value) {
            addCriterion("PreTime =", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeNotEqualTo(String value) {
            addCriterion("PreTime <>", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeGreaterThan(String value) {
            addCriterion("PreTime >", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeGreaterThanOrEqualTo(String value) {
            addCriterion("PreTime >=", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeLessThan(String value) {
            addCriterion("PreTime <", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeLessThanOrEqualTo(String value) {
            addCriterion("PreTime <=", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeLike(String value) {
            addCriterion("PreTime like", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeNotLike(String value) {
            addCriterion("PreTime not like", value, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeIn(List<String> values) {
            addCriterion("PreTime in", values, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeNotIn(List<String> values) {
            addCriterion("PreTime not in", values, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeBetween(String value1, String value2) {
            addCriterion("PreTime between", value1, value2, "pretime");
            return (Criteria) this;
        }

        public Criteria andPretimeNotBetween(String value1, String value2) {
            addCriterion("PreTime not between", value1, value2, "pretime");
            return (Criteria) this;
        }

        public Criteria andAvetimeIsNull() {
            addCriterion("AveTime is null");
            return (Criteria) this;
        }

        public Criteria andAvetimeIsNotNull() {
            addCriterion("AveTime is not null");
            return (Criteria) this;
        }

        public Criteria andAvetimeEqualTo(String value) {
            addCriterion("AveTime =", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeNotEqualTo(String value) {
            addCriterion("AveTime <>", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeGreaterThan(String value) {
            addCriterion("AveTime >", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeGreaterThanOrEqualTo(String value) {
            addCriterion("AveTime >=", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeLessThan(String value) {
            addCriterion("AveTime <", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeLessThanOrEqualTo(String value) {
            addCriterion("AveTime <=", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeLike(String value) {
            addCriterion("AveTime like", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeNotLike(String value) {
            addCriterion("AveTime not like", value, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeIn(List<String> values) {
            addCriterion("AveTime in", values, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeNotIn(List<String> values) {
            addCriterion("AveTime not in", values, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeBetween(String value1, String value2) {
            addCriterion("AveTime between", value1, value2, "avetime");
            return (Criteria) this;
        }

        public Criteria andAvetimeNotBetween(String value1, String value2) {
            addCriterion("AveTime not between", value1, value2, "avetime");
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