package de.wathoserver.vaadin.visjs.demo.showcase.views.nodestyles;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.NodeStylesImagesExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "nodestyles_images", layout = MainShowcaseLayout.class)
@Caption("images")
@Icon(VaadinIcon.PAINTBRUSH)
public class NodeStylesImagesView extends AbstractExampleView {

  public NodeStylesImagesView(@Autowired NodeStylesImagesExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/nodeStyles/images.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("Display nodes as images.");
  }

}
