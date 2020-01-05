Random-Image-Api
========
![license]
![GitHub repo size]


Random-Image-Api 一个能够获取随机图片的 Api，基于 Spring Boot 构建

可读取本地列表的图片地址，并提供随机访问服务

图片列表：项目路径/list/images.txt


### 接口调用：

1、获取随机图片：

- 请求方式：`GET请求`
    
    - 请求地址：`/images`
    

2、刷新图片缓存：

- 请求方式：`GET请求`

    - 请求地址：`/flush`


### 已完成功能：

- 读取本地列表的图片地址，提供随机访问


### TODO：

- 请求域名白名单
- 根据访问路径，读取对应目录的图片，提供随机访问


[license]:https://img.shields.io/github/license/noisky/Random-Image-Api?color=blue
[GitHub repo size]:https://img.shields.io/github/repo-size/noisky/Random-Image-Api?logo=git
