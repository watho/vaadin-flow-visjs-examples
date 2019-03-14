package de.wathoserver.vaadin.visjs.demo.showcase.views.labels;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.appreciated.app.layout.annotations.Caption;
import com.github.appreciated.app.layout.annotations.Icon;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Route;

import de.wathoserver.vaadin.visjs.demo.MainShowcaseLayout;
import de.wathoserver.vaadin.visjs.demo.examples.LabelsLabelMultilineTextExample;
import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExampleView;

@SuppressWarnings("serial")
@Route(value = "labels_labelMultilineText", layout = MainShowcaseLayout.class)
@Caption("Multiline text")
@Icon(VaadinIcon.ALIGN_JUSTIFY)
public class LabelsLabelMultilineTextView extends AbstractExampleView {

  public LabelsLabelMultilineTextView(@Autowired LabelsLabelMultilineTextExample example) {
    super(example);
  }

  @Override
  public String getJsExampleUrl() {
    return "http://visjs.org/examples/network/labels/multilineText.html";
  }

  @Override
  protected Component getDescription() {
    return null;
  }

}
