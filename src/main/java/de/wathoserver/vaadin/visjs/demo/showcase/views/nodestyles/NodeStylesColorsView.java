package de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesColorsExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_colors", layout = MainShowcaseLayout.class)
@Caption("colors")
@Icon(VaadinIcon.PALETE)
public class NodeStylesColorsView extends AbstractExampleView {

  public NodeStylesColorsView(@Autowired NodeStylesColorsExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/colors.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "Nodes can be all kinds of colors. This example shows all possible ways of defining colors. "
            + "If you supply an object, the undefined fields will assume the default colors. "
            + "When supplying a hex or rgb format color, it will be parsed and variations will be created for highlight and hover. "
            + "Edges with inheritColor take the border colors.");
  }

}
