<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>晶科物流管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/bootstrap.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/statics/css/css.css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery1.9.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/sdmenu.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/laydate/laydate.js"></script>

	<style>
		table{
			collapse: 1;
			margin: 0 auto;
		}
		.hinit{
			text-align: center;
			color: red;
		}
		.caozuo{
			text-align: center;

		}
		.daochu{
			text-align: center;
			font-size: 16px;
		}
		a{
			text-decoration: none;
		}

	</style>

     <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.4.min.js"></script>
</head>

<body>

<script>
    $(document).ready(function(){
        $.getJSON("pei",callBack);
        function callBack(data){
            for(var i=0;i<data.length;i++){
                var tt="<tr>\n" +
                    "\t\t\t\t\t<td>"+(i+1)+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].senddate+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].start+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].end+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].sendnum+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].sender+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].taker+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].serderphone+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].takerphone+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].goods+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].sendprice+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].paytype+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].sendtype+"</td>\n" +
                    "\t\t\t\t\t<td>"+data[i].goodsname+"</td>\n" +
                    "\t\t\t\t\t<td> <input type='button' value='配载'onclick='peizai("+data[i].id+")'/>&nbsp;<input type='button' value='修改' onclick='modify("+data[i].id+")'/>&nbsp;<input type='button' value='确认到货' onclick='ok("+data[i].id+")'/> </td>\n" +
                    "\t\t\t\t</tr>";
                $("table>tbody").append(tt);
                $("tbody tr:even").css("background","#fff");
                $("tbody tr:odd").css("background","#acd4f8");
            }


        }

        var message=$("#mes").val();
        if(message!=""&&message!=null){
            alert(message)
		}

    });
	function peizai(id) {
	    location.href="gopeizai?id="+id;
	}
	//修改
    function modify(id) {
        location.href="query?id="+id;
    }

	function ok(id) {
        $.getJSON("queren",{id:id},callBack);
		function callBack(data) {
			if(data=="ok"){
			    alert("确认到货成功！")
                location.reload();
			}
        }


    }
</script>
<div class="header">

	<div class="logo"><img  src="${pageContext.request.contextPath}/statics/img/logo.png" /></div>
	<div class="header-right">
		<i class="icon-question-sign icon-white"></i> <a href="#">帮助</a> <i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal">注销</a> <i class="icon-user icon-white"></i> <a href="#">开票员的工作平台</a> <i class="icon-envelope icon-white"></i> <a href="#">发送短信</a>
		<div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				<h3 id="myModalLabel1">
					注销系统
				</h3>
			</div>
			<div class="modal-body">
				<p>
					您确定要注销退出系统吗？
				</p>
			</div>
			<div class="modal-footer">
				<button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="登录.html" >确定退出</a>
			</div>
		</div>
	</div>
</div>
<!-- 顶部 -->

