package de.wathoserver.vaadin.visjs.demo.showcase.views.labels;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelBackgroundExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelBackground", layout = MainShowcaseLayout.class)
@Caption("Background")
@Icon(VaadinIcon.PROGRESSBAR)
public class LabelsLabelBackgroundView extends AbstractExampleView {

  public LabelsLabelBackgroundView(@Autowired LabelsLabelBackgroundExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelBackground.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph("Labels can have any color background.");
  }

}
