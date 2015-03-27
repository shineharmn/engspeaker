<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加关卡</title>
</head>
<body>
	<div style="margin: 100px">
	<form action="/engspeaker/cases.do?method=add" method="get">
	<div style="margin: 10px">
		<label>选项1:</label>
		<input type="text" name="option1" value="" />
		<label>选项2:</label>
		<input type="text" name="option2" value="" />
		<label>选项3:</label>
		<input type="text" name="option3" value="" />
		<label>选项4:</label>
		<input type="text" name="option4" value="" />
	</div>	
	<div style="margin: 10px">
		<label>选项5:</label>
		<input type="text" name="option5" value="" />
		<label>选项6:</label>
		<input type="text" name="option6" value="" />
		<label>选项7:</label>
		<input type="text" name="option7" value="" />
		<label>选项8:</label>
		<input type="text" name="option8" value="" />
		</div>
		<div style="margin: 10px;padding-left: 220px">
		<label>选项9:</label>	
		<input type="text" name="option9" value="" />
		<label>问题:</label>
		<input type="text" name="question" value="" />
		<label>答案:</label>
		<input type="text" name="answer" value="" />		
		<input type="submit" name="提交" value="提交" /> 
		</div>
	</form> 
	</div>
</body>
</html>