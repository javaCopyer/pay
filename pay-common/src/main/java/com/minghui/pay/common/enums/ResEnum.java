package com.minghui.pay.common.enums;

public enum ResEnum {
	/**
	 * 通用
	 */
	SUCCESS("000000","操作成功"),
	FAILURE("000001","操作失败"),
	PARAMS_IS_NULL("000002","无效参数"),
	NOT_ENOUGH_MONEY("000003","账户余额不足"),
	NOT_PERMISSION("000004","无权限访问"),
	NOT_LOGIN("000005","请登录"),
	NOT_LOCATION_LOGIN("000007","会话过期,请重新登录!"),
	SYSTEM_MAINTAIN("000008","该平台维护,请您随时关注官网公告"),
	ACTIVITY_NOT_LOGIN("000009","请先登录,才能参加活动"),
	ACTIVITY_NOT_LOCATION_LOGIN("000010","您已在别处登录，请重新参加活动"),
	DATAREADFAILED("000011","数据获取失败"),
	LOTTERY_CLOSE_PAN("000012","已封盘"),
	LOTTERY_PROHIBIT_LOGIN("000013","该账户已被禁止登陆！"),
	CHAT_USER_HAS_LIMIT("000014","对不起您的账号已被封禁！"),
	USER_GET_INTEGRAL_SUCCESS("000015","恭喜您获得{0}个金币!"),
	FREQUENT_OPERATION("000016","请勿频繁操作!"),
	NOT_REGION("000017","未配置区域!"),

	/**
	 * 鉴权
	 */
	AUTH_INVALID_CLIENT("100001","client_id或client_secret参数无效"),
	AUTH_EXPIRED_TOKEN("100002","token过期"),
	AUTH_ACCESS_DENIED("100003","用户或授权服务器拒绝授予数据访问权限"),
	AUTH_NOTEMPTY_HEADER("100004","无效基础参数"),
	AUTH_EXCEPTION("100005","鉴权失败"),
	AUTH_NOT_VERSION("100006","app版本错误"),
	AUTH_ERROR_SIGNTURE("100007","签名错误"),
	AUTH_NOT_SIGNTURE("100008","签名参数为空"),
	ACTIVITY_AUTH_EXPIRED_TOKEN("100009","活动的token过期"),
	ACTIVITY_INVALID_HEADER("100010","活动请求头为空"),
	INVAILD_SYMBOL("100011","非法字符"),
	AUTH_EXPIRED_COOKIE("100012","会话过期，请重新登录！"),

