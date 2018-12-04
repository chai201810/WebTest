package com.dy.AutoTest.web.business;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;


import com.dy.AutoTest.OperationPlatform.POJO.UserIncomeExpenditureDetailBean;
import com.dy.AutoTest.OperationPlatform.POJO.UserInfoQueryBean;
import com.dy.AutoTest.OnlineCashier.POJO.OnlineCashierB2BBean;
import com.dy.AutoTest.OnlineCashier.POJO.OnlineCashierB2CBean;
import com.dy.AutoTest.OnlineCashier.PageObject.accountmanage.AccountManageInternalAccountManagePage;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageInternalAccountHistoryBalanceBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageInternalAccountManageBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageItemManageBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageItemRelationBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageManualAccountCheckBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageManualSingleAccountBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageSceneComprehensiveBean;
import com.dy.AutoTest.OnlineCashier.POJO.AccountManageYesterdayWholeQueryBean;
import com.dy.AutoTest.OnlineCashier.POJO.CooperatingAgentInfoBean;
import com.dy.AutoTest.OnlineCashier.POJO.CooperatingPaymentChannelBean;
import com.dy.AutoTest.OnlineCashier.POJO.CooperatingRouteInfoBean;
import com.dy.AutoTest.OnlineCashier.POJO.CooperatingServiceChannelBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelBalanceAccountBatchNumQueryBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelBalanceAccountErrorManageBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelBalanceAccountParameterBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageFlowQueryBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageInfoBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageRateCodeBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageRateMaintainBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageReturnCodeBean;
import com.dy.AutoTest.OnlineCashier.POJO.FinanceChannelManageSignManageBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdCardPhotoVerificationBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdCardValidDateVerificationBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationChannelBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationDetailsBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationQueryBean;
import com.dy.AutoTest.OnlineCashier.POJO.IdentityAuthenticationRouteBean;
import com.dy.AutoTest.OperationPlatform.POJO.MainChildMerRelationshipBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantAccountManagementBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantAuditBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantBalanceQueryBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantFeeRateBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantIncomeExpenditureDetailBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantInfoBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantInfoSearchBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantSettlementAlterBean;
import com.dy.AutoTest.OperationPlatform.POJO.MerchantSettlementBean;
import com.dy.AutoTest.OperationPlatform.POJO.OperBean;
import com.dy.AutoTest.OperationPlatform.POJO.OverdueMerInfoQueryBean;
import com.dy.AutoTest.OperationPlatform.POJO.UserAccountModifySearchBean;
import com.dy.AutoTest.OperationPlatform.POJO.UserActionBean;
import com.dy.AutoTest.web.beans.Data_URLBean;
import com.dy.AutoTest.web.dao.TestingDao;
import com.dy.AutoTest.web.dao.impl.TestingDaoImpl;
import com.dy.AutoTest.web.util.BaseUtil;

/**
 * @author Jerry
 * dto组装与赋值
 */
public class DataBusiness {
	private static TestingDao  testingDao=new TestingDaoImpl();
//	private static TestingDao  testingDao=new TestingDao(true);
	private Map<String , Object> map=null;
	private static List<Map<String, Object>> Data_URL_list=testingDao.getLocator("Data_URL");
	private Data_URLBean data_URLBean;
	private OperBean operBean;
	private MerchantInfoBean MerchantInfoBean;
	private MerchantAuditBean MerchantAuditBean;
	private MerchantSettlementBean MerchantSettlementBean;
	private MerchantFeeRateBean MerchantFeeRateBean;
	private OnlineCashierB2CBean OnlineCashierB2CBean;
	private OnlineCashierB2BBean OnlineCashierB2BBean;
	private UserInfoQueryBean UserInfoQueryBean;
	private UserAccountModifySearchBean UserAccountModifySearchBean;
	private UserIncomeExpenditureDetailBean UserIncomeExpenditureDetailBean;
	private UserActionBean UserActionBean;
	private MerchantInfoSearchBean MerchantInfoSearchBean;
	private MerchantSettlementAlterBean MerchantSettlementAlterBean;
	private MerchantBalanceQueryBean MerchantBalanceQueryBean;
	private MerchantIncomeExpenditureDetailBean MerchantIncomeExpenditureDetailBean;
	private MerchantAccountManagementBean MerchantAccountManagementBean;
	private OverdueMerInfoQueryBean OverdueMerInfoQueryBean;
	private MainChildMerRelationshipBean MainChildMerRelationshipBean;
	
	
	
	
	private List<Object> list;
	
	
	
	
	/**
	 * 为了测试时候使用，放开该空构造器，使用是需要配合loadData方法一起用
	 */
	public DataBusiness() { 
	}
	
