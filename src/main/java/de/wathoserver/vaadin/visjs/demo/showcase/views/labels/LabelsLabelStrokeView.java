package de.wathoserver.vaadin.visjs.demo.showcase.views.labels;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelStrokeExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelStroke", layout = MainShowcaseLayout.class)
@Caption("Stroke")
@Icon(VaadinIcon.BACKSPACE)
public class LabelsLabelStrokeView extends AbstractExampleView {

  public LabelsLabelStrokeView(@Autowired LabelsLabelStrokeExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/labelStroke.html";
  }

  @Override
  protected Component getDescription() {
    return new Paragraph(
        "The stroke of labels is fully can have a width and color. Edgelabels by default have a white stroke for clarity.");
  }

}
