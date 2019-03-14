package de.wathoserver.vaadin.visjs.demo.showcase.views.labels;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelColorAndSizeExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelColorAndSize", layout = MainShowcaseLayout.class)
@Caption("Colors and Sizes")
@Icon(VaadinIcon.PALETE)
public class LabelsLabelColorAndSizeView extends AbstractExampleView {

  public LabelsLabelColorAndSizeView(@Autowired LabelsLabelColorAndSizeExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelColorAndSize.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("The style of the edges can be fully customized.");
  }

}
