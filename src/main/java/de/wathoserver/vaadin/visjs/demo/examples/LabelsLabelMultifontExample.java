package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Font.Multi;
import de.wathoserver.vaadin.visjs.network.util.FontStyle;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
  var nodes = [
    { id: 1, label: 'This is a\nsingle-font label', x: -120, y: -120 },
    { id: 2, font: { multi: true }, label: '<b>This</b> is a\n<i>default</i> <b><i>multi-</i>font</b> <code>label</code>', x: -40, y: -40 },
    { id: 3, font: { multi: 'html', size: 20 }, label: '<b>This</b> is an\n<i>html</i> <b><i>multi-</i>font</b> <code>label</code>', x: 40, y: 40 },
    { id: 4, font: { multi: 'md', face: 'georgia' }, label: '*This* is a\n_markdown_ *_multi-_ font* `label`', x: 120, y: 120},
  ];

  var edges = [
    {from: 1, to: 2, label: "single to default"},
    {from: 2, to: 3, font: { multi: true }, label: "default to <b>html</b>" },
    {from: 3, to: 4, font: { multi: "md" }, label: "*html* to _md_" }
  ];

  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    edges: {
      font: {
        size: 12
      }
    },
    nodes: {
      shape: 'box',
      font: {
        bold: {
          color: '#0077aa'
        }
      }
    },
    physics: {
      enabled: false
    }
  };
  var network = new vis.Network(container, data, options);
</script>
 * </pre>
 *
 * @author watho
 *
 */
@SuppressWarnings("serial")
@SpringComponent
@UIScope
public class LabelsLabelMultifontExample extends AbstractExample {

  private final NetworkDiagram nd;
  ObjectMapper mapper = new ObjectMapper();

  public LabelsLabelMultifontExample() {
    // Set Nodes
    final Node node1 =
        new Node("1", "This is a\nsingle-font label", Node.builder().withx(-120).withy(-120));
    final Node node2 = new Node("2",
        "<b>This</b> is a\n<i>default</i> <b><i>multi-</i>font</b> <code>label</code>",
        Node.builder().withFont(Font.builder().withMulti(true).build()).withx(-40).withy(-40));
    final Node node3 =
        new Node("3", "<b>This</b> is an\n<i>html</i> <b><i>multi-</i>font</b> <code>label</code>",
            Node.builder().withFont(Font.builder().withMulti(Multi.html).withSize(20).build())
                .withx(40).withy(40));
    final Node node4 = new Node("4", "*This* is a\n_markdown_ *_multi-_ font* `label`",
        Node.builder().withFont(Font.builder().withMulti(Multi.md).withFace("georgia").build())
            .withx(120).withy(120));

    nd = new NetworkDiagram(Options.builder()
        .withNodes(Nodes.builder().withShape(Shape.box)
            .withFont(
                Font.builder().withBold(FontStyle.builder().withColor("#0077aa").build()).build())//
            .build())
        .withEdges(Edges.builder().withFont(Font.builder().withSize(12).build())//
            .build())
        .withPhysics(Physics.builder().withEnabled(false).build()).build());
    nd.setSize("600px", "600px");
    nd.setNodes(node1, node2, node3, node4);

    nd.setEdges( //
        new Edge("1", "2", "single to default"),
        new Edge("2", "3",
            Edge.builder().withLabel("default to <b>html</b>")
                .withFont(Font.builder().withMulti(true).build())),
        new Edge("3", "4", Edge.builder().withLabel("*html to _md_")
            .withFont(Font.builder().withMulti(Multi.md).build())));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
