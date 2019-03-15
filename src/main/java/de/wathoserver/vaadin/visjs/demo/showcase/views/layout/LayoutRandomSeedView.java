package de.wathoserver.vaadin.visjs.demo.showcase.views.layout;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LayoutRandomSeedExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "layout_randomSeed", layout = MainShowcaseLayout.class)
@Caption("Random seed")
@Icon(VaadinIcon.PIN)
public class LayoutRandomSeedView extends AbstractExampleView {

  public LayoutRandomSeedView(@Autowired LayoutRandomSeedExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/layout/randomSeed.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Create a simple network with some nodes and edges but with a fixed seed. This means the layout will be the same every time the nodes are settled.");
  }

}