	public DataBusiness(String tableName,String ID) {
		loadData(tableName, ID);
	}
	
	public static String getData_URL(String ID) {
//		loadData_URL();
		String url=BaseUtil.getMapTargetValue(Data_URL_list, "ID", ID, "URL");
		return url;
	}
	

	
	public void loadData(String tableName,String ID) {
		map=testingDao.getData(tableName,ID);
		switch (tableName) {
			case "POP_Data_MerchantAudit":
				MerchantAuditBean=new MerchantAuditBean();
				break;
			case "POP_Data_MerchantInfo":
				MerchantInfoBean=new MerchantInfoBean();
				break;
			case "POP_Data_MerchantSettlement":
				MerchantSettlementBean=new MerchantSettlementBean();
			case "POP_Data_MerchantFeeRate":
				MerchantFeeRateBean=new MerchantFeeRateBean();
				break;
			case "POP_Data_MerchantOper":
				
				break;
				
			case "POP_Data_UserInfoQuery":
				UserInfoQueryBean=new UserInfoQueryBean();
				break;
				
			case "POP_Data_Oper":
				operBean=new OperBean();
				break;
			case "Data_URL":
				data_URLBean=new Data_URLBean();
				break;

			default:
				System.out.println("table is not exist! Please check!");
				break;
		}
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getDataBean(String tableName,String ID) {
		
		T pojo=null;
		switch (tableName) {
			case "POP_Data_MerchantAudit":
				pojo=(T)testingDao.getData(tableName,ID,MerchantAuditBean.class);
				return pojo;
			case "POP_Data_MerchantInfo":
				pojo=(T)testingDao.getData(tableName,ID,MerchantInfoBean.class);
				return pojo;
			case "POP_Data_MerchantSettlement":
				pojo=(T)testingDao.getData(tableName,ID,MerchantSettlementBean.class);
				return pojo;
			case "POP_Data_MerchantSettlementAlter":
				pojo=(T)testingDao.getData(tableName,ID,MerchantSettlementAlterBean.class);
				return pojo;
			case "POP_Data_MerchantFeeRate":
				pojo=(T)testingDao.getData(tableName,ID,MerchantFeeRateBean.class);
				return pojo;
			case "POP_Data_MerchantInfoSearch":
				pojo=(T)testingDao.getData(tableName,ID,MerchantInfoSearchBean.class);
				return pojo;
			case "POP_Data_MerchantBalanceQuery":
				pojo=(T)testingDao.getData(tableName,ID,MerchantBalanceQueryBean.class);
				return pojo;
			case "POP_Data_MerchantIncomeExpenditureDetail":
				pojo=(T)testingDao.getData(tableName,ID,MerchantIncomeExpenditureDetailBean.class);
				return pojo;
			case "POP_Data_MerchantAccountManagement":
				pojo=(T)testingDao.getData(tableName,ID,MerchantAccountManagementBean.class);
				return pojo;
			case "POP_Data_OverdueMerInfoQuery":
				pojo=(T)testingDao.getData(tableName,ID,OverdueMerInfoQueryBean.class);
				return pojo;
			case "POP_Data_MainChildMerRelationship":
				pojo=(T)testingDao.getData(tableName,ID,MainChildMerRelationshipBean.class);
				return pojo;
			case "POP_Data_MerchantOper":
				
				break;
			case "POP_Data_UserInfoQuery":
				pojo=(T)testingDao.getData(tableName,ID,UserInfoQueryBean.class);
				return pojo;
			case "POP_Data_UserAccountModifySearch":
				pojo=(T)testingDao.getData(tableName,ID,UserAccountModifySearchBean.class);
				return pojo;
			case "POP_Data_UserIncomeExpenditureDetail":
				pojo=(T)testingDao.getData(tableName,ID,UserIncomeExpenditureDetailBean.class);
				return pojo;
			case "POP_Data_UserAction":
				pojo=(T)testingDao.getData(tableName,ID,UserActionBean.class);
				return pojo;
			case "POP_Data_Oper":
				pojo=(T)testingDao.getData(tableName,ID,OperBean.class);
				return pojo;
			case "Online_Data_Cashier_B2C":
				pojo=(T)testingDao.getData(tableName,ID,OnlineCashierB2CBean.class);
				return pojo;
			case "Online_Data_Cashier_B2B":
				pojo=(T)testingDao.getData(tableName,ID,OnlineCashierB2BBean.class);
				return pojo;				
				
			case "Data_URL":
				data_URLBean=new Data_URLBean();
				break;

			default:
				System.out.println("DataBusiness.getDataBean: "+tableName+" is not exist! Please check!");
				assertTrue(false);
		}
		return null;
	}
	
	/*
	public void loadDataRef(String tableName,String ID) { 
		switch (tableName) { 
			case "POP_Data_MerchantAudit":
				MerchantAuditBean=testingDao.getData(tableName,ID,MerchantAuditBean.class);
				break;
			case "POP_Data_MerchantInfo":
				MerchantInfoBean=testingDao.getData(tableName,ID,MerchantInfoBean.class);
				break;
			case "POP_Data_MerchantSettlement":
				MerchantSettlementBean=testingDao.getData(tableName,ID,MerchantSettlementBean.class);
				
				break;
			case "POP_Data_MerchantOper":
				
				break;
			case "POP_Data_Oper":
				operBean=testingDao.getData(tableName,ID,OperBean.class);
				break;
			case "Data_URL":
				data_URLBean=new Data_URLBean();
				break;

			default:
				System.out.println("table is not exist! Please check!");
				break;
		}
	}
	*/
	
	public void loadDataBeanList(String tableName) {
		switch (tableName) {
		case "POP_Data_MerchantAudit":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantAuditBean.class));
			break;
		case "POP_Data_MerchantInfo":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantInfoBean.class));
			break;
		case "POP_Data_MerchantSettlement":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantSettlementBean.class));
			break;
		case "POP_Data_MerchantSettlementAlter":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantSettlementAlterBean.class));
			break;
		case "POP_Data_MerchantFeeRate":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantFeeRateBean.class));
			break;
		case "POP_Data_MerchantInfoSearch":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantInfoSearchBean.class));
			break;
		case "POP_Data_MerchantBalanceQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantBalanceQueryBean.class));
			break;
		case "POP_Data_MerchantIncomeExpenditureDetail":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantIncomeExpenditureDetailBean.class));
			break;
		case "POP_Data_MerchantAccountManagement":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MerchantAccountManagementBean.class));
			break;
		case "POP_Data_OverdueMerInfoQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,OverdueMerInfoQueryBean.class));
			break;
		case "POP_Data_MainChildMerRelationship":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,MainChildMerRelationshipBean.class));
			break;
		case "POP_Data_MerchantOper":
			
			break;
			
		case "POP_Data_UserInfoQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,UserInfoQueryBean.class));
			break;
		case "POP_Data_UserAccountModifySearch":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,UserAccountModifySearchBean.class));
			break;
		case "POP_Data_UserIncomeExpenditureDetail":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,UserIncomeExpenditureDetailBean.class));
			break;
		case "POP_Data_UserAction":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,UserActionBean.class));
			break;
		case "POP_Data_Oper":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,OperBean.class));
			break;
		case "Online_Data_Cashier_B2C":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,OnlineCashierB2CBean.class));
			break;
		case "Online_Data_Cashier_B2B":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,OnlineCashierB2BBean.class));
			break;
		case "Data_URL":
			data_URLBean=new Data_URLBean();
			break;
		
		
		case "POP_Data_CooperatingAgencyInfo":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,CooperatingAgentInfoBean.class));
			break;
			
		case "POP_Data_CooperatingPaymentChannel":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,CooperatingPaymentChannelBean.class));
			break;
			
		case "POP_Data_CooperatingServiceChannel":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,CooperatingServiceChannelBean.class));
			break;
		
		case "POP_Data_CooperatingRouteInfo":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,CooperatingRouteInfoBean.class));
			break;
			
		case "POP_Data_IdentityAuthenticationChannel":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdentityAuthenticationChannelBean.class));
			break;
		
		case "POP_Data_IdentityAuthenticationRoute":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdentityAuthenticationRouteBean.class));
			break;
		
		case "POP_Data_IdentityAuthenticationDetails":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdentityAuthenticationDetailsBean.class));
			break;
			
		case "POP_Data_IdentityAuthenticationQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdentityAuthenticationQueryBean.class));
			break;
		
		case "POP_Data_IdCardPhotoVerification":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdCardPhotoVerificationBean.class));
			break;
		
		case "POP_Data_IdCardValidDateVerification":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,IdCardValidDateVerificationBean.class));
			break;
		
		case "POP_Data_FinanceChannelManageInfo":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageInfoBean.class));
			break;
		
		case "POP_Data_FinanceChannelManageFlowQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageFlowQueryBean.class));
			break;
			
		case "POP_Data_FinanceChannelManageReturnCode":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageReturnCodeBean.class));
			break;
			
		case "POP_Data_FinanceChannelManageSignManage":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageSignManageBean.class));
			break;
			
		case "POP_Data_FinanceChannelManageRateMaintain":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageRateMaintainBean.class));
			break;
			
		case "POP_Data_FinanceChannelManageRateCode":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelManageRateCodeBean.class));
			break;
			
		case "POP_Data_FinanceChannelBalanceAccountParameter":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelBalanceAccountParameterBean.class));
			break;
		
		case "POP_Data_FinanceChannelBalanceAccountBatchNumQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelBalanceAccountBatchNumQueryBean.class));
			break;
		
		case "POP_Data_FinanceChannelBalanceAccountErrorManage":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,FinanceChannelBalanceAccountErrorManageBean.class));
			break;	
		
		case "POP_Data_AccountManageItemManage":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageItemManageBean.class));
			break;	
			
		case "POP_Data_AccountManageItemRelation":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageItemRelationBean.class));
			break;	
			
		case "POP_Data_AccountManageInternalAccountManage":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageInternalAccountManageBean.class));
			break;	
			
		case "POP_Data_AccountManageInternalAccountHistoryBalance":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageInternalAccountHistoryBalanceBean.class));
			break;	
		
		case "POP_Data_AccountManageManualSingleAccount":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageManualSingleAccountBean.class));
			break;	
			
		case "POP_Data_AccountManageSceneComprehensive":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageSceneComprehensiveBean.class));
			break;	
			
		case "POP_Data_AccountManageManualAccountCheck":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageManualAccountCheckBean.class));
			break;	
			
		case "POP_Data_AccountManageYesterdayWholeQuery":
			list=BaseUtil.toObject(testingDao.getDataList(tableName,AccountManageYesterdayWholeQueryBean.class));
			break;	
			
			
			
			
		default:
			System.out.println("table "+tableName+" is not exist! Please check!");
			break;
		}
	}
	
	/**
	 * using loadDataBeanList(String tableName) method before this method 
	 * @return
	 */
	public Object[][] getDataBeanArray() {
		if(list==null) {
			System.out.println("DataBeanList is null! Please check!");
			assertTrue(false);
		}
		Object[][] results=new Object[list.size()][1];
		for (int i=0;i<list.size();i++) {
			results[i][0]=list.get(i);
		}
		return results;
	}
	
	public Data_URLBean getData_URLBean(){
		
		data_URLBean.setID((String)map.get("ID"));
		data_URLBean.setURL((String)map.get("URL"));
		data_URLBean.setComment((String)map.get("Comment"));
		
		return data_URLBean;
	}
	
	
