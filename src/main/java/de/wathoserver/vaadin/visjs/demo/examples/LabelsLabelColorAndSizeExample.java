package de.wathoserver.vaadin.visjs.demo.examples;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.Font;
import de.wathoserver.vaadin.visjs.network.util.Shape;

/**
 * <pre>
<script type="text/javascript">
 // create an array with nodes
  var nodes = [
    {id: 1, label: 'Node 1', font: '12px arial red'},
    {id: 2, label: 'Node 2', font: {size:12, color:'lime', face:'arial'}},
    {id: 3, label: 'Node 3', font: '18px verdana blue'},
    {id: 4, label: 'Node 4', font: {size:12, color:'red', face:'sans', background:'white'}},
    {id: 5, label: 'Node 5', font: {size:15, color:'red', face:'courier', strokeWidth:3, strokeColor:'#ffffff'}}
  ];

  // create an array with edges
  var edges = [
    {from: 1, to: 2},
    {from: 1, to: 3},
    {from: 2, to: 4},
    {from: 2, to: 5}
  ];

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes : {
      shape: 'dot',
      size: 10
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
public class LabelsLabelColorAndSizeExample extends AbstractExample {

  private final NetworkDiagram nd;
  ObjectMapper mapper = new ObjectMapper();

  public LabelsLabelColorAndSizeExample() {
    // Set Nodes
    final Node node1 = new Node("1", "Node 1", Node.builder().withFont("12px arial red"));
    final Node node2 = new Node("2", "Node 2", Node.builder()
        .withFont(Font.builder().withSize(12).withColor("lime").withFace("arial").build()));
    final Node node3 = new Node("3", "Node 3", Node.builder().withFont("18px verdana blue"));
    final Node node4 = new Node("4", "Node 4", Node.builder().withFont(Font.builder().withSize(12)
        .withColor("red").withFace("sans").withBackground("white").build()));
    final Node node5 =
        new Node("5", "Node 5", Node.builder().withFont(Font.builder().withSize(15).withColor("red")
            .withFace("courier").withStrokeWidth(3).withStrokeColor("#ffffff").build()));

    nd = new NetworkDiagram(
        Options.builder().withNodes(Nodes.builder().withShape(Shape.dot).withSize(10).build())//
            .build());
    nd.setSize("600px", "600px");
    nd.getElement().getStyle().set("background", "#d1d1d1");
    nd.setNodes(node1, node2, node3, node4, node5);
    nd.setEdges("1", "2", "1", "3", "2", "4", "2", "5");
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
