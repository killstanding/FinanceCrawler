# FinanceCrawler
##金融数据爬虫

###数据库

*   mysql

### 语言

*   JAVA

### 完成


*  完成howbuy 产品基本数据和收益的采集
*  完成howbuy 历史净值的采集
*  完成howbuy 风险评估指标的采集

*  完成eastmoney 产品和收益的采集
*  完成eastmoney 历史净值的采集

### 关键技术

* json  采用org.json进行翻译
* html  采用org.htmlparser进行翻译
* 定时任务           采用org.quartz与spring相结合进行处理

### help

* maven 编码命令 ：
	mvn clean install
	mvn package

* maven导出所有jar
	
	从Maven仓库中导出jar包：进入工程pom.xml 所在的目录下，输入：

	mvn dependency:copy-dependencies  

	会导出到targed/dependency 下面
 
	可以在工程创建lib文件夹，输入以下命令：

	mvn dependency:copy-dependencies -DoutputDirectory=lib  
 
	这样jar包都会copy到工程目录下的lib里面
 
	



    

    
   