/*	public boolean updateMerchantInfoStatusToPass(String merchantNO,String merchantName) {
		boolean flag=testingDao.updateMerchantInfoStatusToPass(merchantNO, merchantName);
		if(!flag) {
			System.out.println("没有找到商户："+merchantName+"的记录，更新数据库失败");
			assertTrue(false);
		}
		return flag;
	}*/
/*	
	public boolean updateMerchantInfoStatusToRefuse(String merchantName) {
		boolean flag=testingDao.updateMerchantInfoStatusToRefuse(merchantName);
		if(!flag) {
			System.out.println("没有找到商户："+merchantName+"的记录，更新数据库失败");
			assertTrue(false);
		}
		return flag;
	}
*/	
/*	public boolean insertMerchantSettlementInfo(String merchantNO,String merchantName) {
		boolean flag=testingDao.insertMerchantSettlementInfo(merchantNO, merchantName);
		if(!flag) {
			System.out.println("插入新数据失败");
			assertTrue(false);
		}
		return flag;
	}*/
	
/*	public boolean updateMerchantNextSettlementDate(int ID,String NextSettlementDate) {
		boolean flag=testingDao.updateMerchantNextSettlementDate(ID,NextSettlementDate);
		if(!flag) {
			System.out.println("update返回false，ID值不存在，导致更新“下一个结算日”失败");
			assertTrue(false);
		}
		return flag;
	}*/
	/*
	public boolean updateMerchantSettlementStatus(int ID,String Status) {
		boolean flag=testingDao.updateMerchantSettlementStatus(ID,Status);
		if(!flag) {
			System.out.println("update返回false，ID值不存在，导致更新“结算状态”失败");
			assertTrue(false);
		}
		return flag;
	}
	*/
