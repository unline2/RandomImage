Random-Image-Api
========
![license]
![GitHub repo size]


Random-Image-Api 一个能够获取随机图片的 Api，基于 Spring Boot 构建

可读取本地图片列表的地址，并提供随机访问服务，可配置域名白名单访问

![random-img]

### 项目说明

程序启动的时候会自动加载 `项目路径/list` 文件夹下的所有列表文件；

图片列表文件：
- 提供访问路径为文件名的随机图片服务
- 文件命名格式 `xxx.txt` 必须为 `.txt` 结尾，每行一个图片url
 
域名白名单列表文件：
- 会开启域名白名单访问，只允许列表中的域名进行接口调用
- 命名只能为 `domains.txt`，每行一个域名，支持泛域名
  - 例如输入 `test.com` ，则会允许所有 `test.com` 结尾的域名访问
- 若域名列表文件不存在或者文件为空，则会关闭域名白名单服务，任何域名都可以进行调用。
 
> 更改列表文件后，刷新图片缓存即可生效。

### 编译运行

``` 
# 拉取项目
git clone https://github.com/noisky/Random-Image-Api.git
# 使用 maven 打包
mvn clean package
cd target && java -jar Random-Image-Api-1.0.0.jar
# 将写好的图片列表文件放入 list 文件夹，刷新缓存即可正常访问
http://localhost:9090/flush
# 默认访问端口 9090
http://localhost:9090/random/{图片列表文件名}
# 主页地址
http://localhost:9090/index.html
``` 
### 接口调用：

1、获取随机图片：

- 请求方式：`GET请求`
    
    - 请求地址：`/random/{images}`
    
    - `{images}` 则对应为存放图片地址的文件名 `images.txt` 去掉后缀
    
2、获取每日图片：

- 请求方式：`GET请求`
    
    - 请求地址：`/today/{images}`
    
    - `{images}` 则对应为存放图片地址的文件名 `images.txt` 去掉后缀
    

3、刷新图片缓存：

- 请求方式：`GET请求`

    - 请求地址：`/flush`


### 已完成功能：

- 获取每日图片

- 读取本地列表的图片地址，提供随机访问

- 域名白名单访问，未授权的域名访问会跳转到未授权页面


### TODO：

- 提供本地图片的随机访问

- 接口调用统计


[license]:https://img.shields.io/github/license/noisky/Random-Image-Api?color=blue
[GitHub repo size]:https://img.shields.io/github/repo-size/noisky/Random-Image-Api?logo=git
[random-img]:https://img.ffis.me/images/2020/01/08/QQ20200108160257.png