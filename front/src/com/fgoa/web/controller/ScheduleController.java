package com.fgoa.web.controller;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.fgoa.web.model.Schedule;
import com.fgoa.web.service.ScheduleService;
import com.fgoa.web.utils.DateFormatUtils;
import com.fgoa.web.utils.OaDateUtils;
import com.fgoa.web.vo.CalendarVo;
import com.jfinal.core.Controller;
import com.woo.jfinal.exception.BizException;

public class ScheduleController extends Controller {
	public void index() {
		setAttr("cal", new CalendarVo());
		String datetime = getPara("datetime");
		Date queryDate = null;
		if (StringUtils.isNotBlank(datetime)) {
			try {
				queryDate = DateFormatUtils.convertToDate(
						DateFormatUtils.SHORT_FORMAT, datetime);
				setAttr("queryDay", OaDateUtils.getDayInMonth(queryDate));

				if (queryDate != null) {
					Date now = new Date();
					Calendar cal = Calendar.getInstance();
					cal.setTime(now);
					int nowMonth = cal.get(Calendar.MONTH);
					int nowYear = cal.get(Calendar.YEAR);

					cal.setTime(queryDate);
					int queryMonth = cal.get(Calendar.MONTH);
					int queryYear = cal.get(Calendar.YEAR);
					if (queryYear - nowYear == 1) {
						queryMonth += 12;
					} else if (nowYear - queryYear == 1) {
						queryMonth -= 12;
					}

					boolean goPre = false;
					boolean goNext = false;
					if (nowMonth == queryMonth) {
						setAttr("cal", new CalendarVo());
						goNext = true;
					} else if ((queryMonth - nowMonth) < 4) {
						setAttr("cal", new CalendarVo(queryDate));
						goPre = true;
						goNext = true;
					} else if ((queryMonth - nowMonth) == 4) {
						setAttr("cal", new CalendarVo(queryDate));
						goPre = true;
						goNext = false;
					} else {
						redirect("/schedule");
					}

					setAttr("goPre", goPre);
					setAttr("goNext", goNext);
				}

			} catch (Exception e) {
				redirect("/schedule");
			}
		} else {
			setAttr("goNext", true);
		}
		if (queryDate == null) {
			queryDate = new Date();
		}

		setAttr("schedules", Schedule.dao.queryScheduleByDateRange(OaDateUtils.getMinTimeInDay(queryDate),OaDateUtils.getMaxTimeInDay(queryDate)));
		setAttr("events", Schedule.dao.queryEventDaysInMonth(queryDate));
		render("schedule.ftl");
	}

	public void submitLeaveInfo() {
		Integer type = getParaToInt("type");
		String typeDesc = getPara("typeDesc");
		Date startDate = getParaToDate("startDate");
		Date endDate = getParaToDate("endDate");
		boolean isHalfDay = getParaToBoolean("isHalfDay") == null ? false
				: true;

		try {
			ScheduleService.instance.submitLeavelApply(type, typeDesc,
					startDate, endDate, isHalfDay);
		} catch (BizException e) {
			setAttr("errorMsg", e.getMessage());
			render("schedule3.ftl");
		}
		redirect("/schedule");
	}

	public void leavePage() {
		render("schedule3.ftl");
	}

	public void approvalLeavePage() {
		render("schedule2.ftl");
	}
}