<div id="middle">
	<div class="left">

		<script type="text/javascript">
            var myMenu;
            window.onload = function() {
                myMenu = new SDMenu("my_menu");
                myMenu.init();
            };
		</script>

		<div id="my_menu" class="sdmenu">
			<div >
				<span>业务处理</span>
				<a href="goindex">运单录入</a>
				<a href="gohwpz">货物配载</a>
				<a href="goquery">货物查询</a>
				<a href="goconfirm">车辆管理</a>
				<a href="gopaixu">发货排行榜</a>
			</div>
			<div class="collapsed">
				<span>统计</span>
				<a href="#">统计</a>
			</div>
			<div class="collapsed">
				<span>资金结算</span>
				<a href="#">提货登记</a>
				<a href="#">收款核销</a>
				<a href="#">现金转账</a>
				<a href="#">现付结算</a>
				<a href="#">返款结算</a>
				<a href="#">提付结算</a>
				<a href="#">浦发打卡</a>
				<a href="#">建行打卡</a>
				<a href="#">其他打卡</a>
				<a href="#">原返提货</a>



			</div>

			<div class="collapsed">
				<span>票据查询</span>
				<a href="#">票据查询</a>
				<a href="#">跟踪查询</a>
				<a href="#">车次查询</a>
			</div>
			<div class="collapsed">
				<span>数据统计</span>
				<a href="#">放款统计</a>
				<a href="#">综合统计</a>
				<a href="#">司机提成</a>
				<a href="#">收款详单</a>
				<a href="#">每日汇总</a>
				<a href="#">车辆运费</a>
				<a href="#">原返收款明细</a>
				<a href="#">现付确认详单</a>
				<a href="#">回单结算明细</a>
				<a href="#">返款确认明细</a>
				<a href="#">提付结算明细</a>
				<a href="#">分公司排行</a>
				<a href="#">浦发转帐统计</a>
				<a href="#">发货排行</a>
				<a href="#">建行转帐统计</a>
				<a href="#">其他转帐统计</a>
				<a href="#">分理处排行</a>
				<a href="#">分公司月运费对比</a>
				<a href="#">分理处月运费对比</a>
				<a href="#">线路货款未到排行</a>
				<a href="#">分公司入库报表</a>
				<a href="#">分公司收款日报</a>
				<a href="#">分公司当日库存</a>
				<a href="#">分公司往日库存</a>
				<a href="#">专线现付统计</a>
				<a href="#">专线分理处统计</a>
				<a href="#">分理处专线统计</a>
				<a href="#">货款回款率统计</a>
				<a href="#">线路运量</a>

			</div>
			<div class="collapsed">
				<span>单据管理</span>
				<a href="#">作废挂失</a>
				<a href="#">取消修改</a>
				<a href="#">修改清单</a>
				<a href="#">退单管理</a>
				<a href="#">转帐差错处理</a>
				<a href="#">运单修改查询</a>
				<a href="#">复核异常处理</a>
				<a href="#">运单修改</a>
				<a href="#">异常处理</a>
				<a href="#">单据备注</a>

			</div>
			<div class="collapsed">

				<span>系统管理</span>
				<a href="#">线路管理</a>
				<a href="#">手续费设置</a>
				<a href="#">更改密码</a>
				<a href="#">系统日志</a>
				<a href="#">帐号管理</a>
				<a href="#">复核设置</a>
				<a href="#">部门管理</a>
				<a href="#">角色管理</a>
				<a href="#">用户管理</a>
				<a href="#">短信设置</a>
				<a href="#">短信发送</a>
				<a href="#">分理处分成设置</a>
				<a href="#">省价格设置</a>
				<a href="#">市价格设置</a>
				<a href="#">县价格设置</a>

			</div>
			<div class="collapsed">
				<span>回单管理</span>
				<a href="#">回单结算</a>
				<a href="#">回单查询</a>
				<a href="#">回单接收</a>

			</div>
			<div class="collapsed">
				<span>财务管理</span>
				<a href="#">分公司日报</a>
				<a href="#">科目管理</a>
				<a href="#">费用录入</a>
				<a href="#">费用统计</a>
				<a href="#">当日对账</a>
				<a href="#">往日对账</a>
				<a href="#">利润分成</a>

			</div>

			<div class="collapsed">
				<span>车辆管理</span>
				<a href="#">基本资料管理</a>
				<a href="#">维修管理</a>
				<a href="#">加油管理</a>
				<a href="#">保养记录</a>
				<a href="#">派车管理</a>
				<a href="#">派车记录</a>
				<a href="#">包车分账</a>
				<a href="#">月分账</a>
				<a href="#">事故业务</a>
				<a href="#">保险业务</a>
				<a href="#">司机档案</a>
				<a href="#">行驶证</a>
				<a href="#">营运证</a>

			</div>
			<div class="collapsed">
				<span>中转处理</span>
				<a href="#">中转操作</a>
				<a href="#">中转单修改</a>
				<a href="#">当日中转明细</a>

			</div>
			<div class="collapsed">
				<span>客户管理</span>
				<a href="#">客户投诉</a>
				<a href="#">投诉处理</a>
				<a href="#">投诉查询</a>
				<a href="#">客户关怀</a>
				<a href="#">积分查询</a>
				<a href="#">分理处排行</a>
				<a href="#">客户管理</a>
				<a href="#">理赔申请</a>
				<a href="#">理赔审核</a>
				<a href="#">理赔结算</a>
				<a href="#">理赔查询</a>

			</div>
			<div class="collapsed">
				<span>行政办公</span>
				<a href="#">文件管理</a>
				<a href="#">在线留言</a>
				<a href="#">人事管理</a>
				<a href="#">公告管理</a>
				<a href="#">罚款登记</a>
				<a href="#">滚动字幕</a>

			</div>
			<div class="collapsed">
				<span>工资及包车费管理</span>
				<a href="#">工资管理</a>
				<a href="#">包车费管理</a>
				<a href="#">房租管理</a>
				<a href="#">货场费管理</a>



			</div>
			<div class="collapsed">
				<span>领导决策</span>
				<a href="#">新增客户分析</a>
				<a href="#">长期未发货分析</a>
				<a href="#">同比业务分析</a>
				<a href="#">环比业务分析</a>
				<a href="#">超期预警</a>

			</div>


















		</div>

	</div>
	<div class="Switch"></div>
	<script type="text/javascript">
        $(document).ready(function(e) {
            $(".Switch").click(function(){
                $(".left").toggle();

            });
        });
	</script>

	<div class="right"  id="mainFrame">

		<div class="right_cont">
			<ul class="breadcrumb">当前位置：
				<a href="#">首页</a> <span class="divider">/</span>
				<a href="#">业务处理</a> <span class="divider">/</span>
				电脑开票
			</ul>

			<div class="title_right"><span class="pull-right margin-bottom-5"><a  class="btn btn-info btn-small"  id="modal-9735581" href="#modal-container-9735581" role="button" data-toggle="modal"><i class="icon-plus icon-white"></i> 添加线路城市</a></span><strong>线路管理</strong></div>



			<div id="modal-container-9735581" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:600px; margin-left:-300px; top:20%">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						装车管理
					</h3>
				</div>
				<div class="modal-body">
					<table class="table table-bordered">
						<tbody>

						<tr>
							<td align="right">城市:</td>
							<td align="left"><input name="endTextBox" type="text" id="endTextBox" class="span1-1" />
								[*]</td>
							<td align="right">缩写:</td>
							<td align="left" colspan="3"><input name="tbx_short2" type="text" id="tbx_short2" class="span1-1" />
								[*]</td>
						</tr>
						<tr>
							<td align="right">联系人</td>
							<td align="left"><input name="manTextBox" type="text" id="manTextBox" class="span1-1" /></td>
							<td align="right">电话:</td>
							<td align="left" colspan="3"><input name="phoneTextBox" type="text" id="phoneTextBox" class="span1-1" /></td>
						</tr>
						<tr>
							<td align="right">郑货总部分成比例:</td>
							<td align="left"><input name="TextBox1" type="text" value="0" id="TextBox1" class="span1-1" />
								%</td>
							<td align="right">郑货分公司分成比例:</td>
							<td colspan="3" align="left"><input name="TextBox2" type="text" value="0" id="TextBox2" class="span1-1" />
								%</td>
						</tr>
						<tr>
							<td align="right">返货总部分成比例:</td>
							<td align="left"><input name="TextBox3" type="text" value="0" id="TextBox3" class="span1-1" />
								%</td>
							<td align="right">返货分公司分成比例:</td>
							<td colspan="3" align="left">

								<input name="TextBox4" type="text" value="0" id="TextBox4" class="span1-1" />
								<input name="" type="hidden" value="${message}" id="mes"/>
								%</td>
						</tr>
						<tr>
							<td colspan="6" align="center">网内中转货分成比例</td>
						</tr>
						<tr>
							<td align="right">（中转）发货方分成比例:</td>
							<td align="left"><input name="TextBox5" type="text" value="0" id="TextBox5" class="span1-1" />
								%</td>
							<td align="right">（中转）收货方分成比例:</td>
							<td colspan="3" align="left"><input name="TextBox6" type="text" value="0" id="TextBox6"class="span1-1"  />
								%</td>
						</tr>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px">保存</button>
					<button class="btn btn-info" data-dismiss="modal" aria-hidden="true" style="width:80px">取消</button>
				</div>
			</div>



		</div>

		<div class="huowupeizai">
			<table border="" cellpadding="">
				<thead>
				<tr>
					<td>序号</td>
					<td>发货日期</td>
					<td>起站</td>
					<td>到站</td>
					<td>发货单号</td>
					<td>发货人</td>
					<td>收货人</td>
					<td>发货人电话</td>
					<td>收货人电话</td>
					<td>货物名字</td>
					<td>运费</td>
					<td>付款方式</td>
					<td>送货方式</td>
					<td>货物状态</td>
					<td class="caozuo">操作</td>
				</tr>

				</thead>
				<tbody>

				<%--<tr>
					<td id>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
					<td>1</td>
				</tr>--%>

				</tbody>
			<%--<p class="hinit">${message}</p>--%>

			</table>
			<p class="daochu">
				<a href="export">导出到excel</a>
			</p>

		</div>

	</div>
</div>



<!-- 底部 -->
<div id="footer">版权所有：晶科客流 &copy; 2015&nbsp;&nbsp;&nbsp;&nbsp;<a href="http://www.mycodes.net/" target="_blank">源码之家</a></div>



<script>
    !function(){
        laydate.skin('molv');
        laydate({elem: '#Calendar'});
        laydate.skin('molv');
        laydate({elem: '#Calendar2'});
    }();

</script>




</body>
</html>
