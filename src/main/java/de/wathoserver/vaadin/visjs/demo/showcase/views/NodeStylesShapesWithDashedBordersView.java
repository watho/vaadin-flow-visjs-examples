package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesShapesWithDashedBordersExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_shapesWithDashedBorders", layout = MainShowcaseLayout.class)
@Caption("dashed borders")
@Icon(VaadinIcon.CUBES)
public class NodeStylesShapesWithDashedBordersView extends AbstractExampleView {

  public NodeStylesShapesWithDashedBordersView(
      @Autowired NodeStylesShapesWithDashedBordersExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/shapesWithDashedBorders.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Nodes can have all sorts of shapes. Note the exception where the nodes with text inside and the text type's size are determined by the font size, not the node size.");
  }

}
