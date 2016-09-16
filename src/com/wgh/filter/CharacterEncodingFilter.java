//���ñ���Ĺ�����filter
package com.wgh.filter;

//�����java.io.IOException
import java.io.IOException;
//�����javax.servlet.*
import javax.servlet.*;

//���ñ������ʵ�ֽӿ�Filter
public class CharacterEncodingFilter implements Filter {
	// ��ʼ������encoding
	protected String encoding = null;
	// ��ʼ������FilterConfig
	protected FilterConfig filterConfig = null;

	// �������ĳ�ʼ����������Ŀ���ص�web��������ʱ�����ִ�У���ִֻ��1�Σ�ע�⣺����Ҫ�������FilterConfig
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		this.encoding = filterConfig.getInitParameter("encoding");
	}

	// doFilter�ǹ������ĺ���
	public void doFilter 
	(ServletRequest request, ServletResponse response, FilterChain chain) // �����Ҫע�⣺����Ĳ�����������Ҫ��������Filter��ʲô��˼
			throws IOException, ServletException // Ҫ�׳��쳣
	{
		if (encoding != null) {
			request.setCharacterEncoding(encoding); // ���������ñ������ʽ
			response.setContentType("text/html; charset=" + encoding); // ����Ϊʲô�����encoding�������ʣ�������
		}
		chain.doFilter(request, response); // �����Ľ��й��ˣ����û��chain.diFilter����ᷢ���������Ͳ��ύ����һ��doFilter
	}

	// �����������٣�����webж����Ŀ��ʱ��ִ�У���ִֻ��1��
	public void destroy() 
	{
		this.encoding = null;
		this.filterConfig = null;
	}
}
