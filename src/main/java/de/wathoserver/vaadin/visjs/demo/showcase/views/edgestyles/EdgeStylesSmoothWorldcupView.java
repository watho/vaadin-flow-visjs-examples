package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesSmoothWorldcupExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_smoothWorldCup", layout = MainShowcaseLayout.class)
@Caption("Smooth curves in action")
@Icon(VaadinIcon.GLOBE_WIRE)
public class EdgeStylesSmoothWorldcupView extends AbstractExampleView {

  public EdgeStylesSmoothWorldcupView(@Autowired EdgeStylesSmoothWorldcupExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/smoothWorldCup.html";
  }

  @Override
  protected Component getDescription() {
    final Paragraph warningP = new Paragraph(
        "The configuration beneath the diagram is not exactly the same as in the original javascript example,"
            + " cause defining functions as options is not possible yet.");
    warningP.getStyle().set("color", "red");

    return new VerticalLayout(new H2("Static smooth curves - World Cup Network"),
        new Paragraph(
            "The static smooth curves are based only on the positions of the connected nodes. "
                + "There are multiple ways to determine the way this curve is drawn. "
                + "This example shows the effect of the different types on a large network."),
        new Paragraph(
            "Also shown in this example is the inheritColor option of the edges as well as the roundness factor. "
                + "Because the physics has been disabled, the dynamic smooth curves do not work here."),
        warningP);
  }

}
