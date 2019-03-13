package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesArrowsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_arrows", layout = MainShowcaseLayout.class)
@Caption("Arrows")
@Icon(VaadinIcon.CURSOR)
public class EdgeStylesArrowsView extends AbstractExampleView {

  public EdgeStylesArrowsView(@Autowired EdgeStylesArrowsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/arrows.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "There are a lot of options with arrows! They can also be combined with dashed lines.");
  }

}
