/* Copyright 2008 Alin Dreghiciu.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ops4j.pax.web.samples.helloworld.jsp.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.http.HttpContext;
import org.ops4j.pax.web.service.WebContainer;

/**
 * Hello World Activator.
 *
 * @author Alin Dreghiciu
 * @since 0.3.0, January 08, 2007
 */
public final class Activator
    implements BundleActivator
{

    /**
     * WebContainer reference.
     */
    private ServiceReference m_webContainerRef;

    /**
     * Called when the OSGi framework starts our bundle
     */
    public void start( BundleContext bc )
        throws Exception
    {
        m_webContainerRef = bc.getServiceReference( WebContainer.class.getName() );
        if( m_webContainerRef != null )
        {
            final WebContainer webContainer = (WebContainer) bc.getService( m_webContainerRef );
            if( webContainer != null )
            {
                // create a default context to share between registrations
                final HttpContext httpContext = webContainer.createDefaultHttpContext();
                // register jsp support
                webContainer.registerJsps(
                    new String[]{ "/helloworld/jsp/*" },    // url patterns
                    httpContext                                 // http context
                );
            }
        }
    }

    /**
     * Called when the OSGi framework stops our bundle
     */
    public void stop( BundleContext bc )
        throws Exception
    {
        if( m_webContainerRef != null )
        {
            bc.ungetService( m_webContainerRef );
            m_webContainerRef = null;
        }
    }
}