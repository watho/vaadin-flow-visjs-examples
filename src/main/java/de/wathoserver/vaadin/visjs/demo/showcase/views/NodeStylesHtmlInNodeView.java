package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesHtmlInNodeExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_htmlInNode", layout = MainShowcaseLayout.class)
@Caption("html in node")
@Icon(VaadinIcon.CODE)
public class NodeStylesHtmlInNodeView extends AbstractExampleView {

  public NodeStylesHtmlInNodeView(@Autowired NodeStylesHtmlInNodeExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/HTMLInNodes.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "This example demonstrates showing custom HTML in Nodes, by using an SVG image.\n" + "\n"
            + "WARNING: this is currently not supported by all browsers.");
  }

}
