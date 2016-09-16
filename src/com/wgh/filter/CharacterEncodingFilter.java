//设置编码的过滤器filter
package com.wgh.filter;

//导入包java.io.IOException
import java.io.IOException;
//导入包javax.servlet.*
import javax.servlet.*;

//设置编码的类实现接口Filter
public class CharacterEncodingFilter implements Filter {
	// 初始化变量encoding
	protected String encoding = null;
	// 初始化变量FilterConfig
	protected FilterConfig filterConfig = null;

	// 过滤器的初始化，会在项目加载到web服务器的时候进行执行，且只执行1次，注意：这里要传入参数FilterConfig
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	// doFilter是过滤器的核心
	public void doFilter 
	(ServletRequest request, ServletResponse response, FilterChain chain) // 这儿需要注意：传入的参数是三个，要查查第三个Filter是什么意思
			throws IOException, ServletException // 要抛出异常
	{
		if (encoding != null) {
			request.setCharacterEncoding(encoding); // 正常的设置编码的形式
			response.setContentType("text/html; charset=" + encoding); // 后面为什么会加上encoding，有疑问？？？？
		}
		chain.doFilter(request, response); // 真正的进行过滤，如果没有chain.diFilter，则会发生阻塞，就不会交给下一个doFilter
	}

	// 过滤器的销毁，会在web卸载项目的时候执行，且只执行1次
	public void destroy() 
	{
		this.encoding = null;
		this.filterConfig = null;
	}
}
