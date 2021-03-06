package com.lq.lss.controller.stock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Value;
import com.lq.springmvc.i18n.I18nModelAndView;
import com.lq.util.JSONUtil;

import net.sf.json.JSONArray;

import com.lq.easyui.dto.ResultDto;
import com.lq.lss.constant.PermResourceConst;
import com.lq.lss.controller.shiro.ShiroBaseController;
import com.lq.lss.controller.util.AjaxModelAndViewUtils;
import com.lq.lss.controller.util.LoginSessionUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lq.lss.model.AdminDept;
import com.lq.lss.model.CStockCompensate;
import com.lq.lss.model.CStockCompensateDetail;
import com.lq.lss.model.SessionUser;
import com.lq.lss.core.service.AdminAuditLogService;
import com.lq.lss.core.service.AdminDeptService;
import com.lq.lss.core.service.CStockCompensateDetailService;
import com.lq.lss.core.service.CStockCompensateService;
import com.lq.lss.dto.CStockCompensateDetailDto;
import com.lq.lss.dto.CStockCompensateDto;
import com.lq.lss.dto.CStockTemporaryDetailDto;
import com.lq.lss.dto.CStockTemporaryDto;
import com.lq.lss.enums.TradeType;

/**
 *
 * @author  作者: hzx
 * @date 创建时间: 2016-12-28 15:32:42
 */
@Controller
@RequestMapping(value ="/user/stock/stockcompensateupdate.htm")
public class CStockCompensateUpdateController extends ShiroBaseController<CStockCompensate, String, CStockCompensateService>{
	
	@Resource
	private CStockCompensateService cStockCompensateService;
	@Resource
	private CStockCompensateDetailService cStockCompensateDetailService;
	@Resource
	private AdminAuditLogService adminAuditLogService;
	@Resource
	private AdminDeptService deptService;
	@Value("/stock/stock_compensate_edit")
	private String indexView;
	
	
	@RequestMapping
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
		SessionUser user = LoginSessionUtils.getUserInSession(request);
		String compensateSerialno=ServletRequestUtils.getStringParameter(request, "id", "");
		String loginName=ServletRequestUtils.getStringParameter(request, "loginName", "");
		AdminDept adminDept= deptService.get(user.getCenterId());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		modelMap.put("add", PermResourceConst.STOCK_CMPENSATE_ADD);
        modelMap.put("update", PermResourceConst.STOCK_CMPENSATE_UPDATE);
        modelMap.put("del", PermResourceConst.STOCK_CMPENSATE_DEL);
        modelMap.put("check", PermResourceConst.STOCK_CMPENSATE_CHECK);
        CStockCompensate cStockCompensate=cStockCompensateService.get(compensateSerialno);
        List<CStockCompensateDetailDto>  detailList=cStockCompensateDetailService.findCStockCompensateDetail(compensateSerialno);
        cStockCompensate.setOperName(user.getLoginName());
        cStockCompensate.setLoginName(loginName);
        cStockCompensate.setCompensateSerialno(compensateSerialno);
        modelMap.put("cStockCompensate", cStockCompensate);
		modelMap.put("detailList", detailList);
		modelMap.put("adminDept", adminDept);
		
		if (useI18n) {
			return new I18nModelAndView(request, indexView, modelMap);
		}
		return new ModelAndView(indexView, modelMap);
	}
	
	@RequestMapping(params = "method=updateStockCompensate")
	@RequiresPermissions(PermResourceConst.STOCK_CMPENSATE_UPDATE)
	public ModelAndView updateStockCompensate(HttpServletRequest request, HttpServletResponse response,
			CStockCompensateDto cStockCompensateDto) {
		SessionUser user = LoginSessionUtils.getUserInSession(request); 
		ResultDto<String> resultDto = null;
		try {
			cStockCompensateDto.setDeptid(user.getCenterId());
			 String listStr=request.getParameter("rows");
			 JSONArray json=JSONArray.fromObject(listStr);
			 List<CStockCompensateDetailDto> dataList =(List<CStockCompensateDetailDto>)JSONArray.toCollection(json, CStockCompensateDetailDto.class);
			 cStockCompensateDto.setcStockCompensateDetailDtos(dataList);
			 if(cStockCompensateDto!=null){
				 resultDto= cStockCompensateService.updateCStockCompensateRdTx(cStockCompensateDto, user);
				 adminAuditLogService.log(user.getUserId(), TradeType.STOCK_COMPENSATE.getType(),"修改赔偿单",cStockCompensateDto,0L);
			 }
	
			} catch (Exception e) {
				 logger.error("提交赔偿数据出现异常", e);
				 resultDto=new ResultDto<String>(false,"数据提交失败");
		}
		
		return AjaxModelAndViewUtils.writeMsgReturnNull(response, JSONUtil.toJSonString(resultDto));
	}
	
	
}