/*	public boolean updateMerchantNOByID(int ID,String merchantNO) {
		boolean flag=testingDao.updateMerchantNOByID(ID,merchantNO);
		if(!flag) {
			System.out.println("update返回false，ID值不存在，导致更新“商户号”失败");
			assertTrue(false);
		}
		return flag;
	}*/
	
/*	public boolean updateSettlementByID(int ID,Map<String , String > map) {
		if(map==null) {
			System.out.println("In DataBusiness.updateSettlementByID(), map can not be null!");
			assertTrue(false);
		}
		boolean flag=testingDao.updateSettlementByID(ID,map);
		if(!flag) {
			System.out.println("update返回false，ID值或字段不存在，更新表失败");
			assertTrue(false);
		}
		return flag;
	}*/
/*	
	public boolean updateMerchantInfoByID(int ID,Map<String , String > map) {
		if(map==null || map.isEmpty()) {
			System.out.println("In DataBusiness.updateMerchantInfoByID(), map can not be null!");
			assertTrue(false);
		}
		boolean flag=testingDao.updateMerchantInfoByID(ID,map);
		if(!flag) {
			System.out.println("update返回false，ID值或字段不存在，更新表失败");
			assertTrue(false);
		}
		return flag;
	}
*/	
/*	
	public boolean insertMerchantFeeRate(String merchantNO,String merchantName) {
		boolean flag=testingDao.insertMerchantFeeRate(merchantNO, merchantName);
		if(!flag) {
			System.out.println("POP_Data_MerchantFeeRate表插入新数据失败");
//			Reporter.log("Reporter:POP_Data_MerchantFeeRate表插入新数据失败");
			assertTrue(false);
		}
		return flag;
	}
	*/
