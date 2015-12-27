function USER() {}

USER.role = function (){
	return $("#user").attr("role");
};

USER.isUser = function (){
	return USER.role() == "STUDENT";
};

USER.isTeacher = function (){
	return USER.role() == "TEACHER";
};