	/**
	 * 会员中心
	 */
	USER_NOT_FOUND("200001","用户名不存在"),
	USER_LOGIN_ERROE_PWD_PARAM("200002","密码错误"),
	USER_LOGIN_STATUS_PARAM("200003","该用户已被冻结,请联系24小时在线客服"),
	USER_REGISTER_INVALID_USERNAME("200004","用户名长度4到12位,由英文字母,数字组成"),
	USER_REGISTER_INVALID_LOGINPWD("200005","登录密码长度6到16位，由英文字母,数字或特殊字符组成"),
	USER_REGISTER_INVALID_WITHDRAWPWD("200006","请正确输入4位数字资金密码"),
	USER_REGISTER_EXIST_USERNAME("200007","该用户名已存在"),
	USER_REGISTER_INVALID_QQ("200008","请正确输入QQ号码"),
	USER_EMAIL_NOT_EXACTNESS("200009", "请正确输入邮箱地址"),
	BANK_CARD_NOT_EXACTNESS("200010","请正确输入银行卡号"),
	USER_REGISTER_INVALID_MOBILE("200011","请正确输入手机号码"),
	USER_REGISTER_NOEEQ_LOGINPWD("200012","两次密码不一致,请重新输入"),
	USER_PWD_CHANGES_FAILED_CODE("200013","密码修改失败,请联系24小时在线客服"),
	USER_PWD_EQUAL("200014","新旧密码一致,请重新输入"),
	BANK_INFO_IS_NULL("200015","请绑定银行卡后再提款"),
	PAY_IS_REQUIRED("200016","无效支付类型"),
	PAYMENT_ERROR("200017","无效付款方式"),
	MEMBER_DEFINED("200018","用户名:{0}该用户类型下，没有绑定在线支付方式"),
	BANK_LIMIT_EXCEEDED("200019","已超出绑定银行卡最大限制"),
	BANK_BINDING_DUPLICATE("200020","请勿重复绑定银行卡"),
	USER_ACCOUNT_FREEZE("200022","密码输入错误超过限制，帐号被冻结。请联系我们24小时在线客服！"),
	USER_ACCOUNT_FREEZE_WARN("200023","密码输入错误，超过{0}次将被冻结。目前第{1}次"),
	ZJ_PWD_FREEZE("200024","资金密码输入错误超过限制，资金操作被冻结。请联系我们24小时在线客服！"),
	ZJ_PWD_FREEZE_WARN("200025","资金密码输入错误，超过{0}次将被冻结。目前第{1}次"),
	USER_AGENT_APPLY_SUCCESS("200026","您的申请已经提交，请等待我们的审核,谢谢！"),
	MESSAGE_NOT_FOUND("200027","未获取到信息详情"),
	WITHDRAW_MIN_MONEY("200028","最低兑换积分{0}分"),
	PAY_MONEY("200029","充值金额范围{0}-{1}元"),
	DEPOSIT_AMOUNT_LESS("200030","最低充值金额{0}元"),
	AGENT_INFO("200031","代理信息"),
	AGENT_TYPE("200032","代理类型"),
	INVALID_AGENT_TYPE("200033","无效代理类型"),
	INVALID_BANK_INFO("200034","银行卡信息异常"),
	NO_GESTURE_PWD("200035","您暂未设置手势密码,请先设置"),
	SET_GESTURE_PWD("200036","您已经设置过手势密码"),
	GESTURE_PWD_STOP("200037","您已经停用手势密码,请先开启"),
	GESTURE_PWD_ERROR("200038","请正确输入4-9位手势密码"),
	INFO_ERROR("200039","请完整个人资料后再进行资金操作"),
	MODIFY_USER_INFO("200040","请联系24小时在线客服修改个人资料"),

	ZJ_PWD_FREEZE_DETAIL("200041","用户{0}资金密码输入错误超过限制，资金操作被冻结。请联系我们24小时在线客服！"),
	USER_LOGIN_STATUS_PARAM_DETAIL("200042","用户{0}已被冻结,请联系24小时在线客服！"),
	USER_DEFAULT_IS_NULL("200043","系统默认配置用户为空,请联系24小时在线客服！"),
	USER_DEFAULT_NOT_EXIST("200044","系统默认配置用户不存在,请联系24小时在线客服！"),
	USER_DEFAULT_NOT_AGEBNT("200045","系统默认配置用户不是代理用户,请联系24小时在线客服！"),
	BACK_DEFAULT_IS_NULL("200046","系统默认配置返水为空,请联系24小时在线客服！"),
	BACK_DEFAULT_NOT_RIGHT("200047","系统默认配置返水不是有效的double数据,请联系24小时在线客服！"),
	BACK_DEFAULT_NO_RIGHT("200048","系统默认配置返水不合理,请联系24小时在线客服！"),
	DEFAULT_PASSWORD_IS_NULL("200049","系统默认密码为空,请联系24小时在线客服！"),
	DEFAULT_PASSWORD_NOT_RIGHT("200050","系统默认密码不合符规则,请联系我们24小时在线客服！"),
	LINK_ACCOUNT_NOT_EXIST("200051","操作失败,推广链接对应的用户名不存在"),
	USER_MONEY_TOO_MATCH("200052","当前登录用户的账户余额不足"),
	USER_REGISTER_INVALID_REALNAME("200053","请正确输入2到5位真实中文姓名"),
	USER_LEVEL_TOO_MAX("200054","当前登录用户层级已达到最大层级数不能注册下级代理"),
	USER_ACCOUNT_NOT_RIGHT("200055","请输入4-16位数字/字母或组合作为帐号"),
	LINK_NOT_EXIST("200056","无效参数推广链接不存在"),
	USER_ACCOUNT_NOT_AGENT("200057","当前登录用户不是代理类型不能注册下级"),
	SALARY_MONEY_NOT_RIGHT("200058","合理的日薪金额范围{0}-{1}元"),
	PERSON_COUNT_NOT_RIGHT_MIN("200059","投注人数要求最少{0}个"),
	PERSON_COUNT_NOT_RIGHT_MAX("200060","投注人数要求最多{0}个"),
	SALARY_REPORT_HAVE_PAY("200061","该记录已经派送了日薪"),
	RECORD_USERNAME_NOT_EXIST("200062","操作失败,该记录对应的用户名不存在"),
	BACK_COUNT_NOT_RIGHT("200063","合理的{0}返水比例为{1}%-{2}%"),
	PROMOTION_LINK_NOT_VALID("200064","该链接已经失效不能注册"),
	PARAMS_SALARY_IS_EXIST("200065","该用户账号已经存在日薪信息"),
	PARAMS_SALARY_NOT_EXIST("200066","该用户账号不存在日薪信息"),
	LINK_ACCOUNT_NOT_AGENT("200067","当前登录用户不是代理类型不能生成推广链接"),
	MEMBER_HUODONG("200068","绑定手机号，赠送{0}元免费彩金！"),
	USER_NOT_AGENT_PARENT("200069","当前登录用户对应的父级代理为空"),
	USER_REGISTER_INVALID_LOGINPASSWORD("200070","请输入6-16位数字/字母或组合作为密码"),
	CLIENT_IP_REGISTER_TOO_MATCH("200071","同一ip一天最多注册{0}次"),

