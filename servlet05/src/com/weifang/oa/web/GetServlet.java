package com.weifang.oa.web;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


public class GetServlet extends GenericServlet {
    /*
    Response Headers:
        HTTP/1.1 200                                          状态行
        Content-Type: text/html;charset=UTF-8                 响应头
        Content-Length: 142
        Date: Sun, 24 Apr 2022 06:34:34 GMT
        Keep-Alive: timeout=20
        Connection: keep-alive
                                                              空白行
    Response Body:                                            响应体
        <!DOCTYPE html>
        <html lang="en">
           <head>
               <meta charset="UTF-8">
               <title>from_get_servlet</title>
           </head>
           <body>
               <h1>from_get_servlet</h1>
              </body>
        </html>
      状态行：
        三部分组成
        1.协议版本号(HTTP/1.1)
        2.状态码：
            200 表示请求响应成功，正常结束
            404 表示访问的资源不存在，通常是因为：要么是你路径写错了，要么是路径写对了，但是服务器对应的资并没有启动成功，总之404错误是前端错误
            405 表示前端发送的请求方式与后端请求的处理方式不一致：比如前端是POST请求，后端的处理方式按照GET方式进行处理
                                                             前端是GET请求，后端的处理方式按照POST方式进行处理
            500 表示服务器端的程序出现了异常，一般会认为是服务器端的错误导致的
            以4开始的，一般是浏览器端的错误导致的
            以5开始的，一般是服务器端的错误导致的
         3.状态的描述信息
            ok表示成功结束
            not found表示资源找不到
       响应头：
            响应的内容类型
            响应的内容长度
            响应的时间
            ……
       空白行：
            用来分隔响应头和响应体
       响应体
            响应体就是响应的正文，这些内容是一个长的字符串，这个字符串被浏览器渲染，解释并执行，最终展示出效果

    */
    /*
    GET请求：
        GET /servlet05/getServlet?username=jack&password=123 HTTP/1.1                                              请求行
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,* / *;      请求头
                q=0.8,application/signed-exchange;v=b3;q=0.9
        Accept-Encoding: gzip, deflate, br
        Accept-Language: zh-CN,zh-TW;q=0.9,zh;q=0.8,en-US;q=0.7,en;q=0.6
        Connection: keep-alive
        Cookie: Idea-5d5bfa09=be2bcbe2-6642-43de-821c-1e03d5d452d9; _xsrf=2|d48ed8c4|9ccb3fe2e3a1c01f1
                ddf41d56af93112|1649755065;username-localhost-8888="2|1:0|10:1649755081|23:
                username-localhost-8888|44:MDViZThlMzNlNjc3NGIwOWFjYWZiNz
                g2MzFiM2M4Y2Y=|cb5ad4c6ccb058c6c00718634e8e356e8b1db0d9cd65b13f70c5471ac1823e51"
        Host: localhost:8080
        Referer: http://localhost:8080/servlet05/
        Sec-Fetch-Dest: document
        Sec-Fetch-Mode: navigate
        Sec-Fetch-Site: same-origin
        Sec-Fetch-User: ?1
        Upgrade-Insecure-Requests: 1
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36
                    (KHTML, like Gecko) Chrome/100.0.4896.127 Safari/537.36
        sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"
        sec-ch-ua-mobile: ?0
        sec-ch-ua-platform: "Windows"
                                                                                                                   空白行
                                                                                                                   请求体
      POST请求：
        POST /servlet05/postServlet HTTP/1.1                                                                       请求行
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,* / *;      请求头
                q=0.8,application/signed-exchange;v=b3;q=0.9
        Accept-Encoding: gzip, deflate, br
        Accept-Language: zh-CN,zh-TW;q=0.9,zh;q=0.8,en-US;q=0.7,en;q=0.6
        Cache-Control: max-age=0
        Connection: keep-alive
        Content-Length: 26
        Content-Type: application/x-www-form-urlencoded
        Cookie: Idea-5d5bfa09=be2bcbe2-6642-43de-821c-1e03d5d452d9; _xsrf=2|d48ed8c4|9ccb3fe2e3a1c01f1
                ddf41d56af93112|1649755065; username-localhost-8888="2|1:0|10:1649755081|
                23:username-localhost-8888|44:MDViZThlMzNlNjc3NGIwOWFjYWZiNzg2MzFiM2M4Y2Y=|
                cb5ad4c6ccb058c6c00718634e8e356e8b1db0d9cd65b13f70c5471ac1823e51"
        Host: localhost:8080
        Origin: http://localhost:8080
        Referer: http://localhost:8080/servlet05/
        Sec-Fetch-Dest: document
        Sec-Fetch-Mode: navigate
        Sec-Fetch-Site: same-origin
        Sec-Fetch-User: ?1
        Upgrade-Insecure-Requests: 1
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko)
                    Chrome/100.0.4896.127 Safari/537.36
        sec-ch-ua: " Not A;Brand";v="99", "Chromium";v="100", "Google Chrome";v="100"
        sec-ch-ua-mobile: ?0
        sec-ch-ua-platform: "Windows"
                                                                                                                   空白行
        name=jack&password=123                                                                                     请求体
        请求行：
            包括三部分：
                1.请求方式 （7种）
                    get         (常用)
                    post        (常用)
                    delete
                    put
                    head
                    options
                    trace
                2.URI
                    什么是URI   统一资源标识符，代表网络中某个资源的名字，但是通过URI是无法定位资源的
                    什么是URL?  统一资源定位符，代表网络中某个资源，同时，通过URL是可以定位到该资源的。
                    区别与联系
                        URL包括URI
                        http://localhost:8080/servlet05/index.html 这是URL
                        /servlet05/index.html 这是URI
                3.HTTP协议版本号
        请求头
            请求的主机
            主机的端口
            浏览器信息
            平台信息
            cookie等信息
            ……
        空白行
            区分请求头和请求体
        请求体
            向服务器发送的具体数据
        怎么向服务器发送GET请求，怎么向服务器发送POST请求？
            到目前为止，只有一种情况发送POST请求：使用form表单，并且form标签中的method属性值为method="post"
            其他所有情况一律都是GET请求
                在浏览器地址上直接输入URL，敲回车，属于GET请求。
                在浏览器上直接点击超链接，属于GET请求。
                使用form表单提交数据时，form标签没有写method属性或者method属性值为method="get"，属于GET请求
        GET请求和POST请求有什么区别？
            GET请求在发送数据的时候，数据会挂在URI的后面，并且在URI后面添加一个"?", "?"后面是数据，这样会导致发送的数据回显在
            浏览器的地址栏上。（get请求在请求行上发送数据）
            http://localhost:8080/servlet05/getServlet?username=jack&password=123
            POST请求发送数据时在请求体当中发送数据，不会回显到浏览器的地址栏上，也就是说，POST发送的数据在浏览器的地址栏上看不到
            （POST在请求体发送数据）
            http://localhost:8080/servlet05/postServlet
            get请求只能发送普通的字符串，并且发送的字符串长度有限制，不同的浏览器限制不同，没有明确的规范
            get请求无法发送大数据量
            post请求可以发送任何类型的数据，包括普通字符，流媒体等信息：视频，声音，图片。。。
            post请求可以发送大数据量，理论上没有长度限制。
            get请求在W3C中是这样说的：get请求比较适合从服务器端获取数据。
            post请求在W3C中是这样说的：post请求比较适合向服务器端传送数据。
        不管你是GET请求还是POST请求，发送的请求数据格式是完全相同的，只不过位置不同，格式都是统一的：
            name=value&name=value……
            name是什么？
                以form表达为例：form表单中input标签的name
            value是什么？
                以form表达为例：form表单中input标签的value
            get请求是绝对安全的，因为get请求只是为了从服务器上获取数据，不会对服务器造成威胁。
            post请求时危险的，因为post请求是向服务器提交数据，如果这些数据通过后门的方式进入到服务器当中，服务器是很危险的，另外post请求
            是为了提交数据，所以一般情况下拦截请求的时候，大部分会选择拦截（监听）post请求
            get请求支持缓存
                任何一个get请求最终响应的结果都会被浏览器缓存起来，在浏览器缓存当中：
                    一个get请求的路径 对应一个资源
                    一个get请求的路径 对应一个资源
                    ……
                实际上，只要你发送get请求，浏览器做得第一件事就是先从本地浏览器缓存中找，找不到的时候才会去服务器上获取，这种缓存机制
                的目的是为了提高用户体验
                https://wx3.sinaimg.cn/orj360/0023tf8yly1h1lpqhzu4dj60wi1417fv02.jpg
                有没有这样一个需求，我们不希望get请求走缓存怎么办？怎么避免走缓存？我希望每一次get请求都去服务器上找资源，不想从本地
                浏览器的缓存中获取
                    只要每一次get请求的请求路径不同即可
                    https://wx3.sinaimg.cn/orj360/0023tf8yly1h1lpqhzu4dj60wi1417fv02.jpg?t=549432465465(时间戳)
                    https://wx3.sinaimg.cn/orj360/0023tf8yly1h1lpqhzu4dj60wi1417fv02.jpg?t=569564554565(时间戳)
                    怎么解决？可以在路径的后面加一个每时每刻都在变化的时间戳，这样，每一次请求的路径都不一样，浏览器就不走缓存了

            post请求不支持缓存（POST是用来修改服务器的资源的）
                post请求之后，服务器响应的结果不会被浏览器缓存起来，因为这个缓存没有意义
        GET请求和POST请求如何选择？
            从服务器端获取数据，使用get请求。向服务器端传送数据，使用post请求。
            大部分form表单的提交，都是post的方式，因为form表单中要填写大量的数据，这些数据是收集用户的信息，一般是需要传给服务器，
            服务器将这些数据保存/修改等
            如果表单中有敏感信息，还是建议使用post请求，因为get请求会回显敏感信息到浏览器地址栏上（例如密码信息）
            做文件上传，一定是post请求。要传的数据不是普通文本
            其他的情况都可以选择get请求。

     */



    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("   <head>");
        out.println("       <meta charset=\"UTF-8\">");
        out.println("       <title>from_get_servlet</title>");
        out.println("   </head>");
        out.println("   <body>");
        out.println("       <h1>from_get_servlet</h1>");
        out.println("      </body>");
        out.println("</html>");
    }
}
