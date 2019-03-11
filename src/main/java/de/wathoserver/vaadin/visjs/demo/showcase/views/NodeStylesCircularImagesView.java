package de.wathoserver.vaadin.visjs.demo.showcase.views;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesCircularImagesExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_circularImages", layout = MainShowcaseLayout.class)
@Caption("circular images")
@Icon(VaadinIcon.CIRCLE_THIN)
public class NodeStylesCircularImagesView extends AbstractExampleView {

  public NodeStylesCircularImagesView(@Autowired NodeStylesCircularImagesExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/circularImages.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("Usage of images in nodes.");
  }

}