	USER_HEADNAME_IS_NULL("200072","无效基础参数,登录账号为空"),
	USER_HEADNAME_NOT_RIGHT("200073","无效基础参数,请输入4-16位数字/字母或组合作为登录账号"),
	USER_HEADNAME_NOT_EXIST("200074","无效基础参数,登录账号不存在"),
	SALARY_REPORT_HAVE_DELETED("200075","该日薪记录已经被删除"),
	USER_DEFAULT_NOT_VALID("200076","系统默认配置用户被冻结"),
	BACK_COUNT_NOT_CHANGE("200077","返水比例与原值相同"),
	USER_REMARK_TOO_LENGTH("200078","备注过长超过了最大长度{0}个字符"),
	USER_ZJPD_STATUS_PARAM("200079","该用户资金密码被冻结,请联系24小时在线客服"),
	USER_REGISTER_INVALID_SKYPE("200080","请正确输入skype账号"),
	USER_REGISTER_INVALID_WX("200081","请正确输入微信账号"),
	PROMOTION_LINK_PASSWORD_IS_NULL("200082","无效参数,该链接对应的密码为空"),
	USER_QQ_HAS("200083","账户QQ号不能修改！"),
	USER_MAIL_HAS("200084","账户邮箱号码不能修改！"),
	USERNICKNAME_MAIL_HAS("200085","账户昵称不能修改！"),
	USERNICKNAME_ERROR("200086","请设置10个字符以内的昵称！"),
	CONNECTION_ALL_EMPTY("200087","请至少填写一种联系方式！"),
	AGENT_BACK_VALUE_NOT_RIGHT("200088","系统默认配置上级最大回扣值为空,请联系24小时在线客服！"),
	
	USER_REGISTER_MANAGE_NOT_EXIST("200089","系统默认管理员好友未配置,请联系24小时在线客服！"),
	USER_REGISTER_MANAGE_NOT_GROUP("200090","系统默认管理员默认分组未配置,请联系24小时在线客服！"),
	USER_REGISTER_PHONE_HAS_EXIST("200091","该手机号已注册！"),
	USER_ACCOUNT_CREATE_FAIL("200092","用户名生成失败！"),
	USER_HAS_BAND_PHONE("200093","对不起您已经绑定手机！"),
	USER_HAS_BAND_QQ("200094","对不起您已经绑定QQ！"),
	USER_BAND_QQ_HAS_EXIST("200095","对不起该QQ号已经被使用！"),
	USER_HAS_BAND_WX("200096","对不起您已经绑定微信！"),
	USER_BAND_WX_HAS_EXIST("200097","对不起该微信号已经被使用！"),
	USER_HAS_BAND_ZFB("200098","对不起该您已经绑定支付宝！"),
	USER_BAND_ZFB_HAS_EXIST("200099","对不起该支付宝帐号已经被使用！"),
	
	USER_REGISTER_INVALID_ZFB("200100","请正确输入支付宝账号"),
	USER_REAL_NAME_BAND_ZFB("200101","请正确输入中文真实姓名"),	
	USER_CHANGE_TOKEN_VALIDATE_ERROR("200102","用戶更新密碼token驗證失敗！"),	
		
