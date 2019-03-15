package de.wathoserver.vaadin.visjs.demo.showcase.views.layout;

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
import de.wathoserver.vaadin.visjs.demo.examples.LayoutHierarchicalLayoutExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "layout_hierarchicalLayout", layout = MainShowcaseLayout.class)
@Caption("Hierarchical layout")
@Icon(VaadinIcon.CONNECT)
public class LayoutHierarchicalLayoutView extends AbstractExampleView {

  public LayoutHierarchicalLayoutView(@Autowired LayoutHierarchicalLayoutExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/layout/hierarchicalLayout.html";
  }

  @Override
  protected Component getDescription() {
    return new VerticalLayout(new H2("Hierarchical Layout - Scale-Free-Network"), new Paragraph(
        "This example shows the randomly generated scale-free-network set of nodes and connected edges from example 2. In this example, hierarchical layout has been enabled and the vertical levels are determined automatically."));
  }

}