/*	public boolean insertMerchantProduct(String merchantNO,String merchantName) {
		boolean flag=testingDao.insertMerchantProduct(merchantNO, merchantName);
		if(!flag) {
			System.out.println("POP_Data_MerchantFeeRate表插入新数据失败");
//			Reporter.log("Reporter:POP_Data_MerchantFeeRate表插入新数据失败");
			assertTrue(false);
		}
		return flag;
	}
	*/
/*	public boolean insertMerchantProduct(Map<String , Object> map) {
		if(map==null || map.isEmpty()) {
			System.out.println("DataBusiness.insertMerchantProduct(): list mustn't be null or empty");
			assertTrue(false);
		}
		boolean flag=testingDao.insertMerchantProduct(map);
		if(!flag) {
			System.out.println("POP_Data_MerchantFeeRate表插入新数据失败");
//			Reporter.log("Reporter:POP_Data_MerchantFeeRate表插入新数据失败");
			assertTrue(false);
		}
		return flag;
	}*/
	
/*	
	public Map<String,Object> querySingleMerchantProduct(List<String> list,Map<String , String>map) {
		if(list.isEmpty()||list==null) {
			System.out.println("DataBusiness.queryMerchantProductByNO(): list mustn't be null or empty");
			assertTrue(false);
		}
		
		return testingDao.querySingleMerchantProduct(list,map);
	}
	*/
	public static Map<String, Object> querySingle(String tableName, List<String> selectList, Map<String, Object> whereMap) {
		if(selectList.isEmpty()||selectList==null) {
			System.out.println("DataBusiness.querySingle(): selectList mustn't be null or empty");
			assertTrue(false);
		}
		return testingDao.querySingle(tableName,selectList,whereMap);
	}
	
	public static List<Map<String, Object>> queryMore(String tableName, List<String> selectList,
			Map<String, Object> whereMap) {
		if(selectList.isEmpty()||selectList==null) {
			System.out.println("DataBusiness.queryMore(): selectList mustn't be null or empty");
			assertTrue(false);
		}
		return testingDao.queryMore(tableName,selectList,whereMap);
	}
	
	public static boolean updateTestData(String tableName, Map<String, Object> updateMap, Map<String, Object> whereMap) {
		if(updateMap==null || updateMap.isEmpty()) {
			System.out.println("In DataBusiness.updateTestData(), updateMap can not be null!");
			assertTrue(false);
		}
		boolean flag=testingDao.updateTestData(tableName,updateMap,whereMap);
		
		if(!flag) {
			System.out.println("DataBusiness.updateTestData(): update返回false，更新表失败");
			assertTrue(false);
		}
		return flag;
	}
	
	public static boolean updateTestData(String tableName, Map<String, Object> updateMap, Map<String, Object> whereMap,boolean existExpression) {
		if(updateMap==null || updateMap.isEmpty()) {
			System.out.println("In DataBusiness.updateTestData(), updateMap can not be null!");
			assertTrue(false);
		}
		boolean flag=testingDao.updateTestData(tableName,updateMap,whereMap,existExpression);
		
		if(!flag) {
			System.out.println("DataBusiness.updateTestData(): update返回false，更新表失败");
			assertTrue(false);
		}
		return flag;
	}
	
	public static boolean insertTestData(String tableName, Map<String, Object> insertMap) {
		if(insertMap==null || insertMap.isEmpty()) {
			System.out.println("DataBusiness.insertTestData(): map mustn't be null or empty");
			assertTrue(false);
		}
		boolean flag=testingDao.insertTestData(tableName,insertMap);
		if(!flag) {
			System.out.println(tableName+"表插入新数据失败");
			assertTrue(false);
		}
		return flag;
	}
	/****************Bean **********************/
