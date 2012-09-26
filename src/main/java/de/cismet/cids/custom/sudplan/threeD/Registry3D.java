/***************************************************
*
* cismet GmbH, Saarbruecken, Germany
*
*              ... and it just works.
*
****************************************************/
package de.cismet.cids.custom.sudplan.threeD;

import com.dfki.av.sudplan.vis.VisualizationPanel;

import java.awt.Dimension;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;

import de.cismet.cids.custom.sudplan.commons.CismetExecutors;
import de.cismet.cids.custom.sudplan.commons.SudplanConcurrency;

/**
 * DOCUMENT ME!
 *
 * @author   martin.scholl@cismet.de
 * @version  $Revision$, $Date$
 */
public final class Registry3D {

    //~ Instance fields --------------------------------------------------------

    private final transient VisualizationPanel visPanel;
    private final transient ExecutorService executor;

    //~ Constructors -----------------------------------------------------------

    /**
     * Creates a new Registry3D object.
     */
    private Registry3D() {
        visPanel = new VisualizationPanel(new Dimension(400, 400));

        final ThreadFactory tf = SudplanConcurrency.createThreadFactory("cismap3D"); // NOI18N
        executor = CismetExecutors.newFixedThreadPool(5, tf);
    }

    //~ Methods ----------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public VisualizationPanel getVisPanel() {
        return visPanel;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public static Registry3D getInstance() {
        return LazyInitializer.INSTANCE;
    }

    /**
     * DOCUMENT ME!
     *
     * @return  DOCUMENT ME!
     */
    public ExecutorService get3DExecutor() {
        return executor;
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @version  $Revision$, $Date$
     */
    private static final class LazyInitializer {

        //~ Static fields/initializers -----------------------------------------

        private static final Registry3D INSTANCE = new Registry3D();

        //~ Constructors -------------------------------------------------------

        /**
         * Creates a new LazyInitializer object.
         */
        private LazyInitializer() {
        }
    }
}
