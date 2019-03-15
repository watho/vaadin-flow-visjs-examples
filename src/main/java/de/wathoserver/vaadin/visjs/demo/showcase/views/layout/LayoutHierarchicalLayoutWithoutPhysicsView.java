package de.wathoserver.vaadin.visjs.demo.showcase.views.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LayoutHierarchicalLayoutWithoutPhysicsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;
import de.wathoserver.vaadin.visjs.demo.showcase.StyledText;

@SuppressWarnings("serial")
@Route(value = "layout_hierarchicalLayoutWithoutPhysics", layout = MainShowcaseLayout.class)
@Caption("Without Physics")
@Icon(VaadinIcon.VAADIN_H)
public class LayoutHierarchicalLayoutWithoutPhysicsView extends AbstractExampleView {

  public LayoutHierarchicalLayoutWithoutPhysicsView(
      @Autowired LayoutHierarchicalLayoutWithoutPhysicsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/layout/hierarchicalLayoutWithoutPhysics.html";
  }

  @Override
  protected Component getDescription() {
    return new StyledText("<h1>Hierarchical Layout without Physics</h1>\n"
        + "The hierarchical layout can now be controlled without the use of physics. This is much quicker. The options for this are: <br /><br />\n"
        + "\n" + "<table>\n" + "    <tr>\n"
        + "        <td width=\"150px\"><code>levelSeparation</code></td>\n"
        + "        <td width=\"400px\">Distance between levels.</td>\n" + "    </tr>\n"
        + "    <tr>\n" + "        <td><code>nodeSpacing</code></td>\n"
        + "        <td>Minimum distance between nodes on the free axis.</td>\n" + "    </tr>\n"
        + "    <tr>\n" + "        <td><code>treeSpacing</code></td>\n"
        + "        <td>Distance between different trees (independent networks).</td>\n"
        + "    </tr>\n" + "    <tr>\n" + "        <td><code>blockShifting</code></td>\n"
        + "        <td>Method for reducing whitespace. Can be used alone or together with edge minimization. Each node will check for whitespace and will shift\n"
        + "            it's branch along with it for as far as it can, respecting the nodeSpacing on any level.</td>\n"
        + "    </tr>\n" + "    <tr>\n" + "        <td><code>edgeMinimization</code></td>\n"
        + "        <td>Method for reducing whitespace. Can be used alone or together with block shifting. Enabling block shifting will usually speed up the layout process.\n"
        + "            Each node will try to move along its free axis to reduce the total length of it's edges.</td>\n"
        + "    </tr>\n" + "    <tr>\n" + "        <td><code>parentCentralization</code></td>\n"
        + "        <td>When true, the parents nodes will be centered again after the the layout algorithm has been finished.</td>\n"
        + "    </tr>\n" + "</table>\n" + "<br /><br />\n"
        + "Play with the settings below the network and see how the layout changes!");
  }

}
