package org.ops4j.pax.web.extender.whiteboard.internal.element;


import org.ops4j.lang.NullArgumentException;
import org.ops4j.pax.web.service.WebContainer;
import org.ops4j.pax.web.service.whiteboard.R6ResourceMapping;
import org.ops4j.pax.web.service.whiteboard.WhiteboardR6ResourceMapping;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;


/**
 * Created by peter on 11.05.2017.
 */
public class R6ResourceWebElement extends WebElement<R6ResourceMapping>
  implements WhiteboardR6ResourceMapping
{

  private final R6ResourceMapping mapping;


  /**
   * Subclasses must provide the service-reference.
   *
   * @param ref the service-reference of the registered service. Used to extract further properties.
   */
  public R6ResourceWebElement (ServiceReference<R6ResourceMapping> ref, R6ResourceMapping mapping)
  {
    super (ref);
    NullArgumentException.validateNotNull(mapping, "R6 resource mapping");

    this.mapping = mapping;
  }
  
  
  @Override
  public void register (WebContainer webContainer, HttpContext httpContext) throws Exception
  {
    mapping.
    webContainer.registerResources();
  }
  
  
  @Override
  public void unregister (WebContainer webContainer, HttpContext httpContext)
  {
  
  }
  
  
  @Override
  public String getHttpContextId ()
  {
    return null;
  }


  @Override
  public R6ResourceMapping getResourceMapping() {
    return mapping;
  }
}
