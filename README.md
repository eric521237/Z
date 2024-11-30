随记：
整理出一个算法详解过程。
举个例子：

映射关系如下

a -> [b,c,d,e]

b->[c,d,e]

c->[d,e]

d->[e]

=================================================================

做一个入深度记录如下：

Key    Value

e        4

d       3

c       2

b       1

a       0

====================================================================

此时我们需要判断深度值等于0的，我们插入到集合里

List<String> result = new ArrayList<>();

result.add(0, a);

我们通过键值a，获得数组[b,c,d,e]处理（入深度）得到如下

e      3

d      2

c      1

b      0

再次操作

result.add(0,b);

反复操作如上步骤即可得到排序


public void topoSort(List<TeamTemplateItem> params) {
        params.forEach(i->i.setLevel(0));
        Map<String, TeamTemplateItem> totalMap = params.stream().collect(Collectors.toMap(TeamTemplateItem::getColumnName, o -> o, (k1, k2) -> k2));

        Map<String, List<String>> formulas = new HashMap<>();

        totalMap.forEach((k, v) -> {
            if (StringUtils.isNotBlank(v.getRelationFormula())) {
                formulas.put(k, Arrays.asList(v.getRelationFormula().split(",")));
            }
        });

        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>(formulas);

        for (String node : formulas.keySet()) {
            inDegree.putIfAbsent(node, 0);
        }

        for (String node : formulas.keySet()) {
            for (String neighbor : formulas.get(node)) {
                inDegree.put(neighbor, inDegree.getOrDefault(neighbor, 0) + 1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for (String node : inDegree.keySet()) {
            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();
            result.add(0, node); // Insert at the beginning of the list

            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if (totalMap.containsKey(result.get(i))) {
                totalMap.get(result.get(i)).setLevel(i);
            }
        }
    }
