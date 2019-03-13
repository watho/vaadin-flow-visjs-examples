package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesDashesExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_dashes", layout = MainShowcaseLayout.class)
@Caption("Dashes")
@Icon(VaadinIcon.ELLIPSIS_H)
public class EdgeStylesDashesView extends AbstractExampleView {

  public EdgeStylesDashesView(@Autowired EdgeStylesDashesExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/dashes.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Playing with dashes.");
  }

}
