package com.util.page;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.awifi.core.page.Page;


public class PageContext extends   Page  {
	/** 
	 *
	 */
	private static final long	serialVersionUID	= 7628165538197668735L;

	/**
	 * 
	 */

	private static final Logger logger = LoggerFactory.getLogger(PageContext.class);

	private static ThreadLocal<PageContext> context = new ThreadLocal<PageContext>();

	public static boolean hasPageContext(){
		PageContext ci = context.get();
		if(ci==null)
			return false;
		return true;
	}
	public static PageContext getContext()
	{
		PageContext ci = context.get();
		if(ci == null)
		{
			ci = new PageContext();
			context.set(ci);
		}
		return ci;
	}

	public  static void removeContext()
	{
		context.remove();
	}
	
	public static PageContext initContext(Integer pageSize,Integer curPage){
		removeContext();
		PageContext ci = new PageContext();
		if(pageSize!=null){
			ci.setPageSize(pageSize);
		}
		if(curPage!=null){
			ci.setCurPage(curPage);
		}
		ci.setPagination(true);
		context.set(ci);
		return ci;
	}

	protected void initialize() {

	}
}