	/***
	 * MobileSmsVerif模块
	 */
	MOBILESMSVERIF_NOT_FIND("200040","未发现相关验证信息"),
	ZJ_HAS("200041","已经绑定资金密码"),
	USERNAME_HAS("200042","已经绑定持卡人姓名"),
	USERMOBILE_HAS("200043","已经绑定手机号"),
	USERMOBILE_NOT_FOUND("200044","该用户未绑定手机号"),
	USERMOBILE_SYSTEM_HAS("200045","该手机号已被绑定, 请更换手机号!"),
	USERMOBILE_ERROR("200046","用户名与手机号不匹配!"),
	/**
	 * 体育
	 */
	MATCH_NOT_FOUND("300001","该赛事不存在或已过期"),
	MATCH_COUNT_LESS("300002","串关至少选择三场赛事"),
	//MATCH_MONEY_LIMIT("300003","下注金额不能低于{0}元"),
	//MATCH_MONEY_MAX("300004","下注金额不能超过{0}元"),
	MATCH_NOT_ANY("300005","暂无赛事"),
	MATCH_BET_UNNORMAL("300006","投注异常"),
	MATCH_BETRECORD_UNNORMAL("300007","下注失败,请重试"),
	MATCH_MONEY_LIMIT("300008","单注最低{0}元,单注最高{1}元"),
	MATCH_SINGLE_MONEY_LIMIT("300009","赛事累计限额最高{0}元,您共投注{1}元"),
	/**
	 * 彩票
	 */
	CP_GAME_NOT_ERROR("400001","彩种不存在"),
	CP_PLAYER_NOT_ERROR("400002","玩法不存在"),
	CP_PERIODS_NOT_ERROR("400003","期数限制"),
	CP_CLOSE_PAN("400004","该期已封盘"),
	CP_INVALID_ORDER_FORMAT_CODE("400005","下注内容格式不正确"),
	CP_INVALID_PRARAM_PAN("400006","非法参数"),
	CP_RESULTS_EXISTS_CODE("400007","已开奖下单异常"),
	CP_REVERSE_BET_CODE("400008","禁止逆向投注"),
	CP_LIMIT_BET_CODE("400009","金额超过最大限额"),
	CP_NOT_AUTHORITY("400010","用户无权限访问平台"),
	CP_LIMIT_BET_RATE("400011","盈利率或单期倍数设置过大"),
	CP_LIMIT_SINGLE_BET_RATE("400012","单笔金额超过最大限度"),
	CP_LIMIT_BET_MULTIPLE("400013","订单追号倍数超过限制"),
	CP_STATUS_SALE("400014","彩种已停售"),
	CP_STATUS("400015","彩种已停用"),
	CP_INTERFAILED("400016","接口信息出错"),
	CP_NOTSUPPORT("400017","不支持高返模式"),
	CP_LIMIT_BET_QS("400018","订单追号期数超过限制"),
	CP_PK_STATUS_SALE("400019","盘口已停售"),
	CP_PK_STATUS("400020","盘口已停用"),
	CP_PKGROUP_STATUS_SALE("400021","盘口组已停售"),
	CP_PKGROUP_STATUS("400022","盘口组已停用"),
	CP_PKGROUPDETAIL_STATUS_SALE("400023","盘口组已停售"),
	CP_PKGROUPDETAIL_STATUS("400024","盘口组已停用"),
	ORDER_STATUS_HAVE_END("400025","注单已完成无法撤单"),
	ORDER_TIME_HAVE_END("400026","当期已封盘无法撤单"),
	ORDER_DATA_NOT_EXIST("400027","无效参数,订单不存在"),
	ORDER_HAVE_END("400028","订单已完成"),
	ORDER_DEATIL_HAVE_END("400029","该订单对应的所有注单都已经结束或封盘不能停止追号"),
	ORDER_DETAIL_NOT_EXIST("400030","无效参数,注单不存在"),
	DATE_ID_HAVE_DELET("400031","站内信息记录已被删除"),
	DATE_STATUS_UPDATE_FALURE("400032","站内信息状态修改失败"),
	DATA_GROUPKEY_NOT_EXIST("400033","站内信息记录不存在"),
	NAME_ID_NOT_EXPEND("400034","无效参数,账号与ID不匹配"),
	SALARY_REPORT_NOT_EXIST("400035","无效参数,操作数据不存在"),
	ORDERNUMM_ID_NOT_EXPEND("400026","无效参数,订单号与ID不匹配"),
	APPEND_ID_NOT_VALID("400037","无效参数,不是追号订单"),
	CP_BET_COUNT_MAX("400038","投注注数超过限制"),
	CP_BET_UNNORMAL("400039","投注异常,请重试"),
	/**
	 * lottery下注参数校验
	 *
	 */
	LOTTERY_BETPARAMS_IS_NULL("400001","参数为空"),
	LOTTERY_PARAMS_IS_NOTEMPTY("400001","参数无效"),






