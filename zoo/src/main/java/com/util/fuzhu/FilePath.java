package com.util.fuzhu;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FilePath
{
  public static String getAbsolutePathWithClass()
  {
    String path = FilePath.class.getResource("/").getPath();
    try
    {
      path = URLDecoder.decode(path, "utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    if ((path.length() > 5) && ("file:".equals(path.substring(0, 5))))
    {
      path = path.substring(5);
    }
    return path;
  }

  public static String getWEBRoot()
  {
    String path = getAbsolutePathWithClass().toString();
    if (path.indexOf("WEB-INF") > -1) {
      path = path.substring(0, path.indexOf("WEB-INF"));
    }
    return path;
  }

  public static String getAbsolutePathWithClass(String path)
  {
    return FilePath.class.getResource(path).toString();
  }

  public static String getAbsolutePathWithClass(Class<?> clazz)
  {
    String path = clazz.getResource("").toString();
    if ((path.length() > 5) && ("file:".equals(path.substring(0, 5))))
    {
      path = path.substring(5);
    }
    return path;
  }

}