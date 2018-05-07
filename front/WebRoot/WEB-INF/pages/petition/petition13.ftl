<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<link rel="stylesheet" type="text/css" href="js/fancybox/jquery.thumbox.1.2.css" />
<script type="text/javascript" src="js/fancybox/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/fancybox/jquery.thumbox.1.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$('#read_box').click(function(){
			$('#img_box a:first').trigger("click");
			return false;
		});
		$('#img_box').thumbox({maxThumbHeight:100});
	});
</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:#fff;padding:10px 46px 80px;}
#main .bg h2{ line-height:70px;height:70px;text-align:center;font-size:16px;color:#020202;}
#main .bg .content{width:864px;overflow:hidden;margin:0 auto;}
#main .bg .content p{ line-height:2em;font-size:14px;color:#454545;padding:12px 3px;}
#main .bg .btn{text-align:center;padding:20px 0 0;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg" alt="日程安排" />
		</div>
		<div class="bg">
			<h2>武汉市房地产市场管理中心信访处理单</h2>
			<div class="content">
				<p>　　党的最高领导机关，是党的中国共产党全国代表大会和它所产生的中央委员会（第10条）。目前的“党代会”一般每五年举行一次，为期数天。</p>
				<p>　　在全国代表大会闭会期间，中央委员会执行全国代表大会的决议，领导党的全部工作，对外代表中国共产党（21条）。中央委员会全体大会一般每年举行一次，为期二至三天，常根据全国代表大会排序简称“几几届几中全会”。</p>
				<p>　　中央政治局和它的常务委员会在中央委员会全体会议闭会期间，行使中央委员会的职权（22条）。中央政治局会议不定期举行，但是由于其二十多个成员中有多名直辖市市委书记等不在北京的人员，非预定例会的情况下，往往即使有重大事宜也不会、不及召集政治局全体会议。</p>
				<p>　　中央政治局未举行全体会议闭会期间，由中共中央政治局常务委员会代行其职权，实际决定日常党和政府的大小事宜，是中国共产党和中华人民共和国政府的核心和实际最高权力机制。三个闭会，使中国共产党的权力集中到顶端，集中到中共中央政治局常务委员会。理论上，中国共产党全国代表大会有权驳回中央委员会或中央政治局的不正确决定，实际历史上在非动乱时期从未发生过这一情况。</p>
				<p>　　在党的地方各级代表大会闭会期间，上级党的组织认为有必要时，可以调动或者指派下级党组织的负责人（13条）。人事任免权直接保证了中国共产党由上而下的控制力，上级和中央可以随时撤换下级领导人。</p>
			</div>
			<div class="btn">
				<a style="margin-right:35px;"><img src="${base}/res/images/Petition/Inbox13_1.jpg" alt="" /></a>
				<a><img src="${base}/res/images/Petition/Inbox13_2.jpg" alt="" /></a>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