/*	
	public OperBean getOperBean(){
		operBean.setOperID((String)map.get("OperID"));
		operBean.setPassword((String)map.get("password"));
		operBean.setMobileNO((String)map.get("mobileNO"));
		operBean.setComment((String)map.get("comment"));
		return operBean;
	}*/
	/*
	public MerchantInfoBean getMerchantInfoBean(){
		MerchantInfoBean.setID((Integer)map.get("ID"));
		MerchantInfoBean.setA_MerchantType((String)map.get("A_MerchantType"));
		MerchantInfoBean.setA_MerchantName((String)map.get("A_MerchantName"));
		MerchantInfoBean.setA_shortName((String)map.get("A_shortName"));
		MerchantInfoBean.setA_mcc_super((String)map.get("A_mcc_super"));
		MerchantInfoBean.setA_mcc((String)map.get("A_mcc"));
		MerchantInfoBean.setA_Province((String)map.get("A_Province"));
		MerchantInfoBean.setA_City((String)map.get("A_City"));
		MerchantInfoBean.setA_Business_Address((String)map.get("A_Business_Address"));
		MerchantInfoBean.setA_Account_Permits((String)map.get("A_Account_Permits"));
		MerchantInfoBean.setA_Merchant_Property((String)map.get("A_Merchant_Property"));
		MerchantInfoBean.setA_Business_License((String)map.get("A_Business_License"));
		MerchantInfoBean.setA_Business_License_StartDate((String)map.get("A_Business_License_StartDate"));
		MerchantInfoBean.setA_Business_License_ExpiredDate((String)map.get("A_Business_License_ExpiredDate"));
		MerchantInfoBean.setA_Business_Scope((String)map.get("A_Business_Scope"));
		MerchantInfoBean.setA_Registered_Capital((String)map.get("A_Registered_Capital"));
		MerchantInfoBean.setA_Registered_Address((String)map.get("A_Registered_Address"));
		MerchantInfoBean.setA_Organization_Code((String)map.get("A_Organization_Code"));
		MerchantInfoBean.setA_Tax_Registration_Certificate((String)map.get("A_Tax_Registration_Certificate"));
		MerchantInfoBean.setA_CorpName((String)map.get("A_CorpName"));
		MerchantInfoBean.setA_CorpID_Type((String)map.get("A_CorpID_Type"));
		MerchantInfoBean.setA_CorpID((String)map.get("A_CorpID"));
		MerchantInfoBean.setA_CopID_StartDate((String)map.get("A_CopID_StartDate"));
		MerchantInfoBean.setA_CopID_ExpiredDate((String)map.get("A_CopID_ExpiredDate"));
		MerchantInfoBean.setB_StoreName((String)map.get("B_StoreName"));
		MerchantInfoBean.setB_StoreShortName((String)map.get("B_StoreShortName"));
		MerchantInfoBean.setB_Store_Address((String)map.get("B_Store_Address"));
		MerchantInfoBean.setB_Store_PhoneNO((String)map.get("B_Store_PhoneNO"));
		MerchantInfoBean.setB_Business_Hours((String)map.get("B_Business_Hours"));
		MerchantInfoBean.setC_Controller_Type((String)map.get("C_Controller_Type"));
		MerchantInfoBean.setC_ControllerName((String)map.get("C_ControllerName"));
		MerchantInfoBean.setC_ControllerID_Type((String)map.get("C_ControllerID_Type"));
		MerchantInfoBean.setC_ControllerID((String)map.get("C_ControllerID"));
		MerchantInfoBean.setC_ControlleID_StartDate((String)map.get("C_ControlleID_StartDate"));
		MerchantInfoBean.setC_ControlleID_ExpiredDate((String)map.get("C_ControlleID_ExpiredDate"));
		MerchantInfoBean.setC_Stakeholder_Type((String)map.get("C_Stakeholder_Type"));
		MerchantInfoBean.setC_StakeholderName((String)map.get("C_StakeholderName"));
		MerchantInfoBean.setC_StakeholderID_Type((String)map.get("C_StakeholderID_Type"));
		MerchantInfoBean.setC_StakeholderID((String)map.get("C_StakeholderID"));
		MerchantInfoBean.setC_Stakeholder_StartDate((String)map.get("C_Stakeholder_StartDate"));
		MerchantInfoBean.setC_Stakeholder_ExpiredDate((String)map.get("C_Stakeholder_ExpiredDate"));
		MerchantInfoBean.setD_Introduce_Channel((String)map.get("D_Introduce_Channel"));
		MerchantInfoBean.setD_AgreementNO((String)map.get("D_AgreementNO"));
		MerchantInfoBean.setD_AgreementExpiredDate((String)map.get("D_AgreementExpiredDate"));
		MerchantInfoBean.setD_HandlerName((String)map.get("D_HandlerName"));
		MerchantInfoBean.setD_HandlerID_Type((String)map.get("D_HandlerID_Type"));
		MerchantInfoBean.setD_HandlerID((String)map.get("D_HandlerID"));
		MerchantInfoBean.setD_Handler_StartDate((String)map.get("D_Handler_StartDate"));
		MerchantInfoBean.setD_Handler_ExpiredDate((String)map.get("D_Handler_ExpiredDate"));
		MerchantInfoBean.setH_MerchantAdminName((String)map.get("H_MerchantAdminName"));
		MerchantInfoBean.setH_MerchantAdmin_MobileNO((String)map.get("H_MerchantAdmin_MobileNO"));
		MerchantInfoBean.setH_MerchantAdmin_Email((String)map.get("H_MerchantAdmin_Email"));
		MerchantInfoBean.setH_MerchantInterfaceType((String)map.get("H_MerchantInterfaceType"));

		return MerchantInfoBean;
	}
		*/
	/*public MerchantAuditBean getMerchantAuditBean() {
		MerchantAuditBean.setID(String.valueOf(map.get("ID")));
		MerchantAuditBean.setOperID((String)map.get("OperID"));
		MerchantAuditBean.setTransactionName((String)map.get("TransactionName"));
		MerchantAuditBean.setKeyInfo((String)map.get("KeyInfo"));
		MerchantAuditBean.setComment((String)map.get("Comment"));
		
		return MerchantAuditBean;
	}*/

	public MerchantSettlementBean getMerchantSettlementBean(){

	    return MerchantSettlementBean;
	}
	
	public MerchantFeeRateBean getMerchantFeeRateBean(){

	    return MerchantFeeRateBean;
	}



}
