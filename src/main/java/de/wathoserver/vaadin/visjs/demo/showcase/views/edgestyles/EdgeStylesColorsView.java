package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesColorsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_colors", layout = MainShowcaseLayout.class)
@Caption("Different colors")
@Icon(VaadinIcon.COPYRIGHT)
public class EdgeStylesColorsView extends AbstractExampleView {

  public EdgeStylesColorsView(@Autowired EdgeStylesColorsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/colors.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "There are a lot of options with colors. You can manually define a color or inherit the color from the nodes. You can set the opacity to override any opacity given by a color. IN ORDER TO USE THE OPACITY, BOTH THE NODES AND THE EDGES NEED COLORS IN HEX OR RGB!");
  }

}
