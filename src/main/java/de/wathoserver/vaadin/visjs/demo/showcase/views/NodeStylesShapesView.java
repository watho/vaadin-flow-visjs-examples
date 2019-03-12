package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesShapesExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_shapes", layout = MainShowcaseLayout.class)
@Caption("shapes")
@Icon(VaadinIcon.CUBE)
public class NodeStylesShapesView extends AbstractExampleView {

  public NodeStylesShapesView(@Autowired NodeStylesShapesExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/shapes.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Nodes can have all sorts of shapes. Note the exception where the nodes with text inside and the text type's size are determined by the font size, not the node size.");
  }

}
