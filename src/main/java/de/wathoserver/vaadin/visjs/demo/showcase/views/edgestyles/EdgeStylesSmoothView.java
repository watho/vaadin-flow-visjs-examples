package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesSmoothExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_smooth", layout = MainShowcaseLayout.class)
@Caption("Smooth curves")
@Icon(VaadinIcon.SHARE)
public class EdgeStylesSmoothView extends AbstractExampleView {

  public EdgeStylesSmoothView(@Autowired EdgeStylesSmoothExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/smooth.html";
  }

  @Override
  protected Component getDescription() {
    final Paragraph warningP = new Paragraph(
        "The configuration beneath the diagram is not exactly the same as in the original javascript example, cause defining functions as options is not possible yet.");
    warningP.getStyle().set("color", "red");

    return new VerticalLayout(new Paragraph(
        "All the smooth curves in the examples so far have been using dynamic smooth curves. This means that each curve has a support node which takes part in the physics simulation. For large networks or dense clusters, this may not be the ideal solution. To solve this, static smooth curves have been added. The static smooth curves are based only on the positions of the connected nodes. There are multiple ways to determine the way this curve is drawn. This example shows the effect of the different types. \n"
            + ""),
        new Paragraph(
            "Drag the node around to see how the smooth curves are drawn for each setting. For animated system, we recommend only the continuous mode. In the next example you can see the effect of these methods on a large network. Keep in mind that the direction (the from and to) of the curve matters. \n"
                + ""),
        new Paragraph(
            "When you select the dynamic type, you can see the interaction with the fixed node and the edge, any other type will not interact with other nodes. \n"
                + ""),
        warningP);
  }

}
