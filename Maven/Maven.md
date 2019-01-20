# Maven

## 1. 什么是Maven

​	Maven 是一个项目管理工具，可以对项目进行构建、依赖的管理。

## 2. 约定配置

​	Maven 提倡使用共同的标准目录结构， Maven 使用约定优于配置的原则。


| 目录                               | 目的                                                         |
| ---------------------------------- | ------------------------------------------------------------ |
| ${basedir}                         | 存放pom.xml和所有的子目录                                    |
| ${basedir}/src/main/java           | 项目的java源代码                                             |
| ${basedir}/src/main/resources      | 项目的资源，比如说property文件，springmvc.xml                |
| ${basedir}/src/test/java           | 项目的测试类，比如说Junit代码                                |
| ${basedir}/src/test/resources      | 测试用的资源                                                 |
| ${basedir}/src/main/webapp/WEB-INF | web应用文件目录，web项目的信息，比如存放web.xml、本地图片、jsp视图页面 |
| ${basedir}/target                  | 打包输出目录                                                 |
| ${basedir}/target/classes          | 编译输出目录                                                 |
| ${basedir}/target/test-classes     | 测试编译输出目录                                             |
| Test.java                          | Maven只会自动运行符合该命名规则的测试类                      |
| ~/.m2/repository                   | Maven默认的本地仓库目录位置                                  |

## 3. 环境配置

​	[Maven 下载地址](http://maven.apache.org/download.html)

​	[Maven 安装](http://maven.apache.org/install.html)

​	注：Maven 是一个基于 Java 的工具

| 项目 | 要求                                                         |
| ---- | ------------------------------------------------------------ |
| JDK  | Maven 3.3 要求 JDK 1.7 或以上 <br>Maven 3.2 要求 JDK 1.6 或以上<br/>Maven 3.0/3.1 要求 JDK 1.5 或以上 |