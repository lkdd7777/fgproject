package com.fgoa.web.model;

import com.fgoa.web.security.ShiroRealmUser;
import com.fgoa.web.security.ShiroUtils;
import com.fgoa.web.utils.OaDateUtils;
import com.fgoa.web.vo.CommonDate;
import com.fgoa.web.vo.ScheduleVo;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

public class Schedule extends Model<Schedule> {
	public static Schedule dao = new Schedule();

	public List<ScheduleVo> queryScheduleByDateRange(Date beginDate,
			Date endDate) {
		List<ScheduleVo> returnValue = new ArrayList();
		if (beginDate == null) {
			return new ArrayList();
		}
		String orgId = ShiroUtils.getCurrentUser().getOrgId();
		if (StringUtils.isBlank(orgId)) {
			return returnValue;
		}
		String userId = ShiroUtils.getCurrentUser().getId();
		if (StringUtils.isBlank(userId)) {
			return returnValue;
		}
		return queryScheduleList(beginDate, endDate, userId, orgId);
	}

	public List<ScheduleVo> queryScheduleList(Date beginDate, Date endDate,
			String userId, String orgId) {
		List<ScheduleVo> returnValue = new ArrayList();
		if ((beginDate == null) || (endDate == null)
				|| (StringUtils.isBlank(userId))
				|| (StringUtils.isBlank(orgId))) {
			return returnValue;
		}
		String sql = "SELECT distinct(c.id) FROM `t_oa_schedule` as c ,`t_oa_schedule_depart` as cd,`t_s_depart` as d ,`t_s_user` as s, `t_oa_schedule_user` as su where ((c.id=cd.schedule_id and d.id=cd.depart_id and d.id = ?) OR ( c.id =su.schedule_id and s.id=su.user_id and s.id=?)) and (executetime > ? and executetime < ?)";

		List<Record> idRecords = Db.find(sql, new Object[] { orgId, userId,
				beginDate, endDate });
		if (CollectionUtils.isEmpty(idRecords)) {
			return returnValue;
		}
		StringBuffer sb = new StringBuffer("(");
		for (Record idRecord : idRecords) {
			sb.append("'" + idRecord.getStr("id") + "',");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");

		String resultSql = "SELECT * FROM `t_oa_schedule` as c where c.id in "
				+ sb.toString() + " ORDER BY executetime ASC";
		System.out.println(resultSql);
		List<Record> result = Db.find(resultSql);
		for (Record c : result) {
			ScheduleVo vo = new ScheduleVo();
			vo.setContent(c.getStr("content"));
			vo.setAddress(c.getStr("address"));
			vo.setDepartName(c.getStr("usersName") + ","
					+ c.getStr("departsName"));
			CommonDate cd = OaDateUtils.getCommonDate(c
					.getTimestamp("executetime"));

			vo.setWeek(cd.getWeek());
			vo.setNoon(cd.getNoon());
			vo.setDate(cd.getDate());
			vo.setTime(cd.getTime());
			vo.setMasterDepartName(c.getStr("masterDepartName"));

			returnValue.add(vo);
		}
		return returnValue;
	}

	public List<Integer> queryEventDaysInMonth(Date date) {
		List<Integer> returnValue = new ArrayList();

		String orgId = ShiroUtils.getCurrentUser().getOrgId();
		if (StringUtils.isBlank(orgId)) {
			return returnValue;
		}
		String userId = ShiroUtils.getCurrentUser().getId();
		if (StringUtils.isBlank(userId)) {
			return returnValue;
		}
		String sql = "SELECT distinct(c.id) FROM `t_oa_schedule` as c ,`t_oa_schedule_depart` as cd,`t_s_depart` as d ,`t_s_user` as s, `t_oa_schedule_user` as su where ((c.id=cd.schedule_id and d.id=cd.depart_id and d.id = ?) OR ( c.id =su.schedule_id and s.id=su.user_id and s.id=?)) and (executetime > ? and executetime < ?)";
		if (date == null) {
			date = new Date();
		}
		List<Record> idRecords = Db.find(
				sql,
				new Object[] { orgId, userId,
						OaDateUtils.getMinTimeInMonth(date),
						OaDateUtils.getMaxTimeInMonth(date) });
		if (CollectionUtils.isEmpty(idRecords)) {
			return returnValue;
		}
		StringBuffer sb = new StringBuffer("(");
		for (Record idRecord : idRecords) {
			sb.append("'" + idRecord.getStr("id") + "',");
		}
		sb.deleteCharAt(sb.length() - 1);
		sb.append(")");
		String resultSql = "SELECT distinct(c.executetime) FROM `t_oa_schedule` as c where c.id in "
				+ sb.toString() + " ORDER BY executetime ASC";

		System.out.println(resultSql);
		List<Record> result = Db.find(resultSql);
		for (Record r : result) {
			returnValue.add(Integer.valueOf(OaDateUtils.getDayByDate(r
					.getTimestamp("executetime"))));
		}
		return returnValue;
	}
}
