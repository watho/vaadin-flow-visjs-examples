package de.wathoserver.vaadin.visjs.demo.showcase;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout.Orientation;

@SuppressWarnings("serial")
public abstract class AbstractExampleView extends VerticalLayout {

  protected static final Logger log = LoggerFactory.getLogger(AbstractExampleView.class);

  public AbstractExampleView(final AbstractExample exampleComponent) {
    Objects.requireNonNull(exampleComponent);
    setSizeFull();
    final Anchor anchor = new Anchor(getJsExampleUrl(), getJsExampleUrl());
    anchor.setTarget("_blank");
    final Label al = new Label("Vis.js-Demolink:");
    final SplitLayout layout = new SplitLayout();
    layout.setOrientation(Orientation.HORIZONTAL);
    if (getDescription() != null) {
      layout.addToPrimary(new HorizontalLayout(al, anchor), new Paragraph(getDescription()),
          new CodeExampleView(new CodeExample(exampleComponent.getClass())));
    } else {
      layout.addToPrimary(new HorizontalLayout(al, anchor),
          new CodeExampleView(new CodeExample(exampleComponent.getClass())));
    }
    layout.addToSecondary(exampleComponent);
    layout.setSplitterPosition(50d);
    add(layout);
    expand(layout);
  }

  protected abstract Component getDescription();

  public abstract String getJsExampleUrl();
}
