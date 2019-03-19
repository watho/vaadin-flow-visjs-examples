package de.wathoserver.vaadin.visjs.demo.examples;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.Edge;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.Interaction;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.nodes.NodeColor;
import de.wathoserver.vaadin.visjs.network.options.nodes.Nodes;
import de.wathoserver.vaadin.visjs.network.util.SimpleColor;

/**
 * <pre>
<script type="text/javascript">
  // create an array with nodes
  var nodes = new vis.DataSet([
    {id: 1, label:'html color', color: 'lime'},
    {id: 2, label:'rgb color', color: 'rgb(255,168,7)'},
    {id: 3, label:'hex color', color: '#7BE141'},
    {id: 4, label:'rgba color', color: 'rgba(97,195,238,0.5)'},
    {id: 5, label:'colorObject', color: {background:'pink', border:'purple'}},
    {id: 6, label:'colorObject + highlight',
      color: {background:'#F03967', border:'#713E7F',highlight:{background:'red',border:'black'}}},
    {id: 7, label:'colorObject + highlight + hover',
      color: {background:'cyan', border:'blue',highlight:{background:'red',border:'blue'},hover:{background:'white',border:'red'}}}
  ])

  // create an array with edges
  var edges = new vis.DataSet([
    {from: 1, to: 3},
    {from: 1, to: 2},
    {from: 2, to: 4},
    {from: 2, to: 5},
    {from: 2, to: 6},
    {from: 4, to: 7},
  ]);

  // create a network
  var container = document.getElementById('mynetwork');
  var data = {
    nodes: nodes,
    edges: edges
  };
  var options = {
    nodes: {borderWidth: 2},
    interaction: {hover: true}
  }
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
public class NodeStylesColorsExample extends AbstractExample {

  private final NetworkDiagram nd;

  public NodeStylesColorsExample() {
    nd = new NetworkDiagram(Options.builder() //
        .withNodes(Nodes.builder().withBorderWidth(2).build()) //
        .withInteraction(Interaction.builder().withHover(true).build()) //
        .build());
    nd.setSize("600px", "400px");

    // Set Nodes
    final Node node1 = new Node("1", "html color");
    node1.setColor("lime");
    final Node node2 = new Node("2", "rgb color");
    node2.setColor("rgb(255,168,7)");
    final Node node3 = new Node("3", "hex color");
    node3.setColor("#7BE141");
    final Node node4 = new Node("4", "rgba color");
    node4.setColor("rgba(97,195,238,0.5)");
    final Node node5 = new Node("5", "colorObject");
    node5.setColor(NodeColor.builder().withBackground("pink").withBorder("purple").build());
    final Node node6 = new Node("6", "colorObject + highlight");
    node6.setColor(NodeColor.builder().withBackground("#F03967").withBorder("#713E7F")
        .withHighlightColor(new SimpleColor("red", "black")).build());
    final Node node7 = new Node("7", "colorObject + highlight + hover");
    node7.setColor(NodeColor.builder().withBackground("cyan").withBorder("blue")
        .withHighlightColor(new SimpleColor("red", "blue"))
        .withHoverColor(new SimpleColor("white", "red")).build());
    nd.setNodes(node1, node2, node3, node4, node5, node6, node7);

    // Set Edges
    nd.setEdges(new Edge("1", "3"), new Edge("1", "2"), new Edge("2", "4"), new Edge("2", "5"),
        new Edge("2", "6"), new Edge("4", "7"));
    nd.addSelectNodeListener(ev -> Notification.show("node selected"));
    add(nd);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
