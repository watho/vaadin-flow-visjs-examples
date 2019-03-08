package de.wathoserver.vaadin.visjs.demo.showcase;

import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Label;
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
    add(new HorizontalLayout(al, anchor));
    final SplitLayout layout = new SplitLayout();
    layout.setOrientation(Orientation.HORIZONTAL);
    layout.addToPrimary(exampleComponent);
    layout.addToSecondary(new CodeExampleView(new CodeExample(exampleComponent.getClass())));
    add(layout);
    expand(layout);
  }

  public abstract String getJsExampleUrl();
}
