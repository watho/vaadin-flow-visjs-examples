package de.wathoserver.vaadin.visjs.demo.examples;

import java.util.Set;

import com.google.common.collect.Sets;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout.SortMethod;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Arrows;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;

/**
 * <pre>
<script type="text/javascript">
  var nodes = [];
      var edges = [];
      // randomly create some nodes and edges
      for (var i = 0; i < 19; i++) {
        nodes.push({id: i, label: String(i)});
      }
      edges.push({from: 0, to: 1});
      edges.push({from: 0, to: 6});
      edges.push({from: 0, to: 13});
      edges.push({from: 0, to: 11});
      edges.push({from: 1, to: 2});
      edges.push({from: 2, to: 3});
      edges.push({from: 2, to: 4});
      edges.push({from: 3, to: 5});
      edges.push({from: 1, to: 10});
      edges.push({from: 1, to: 7});
      edges.push({from: 2, to: 8});
      edges.push({from: 2, to: 9});
      edges.push({from: 3, to: 14});
      edges.push({from: 1, to: 12});
      edges.push({from: 16, to: 15});
      edges.push({from: 15, to: 17});
      edges.push({from: 18, to: 17});

      // create a network
      var container = document.getElementById('mynetwork');
      var data = {
        nodes: nodes,
        edges: edges
      };

      var options = {
        layout: {
          hierarchical: {
            sortMethod: layoutMethod
          }
        },
        edges: {
          smooth: true,
          arrows: {to : true }
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
public class LayoutHierarchicalLayoutMethodsExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Options options;

  public LayoutHierarchicalLayoutMethodsExample() {
    // Set Nodes
    final Set<Node> nodes = Sets.newLinkedHashSetWithExpectedSize(18);
    for (int i = 0; i < 19; i++) {
      nodes.add(new Node(String.valueOf(i), String.valueOf(i)));
    }

    options = Options.builder()
        .withLayout(Layout.builder()
            .withHierarchical(
                HierarchicalLayout.builder().withSortMethod(SortMethod.directed).build())
            .build())
        .withEdges(Edges.builder().withSmooth(true)//
            .withArrows(Arrows.builder().withTo(true).build())//
            .build())
        .build();
    nd = new NetworkDiagram(options);
    nd.setSize("800px", "500px");
    nd.setNodes(nodes);
    nd.setEdges("0", "1", "0", "6", "0", "13", "0", "11", "1", "2", "2", "3", "2", "4", "3", "5",
        "1", "10", "1", "7", "2", "8", "2", "9", "3", "14", "1", "12", "16", "15", "15", "17", "18",
        "17");
    add(nd);
    final Select<SortMethod> select = new Select<>(SortMethod.directed, SortMethod.hubsize);
    select.setLabel("Method");
    select.setValue(SortMethod.directed);
    select.addValueChangeListener(ev -> {
      options.getLayout().getHierarchicalObject().setSortMethod(ev.getValue());
      nd.setOptions(options);
    });
    add(select);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
