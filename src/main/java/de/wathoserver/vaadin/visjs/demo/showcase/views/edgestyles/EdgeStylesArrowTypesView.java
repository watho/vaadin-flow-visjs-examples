package de.wathoserver.vaadin.visjs.demo.showcase.views.edgestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.EdgeStylesArrowTypesExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "edgestyles_arrowtypes", layout = MainShowcaseLayout.class)
@Caption("Arrow types")
@Icon(VaadinIcon.CURSOR_O)
public class EdgeStylesArrowTypesView extends AbstractExampleView {

  public EdgeStylesArrowTypesView(@Autowired EdgeStylesArrowTypesExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/edgeStyles/arrowTypes.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "The types of endpoints are: 'arrow' 'circle' 'bar'. The default is 'arrow'.");
  }

}
