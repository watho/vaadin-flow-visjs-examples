package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout.Direction;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;

/**
 * <pre>
<script type="text/javascript">
   // randomly create some nodes and edges
            var nodeCount = document.getElementById('nodeCount').value;
            var data = getScaleFreeNetwork(nodeCount)

            // create a network
            var container = document.getElementById('mynetwork');
            var directionInput = document.getElementById("direction").value;
            var options = {
                layout: {
                    hierarchical: {
                        direction: directionInput
                    }
                }
            };
            network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
@JavaScript("src/exampleUtil.js")
public class LayoutHierarchicalLayoutExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Options options;

  public LayoutHierarchicalLayoutExample() {
    // Set Nodes

    options = Options.builder().withLayout(Layout.builder()
        .withHierarchical(HierarchicalLayout.builder().withDirection(Direction.UD).build()).build())
        .build();
    nd = new NetworkDiagram(options);
    nd.diagramSetSize("600px", "600px");
    add(nd);
    final FormLayout fl = new FormLayout();
    add(fl);
    // Numberchoice
    final NumberField nf = new NumberField("Number of nodes", 25.0, e -> {
      // rerun javascript for generatig nodes and edges
      runNodeGeneratingJavaScript(e.getValue().intValue());
      nd.updatePredefinedNodesAndEdges();
    });
    nf.setStep(1.0);
    nf.setMin(1.0);
    nf.setHasControls(true);
    fl.add(nf);
    final Select<Direction> select =
        new Select<>(Direction.UD, Direction.DU, Direction.LR, Direction.RL);
    select.setItemLabelGenerator(direction -> {
      switch (direction) {
        case UD:
          return "Up-Down";
        case DU:
          return "Down-Up";
        case LR:
          return "Left-Right";
        case RL:
          return "Right-Left";
        default:
          return "";
      }
    });
    select.setLabel("Direction");
    select.setValue(Direction.UD);
    select.addValueChangeListener(ev -> {
      options.getLayout().getHierarchicalObject().setDirection(ev.getValue());
      nd.diagramSetOptions(options);
    });
    fl.add(select);
    // Call native javascript from example to generate nodes and edges and add it to window.
    runNodeGeneratingJavaScript(25);
    // set variable names on diagram
    nd.setPredefinedNodesVariableName("predefinedNodes");
    nd.setPredefinedEdgesVariableName("predefinedEdges");
  }

  private void runNodeGeneratingJavaScript(final int nodeCount) {
    UI.getCurrent().getPage().executeJavaScript("var data = getScaleFreeNetwork(" + nodeCount + ");"
        + "window.predefinedNodes = data.nodes;" + "window.predefinedEdges = data.edges;");
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
