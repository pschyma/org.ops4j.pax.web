package org.ops4j.pax.web.service.whiteboard;


/**
 * Created by peter on 11.05.2017.
 */
public interface R6ResourceMapping
{
  /**
   * Getter.
   *
   * @return id of the http context this listener belongs to
   */
  String getHttpContextId();


  /**
   * Getter.
   *
   * @return the alias for the resources.
   */
  String getAlias();


  /**
   * Getter.
   *
   * @return the path prefix for the mapping.
   */
  String getPrefix();
  
}
