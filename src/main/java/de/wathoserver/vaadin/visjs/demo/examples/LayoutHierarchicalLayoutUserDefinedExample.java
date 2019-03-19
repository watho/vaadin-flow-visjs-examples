package de.wathoserver.vaadin.visjs.demo.examples;

import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.Sets;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import de.wathoserver.vaadin.visjs.demo.showcase.AbstractExample;
import de.wathoserver.vaadin.visjs.network.NetworkDiagram;
import de.wathoserver.vaadin.visjs.network.Node;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout;
import de.wathoserver.vaadin.visjs.network.options.HierarchicalLayout.Direction;
import de.wathoserver.vaadin.visjs.network.options.Options;
import de.wathoserver.vaadin.visjs.network.options.edges.Edges;
import de.wathoserver.vaadin.visjs.network.options.edges.Layout;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth.ForceDirection;
import de.wathoserver.vaadin.visjs.network.options.edges.Smooth.Type;
import de.wathoserver.vaadin.visjs.network.options.physics.Physics;

/**
 * <pre>
<script type="text/javascript">
  nodes = [];
            edges = [];
            var connectionCount = [];

            // randomly create some nodes and edges
            for (var i = 0; i < 15; i++) {
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
            nodes[0]["level"] = 0;
            nodes[1]["level"] = 1;
            nodes[2]["level"] = 3;
            nodes[3]["level"] = 4;
            nodes[4]["level"] = 4;
            nodes[5]["level"] = 5;
            nodes[6]["level"] = 1;
            nodes[7]["level"] = 2;
            nodes[8]["level"] = 4;
            nodes[9]["level"] = 4;
            nodes[10]["level"] = 2;
            nodes[11]["level"] = 1;
            nodes[12]["level"] = 2;
            nodes[13]["level"] = 1;
            nodes[14]["level"] = 5;


            // create a network
            var container = document.getElementById('mynetwork');
            var data = {
                nodes: nodes,
                edges: edges
            };

            var options = {
                edges: {
                    smooth: {
                        type: 'cubicBezier',
                        forceDirection: (directionInput.value == "UD" || directionInput.value == "DU") ? 'vertical' : 'horizontal',
                        roundness: 0.4
                    }
                },
                layout: {
                    hierarchical: {
                        direction: directionInput.value
                    }
                },
                physics:false
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
public class LayoutHierarchicalLayoutUserDefinedExample extends AbstractExample {

  private final NetworkDiagram nd;
  private final Options options;

  public LayoutHierarchicalLayoutUserDefinedExample() {
    // Set Nodes
    final Set<Node> nodes = Sets.newLinkedHashSetWithExpectedSize(18);
    final Function<Integer, Integer> levelProvider = source -> {
      switch (source) {
        case 2:
          return 3;
        case 3:
        case 4:
          return 4;
        case 6:
        case 11:
        case 13:
          return 1;
        case 7:
        case 10:
        case 12:
          return 2;
        case 8:
        case 9:
          return 4;
        case 14:
          return 5;
        default: // 0, 1, 5
          return source;
      }
    };
    for (int i = 0; i < 15; i++) {
      nodes.add(new Node(String.valueOf(i), String.valueOf(i),
          Node.builder().withLevel(levelProvider.apply(i))));
    }

    options = Options.builder().withLayout(Layout.builder()
        .withHierarchical(HierarchicalLayout.builder().withDirection(Direction.UD).build()).build())
        .withEdges(Edges.builder()
            .withSmooth(Smooth.builder().withType(Type.cubicBezier)
                .withForceDirection(ForceDirection.vertical).withRoundness(0.4).build())//
            .build()) //
        .withPhysics(Physics.builder().withEnabled(false).build()) //
        .build();
    nd = new NetworkDiagram(options);
    nd.setSize("600px", "600px");
    nd.setNodes(nodes);
    nd.setEdges("0", "1", "0", "6", "0", "13", "0", "11", "1", "2", "2", "3", "2", "4", "3", "5",
        "1", "10", "1", "7", "2", "8", "2", "9", "3", "14", "1", "12");
    add(nd);
    final Select<Direction> select =
        new Select<>(Direction.UD, Direction.DU, Direction.LR, Direction.RL);
    select.setLabel("Direction");
    select.setValue(Direction.UD);
    select.addValueChangeListener(ev -> {
      options.getLayout().getHierarchicalObject().setDirection(ev.getValue());
      final ForceDirection direction =
          ev.getValue().equals(Direction.UD) || ev.getValue().equals(Direction.DU)
              ? ForceDirection.vertical
              : ForceDirection.horizontal;
      options.getEdges().getSmoothObject().setForceDirection(direction);
      nd.setOptions(options);
    });
    add(select);
  }

  @Override
  public NetworkDiagram getNetworkDiagram() {
    return nd;
  }

}
