
package com.gateway.filter;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * This class can be used to allow sensitive headers
 * Omitted by zuul.
 * 
 * @see ZuulFilter
 * @author tariq.anwar
 */
@Component
public class GatewayFilter extends ZuulFilter {

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    /*
     * Adding authorization header to zuul request header as 
     * zuul omits sensitive headers
     */
    if(request.getHeader("Authorization") != null){
    	ctx.addZuulRequestHeader("Authorization", request.getHeader("Authorization"));
    }
    return null;
  }

}
