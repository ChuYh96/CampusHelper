# CampusHelper

/*06.21
1）建立了相关的一些数据模型
课程表：

	Student //学生：
		private String StuId;   //学生编号
		private String StuName; //学生姓名 
		private String StuPsd;   //学生密码
		private String StuMajor; //学生专业
		private String StuClass; //学生年级
		private String StuGrade; //学生班级
	
	Teacher //教师
		private String TeaId;  //教师编号 PK
		private String TeaName;//教师姓名
	
	Course //课程
		private String CosId;  //课程编号 PK 
		private String CosName;//课程名称
		
	Report //成绩单
		private String StuId;// 学生编号  FK 
		private String CosId;// 课程      FK
		private String RepNum;// 成绩
		private String RepTerm;// 学期(第一学期）
	
	Syllabus //课程表：
		private String StuId;      //学生编号  FK 
		private String CosId;      //课程编号  FK
		private String TeaId;      //教师编号  FK
		private String SylWeek;    //授课周
		private String SylTime;    //授课时间
		
		private String SylAddress; //授课地点
2）建立了本应用的数据库，以及相关的一些表

3）对主界面进行了部分规划
	使用了抽屉布局，第一个子布局是未打开时的界面布局，第二个自布局为打开后的布局

4)对数据库中的表进行一些修改

	课程表Schedule
	private String StuId;      //学生编号  FK
	private String Semester    //学期 2017-2018-2
    private String CosId;      //课程编号  FK
    private String TeaId;      //教师编号  FK
    private String SylWeek;    //授课周
    private String SylTime;    //授课时间
    private String SylAddress; //授课地点

	Notice 通知

	NotiId  通知编号
	NotiTitle 通知标题
	NotiContent 通知内容
	NotiTime 通知时间
	NotiOrgan 通知机构

	Backlog 代办事项

	BagId 事项编号
	BagContent 事项内容
	BagTime 事项提醒时间