	/**
	 * 真人电子
	 */
	FLAT_NOT_FOUNT("500001","无效平台"),
	FLAT_BALANCE_ERROR("500002","查询余额失败,请重试"),
	FLAT_LOGIN_ERROR("500003","登陆失败,请重试"),
	FLAT_REGISTER_ERROR("500004","注册失败,请重试"),
	BBIN_LOGIN_ERROR("500005","BBIN游戏30秒内只能登录一次,请您稍候再试"),
	SB_INSUFFICIENT_BALANCE("500006","沙巴账户余额不足请充值"),
	FLAT_NOT_AUTHORITY("500007","用户无权限访问平台"),
	EDU_CREATE("500008","额度记录创建失败请重试"),
	ACCOUNT_CREATE("500009","流水记录创建失败请重试"),
	USER_MONEY_ERROR("500010","用户金额操作失败"),
	EDU_ERROR("500011","额度转换操作失败"),
	INSUFFICIENT_BALANCE_ERROR("500012","账户余额不足"),
	EDU_MIN_ERROR("500013","最低交易金额为：{0}元"),
	EDU_MAX_ERROR("500014","最高交易金额为：{0}元"),
	GAME_NOT_FOUND_ERROR("500015","未找到该游戏,请重试"),
	EDU_ORDER_ERROR("500016","订单号:{0}出现异常,请联系24小时在线客服"),
	FLAT_MAINTAIN("500017","该平台游戏暂时下架,请您随时关注官网公告"),
	EDU_BET_DAY("50018","额度每日记录创建失败"),

	/**
	 * 推送
	 */
	PUSH_MESSAGE_NOT_FOUNT("600001","未找到推送的消息"),
	PUSH_SERVER_TIMEOUT("600002","推送服务器连接超时"),
	PUSH_FAILURE("600003","消息推送失败"),
	PUSH_CONFIG_EMPATY("600004","消息推送配置为空"),
	/**
	 * 活动
	 */
	INVALID_ACTIVITY("700001","无效活动"),
	ACTIVITY_EXPIRED("700002","活动已下架,谢谢参与"),
	INVALID_DATE("700003","活动时间为{0}至{1}每天的{2}至{3}"),
	NOT_HUIKUAN_RECORD("700004","您昨日没有充值记录,无法参与抢红包活动,抱歉"),
	HUIKUAN_NOT_ENOUGH("700005","您昨日共充值{0}元,参与活动最低充值金额为{1}元"),
	COUNT_UPPER_LIMIT("700006","您共有{0}次抢红包机会,今日已经达到上限"),

	ACTIVITY_NOTINTIME("799001","非活动期间，不能参与"),

	ZHUANPAN_NOTTIMES("700101","您目前共有{0}次抽奖的机会"),//7001**转盘
	HONGBAO_NOTTIMES("700201","您目前共有{0}次抽奖的机会"),//7002**红包

	/**
	 * 聊天消息系统
	 */
	MESSAGE_HISTORY("80000","消息系统请求结果为空"),
	MESSAGE_HISTORY_NULLDATA("80001","返回消息中datas为空"),
	MESSAGE_HISTORY_NULLURL("80002","返回消息中url为空"),
	MESSAGE_HISTORY_DOWN("80003","下载文件出错。"),
	MESSAGE_HISTORY_NULL("80004","解析数据为实体类为空"),



