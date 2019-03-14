package de.wathoserver.vaadin.visjs.demo.examples;

import com.github.appreciated.demo.helper.view.entity.CodeExample;
import com.github.appreciated.demo.helper.view.other.CodeExampleView;
import com.github.appreciated.prism.element.Language;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Font.Align;
import de.wathoserver.vaadin.visjs.network.util.Shape;
import elemental.json.JsonObject;
import elemental.json.impl.JsonUtil;

/**
 * <pre>
<script type="text/javascript">
  // create an array with nodes
  var nodes = [
    {id: 1, label: 'Node 1'},
    {id: 2, label: 'Node 2'},
    {id: 3, label: 'Node 3:\nLeft-Aligned', font: {'face': 'Monospace', align: 'left'}},
    {id: 4, label: 'Node 4'},
    {id: 5, label: 'Node 5\nLeft-Aligned box', shape: 'box',
     font: {'face': 'Monospace', align: 'left'}}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2, label: 'middle',     font: {align: 'middle'}},
    {from: 1, to: 3, label: 'top',        font: {align: 'top'}},
    {from: 2, to: 4, label: 'horizontal', font: {align: 'horizontal'}},
    {from: 2, to: 5, label: 'bottom',     font: {align: 'bottom'}}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {physics:false};
  var network = new vis.Network(container, data, options);

    network.on("click", function (params) {
        params.event = "[original event]";
        document.getElementById('eventSpan').innerHTML = '<h2>Click event:</h2>' + JSON.stringify(params, null, 4);
    });
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class LabelsLabelAlignmentExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Div eventDataContainer = new Div();

  public LabelsLabelAlignmentExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1");
    final Node node2 = new Node("2", "Node 2");
    final Node node3 = new Node("3", "Node 3:\nLeft-Aligned", Node.builder()
        .withFont(Font.builder().withFace("Monospace").withAlign(Align.left).build()));
    final Node node4 = new Node("4", "Node 4");
    final Node node5 = new Node("5", "Node 5\nLeft-Aligned box", Node.builder().withShape(Shape.box)
        .withFont(Font.builder().withFace("Monospace").withAlign(Align.left).build()));

    nd = new NetworkDiagram(
        Options.builder().withPhysics(Physics.builder().withEnabled(false).build()).build());
    nd.diagramSetSize("600px", "400px");
    nd.setNodes(node1, node2, node3, node4, node5);

    nd.setEdges( //
        new Edge("1", "2",
            Edge.builder().withLabel("middle")
                .withFont(Font.builder().withAlign(Align.middle).build())),
        new Edge("1", "3",
            Edge.builder().withLabel("top").withFont(Font.builder().withAlign(Align.top).build())),
        new Edge("2", "4",
            Edge.builder().withLabel("horizontal")
                .withFont(Font.builder().withAlign(Align.horizontal).build())),
        new Edge("2", "5", Edge.builder().withLabel("bottom")
            .withFont(Font.builder().withAlign(Align.bottom).build())));
    nd.addClickListener(event -> showEventData(event.getParams()));
    add(nd);
    eventDataContainer.setWidth("600px");
    add(eventDataContainer);
  }

  private void showEventData(JsonObject params) {
    eventDataContainer.removeAll();
    eventDataContainer.add(new H2("Click event"));
    eventDataContainer
        .add(new CodeExampleView(
            new CodeExample(JsonUtil.stringify(params, 2), Language.json, "JSON")));
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
