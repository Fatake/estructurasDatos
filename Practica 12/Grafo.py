class Grafo:
  def __init__(self):
    self.nodos = set()
    self.edges = defaultdict(list)
    self.distances = {}

  def add_node(self, value):
    self.nodos.add(value)

  def add_edge(self, from_node, to_node, distance):
    self.edges[from_node].append(to_node)
    self.edges[to_node].append(from_node)
    self.distances[(from_node, to_node)] = distance


def dijsktra(Grafo, initial):
  visited = {initial: 0}
  path = {}

  nodos = set(Grafo.nodos)

  while nodos: 
    min_node = None
    for node in nodos:
      if node in visited:
        if min_node is None:
          min_node = node
        elif visited[node] < visited[min_node]:
          min_node = node

    if min_node is None:
      break

    nodos.remove(min_node)
    current_weight = visited[min_node]

    for edge in Grafo.edges[min_node]:
      weight = current_weight + Grafo.distance[(min_node, edge)]
      if edge not in visited or weight < visited[edge]:
        visited[edge] = weight
        path[edge] = min_node

  return visited, path
