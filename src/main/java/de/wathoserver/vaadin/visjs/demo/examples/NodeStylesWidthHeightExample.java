package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.nodes.HeightConstraint;
import de.wathoserver.vaadin.visjs.network.options.nodes.HeightConstraint.Valign;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.options.nodes.WidthConstraint;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
  var nodes = [
    { id: 100, label: 'This node has no fixed, minimum or maximum width or height', x: -50, y: -300 },
    { id: 210, widthConstraint: { minimum: 120 }, label: 'This node has a mimimum width', x: -400, y: -200 },
    { id: 211, widthConstraint: { minimum: 120 }, label: '...so does this', x: -500, y: -50 },
    { id: 220, widthConstraint: { maximum: 170 }, label: 'This node has a maximum width and breaks have been automatically inserted into the label', x: -150, y: -150 },
    { id: 221, widthConstraint: { maximum: 170 }, label: '...this too', x: -100, y: 0 },
    { id: 200, font: { multi: true }, widthConstraint: 150, label: '<b>This</b> node has a fixed width and breaks have been automatically inserted into the label', x: -300, y: 50 },
    { id: 201, widthConstraint: 150, label: '...this as well', x: -300, y: 200 },
    { id: 300, heightConstraint: { minimum: 70 }, label: 'This node\nhas a\nminimum\nheight', x: 100, y: -150 },
    { id: 301, heightConstraint: { minimum: 70 }, label: '...this one here too', x: 100, y: 0 },
    { id: 400, heightConstraint: { minimum: 100, valign: 'top' }, label: 'Minimum height\nvertical alignment\nmay be top', x: 300, y: -200 },
    { id: 401, heightConstraint: { minimum: 100, valign: 'middle' }, label: 'Minimum height\nvertical alignment\nmay be middle\n(default)', x: 300, y: 0 },
    { id: 402, heightConstraint: { minimum: 100, valign: 'bottom' }, label: 'Minimum height\nvertical alignment\nmay be bottom', x: 300, y: 200 }
  ];

  var edges = [
    { from: 100, to: 210, label: "unconstrained to minimum width"},
    { from: 210, to: 211, label: "more minimum width"},
    { from: 100, to: 220, label: "unconstrained to maximum width"},
    { from: 220, to: 221, label: "more maximum width"},
    { from: 210, to: 200, label: "minimum width to fixed width"},
    { from: 220, to: 200, label: "maximum width to fixed width"},
    { from: 200, to: 201, label: "more fixed width"},
    { from: 100, to: 300, label: "unconstrained to minimum height"},
    { from: 300, to: 301, label: "more minimum height"},
    { from: 100, to: 400, label: "unconstrained to top valign"},
    { from: 400, to: 401, label: "top valign to middle valign"},
    { from: 401, to: 402, widthConstraint: { maximum: 150 }, label: "middle valign to bottom valign"},
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
      },
      widthConstraint: {
        maximum: 90
      }
    },
    nodes: {
      shape: 'box',
      margin: 10,
      widthConstraint: {
        maximum: 200
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
public class NodeStylesWidthHeightExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesWidthHeightExample() {
    // Set Nodes
    final Node node1 = new Node("100", "This node has no fixed, minimum or maximum width or height",
        Node.builder().withx(-50).withy(-300));
    final Node node2 = new Node("210", "This node has a mimimum width", Node.builder()//
        .withWidthConstraint(WidthConstraint.builder().withMinimum(120).build())//
        .withx(-400).withy(-200));
    final Node node3 = new Node("211", "..so does this", Node.builder()//
        .withWidthConstraint(WidthConstraint.builder().withMinimum(120).build())//
        .withx(-500).withy(-50));
    final Node node4 = new Node("220",
        "This node has a maximum width and breaks have been automatically inserted into the label",
        Node.builder()//
            .withWidthConstraint(WidthConstraint.builder().withMaximum(170).build())//
            .withx(-150).withy(-150));
    final Node node5 = new Node("221", "...this too", Node.builder()//
        .withWidthConstraint(WidthConstraint.builder().withMaximum(170).build())//
        .withx(-100).withy(0));
    final Node node6 = new Node("200",
        "<b>This</b> node has a fixed width and breaks have been automatically inserted into the label",
        Node.builder()//
            .withFont(Font.builder().withMulti(true).build()) //
            .withWidthConstraint(150)//
            .withx(-300).withy(50));
    final Node node7 = new Node("201", "...this as well", Node.builder()//
        .withWidthConstraint(150)//
        .withx(-300).withy(200));
    final Node node8 = new Node("300", "This node\\nhas a\\nminimum\\nheight", Node.builder()//
        .withHeightConstraint(HeightConstraint.builder().withMinimum(70).build())//
        .withx(100).withy(-150));
    final Node node9 = new Node("301", "...this one here too", Node.builder()//
        .withHeightConstraint(HeightConstraint.builder().withMinimum(70).build())//
        .withx(100).withy(0));
    final Node node10 = new Node("400", "Minimum height\nvertical alignment\nmay be top",
        Nodes.builder()
            .withHeightConstraint(
                HeightConstraint.builder().withMinimum(100).withValign(Valign.top).build())//
            .withx(300).withy(-200));
    final Node node11 =
        new Node("401", "Minimum height\nvertical alignment\nmay be middle\n(default)",
            Nodes.builder()
                .withHeightConstraint(
                    HeightConstraint.builder().withMinimum(100).withValign(Valign.middle).build())//
                .withx(300).withy(0));
    final Node node12 = new Node("402", "Minimum height\nvertical alignment\nmay be bottom",
        Nodes.builder()
            .withHeightConstraint(
                HeightConstraint.builder().withMinimum(100).withValign(Valign.bottom).build())//
            .withx(300).withy(200));

    nd = new NetworkDiagram(Options.builder() //
        .withEdges(Edges.builder()//
            .withFont(Font.builder().withSize(12).build())//
            .withWidthConstraintMaximum(90)//
            .build())
        .withNodes(Nodes.builder().withShape(Shape.box).withMargin(10)
            .withWidthConstraint(WidthConstraint.builder().withMaximum(200).build()).build())
        .withPhysics(Physics.builder().withEnabled(false).build())//
        .build());
    nd.diagramSetSize("800px", "800px");
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7, node8, node9, node10, node11,
        node12);
    nd.setEdges(new Edge("100", "210", "unconstrained to minimum width"),
        new Edge("210", "211", "more minimum width"),
        new Edge("100", "220", "unconstrained to maximum width"),
        new Edge("220", "221", "more maximum width"),
        new Edge("210", "200", "minimum width to fixed width"),
        new Edge("220", "200", "maximum width to fixed width"),
        new Edge("200", "201", "more fixed width"),
        new Edge("100", "300", "unconstrained to minimum height"),
        new Edge("300", "301", "more minimum height"),
        new Edge("100", "400", "unconstrained to top valign"),
        new Edge("400", "401", "top valign to middle valign"), new Edge("401", "402", Edge.builder()
            .withLabel("middle valign to bottom valign").withWidthConstraintMaximum(150)));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