	QIANDAO_FINSH("700007","您今日已经签到完成"),
	QIANDAO_NOT_SATISFIED("700008","您暂时没达到领取该礼包条件,无法领取该礼包"),
	QIANDAO_PRIZE_RECEIVE("700009","您已经领取过该礼包"),
	DOWNLOAD_FLNSH("7000010","您的手机已经领取过彩金了"),
	DOWNLOAD_NOTAPP("7000011","请通过APP客户端软件领取免费彩金"),
	DOWNLOAD_NOTFIRSTCONDITION("7000012","您一个月内没有存过款，不可领取下载彩金"),
	DOWNLOAD_AGENT("7000013","APP月累积签到彩金请联系我们活动专员领取，谢谢！"),
	DOWNLOAD_NOTMONEY("7000014","您当前可领取的彩金为0元"),

	SMS_SEND_ERROR("800001", "短信发送失败"),
	SMS_VERIFY_ERROR("800002", "短信校验失败"),
	MD5_KEY_ERROR("800003", "该操作已失效,请重新发送验证码"),
	PHONE_USER_ERROR("800004", "该手机号码与用户名不匹配"),
	SMS_SEND_SUCCESS("800005", "验证码已发送至您的手机"),

	/**
	 * IM聊天相关
	 */
	
	UNCONFIGURED_PLAN("900001", "未配置计划"),
	TIME_UNCONFIGURED_PLAN("900001", "该时间段未配置计划"),
	MODULE_FAIL("900002", "未查询到该模块"),
	WEB_IP_NOT_AUTH("900003", "当前登录ip无访问权限！"),
	
	THIRD_GET_TOKEN_FAILE("900004","获取第三方平台accessToken失败！"),
	THIRD_REFRESH_TOKEN_FAILE("900005","刷新第三方平台accessToken有效期失败！"),
	THIRD_TOKEN_NOT_INVALID("900006","第三方平台accessToken无效！"),
	THIRD_GET_USER_FAILE("900007","获取第三方平台用户信息失败！"),
	
	CHAT_GOODS_NUMBER_LIMITED("900008","该商品最多兑换{0}个,目前你已兑换{1}个,最多还可以兑换{2}个！"),
	CHAT_GOODS_NUMBER_LIMITED_ZERO("900008","该商品最多兑换{0}个,目前你已兑换{1}个,不能再兑换了！"),
	CHAT_TASK_OPERATOR_LIMITED("900009","该任务最多可执行{0}次,目前你已执行了{1}次,不能再执行！"),
	CHAT_FORUM_POST_DEL("900010", "该帖子已经删除，无法评论！"),
	CHAT_FORUM_POST_COMMENT_DEL("900011", "该评论已经删除，无法回复！"),
	CHAT_FORUM_POST_COMMENT_NOT_FOUND("900012", "该评论不存在！"),
	CHAT_FORUM_POST_NOT_FOUND("900013", "该帖子不存在！"),
	CHAT_FORUM_POST_REPLY_NOT_DEL("900014", "该回复已经删除，无法进行回复！"),
	CHAT_FORUM_POST_REPRAISE("900015", "不能重复点赞！"),
	CHAT_FORUM_POST_REPLY_NOT_FOUND("900016", "该回复不存在！"),
	CHAT_FORUM_POST_FOLLOW_HAS("900017", "，操作失败，您已关注！"),
	CHAT_THIRD_TC_BET_FAILE("900018", "投注失败"),
	CHAT_ROOM_NOT_FOUND("900019", "未找到该聊天室"),
	CHAT_ROOM_CLOSE("900020", "该聊天室已关闭"),
	CHAT_COMMENT_REPLY_NOT_DEL1("900021", "您不是楼主,无法删除!"),
	CHAT_COMMENT_REPLY_NOT_DEL2("900022", "您不是本人,无法删除!"),
	CHAT_COMMENT_DELETE("900023", "评论已被删除或不存在"),
	CHAT_POST_DELETE("900024", "帖子已被删除或不存在!"),
	CHAT_ROOM_NOT_WORK("900025", "该聊天室工作状态为休息中"),
	CHAT_TOKEN_ERROR("900026", "获取token失败"),
	CHAT_RECEPTIONIST_NOT_FOUND("900027", "未获取到接待员信息，请稍后再试"),
	CHAT_WECHAT_TOKEN_ERROR("900028", "微信鉴权失败"),
	CHAT_GROUP_MEMBER_CAN_NOT_MORE("900028", "当前群组成员上限为{0}人,当前最多可以再加入{1}人！");
	private String code;
	private String msg;

	private ResEnum(String code,String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
