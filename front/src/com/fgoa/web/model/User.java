/*     */ package com.fgoa.web.model;
/*     */ 
/*     */ import com.fgoa.web.vo.OrgVo;
/*     */ import com.fgoa.web.vo.UserVo;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Model;
/*     */ import com.jfinal.plugin.activerecord.Record;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class User extends Model<User>
/*     */ {
/*  17 */   public static User dao = new User();
/*     */   public static final String CHIEF = "chief";
/*     */   public static final String INBOX_MANAGER = "inboxmanager";
/*     */   public static final String POST_MANAGER = "postmanager";
/*     */   public static final String PETITION_MANAGER = "petitionmanager";
/*     */   public static final String CENTER_LEADER = "centerleader";
/*     */   public static final String DIRECTOR = "director";
/*     */   public static final String VICE_DIRECTOR = "vicedirector";
/*     */   public static final String SECTION_CHIFE = "sectionchife";
/*     */   public static final String VICE_SECTION_CHIFE = "vicesectionchife";
/*     */   public static final String NORMAL_USER = "normaluser";
/*     */   
/*     */   public User findUserByName(String userName) {
/*  30 */     if (StringUtils.isBlank(userName)) {
/*  31 */       return null;
/*     */     }
/*  33 */     return (User)dao.findFirst(
/*  34 */       "select * from t_s_base_user where status=1 and username = ?", 
/*  35 */       new Object[] { userName });
/*     */   }
/*     */   
/*     */   public List<User> findUserListByRole(String roleCode) {
/*  39 */     String sql = "select u.* from `t_s_base_user` as u,`t_s_role` as r,`t_s_role_user` as ru ,`t_s_user` as su where u.status=1 and ru.roleid=r.id and u.id=ru.userid and u.id = su.id and r.rolecode = ? order by su.orderNum desc";
/*     */     
/*  41 */     return dao.find(sql, new Object[] { roleCode });
/*     */   }
/*     */   
/*     */   public List<User> findUserListByRole2() {
/*  45 */     String sql = "select * from (select u.* from `t_s_base_user` as u,`t_s_role` as r,`t_s_role_user` as ru ,`t_s_user` as su where u.status=1 and ru.roleid=r.id and u.id=ru.userid and u.id = su.id and r.rolecode in ('sectionchife','vicesectionchife','dydzb','dedzb','ghzx','tzb') order by su.orderNum desc) t GROUP BY t.ID";
/*     */     
/*  47 */     return dao.find(sql);
/*     */   }
/*     */   
/*     */   public List<User> findUserByRoleExceptId(String roleCode, String exceptionId) {
/*  51 */     String sql = "select u.* from `t_s_base_user` as u,`t_s_role` as r,`t_s_role_user` as ru,`t_s_user` as tu where u.status=1 and ru.roleid=r.id and u.id=ru.userid and tu.id=u.id and r.rolecode = ? and u.id <> ? order by tu.orderNum desc";
/*     */     
/*  53 */     return dao.find(sql, new Object[] { roleCode, exceptionId });
/*     */   }
/*     */   
/*     */   public List<UserVo> findViceDirectors() {
/*  57 */     List<UserVo> returnValue = new ArrayList();
/*     */     
/*  59 */     String sql = "select d.ID as orgId,d.departname as orgName,u.ID as userId,u.realname as userName from t_s_base_user as u ,t_s_depart as d,t_oa_inbox_user_org as uo ,t_s_role_user ru ,t_s_role as r where u.status=1 and u.ID=uo.userId and d.ID=uo.orgId and u.ID=ru.userid and ru.roleid = r.ID and r.rolecode=?";
/*     */     
/*  61 */     List<Record> rs = Db.find(sql, new Object[] { "vicedirector" });
/*     */     
/*  63 */     Map<String, UserVo> map = new HashMap();
/*  64 */     for (Record r : rs) {
/*  65 */       OrgVo o = new OrgVo();
/*  66 */       o.setOrgId(r.getStr("orgId"));
/*  67 */       o.setOrgName(r.getStr("orgName"));
/*     */       
/*  69 */       String userId = (String)r.get("userId");
/*     */       UserVo u;
				if (map.keySet().contains(userId)) {
/*  72 */         u = (UserVo)map.get(userId);
/*     */       } else {
/*  74 */         u = new UserVo();
/*  75 */         u.setUserId(r.getStr("userId"));
/*  76 */         u.setUserName(r.getStr("userName"));
/*     */       }
/*  78 */       List<OrgVo> orgs = u.getOrgs();
/*  79 */       if (org.apache.commons.collections.CollectionUtils.isNotEmpty(orgs)) {
/*  80 */         orgs.add(o);
/*     */       } else {
/*  82 */         orgs = new ArrayList();
/*  83 */         orgs.add(o);
/*     */       }
/*  85 */       u.setOrgs(orgs);
/*  86 */       map.put(userId, u);
/*     */     }
/*  88 */     for (UserVo uo : map.values()) {
/*  89 */       returnValue.add(uo);
/*     */     }
/*  91 */     return returnValue;
/*     */   }
/*     */   
/*     */   public List<User> findUserByDepartIdAndRoleCode(String roleCode, String departId)
/*     */   {
/*  96 */     String sql = "select u.* from t_s_base_user as u  ,t_s_role_user as ru ,t_s_role as r where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and r.rolecode=? and u.departid=?";
/*     */     
/*  98 */     return dao.find(sql, new Object[] { roleCode, departId });
/*     */   }
/*     */   
/*     */   public List<User> findSectionChifeByDepartId(String departId) {
/* 102 */     String sql = "select u.* from t_s_base_user as u  ,t_s_role_user as ru ,t_s_role as r where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and r.rolecode = ? and u.departid=?";
/*     */     
/* 104 */     return dao.find(sql, new Object[] { "sectionchife", departId });
/*     */   }
/*     */   
/*     */   public User findSectionChife(String departId) {
/* 108 */     String sql = "select u.* from t_s_base_user as u  ,t_s_role_user as ru ,t_s_role as r where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and r.rolecode in (?) and u.departid=?";
/*     */     
/* 110 */     return (User)dao.findFirst(sql, new Object[] { "sectionchife", 
/* 111 */       departId });
/*     */   }
/*     */   
/*     */   public List<User> findSectionLeader(String departId) {
/* 115 */     String sql = "select u.* from t_s_base_user as u,t_oa_inbox_user_org as uo where u.status=1 and u.ID=uo.userId and uo.orgId=?";
/*     */     
/* 117 */     return dao.find(sql, new Object[] { departId });
/*     */   }
/*     */   
/*     */   public User findFirstSectionLeader(String departId) {
/* 121 */     String sql = "select u.* from t_s_base_user as u,t_oa_inbox_user_org as uo where u.status=1 and u.ID=uo.userId and uo.orgId=?";
/*     */     
/* 123 */     return (User)dao.findFirst(sql, new Object[] { departId });
/*     */   }
/*     */   
/*     */   public String findUserNameById(String userId) {
/* 127 */     User user = (User)dao.findById(userId);
/* 128 */     if (user != null) {
/* 129 */       return user.getStr("realname");
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   public List<User> findByIds(String[] userIds) {
/* 135 */     StringBuilder param = new StringBuilder();
/* 136 */     String[] arrayOfString; int j = (arrayOfString = userIds).length; for (int i = 0; i < j; i++) { String userId = arrayOfString[i];
/* 137 */       if (param.length() > 0) {
/* 138 */         param.append(",");
/*     */       }
/* 140 */       param.append("'" + userId + "'");
/*     */     }
/* 142 */     String sql = "select u.* from t_s_base_user as u where u.id in(" + 
/* 143 */       param + ")";
/* 144 */     return dao.find(sql);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\User.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */